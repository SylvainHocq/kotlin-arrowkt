package com.functional.programming

import arrow.core.Either
import arrow.core.left

class EitherExo {

    val books = listOf(
        Book("ISBNTEST1", "Programming Kotlin"),
        Book("ISBNTEST2", "The joy of Kotlin"),
        Book("ISBNTEST3", "Functional Kotlin")
    )

    fun findBookByTitle(title: String): Either<BookResult.BookNotFound, Book> {
        //TODO complete code ...
        return BookResult.BookNotFound(title).left()
    }
}

fun main() {
    val foundBook = EitherExo().findBookByTitle("programming kotlin")
    //TODO complete code ...
}
