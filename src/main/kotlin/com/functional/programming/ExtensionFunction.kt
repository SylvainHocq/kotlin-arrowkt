package com.functional.programming

import java.time.LocalDateTime

fun Book.rate(note: Int): String{
    //TODO complete code ...
    return ""
}

fun Book.availability(): String {
    //TODO complete code ...
    return ""
}

fun Book.titleInUpperCase(): String{
    //TODO complete code ...
    return ""
}

fun main() {
    val book = Book("ISBNTEST1", "Programming Kotlin")
    val bookRate = book.rate(5)
    println("Book ${book.title} rated: $bookRate")
}
