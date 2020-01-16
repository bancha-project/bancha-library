package com.github.banchaproject.banchalibrary.domain.service.book

import com.github.banchaproject.banchalibrary.domain.model.Book
import com.github.michaelbull.result.Result
import java.util.*

interface BookService {
    fun findAll(): Result<Iterable<Book>, Throwable>
    fun findOne(bookId: Long): Result<Optional<Book>, Throwable>
    fun save(book: Book): Result<Book, Throwable>
}