package com.github.banchaproject.banchalibrary.api.book

data class BookResource(
    val bookId: Long,
    val title: String,
    val author: String,
    val summary: String,
    val isbn: String
)