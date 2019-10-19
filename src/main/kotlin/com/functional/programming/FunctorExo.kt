package com.functional.programming

fun main() {
    val books = listOf(
        Book("ISBNTEST1", "Programming Kotlin"),
        Book("ISBNTEST2", "The joy of Kotlin"),
        Book("ISBNTEST3", "Functional Kotlin")
    )

val bookTitles =  books.map { it.title }
    println(bookTitles)

}
