package com.rmmcosta.bookreadskotlin.search

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.reactive.function.client.WebClient

@Controller
@RequestMapping("/search")
class SearchController {
    private var webClient: WebClient = WebClient.create("https://openlibrary.org")

    @GetMapping
    fun search(@RequestParam term: String, model: Model): String {
        val result = webClient.get()
            .uri("/search.json?q=$term&limit=3")
            .retrieve()
            .bodyToMono(SearchDTO::class.java)
            .block()

        val docs: List<DocDTO>? = result?.docs?.map {
            it.copy(imageUrl = if (it.coverId != null) "https://covers.openlibrary.org/b/id/${it.coverId}-M.jpg" else "/images/unavailable.png")
        }

        return if (docs != null) {
            model.addAttribute("docs", docs)
            "search"
        } else {
            "search-not-found"
        }
    }
}