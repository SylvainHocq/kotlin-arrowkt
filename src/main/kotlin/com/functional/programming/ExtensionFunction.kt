package com.functional.programming

import java.time.LocalDateTime

fun Book.rate(note: Int): String{
    return when(note){
        in 1..5 -> "★".repeat(note)
        else -> "Note invalide !"
    }
}

fun Book.availability(): String {
    return when {
        this.editionDate.isBefore(LocalDateTime.now()) -> "disponible"
        else -> "indisponible"
    }
}

fun Book.titleInUpperCase(): String = this.title.toUpperCase()

fun main() {
    val book = Book("ISBNTEST1", "Programming Kotlin")
    val bookRate = book.rate(5)
    println("bookRate :: $bookRate")
}
