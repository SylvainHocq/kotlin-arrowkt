package com.functional.programming

class BookRepository {

    val books = listOf(
            Book("ISBNTEST1", "Programming Kotlin"),
            Book("ISBNTEST2", "The joy of Kotlin"),
            Book("ISBNTEST3", "Functional Kotlin"),
            Book("ISBNTEST4", "Programming Rust")
    )

    fun findBookByIsbn(isbn: String): BookResult {
        return when (val res = books.find { it.isbn == isbn }) {
            null -> BookResult.BookNotFound(isbn)
            else -> BookResult.FoundBook(res)
        }
    }
}

fun main() {
    val bookRepository = BookRepository()
    arrayListOf<String>("ISBNTEST4", "????")
            .map { bookRepository.findBookByIsbn(it) }
            .map {
                when (it) {
                    is BookResult.BookNotFound -> {
                        println("book found ${it.title}")
                    }
                    is BookResult.FoundBook -> {
                        println("book found ${it.book}")
                    }
                }
            }
    println()
    println(bookRepository.findBookByIsbn("????"))
}
