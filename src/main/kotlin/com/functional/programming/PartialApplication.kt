package com.functional.programming

import arrow.syntax.function.partially2

fun createBook(isbn: String, title: String, type: String): Book {
    return Book(isbn, title, type)
}

fun main() {
    val createProgrammingBook: (String, String) -> Book = ::createBook.partially2("Programming")
    val programmingKotlinBook = createProgrammingBook("ISBNTEST1", "Programming Kotlin")
    println(programmingKotlinBook)
}
