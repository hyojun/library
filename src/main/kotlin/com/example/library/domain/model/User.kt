package com.example.library.domain.model

open class User(
    open val id: Long?,
    open val name: String?) {
    constructor() : this(null, null)
}
