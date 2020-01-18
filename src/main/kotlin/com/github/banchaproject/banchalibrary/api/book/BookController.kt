package com.github.banchaproject.banchalibrary.api.book

import com.github.banchaproject.banchalibrary.domain.service.book.BookService
import com.github.michaelbull.result.mapBoth
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put

@Controller("books")
class BookController(
    private val bookMapper: BookMapper,
    private val bookService: BookService
) {

    @Get
    fun getBooks(): HttpResponse<Iterable<BookResource>> = bookService.findAll()
        .mapBoth(
            success = { HttpResponse.ok(bookMapper.map(it)) },
            failure = { HttpResponse.serverError() }
        )

    @Get("{bookId}")
    fun getBook(@PathVariable bookId: Long): HttpResponse<BookResource> = bookService.findOne(bookId)
        .mapBoth(
            success = {
                when {
                    it.isPresent -> HttpResponse.ok(bookMapper.map(it.get()))
                    else -> HttpResponse.notFound()
                }
            },
            failure = { HttpResponse.serverError() }
        )

    @Post
    fun postBook(@Body bookResource: BookResource): HttpResponse<BookResource> = bookService.save(bookMapper.map(bookResource)).mapBoth(
        success = { HttpResponse.ok(bookMapper.map(it)) },
        failure = { HttpResponse.serverError() }
    )

    @Put("{bookId}")
    fun putBook(@PathVariable bookId: Long, @Body bookResource: BookResource): HttpResponse<BookResource> =
        bookService.update(bookMapper.map(bookResource.copy(bookId = bookId))).mapBoth(
            success = { HttpResponse.ok(bookMapper.map(it)) },
            failure = { HttpResponse.serverError() }
        )

    @Delete("{bookId}")
    fun deleteBook(@PathVariable bookId: Long): HttpResponse<BookResource> = bookService.deleteOne(bookId).mapBoth(
        success = { HttpResponse.ok() },
        failure = { HttpResponse.serverError() }
    )
}