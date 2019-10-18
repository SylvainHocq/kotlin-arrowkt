package com.functional.programming

import arrow.optics.Lens

data class TechnicalBook(val isbn: String, val title: String, val publisher: Publisher)
data class Publisher(val name: String)

fun main() {

    val technicalBook = TechnicalBook("ISBNTEST1", "The joy of Kotlin", Publisher("packt"))

    val bookLens: Lens<TechnicalBook, Publisher> = Lens(
    get = { book -> book.publisher },
    set = { book, value -> book.copy(publisher = value) }
    )

    val publisherLens : Lens<Publisher, String> = Lens(
        get = { publisher -> publisher.name },
        set = { publisher, name -> publisher.copy(name = name) }
    )

    val bookPublisher =  bookLens compose publisherLens
    val result = bookPublisher.modify(technicalBook, String::toUpperCase)
    println(result)


}
