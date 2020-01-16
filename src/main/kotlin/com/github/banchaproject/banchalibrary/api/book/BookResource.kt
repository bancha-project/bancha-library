package com.github.banchaproject.banchalibrary.api.book

import com.github.pozo.KotlinBuilder

@KotlinBuilder
data class BookResource(
    val bookId: Long,
    val title: String,
    val author: String,
    val summary: String,
    val isbn: String
)