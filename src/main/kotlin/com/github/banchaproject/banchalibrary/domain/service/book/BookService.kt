package com.github.banchaproject.banchalibrary.domain.service.book

import com.github.banchaproject.banchalibrary.domain.model.Book
import java.util.*

interface BookService {
    fun findAll(): Iterable<Book>
    fun findOne(bookId: Long): Optional<Book>
}