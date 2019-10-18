package com.functional.programming

import arrow.syntax.function.curried

fun main() {
    val curriedBook : (String) -> (String) -> (String) -> (Book) = ::createBook.curried()
    val result = curriedBook("ISBNTEST2")("The joy of kotlin")("programming")
    println("result :: $result")
}
