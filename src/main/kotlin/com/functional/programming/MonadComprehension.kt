package com.functional.programming

import arrow.core.Either
import arrow.core.flatMap


data class Freelance(val name: String, val company: Company)
data class Company(val name: String, val intermediary: Intermediary)
data class Intermediary(val name: String, val customer: Customer)
data class Customer(val name: String)

class MonadComprehension {

    fun findFreelanceCompany(freelance: Freelance): Either<SearchResult.FreelanceCompanyNotFound, Company> {
        val result = freelance.company
        return when (result) {
            null -> Either.left(SearchResult.FreelanceCompanyNotFound(freelance))
            else -> Either.right(result)
        }
    }

    fun findIntermediary(company: Company): Either<SearchResult.CompanyIntermediaryNotFound, Intermediary> {
        val result = company.intermediary
        return when (result) {
            null -> Either.left(SearchResult.CompanyIntermediaryNotFound(company))
            else -> Either.right(result)
        }
    }

    fun findFreelanceCustomer(intermediary: Intermediary): Either<SearchResult.CustomerNotFound, Customer> {
        val result = intermediary.customer
        return when (result) {
            null -> Either.left(SearchResult.CustomerNotFound(intermediary))
            else -> Either.right(result)
        }
    }

}

fun main() {
    val freelance = Freelance("Riadh MNASRI", Company("Cool Technologies", Intermediary("Cool Intermediary", Customer("Cool Customer"))))
    val comprehension = MonadComprehension()
    val customer = MonadComprehension().findFreelanceCompany(freelance)
        .flatMap { company -> comprehension.findIntermediary(company)
                                           .flatMap { intermediary -> comprehension.findFreelanceCustomer(intermediary)
        }
    }
    val customerName = customer.fold({ 1 }, { it }) as Customer
    println(customerName.name)
}

sealed class SearchResult {
    class FreelanceCompanyNotFound(freelance: Freelance) : SearchResult()
    class CompanyIntermediaryNotFound(company: Company) : SearchResult()
    class CustomerNotFound(intermediary: Intermediary) : SearchResult()
}


