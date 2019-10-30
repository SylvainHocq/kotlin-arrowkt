package com.functional.programming

import arrow.core.Eval
import arrow.core.Option
import arrow.core.Some
import arrow.core.Tuple2
import arrow.core.extensions.list.apply.ap
import arrow.core.extensions.option.applicative.applicative
import java.time.LocalDateTime

fun main() {
    val books = listOf(
        Book("ISBNTEST1", "Programming Kotlin", "Programming", listOf(Author("A1"), Author("A2")), 10000, LocalDateTime.now().minusYears(2)),
        Book("ISBNTEST2", "The joy of Kotlin", "Programming", listOf(Author("B1"), Author("B2")), 5000, LocalDateTime.now().minusYears(3)),
        Book("ISBNTEST3", "Functional Kotlin", "Programming", listOf(Author("C1"), Author("C2")), 7000, LocalDateTime.now().minusYears(1))
    )

    val functions = listOf<(Book) -> Any>(Book::titleInUpperCase, Book::availability)

    val result= books.ap(functions).joinToString()
    println("result :: $result")


    val  ap = Option.applicative().run { Some(1).ap(Some({ n: Int -> n + 1 })) }
    println("ap: $ap")

    val ap2 = Option.applicative().run { Some(1).map2Eval(Eval.later { Some("x") }, { z: Tuple2<Int, String> ->  "${z.a}${z.b}" }).value() }
    println("ap: $ap")
}
