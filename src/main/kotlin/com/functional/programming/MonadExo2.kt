package com.functional.programming

import arrow.core.Option
import arrow.core.getOrElse
import arrow.core.toOption

fun <T, R> Option<T>.mapCustom(transform: (T) -> R): Option<R> {
    //TODO complete code ...
    return Option.empty()
}


fun main() {
    val optBook = Book("ISBNTEST1", "Programming Kotlin", "Programming", listOf(Author("Author 1"), Author("Author 2"))).toOption()
    val bookTitle = optBook.mapCustom { it.title }
    println(" bookTitle:: ${bookTitle.getOrElse { "Not Found" }}")
}
