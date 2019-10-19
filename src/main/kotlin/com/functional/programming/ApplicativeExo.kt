package com.functional.programming

import arrow.core.extensions.list.apply.ap
import java.time.LocalDateTime

fun main() {
    val books = listOf(
        Book("ISBNTEST1", "Programming Kotlin", "Programming", listOf(Author("A1"), Author("A2")), 10000, LocalDateTime.now().minusYears(2)),
        Book("ISBNTEST2", "The joy of Kotlin", "Programming", listOf(Author("B1"), Author("B2")), 5000, LocalDateTime.now().minusYears(3)),
        Book("ISBNTEST3", "Functional Kotlin", "Programming", listOf(Author("C1"), Author("C2")), 7000, LocalDateTime.now().minusYears(1))
    )

    val functions = listOf<(Book) -> Any>(Book::titleInUpperCase, Book::availability)

    val result = books.ap(functions).joinToString(" - ")
    println(result)

}
