package com.functional.programming

import arrow.core.Option
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
    arrayListOf<String>("Functional Kotlin", "The joy of Kotlin", "????")
            .map { OptionExo().findBookByTitle(it) }
            .map { findBookByTitle ->
                findBookByTitle
                        .fold(ifEmpty = {
                            "book not found!!!"
                        }, ifSome = {
                            "founded: $it"
                        })
                        .let { println(it) }
            }

}

