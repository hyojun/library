package com.example.library.persistence.jpa.entity;

import com.example.library.domain.model.Book
import java.time.LocalDate
import javax.persistence.*

@Entity(name = "book")
class BookEntity (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) override val id: Long?,
    override val name: String?,
    override val author: String?,
    override val publishDate:LocalDate?,
    @Enumerated(EnumType.STRING) override var status: BookStatus?)
    : Book(id, name, author, publishDate, status) {
    fun inLending() {
        this.status = BookStatus.IN_LENDING
    }

    fun available() {
        this.status = BookStatus.AVAILABLE
    }
}