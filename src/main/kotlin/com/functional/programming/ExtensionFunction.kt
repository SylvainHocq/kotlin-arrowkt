package com.functional.programming

import java.time.LocalDateTime

fun Book.rate(note: Int): String{
    return when(note){
        in 1..5 -> "★".repeat(note)
        else -> "Invalid note !!"
    }
}

fun Book.availability(): String{
    return when {
        this.editionDate.isAfter(LocalDateTime.now()) -> "Indisponible"
        else -> "disponible"
    }
}

fun Book.titleInUpperCase(): String{
    return this.title.toUpperCase()
}

fun Int.isEven() = this % 2 == 0

fun main() {
    val book = Book("ISBNTEST1", "Programming Kotlin")
    val bookRate = book.rate(5)
    println("Book ${book.title} rated: $bookRate")
    println("isEven: "+ 1.isEven())
}
