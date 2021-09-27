package com.example.library.persistence.jpa

import com.example.library.domain.model.Loan
import com.example.library.persistence.jpa.entity.LoanEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LoanRepository: JpaRepository<LoanEntity, Long> {
    fun findByUserIdAndBookIdInAndStatus(userId: Long, bookIds: List<Long>, status: Loan.LoanStatus): List<LoanEntity>
}