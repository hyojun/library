package com.example.library.persistence.port

import com.example.library.domain.model.Book
import com.example.library.userinterface.port.model.BookSearchParameter

interface BookPersistenceDrivenPort {
    fun searchBooks(bookSearchParameter: BookSearchParameter): List<Book>
}
