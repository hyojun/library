package com.example.library.userinterface.port.model

import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate

data class BookSearchParameter(
    val author: String?,
    val name: String?,
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    val fromDate: LocalDate?,
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    val toDate: LocalDate?)
