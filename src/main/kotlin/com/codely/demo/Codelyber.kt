package com.codely.demo

import java.time.LocalDate
import java.time.Period

fun main() {
    println("Please, enter your birthday with the format <yyyy-MM-dd>:")
    val input = readLine()
    val birthday = LocalDate.parse(input)
    val difference = Period.between(birthday, LocalDate.now())
    println("Years from birthday: ${difference.years}")
}
