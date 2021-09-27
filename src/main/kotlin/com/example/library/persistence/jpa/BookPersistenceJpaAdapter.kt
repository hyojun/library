package com.example.library.persistence.jpa

import com.example.library.domain.model.Book
import com.example.library.persistence.port.BookPersistenceDrivenPort
import com.example.library.userinterface.port.model.BookSearchParameter
import org.springframework.stereotype.Component
import java.time.LocalDate
import javax.transaction.Transactional

@Component
@Transactional
class BookPersistenceJpaAdapter(
    val bookRepository: BookRepository)
    : BookPersistenceDrivenPort {

    override fun searchBooks(bookSearchParameter: BookSearchParameter): List<Book> {
        return bookRepository.findByAuthorLikeAndNameLikeAndPublishDateBetween(
            bookSearchParameter.author?.let { "%${it}%" }?: "%",
            bookSearchParameter.name?.let { "%${it}%" }?: "%",
            bookSearchParameter.fromDate?: LocalDate.of(1,1,1),
            bookSearchParameter.toDate?: LocalDate.of(9999,12,31)
        )
    }
}