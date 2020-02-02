package com.github.banchaproject.banchalibrary.domain.service.book

import com.github.banchaproject.banchalibrary.domain.model.Book
import com.github.banchaproject.banchalibrary.domain.model.Pagination
import com.github.michaelbull.result.Result
import io.micronaut.data.model.Page
import java.util.*

interface BookService {
    fun findAll(pagination: Pagination): Result<Page<Book>, Throwable>
    fun findOne(bookId: Long): Result<Optional<Book>, Throwable>
    fun save(book: Book): Result<Book, Throwable>
    fun update(book: Book): Result<Book, Throwable>
    fun deleteOne(bookId: Long): Result<Long, Throwable>
}