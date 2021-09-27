package com.example.library.userinterface.port

import com.example.library.userinterface.port.model.LoanResponse

interface LoanUIDrivingPort {
    fun getLoan(
        id: Long
    ): LoanResponse?

    fun lendBooks(
        bookIds: List<Long>
    )

    fun returnBooks(
        bookIds: List<Long>
    )
}
