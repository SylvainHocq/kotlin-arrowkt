package com.functional.programming

import java.time.LocalDateTime

fun Book.availability(): String{
    return when {
        this.editionDate.isAfter(LocalDateTime.now()) -> "Indisponible"
        else -> "disponible"
    }
}

fun Book.titleInUpperCase(): String{
    return this.title.toUpperCase()
}

fun Book.rate(note: Int):String{
    return when(note){
        in 1..5 -> "★".repeat(note)
        else -> "Note invalide"
    }
}

fun main() {
    val book = Book("ISBNTEST1", "Programming Kotlin")
    val note = book.rate(5)
    println("note :: $note")
}
