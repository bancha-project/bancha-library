package com.github.banchaproject.banchalibrary.api.book

import com.github.banchaproject.banchalibrary.domain.model.Book
import com.github.banchaproject.banchalibrary.infra.config.MapConfig
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(config = MapConfig::class)
interface BookMapper {
    @Mapping(source = "bookId", target = "id")
    fun map(book: Book): BookResource
    fun map(books: Iterable<Book>): Iterable<BookResource>
    @InheritInverseConfiguration
    fun map(bookResource: BookResource): Book
}