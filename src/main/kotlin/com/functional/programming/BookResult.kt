package com.functional.programming

sealed class BookResult {

    class FoundBook(val book: Book): BookResult()
    class BookNotFound(val title: String): BookResult()
    class BookNotFound2(val title: String): BookResult()

}
