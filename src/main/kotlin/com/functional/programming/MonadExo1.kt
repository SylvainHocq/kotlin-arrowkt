package com.functional.programming

fun main() {
    val books = listOf(
            Book("ISBNTEST1", "Programming Kotlin", "Programming", listOf(Author("Author 1"), Author("Author 2"))),
            Book("ISBNTEST2", "The joy of Kotlin", "Programming", listOf(Author("Author 3"), Author("Author 4"))),
            Book("ISBNTEST3", "Functional Kotlin", "Programming", listOf(Author("Author 5"))),
            Book("ISBNTEST4", "Programming Rust", "Programming", listOf(Author("Author 6"), Author("Author 7")))
    )


//    interface Monad<F>{
//        fun <A, B> Kind<F, A>.flatMap(f: (A) -> Kind<F, B>): Kind<F, B>
//    }


    val res = authors(books)
    println("authors : $res")

}

fun authors(books: List<Book>) = books.filter { it.title.contains("kotlin", true) }.flatMap { it.authors }
