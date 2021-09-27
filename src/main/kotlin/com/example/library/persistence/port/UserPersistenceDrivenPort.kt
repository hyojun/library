package com.example.library.persistence.port

import com.example.library.domain.model.User

interface UserPersistenceDrivenPort {
    fun getUser(id: Long): User?
}
