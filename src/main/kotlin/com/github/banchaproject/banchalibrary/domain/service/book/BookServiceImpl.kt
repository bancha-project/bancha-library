package com.github.banchaproject.banchalibrary.domain.service.book

import com.github.banchaproject.banchalibrary.domain.model.Book
import com.github.banchaproject.banchalibrary.domain.repository.book.BookRepository
import com.github.michaelbull.result.Result
import com.github.michaelbull.result.runCatching
import java.util.*
import javax.inject.Singleton

@Singleton
class BookServiceImpl(
    private val bookRepository: BookRepository
) : BookService {

    override fun findAll(): Result<Iterable<Book>, Throwable> = runCatching { bookRepository.findAll() }

    override fun findOne(bookId: Long): Result<Optional<Book>, Throwable> = runCatching { bookRepository.findById(bookId) }
}