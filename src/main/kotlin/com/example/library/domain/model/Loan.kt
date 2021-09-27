package com.example.library.domain.model

import java.util.*

open class Loan(
    open val id: Long?,
    open val user: User?,
    open val book: Book?,
    open val status: LoanStatus?,
    open val lentDate: Date?,
    open val returnedDate: Date?) {
    constructor() : this(null, null, null, null, null, null)

    enum class LoanStatus {
        IN_LENDING,
        RETURNED,
    }
}
