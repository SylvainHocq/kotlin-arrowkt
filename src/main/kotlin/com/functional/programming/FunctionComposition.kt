package com.functional.programming

import arrow.core.compose

fun bookTitle(book: Book): String = book.title

fun toUpperCase(text: String) = text.toUpperCase()

fun main() {
    val bookTitleInUpperCase= ::toUpperCase compose ::bookTitle
    val kotlinBook = Book("ISBNTEST1", "programming kotlin")
    val result = bookTitleInUpperCase(kotlinBook)
    println("result:: $result")

}
