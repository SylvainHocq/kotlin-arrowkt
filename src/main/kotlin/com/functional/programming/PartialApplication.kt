package com.functional.programming

import arrow.syntax.function.partially2
import arrow.syntax.function.partially3

fun createBook(isbn: String, title: String, type: String): Book {
    return Book(isbn, title, type)
}

fun main() {
    val createProgrammingBook: (String, String) -> Book = ::createBook.partially3("Programming")
    val programmingKotlinBook = createProgrammingBook("ISBNTEST1", "Programming Kotlin")
    println(programmingKotlinBook)
}
