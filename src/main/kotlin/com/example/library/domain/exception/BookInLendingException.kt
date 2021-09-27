package com.example.library.domain.exception

class BookInLendingException(
    val bookIdsInLending: List<Long>)
    : Exception("bookIdsInLending:${bookIdsInLending.joinToString(",")}")
