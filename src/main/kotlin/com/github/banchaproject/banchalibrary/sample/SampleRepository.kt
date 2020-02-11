package com.github.banchaproject.banchalibrary.sample

import com.amazon.rdsdata.client.RdsDataClient
import javax.inject.Singleton

@Singleton
class SampleRepository(
    private val client: RdsDataClient
) {
    fun findAll(): List<Book> = client.forSql("SELECT * FROM book")
        .withTransactionId(client.beginTransaction())
        .execute()
        .mapToList(Book::class.java)

    fun findById(id: Long) : Book = client.forSql("SELECT * FROM book WHERE book_id = :book_id")
        .withTransactionId(client.beginTransaction())
        // ドキュメントにある withParams が無い...
        .withParamSets(mapOf("book_id" to id))
        .execute()
        .mapToSingle(Book::class.java)

    fun add(book: Book) {
        val tx = client.beginTransaction()
        runCatching {
            client.forSql("INSERT INTO book(title, author, summary, isbn) VALUES (:title, :author, :summary, :isbn)")
                .withParamSets(book)
                .withTransactionId(tx)
                .execute()
        }.onSuccess {
            client.commitTransaction(tx)
        }.onFailure {
            client.rollbackTransaction(tx)
            throw it
        }
    }

    fun update(book: Book) {
        val tx = client.beginTransaction()
        runCatching {
            client.forSql("""
                UPDATE book 
                   SET title = :title
                     , author = :author
                     , summary = :summary
                     , isbn = :isbn
                 WHERE book_id = :book_id
            """.trimIndent())
                .withParamSets(book)
                .withTransactionId(tx)
                .execute()
        }.onSuccess {
            client.commitTransaction(tx)
        }.onFailure {
            client.rollbackTransaction(tx)
            throw it
        }
    }

    fun delete(id: Long) {
        val tx = client.beginTransaction()
        runCatching {
            client.forSql("DELETE FROM book WHERE book_id = :book_id")
                .withParamSets(mapOf("book_id" to id))
                .withTransactionId(tx)
                .execute()
        }.onSuccess {
            client.commitTransaction(tx)
        }.onFailure {
            client.rollbackTransaction(tx)
            throw it
        }
    }
}