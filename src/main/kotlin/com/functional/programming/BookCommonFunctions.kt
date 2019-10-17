package com.functional.programming

fun createBook(isbn: String, title: String, type: String): Book {
    return Book(isbn, title, type)
}
