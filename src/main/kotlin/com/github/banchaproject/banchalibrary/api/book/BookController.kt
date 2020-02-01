package com.github.banchaproject.banchalibrary.api.book

import com.github.banchaproject.banchalibrary.domain.model.Pagination
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
import io.micronaut.http.annotation.QueryValue

@Controller("books")
class BookController(
    private val bookMapper: BookMapper,
    private val bookService: BookService
) {

    @Get
    fun getBooks(
        @QueryValue("_start") start: Int,
        @QueryValue("_end") end: Int,
        @QueryValue("_sort") sort: String,
        @QueryValue("_order") order: String
    ): HttpResponse<Iterable<BookResource>> =
        bookService.findAll(Pagination.from(start, end, sort.replace("id", "bookId"), order))
            .mapBoth(
                success = {
                    HttpResponse.ok(bookMapper.map(it))
                        .header("X-Total-Count", it.totalSize.toString())
                },
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
        bookService.update(bookMapper.map(bookResource.copy(id = bookId))).mapBoth(
            success = { HttpResponse.ok(bookMapper.map(it)) },
            failure = { HttpResponse.serverError() }
        )

    @Delete("{bookId}")
    fun deleteBook(@PathVariable bookId: Long): HttpResponse<Long> = bookService.deleteOne(bookId).mapBoth(
        success = { HttpResponse.ok(bookId) },
        failure = { HttpResponse.serverError() }
    )
}