package com.example.library.domain

import com.example.library.persistence.port.BookPersistenceDrivenPort
import com.example.library.userinterface.port.BookUIDrivingPort
import com.example.library.userinterface.port.model.BookResponse
import com.example.library.userinterface.port.model.BookSearchParameter
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookPersistenceDrivenPort: BookPersistenceDrivenPort)
    : BookUIDrivingPort {
    override fun searchBooks(bookSearchParameter: BookSearchParameter): List<BookResponse> {
        return bookPersistenceDrivenPort.searchBooks(bookSearchParameter).map {
            BookResponse.from(it)
        }
    }
}
