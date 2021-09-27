package com.example.library.domain

import com.example.library.persistence.port.LoanPersistenceDrivenPort
import com.example.library.userinterface.port.LoanUIDrivingPort
import com.example.library.userinterface.port.model.LoanResponse
import org.springframework.stereotype.Service

@Service
class LoanService(
    val loanPersistenceDrivenPort: LoanPersistenceDrivenPort)
    : LoanUIDrivingPort {
    override fun getLoan(id: Long): LoanResponse? {
        return loanPersistenceDrivenPort.getLoan(id)?.let { LoanResponse.from(it) }
    }

    override fun lendBooks(bookIds: List<Long>) {
        loanPersistenceDrivenPort.lendBooks(1L, bookIds)
    }

    override fun returnBooks(bookIds: List<Long>) {
        loanPersistenceDrivenPort.returnBook(1L, bookIds)
    }
}
