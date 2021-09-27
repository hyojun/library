package com.example.library.domain.model

import java.time.LocalDate

open class Book (
    open val id: Long?,
    open val name: String?,
    open val author: String?,
    open val publishDate: LocalDate?,
    open val status: BookStatus?) {

    constructor() : this(null, null, null, null, null)

    enum class BookStatus {
        AVAILABLE,
        IN_LENDING
    }
}