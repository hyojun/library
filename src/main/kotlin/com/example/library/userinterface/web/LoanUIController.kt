package com.example.library.userinterface.web

import com.example.library.userinterface.port.LoanUIDrivingPort
import com.example.library.userinterface.port.model.LoanResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("loans")
class LoanUIController(val loanUIDrivingPort: LoanUIDrivingPort) {
    @GetMapping("{id}")
    fun getLoan(@PathVariable("id") id: Long): LoanResponse? {
        return loanUIDrivingPort.getLoan(id)
    }

    @PostMapping("lend")
    fun lendBooks(@RequestBody bookIds: List<Long>): ResponseEntity<Boolean> {
        loanUIDrivingPort.lendBooks(bookIds)
        return ResponseEntity.ok(true)
    }

    @PostMapping("return")
    fun returnBooks(@RequestBody bookIds: List<Long>): ResponseEntity<Boolean> {
        loanUIDrivingPort.returnBooks(bookIds)
        return ResponseEntity.ok(true)
    }
}
