package com.functional.programming

import arrow.Kind
import arrow.core.Option
import arrow.core.Try
import arrow.core.extensions.`try`.functor.functor
import arrow.core.extensions.option.functor.functor
import arrow.core.fix
import arrow.typeclasses.Functor

fun main() {
    val books = listOf(
        Book("ISBNTEST1", "Programming Kotlin"),
        Book("ISBNTEST2", "The joy of Kotlin"),
        Book("ISBNTEST3", "Functional Kotlin")
    )

    val result = books.filter { it.title.contains("465465", true) }.map(Book::title)
    println("result :: $result")

    fun <F> Functor<F>.addOne(fa: Kind<F, Int>) : Kind<F, Int> = fa.map { it + 1 }

    Option.functor().addOne(Option(1)).fix()
    Try.functor().addOne(Try { 1}).fix()

}
