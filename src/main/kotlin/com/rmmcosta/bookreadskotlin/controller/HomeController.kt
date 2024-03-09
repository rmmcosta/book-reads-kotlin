package com.rmmcosta.bookreadskotlin.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {
    @GetMapping("/")
    fun home(): String {
        return "Hello, Home!"
    }

    @GetMapping("/secured")
    fun secured(): String {
        return "Hello, Secured!"
    }
}