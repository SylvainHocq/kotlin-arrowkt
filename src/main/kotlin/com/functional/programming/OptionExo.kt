package com.functional.programming

import arrow.core.Option
import arrow.core.getOrElse
import arrow.core.right
import arrow.core.toOption

class OptionExo {

    val books = listOf(
        Book("ISBNTEST1", "Programming Kotlin"),
        Book("ISBNTEST2", "The joy of Kotlin"),
        Book("ISBNTEST3", "Functional Kotlin")
    )

    fun findBookByTitle(title: String): Option<Book> {
       return books.firstOrNull { it.title.equals(title, true) }.toOption()
    }

}

fun main() {
    val result = OptionExo().findBookByTitle("programming Kotlin")
    val bookTitle = result.map { it.title }.getOrElse { 1 }
    println("result :: $bookTitle")
}
