package com.functional.programming

import java.time.LocalDateTime

data class Book(val isbn: String,
                val title: String,
                val type: String="",
                val authors: List<Author> = emptyList(),
                val numberOfReaders: Long = 0,
                val editionDate: LocalDateTime = LocalDateTime.now())
