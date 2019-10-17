package com.functional.programming

class BookRepository {

    val books = listOf(
        Book("ISBNTEST1", "Programming Kotlin"),
        Book("ISBNTEST2", "The joy of Kotlin"),
        Book("ISBNTEST3", "Functional Kotlin"),
        Book("ISBNTEST4", "Programming Rust")
    )

    fun findBookByIsbn(isbn: String): BookResult{
      //TODO complete code ...
        return BookResult.BookNotFound(isbn)
    }

    fun isAvailable(isbn: String): Boolean{
        //TODO complete code ...
        return false
    }

}

fun main() {
    //TODO complete code ...
}
