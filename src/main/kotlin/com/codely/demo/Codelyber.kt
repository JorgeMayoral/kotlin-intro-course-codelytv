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
    }.run {
        with(Period.between(this, LocalDate.now())) {
            println("Years from birthday: ${this.years}")
        }
    }
}

