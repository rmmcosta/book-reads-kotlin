package com.rmmcosta.bookreadskotlin.search

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class SearchDTO(
    val numFound: Int,
    val start: Int,
    val numFoundExact: Boolean,
    val docs: List<DocDTO>,
    val q: String,
    val offset: Int?,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class DocDTO(
    val key: String,
    val title: String,
    @JsonProperty("author_key")
    val authorKey:List<String>,
    @JsonProperty("author_name")
    val authorName: List<String>,
    @JsonProperty("first_publish_year")
    val firstPublishYear: Int,
    @JsonProperty("cover_i")
    val coverId: Long?,
    val imageUrl: String?,
)