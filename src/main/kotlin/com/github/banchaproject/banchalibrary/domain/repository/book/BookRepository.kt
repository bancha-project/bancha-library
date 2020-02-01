package com.github.banchaproject.banchalibrary.domain.repository.book

import com.github.banchaproject.banchalibrary.domain.model.Book
import io.micronaut.data.annotation.Id
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.repository.PageableRepository

@JdbcRepository
interface BookRepository : PageableRepository<Book, Long> {
    // entityをそのまま渡せないっぽい。
    fun update(@Id id: Long?, title: String, author: String, summary: String, isbn: String)
}