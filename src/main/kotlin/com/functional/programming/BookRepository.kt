package com.functional.programming

class BookRepository {

    val books = listOf(
        Book("ISBNTEST1", "Programming Kotlin"),
        Book("ISBNTEST2", "The joy of Kotlin"),
        Book("ISBNTEST3", "Functional Kotlin"),
        Book("ISBNTEST4", "Programming Rust")
    )

    fun findBookByIsbn(isbn: String): BookResult{
        val result =  books.find { it.isbn == isbn }
        return when(result){
            null -> BookResult.BookNotFound(isbn)
            else -> BookResult.FoundBook(result)
        }
    }

    fun isAvailable(isbn: String): Boolean{
        val bookResult = findBookByIsbn(isbn)
        return when(bookResult){
            is BookResult.FoundBook -> true
            else -> false
        }
    }

}

fun main() {
    val isbnTest1 = "ISBNTEST1"
    val isAvailable = BookRepository().isAvailable(isbnTest1)
    println("Book with $isbnTest1 - isAvailable: $isAvailable")
}
