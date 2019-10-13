package com.functional.programming

import arrow.core.Either
import arrow.core.Option
import arrow.core.extensions.option.functor.functor
import arrow.core.flatMap

fun main() {
    val books = listOf(
        Book("ISBNTEST1", "Programming Kotlin"),
        Book("ISBNTEST2", "The joy of Kotlin"),
        Book("ISBNTEST3", "Functional Kotlin")
        )

    println(books.map(Book::title))

    /*val right: Either<String, Int> = Either.Right(5)
    right.flatMap { r -> r. }*/
}
