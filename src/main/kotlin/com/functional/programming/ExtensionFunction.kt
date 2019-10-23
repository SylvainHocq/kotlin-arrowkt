package com.functional.programming


fun Book.note(note:Int):String {
    return when(note) {
        in 1..5 -> "*".repeat(note)
        else -> "unknowed"
    }
}

fun Book.availability(): String {
    //TODO complete code ...
    return ""
}

fun Book.titleInUpperCase(): String {
    //TODO complete code ...
    return ""
}

fun main() {
    val book = Book("ISBNTEST1", "Programming Kotlin")
    println("Note ${book.note(4)}")
    println("Note ${book.note(6)}")
}
