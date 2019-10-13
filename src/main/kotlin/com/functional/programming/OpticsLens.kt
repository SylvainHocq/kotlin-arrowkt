package com.functional.programming

import arrow.optics.Lens

fun main() {
    val playerLens: Lens<Book, String> = Lens(
        get = { book -> book.title },
        set = { book, value -> book.copy(title = value) }
    )

    val book =  Book("ISBNTEST1", "Programming Kotlin")
    val modifiedBook = playerLens.set(book, "The Joy of Kotlin")
    println(modifiedBook)
}
