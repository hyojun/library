package com.example.library.userinterface.port.model

import com.example.library.domain.model.Loan

class LoanResponse(
    val id: Long,
    val user: UserResponse,
    val book: BookResponse,
    val status: Loan.LoanStatus
) {
    companion object {
        fun from(loan: Loan): LoanResponse {
            return LoanResponse(
                loan.id!!,
                UserResponse.from(loan.user!!),
                BookResponse.from(loan.book!!),
                loan.status!!)
        }
    }
}
