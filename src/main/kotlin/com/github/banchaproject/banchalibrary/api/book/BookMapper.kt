package com.github.banchaproject.banchalibrary.api.book

import com.github.banchaproject.banchalibrary.domain.model.Book
import com.github.banchaproject.banchalibrary.infra.config.MapConfig
import org.mapstruct.Mapper

@Mapper(config = MapConfig::class)
interface BookMapper {
    fun map(book: Book): BookResource
    fun map(books: Iterable<Book>): Iterable<BookResource>
}