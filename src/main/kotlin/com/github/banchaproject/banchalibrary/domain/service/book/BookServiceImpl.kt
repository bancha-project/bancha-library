package com.github.banchaproject.banchalibrary.domain.service.book

import com.github.banchaproject.banchalibrary.domain.model.Book
import com.github.banchaproject.banchalibrary.domain.repository.book.BookRepository
import java.util.*
import javax.inject.Singleton
import javax.transaction.Transactional

@Singleton
@Transactional
open class BookServiceImpl(
    private val bookRepository: BookRepository
) : BookService {

    override fun findAll(): Iterable<Book> = bookRepository.findAll()

    override fun findOne(bookId: Long): Optional<Book> = bookRepository.findById(bookId)
}