package com.github.banchaproject.banchalibrary.domain.model

import com.github.pozo.KotlinBuilder
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
@KotlinBuilder
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var bookId: Long = 0,
    val title: String,
    val author: String,
    val summary: String,
    val isbn: String
)