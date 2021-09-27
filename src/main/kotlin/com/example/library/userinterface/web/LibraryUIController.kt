package com.example.library.userinterface.web

import com.example.library.userinterface.port.LibraryUIDrivingPort
import com.example.library.userinterface.port.model.LibraryResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("library")
class LibraryUIController(val libraryUIDrivingPort: LibraryUIDrivingPort) {
    @GetMapping
    fun info(): LibraryResponse {
        return libraryUIDrivingPort.info()
    }
}