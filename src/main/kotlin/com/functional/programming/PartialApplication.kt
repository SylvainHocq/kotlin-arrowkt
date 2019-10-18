package com.functional.programming

import arrow.syntax.function.partially3


fun multiply(x: Int, y: Int, z: Int): Int {
    return x * y * z
}

fun main() {

    val multiplyBy3: (x: Int, y: Int) -> Int = ::multiply.partially3(3)
    println(multiplyBy3(5,5))

    val createProgrammingBook = ::createBook.partially3("programming")
    val kotlinBook = createProgrammingBook("ISBNTEST1", "Programming Kotlin")
    println(kotlinBook)

}


