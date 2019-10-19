package com.functional.programming

import arrow.core.Either
import arrow.core.getOrElse
import arrow.core.left

class EitherExo {

    val books = listOf(
        Book("ISBNTEST1", "Programming Kotlin"),
        Book("ISBNTEST2", "The joy of Kotlin"),
        Book("ISBNTEST3", "Functional Kotlin")
    )

    fun findBookByTitle(title: String): Either<BookResult.BookNotFound, Book> {
        val foundBook = books.firstOrNull { it.title.equals(title, true) }
        return when(foundBook){
            null -> Either.left(BookResult.BookNotFound(title))
            else -> Either.right(foundBook)

        }
    }
}

fun main() {
    val foundBook = EitherExo().findBookByTitle("programming kotlin")
    val titleBook = foundBook.map { it.title }
    when{
        titleBook.isLeft() -> ""
        titleBook.isRight() -> ""
    }

    println(titleBook)
}
