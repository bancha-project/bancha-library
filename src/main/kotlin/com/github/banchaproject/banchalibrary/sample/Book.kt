package com.github.banchaproject.banchalibrary.sample

data class Book(
    // キャメルケース対応してないっぽい
    val book_id: Long = 0,
    val title: String = "",
    val author: String = "",
    val summary: String = "",
    val isbn: String = ""
)