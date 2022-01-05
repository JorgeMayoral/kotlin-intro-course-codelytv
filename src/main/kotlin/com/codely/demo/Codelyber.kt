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
        years > 0 -> println("Years from birthday: $years")
        months > 0 -> println("Months from birthday: $months")
        days > 0 -> println("Days from birthday: $days")
    }
}
