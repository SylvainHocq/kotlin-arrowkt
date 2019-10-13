package com.functional.programming

fun main() {
    val books = listOf(
        Book("ISBNTEST1", "Programming Kotlin"),
        Book("ISBNTEST2", "The joy of Kotlin"),
        Book("ISBNTEST3", "Functional Kotlin")
    )

    val result = books.filter { it.title.contains("kotlin", true) }.map(Book::title)
    println("result :: $result")

}
