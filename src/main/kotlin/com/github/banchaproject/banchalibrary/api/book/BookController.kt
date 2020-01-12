package com.github.banchaproject.banchalibrary.api.book

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put

@Controller("books")
class BookController {

    @Get
    fun getBooks(): HttpResponse<List<BookResource>> {
        TODO("未実装")
    }

    @Get("{bookId}")
    fun getBook(@PathVariable bookId: Long): HttpResponse<BookResource> {
        TODO("未実装")
    }

    @Post
    fun postBook(@Body bookResource: BookResource): HttpResponse<BookResource> {
        TODO("未実装")
    }

    @Put("{bookId}")
    fun putBook(@PathVariable bookId: Long, @Body bookResource: BookResource): HttpResponse<BookResource> {
        TODO("未実装")
    }

    @Delete("{bookId}")
    fun deleteBook(@PathVariable bookId: Long): HttpResponse<BookResource> {
        TODO("未実装")
    }
}