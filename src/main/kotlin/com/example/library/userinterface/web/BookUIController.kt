package com.example.library.userinterface.web

import com.example.library.userinterface.port.BookUIDrivingPort
import com.example.library.userinterface.port.model.BookResponse
import com.example.library.userinterface.port.model.BookSearchParameter
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("books")
class BookUIController(val bookUIDrivingPort: BookUIDrivingPort) {
    @GetMapping
    fun searchBooks(bookSearchParameter: BookSearchParameter): List<BookResponse>? {
        return bookUIDrivingPort.searchBooks(bookSearchParameter)
    }
}
