package com.functional.programming

sealed class BookResult {

    class FoundBook(val book: Book): BookResult()
    class BookNotFound(title: String): BookResult()
}
