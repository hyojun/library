package com.example.library.userinterface.port

import com.example.library.userinterface.port.model.BookResponse
import com.example.library.userinterface.port.model.BookSearchParameter

interface BookUIDrivingPort {
    fun searchBooks(
        bookSearchParameter: BookSearchParameter
    ): List<BookResponse>
}
