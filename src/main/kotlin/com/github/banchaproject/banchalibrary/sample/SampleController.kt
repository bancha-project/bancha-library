package com.github.banchaproject.banchalibrary.sample

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable

@Controller("sample")
class SampleController(
    private val repository: SampleRepository
) {

    @Get
    fun get(): List<Book> = repository.findAll()

    @Get("{id}")
    fun get(@PathVariable id: Long): Book = repository.findById(id)

    @Get("add")
    fun add(): String = repository.add(
        Book(title = "ねこしま", author = "猫島猫太郎", summary = "ねこしまのはなし", isbn = "9999")
    ).run { "OK" }

    @Get("{id}/update")
    fun update(@PathVariable id: Long): String = repository.update(
        Book(book_id = id, title = "ねこしま", author = "猫島猫太郎", summary = "ねこしまのはなし改訂版", isbn = "9999")
    ).run { "OK" }

    @Get("{id}/delete")
    fun delete(@PathVariable id: Long): String = repository.delete(id).run { "OK" }
}