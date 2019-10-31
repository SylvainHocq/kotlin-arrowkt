package com.functional.programming

import arrow.core.Either
import arrow.core.extensions.fx
import arrow.core.flatMap


data class Freelance(val name: String, val company: Company?)
data class Company(val name: String, val intermediary: Intermediary?)
data class Intermediary(val name: String, val customer: Customer?)
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
    var freelance = Freelance("Riadh MNASRI", Company("Cool Technologies", Intermediary("Cool Intermediary", Customer("Cool Customer"))))
    findCustomer(freelance)

    findCustomerWithoutFlatMap(freelance)

    freelance = Freelance("Riadh MNASRI", Company("Cool Technologies", Intermediary("Cool Intermediary", null)))
    findCustomer(freelance)
}

private fun findCustomer(freelance: Freelance) {
    val comprehension = MonadComprehension()
    val customer = MonadComprehension().findFreelanceCompany(freelance)
            .flatMap { company ->
                comprehension.findIntermediary(company)
                        .flatMap { intermediary ->
                            comprehension.findFreelanceCustomer(intermediary)
                        }
            }
    val customerName = customer.fold({ Customer("Unknowed Customer") }, { it })
    println(customerName.name)
}

private fun findCustomerWithoutFlatMap(freelance: Freelance) {
    val customer: Either<Any, Customer> =
            Either.fx<Any, Customer> {
                val company = MonadComprehension().findFreelanceCompany(freelance).bind()
                val intermediary = MonadComprehension().findIntermediary(company).bind()
                val customer = MonadComprehension().findFreelanceCustomer(intermediary).bind()
                customer
            }
    println(customer)
}

sealed class SearchResult {
    class FreelanceCompanyNotFound(freelance: Freelance) : SearchResult()
    class CompanyIntermediaryNotFound(company: Company) : SearchResult()
    class CustomerNotFound(intermediary: Intermediary) : SearchResult()
}


