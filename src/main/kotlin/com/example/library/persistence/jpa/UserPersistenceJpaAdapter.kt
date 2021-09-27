package com.example.library.persistence.jpa

import com.example.library.domain.model.User
import com.example.library.persistence.port.UserPersistenceDrivenPort
import org.springframework.stereotype.Component
import javax.transaction.Transactional

@Component
@Transactional
class UserPersistenceJpaAdapter(
    val userRepository: UserRepository)
    : UserPersistenceDrivenPort {

    override fun getUser(id: Long): User? {
        return userRepository.findById(id).orElse(null)
    }
}