package com.functional.programming

sealed class BookResult {

    class FoundBook(book: Book): BookResult()
    class BookNotFound(title: String): BookResult()
}
