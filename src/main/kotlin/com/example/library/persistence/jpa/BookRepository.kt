package com.example.library.persistence.jpa

import com.example.library.persistence.jpa.entity.BookEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface BookRepository: JpaRepository<BookEntity, Long> {
    fun findByAuthorLikeAndNameLikeAndPublishDateBetween(
        author: String,
        name: String,
        fromDate: LocalDate,
        toDate: LocalDate
    ): List<BookEntity>
}
