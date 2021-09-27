package com.example.library.persistence.jpa

import com.example.library.domain.exception.BookInLendingException
import com.example.library.domain.model.Book
import com.example.library.domain.model.Loan
import com.example.library.persistence.jpa.entity.BookEntity
import com.example.library.persistence.jpa.entity.LoanEntity
import com.example.library.persistence.jpa.entity.UserEntity
import com.example.library.persistence.port.LoanPersistenceDrivenPort
import org.springframework.stereotype.Component
import java.util.*
import javax.transaction.Transactional

@Component
@Transactional
class LoanPersistenceJpaAdapter(
    val userRepository: UserRepository,
    val bookRepository: BookRepository,
    val loanRepository: LoanRepository)
    : LoanPersistenceDrivenPort {

    override fun getLoan(id: Long): Loan? {
        return loanRepository.findById(id).orElse(null)
    }

    override fun lendBooks(userId: Long, bookIds: List<Long>) {
        val user: UserEntity = userRepository.findById(userId).orElseThrow()
        val books: List<BookEntity> = bookRepository.findAllById(bookIds)

        val booksInLending = books.filter { it.status == Book.BookStatus.IN_LENDING }
        if (!booksInLending.isEmpty()) {
            throw BookInLendingException(booksInLending.map { it.id!! })
        }

        loanRepository.saveAll(
            books.map {book ->
                LoanEntity(user, book, Loan.LoanStatus.IN_LENDING, Date(), null)
            }
        )

        bookRepository.saveAll(books.onEach { it.inLending() })
    }

    override fun returnBook(userId: Long, bookIds: List<Long>) {
        val books: List<BookEntity> = bookRepository.findAllById(bookIds)
        val loans: List<LoanEntity> = loanRepository.findByUserIdAndBookIdInAndStatus(userId, bookIds, Loan.LoanStatus.IN_LENDING)

        loanRepository.saveAll(
            loans.onEach {loan ->
                loan.returned()
            }
        )

        bookRepository.saveAll(books.onEach { it.available() })
    }
}