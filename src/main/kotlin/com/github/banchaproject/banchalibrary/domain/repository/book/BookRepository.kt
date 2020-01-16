package com.github.banchaproject.banchalibrary.domain.repository.book

import com.github.banchaproject.banchalibrary.domain.model.Book
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.repository.CrudRepository

@JdbcRepository
interface BookRepository : CrudRepository<Book, Long>