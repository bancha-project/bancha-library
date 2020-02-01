package com.github.banchaproject.banchalibrary.domain.model

import io.micronaut.data.model.Pageable
import io.micronaut.data.model.Sort

data class Pagination(
    val page: Int,
    val size: Int,
    val orderPropertyName: String,
    val orderDirection: Sort.Order.Direction
) {
    companion object {
        fun from(start: Int, end: Int, sort: String, order: String): Pagination {
            val size = end - start
            val page = start / size
            val direction = when (order) {
                "ASC" -> Sort.Order.Direction.ASC
                else -> Sort.Order.Direction.DESC
            }
            return Pagination(page, size, sort, direction)
        }
    }

    fun toPageable() = Pageable.from(this.page, this.size).order(this.orderPropertyName, this.orderDirection)
}