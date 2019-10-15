package com.functional.programming

import arrow.syntax.function.curried


fun multiply(x: Int, y: Int, z: Int): Int {
    return x * y * z
}


fun main() {
    val createProgrammingBook: (String) -> (String) -> (String) -> Book = ::createBook.curried()
    val result = createProgrammingBook("ISBNTEST1")("Programming Kotlin")("Programming")
    println(result)

    val curriedMultiply: (Int) -> (Int) -> (Int) -> Int = ::multiply.curried()
    val result2 = curriedMultiply(5)(5)(3)
    println(result2)
}
