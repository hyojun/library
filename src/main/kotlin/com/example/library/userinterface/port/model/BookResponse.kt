package com.example.library.userinterface.port.model

import com.example.library.domain.model.Book
import java.time.LocalDate

data class BookResponse(
    val id: Long?,
    val name: String?,
    val author: String?,
    val publishDate: LocalDate?,
    val status: Book.BookStatus?
) {
    companion object {
        fun from(book: Book): BookResponse {
            return BookResponse(book.id, book.name, book.author, book.publishDate, book.status)
        }
    }
}

