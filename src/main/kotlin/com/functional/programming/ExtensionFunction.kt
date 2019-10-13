package com.functional.programming

import java.time.LocalDateTime

fun Book.rate(note: Int): String{
    return when(note){
        in 1..5 -> "★".repeat(note)
        else -> "Invalid note !!"
    }
}

fun Book.isAvailable(): Boolean{
    return when {
        this.editionDate.isAfter(LocalDateTime.now()) -> false
        else -> true
    }
}

fun Book.titleInUpperCase(): String{
    return this.title.toUpperCase()
}

fun main() {
    val book = Book("ISBNTEST1", "Programming Kotlin")
    val bookRate = book.rate(5)
    println("Book ${book.title} rated: $bookRate")
}
