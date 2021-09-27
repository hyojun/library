package com.example.library.userinterface.port.model

import com.example.library.domain.model.User

class UserResponse(
    val id: Long,
    val name: String) {
    companion object {
        fun from(user: User): UserResponse {
            return UserResponse(user.id!!, user.name!!)
        }
    }
}