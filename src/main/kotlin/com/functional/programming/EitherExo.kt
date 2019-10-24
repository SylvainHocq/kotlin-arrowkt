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
        return when (val res = books.firstOrNull { it.title.equals(title, true) }) {
            null -> {
                Either.left(BookResult.BookNotFound(title))
            }
            else -> {
                Either.right(res)
            }
        }
    }
}

fun main() {
    arrayListOf<String>("Functional Kotlin", "The joy of Kotlin", "????")
            .map { EitherExo().findBookByTitle(it) }
            .map { findBookByTitle ->
                findBookByTitle.fold({ "book not found!!!" }, { "founded: $it" })
            }
            .map { println(it) }
}
