package com.functional.programming

import java.time.LocalDateTime
import java.util.*

fun Book.availability(): Boolean {
    return when {
        this.editionDate.isAfter(LocalDateTime.now()) -> false
        else -> true
    }
}

fun Book.titleInUpperCase(): String {
    return title.toUpperCase()
}


fun Book.note(value: Int): String {
    return when (value) {
        in 1..5 -> {
            "*".repeat(value)
        }
        else -> {
            "note not available"
        }
    }
}

fun main() {
    val book = Book("ISBNTEST1", "Programming Kotlin")

    println(book.note(4))
    println(book.note(9))

}
