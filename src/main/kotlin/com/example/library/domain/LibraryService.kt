package com.example.library.domain

import com.example.library.configuration.LibraryConfigurationProperties
import com.example.library.userinterface.port.LibraryUIDrivingPort
import com.example.library.userinterface.port.model.LibraryResponse
import org.springframework.stereotype.Service

@Service
class LibraryService(val libraryConfigurationProperties: LibraryConfigurationProperties): LibraryUIDrivingPort {
    override fun info(): LibraryResponse {
        return LibraryResponse(libraryConfigurationProperties.name)
    }
}