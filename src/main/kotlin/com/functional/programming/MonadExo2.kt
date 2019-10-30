package com.functional.programming

import arrow.core.Option
import arrow.core.Some
import arrow.core.extensions.option.monad.flatMap
import arrow.core.getOrElse
import arrow.core.toOption

fun <T, R> Option<T>.mapCustom(transform: (T) -> R): Option<R> {
    return this.flatMap { Option.just(transform(it)) }
}


fun main() {
    val optBook = Book("ISBNTEST1", "Programming Kotlin", "Programming", listOf(Author("Author 1"), Author("Author 2"))).toOption()
    val bookTitle = optBook.mapCustom { it.title }
    println(" bookTitle:: ${bookTitle.getOrElse { "Not Found" }}")
}


