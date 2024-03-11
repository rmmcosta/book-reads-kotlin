package com.rmmcosta.bookreadskotlin.book

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/books")
class BookController(val bookRepository: BookRepository) {
    @GetMapping("/{id}")
    fun getBookById(@PathVariable id: String, model: Model): String {
        model.addAttribute("bookId", id)
        val book = bookRepository.findByIdOrNull(id) ?: return "book-not-found"
        model.addAttribute("imageUrl", "/images/unavailable.png")
        model.addAttribute("book", book)
        book.covers?.firstOrNull()?.let {
            model.addAttribute("imageUrl", "https://covers.openlibrary.org/b/id/${it}-L.jpg")
        }
        return "book"
    }
}