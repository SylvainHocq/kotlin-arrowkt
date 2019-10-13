package com.functional.programming

fun Book.rate(note: Int): String{
    return when(note){
        in 1..5 -> "★".repeat(note)
        else -> "Invalid note !!"
    }
}

fun main() {
    val book = Book("ISBNTEST1", "Programming Kotlin")
    val bookRate = book.rate(5)
    println("Book ${book.title} rated: $bookRate")
}
