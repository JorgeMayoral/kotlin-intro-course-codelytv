package com.codely.demo

import java.time.LocalDate
import java.time.Period
import kotlin.system.exitProcess

fun main() {
    println("Please, enter your birthday with the format <yyyy-MM-dd>:")

    readLine().takeUnless {
        it.isNullOrEmpty() || it.isBlank()
    }?.let {
        LocalDate.parse(it)
    }.apply {
        if (this == null) {
            println("The date is not valid")
            exitProcess(1)
        }
    }?.also {
        println("Your birthday is $it")
    }?.run {
        calculateDifference()
    }
}

private fun LocalDate.calculateDifference() = with(Period.between(this, LocalDate.now())) {
    when {
        years >= 18 -> println("You are older than 18 years, you have $years years.")
        years > 0 -> println("You are younger than 18 years, you have $years years.")
        months > 0 -> println("Months from birthday: $months")
        days > 0 -> println("Days from birthday: $days")
    }
}
