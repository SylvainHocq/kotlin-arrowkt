package com.functional.programming

import arrow.core.Either

class EitherExo {

    val books = listOf(
        Book("ISBNTEST1", "Programming Kotlin"),
        Book("ISBNTEST2", "The joy of Kotlin"),
        Book("ISBNTEST3", "Functional Kotlin")
    )

    fun findBookByTitle(title: String): Either<BookResult.BookNotFound, Book> {
        val result = books.firstOrNull { it.title.equals(title, true) }
        return when(result){
            null -> Either.left(BookResult.BookNotFound(title))
            else -> Either.right(result)
        }
    }
}

fun main() {
    val foundBook = EitherExo().findBookByTitle("programming kotlin")
    val foundBookTitle = foundBook.fold({ "Sorry! Book not found" }, { it.title })
    println(foundBookTitle)
}
