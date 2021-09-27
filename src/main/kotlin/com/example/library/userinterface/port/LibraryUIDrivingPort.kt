package com.example.library.userinterface.port

import com.example.library.userinterface.port.model.LibraryResponse

interface LibraryUIDrivingPort {
    fun info(): LibraryResponse
}
