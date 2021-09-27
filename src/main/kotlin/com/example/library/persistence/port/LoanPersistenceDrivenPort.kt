package com.example.library.persistence.port

import com.example.library.domain.exception.BookInLendingException
import com.example.library.domain.model.Loan

interface LoanPersistenceDrivenPort {
    fun getLoan(id: Long): Loan?
    @Throws(BookInLendingException::class)
    fun lendBooks(userId: Long, bookIds: List<Long>)
    fun returnBook(userId: Long, bookIds: List<Long>)
}
