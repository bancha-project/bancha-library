package com.github.banchaproject.banchalibrary.api.book

import com.github.banchaproject.banchalibrary.domain.service.book.BookService
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
    fun getBooks() = bookMapper.map(bookService.findAll())

    @Get("{bookId}")
    fun getBook(@PathVariable bookId: Long): HttpResponse<BookResource> {
        val book = bookService.findOne(bookId)
        return if (book.isPresent) {
            HttpResponse.ok(bookMapper.map(book.get()))
        } else {
            HttpResponse.notFound()
        }
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