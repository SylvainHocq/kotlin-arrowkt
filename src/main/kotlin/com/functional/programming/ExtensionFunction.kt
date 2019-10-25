package com.functional.programming

fun Book.availability(): String {
    //TODO complete code ...
    return ""
}

fun Book.titleInUpperCase(): String {
    //TODO complete code ...
    return ""
}


fun Book.note(value: Int): String {
    return when (value) {
        in 1..5 -> {
            "*".repeat(value)
        }
        else -> {
            "note not available"
        }
    }
}

fun main() {
    val book = Book("ISBNTEST1", "Programming Kotlin")

    println(book.note(4))
    println(book.note(9))

}
