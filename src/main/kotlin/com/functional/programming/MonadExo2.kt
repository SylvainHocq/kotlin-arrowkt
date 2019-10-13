package com.functional.programming

import arrow.core.Option

fun <T, R> Option<T>.map(transform: (T) -> R): Option<R> {
   return this.flatMap { Option.just(transform(it))}
}

fun main() {
    val books = listOf(
        Book("ISBNTEST1", "Programming Kotlin", listOf(Author("Author 1"), Author("Author 2"))),
        Book("ISBNTEST2", "The joy of Kotlin", listOf(Author("Author 3"), Author("Author 4"))),
        Book("ISBNTEST3", "Functional Kotlin", listOf(Author("Author 5"))),
        Book("ISBNTEST4", "Programming Rust", listOf(Author("Author 6"), Author("Author 7")))
    )

    val result = books.filter{it.title.contains("kotlin", true)}.map { b -> b.title }
    println("result :: $result")
}
