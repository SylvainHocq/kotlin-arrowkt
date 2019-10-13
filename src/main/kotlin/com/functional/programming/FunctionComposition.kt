package com.functional.programming

import arrow.core.compose

fun Book.bookTitle() = this.title

fun main() {

    val toUpperCase: (String) -> String = { text -> text.toUpperCase()}
    val bookTitle: (book: Book) -> String = {book -> book.title}
    val bookTitleUpperCase: (book: Book) -> String = toUpperCase compose bookTitle
    println(bookTitleUpperCase(Book("ISBN", "programming kotlin")))
}
