package com.example.library.persistence.jpa.entity

import com.example.library.domain.model.User
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "user")
class UserEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) override val id: Long?,
    override val name: String?)
    : User(id, name)
