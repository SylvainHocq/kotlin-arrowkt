package com.functional.programming

class BookRepository {

    val books = listOf(
        Book("ISBNTEST1", "Programming Kotlin"),
        Book("ISBNTEST2", "The joy of Kotlin"),
        Book("ISBNTEST3", "Functional Kotlin"),
        Book("ISBNTEST4", "Programming Rust")
    )

    fun findBookByIsbn(isbn: String): BookResult {
      val foundBook = books.firstOrNull { it.isbn==isbn }
        return when(foundBook){
            null -> BookResult.BookNotFound(isbn)
            else -> BookResult.FoundBook(foundBook)
        }

    }

}

fun main() {
   val result = BookRepository().findBookByIsbn("ISBNTEST1")
   when(result){
       is BookResult.BookNotFound -> println("Bouquin indispo !")
       is BookResult.FoundBook -> println("Bouquin dispo !")
   }
}
