package com.github.banchaproject.banchalibrary.domain.service.book

import com.github.banchaproject.banchalibrary.domain.model.Book
import com.github.banchaproject.banchalibrary.domain.repository.book.BookRepository
import com.github.michaelbull.result.Result
import com.github.michaelbull.result.runCatching
import io.micronaut.transaction.SynchronousTransactionManager
import java.sql.Connection
import java.util.*
import javax.inject.Singleton

@Singleton
class BookServiceImpl(
    private val txManager: SynchronousTransactionManager<Connection>,
    private val bookRepository: BookRepository
) : BookService {

    override fun findAll(): Result<Iterable<Book>, Throwable> = runCatching { bookRepository.findAll() }

    override fun findOne(bookId: Long): Result<Optional<Book>, Throwable> = runCatching { bookRepository.findById(bookId) }

    override fun save(book: Book): Result<Book, Throwable> = runCatching {
        txManager.executeWrite {
            bookRepository.save(book)
        }
    }

    override fun update(book: Book): Result<Book, Throwable> = runCatching {
        txManager.executeWrite {
            bookRepository.update(book.bookId, book.title, book.author, book.summary, book.isbn)
            book
        }
    }
}