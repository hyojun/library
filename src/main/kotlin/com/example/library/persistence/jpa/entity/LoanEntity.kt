package com.example.library.persistence.jpa.entity

import com.example.library.domain.model.Loan
import java.util.*
import javax.persistence.*

@Entity(name = "loan")
class LoanEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) override val id: Long?,
    @ManyToOne override val user: UserEntity?,
    @ManyToOne override val book: BookEntity?,
    override var status: LoanStatus?,
    override val lentDate: Date,
    override var returnedDate: Date?)
    : Loan(id, user, book, status, lentDate, returnedDate) {
        constructor(
            user: UserEntity?, book: BookEntity?, status: LoanStatus?, lentDate: Date, returnedDate: Date?
        ) : this(null, user, book, status, lentDate, returnedDate)

    fun returned() {
        this.status = LoanStatus.RETURNED
        this.returnedDate = Date()
    }
}
