package year2023.day01

import util.Utils

var digitMap = mapOf(
    Pair("one", 1),
    Pair("two", 2),
    Pair("three", 3),
    Pair("four", 4),
    Pair("five", 5),
    Pair("six", 6),
    Pair("seven", 7),
    Pair("eight", 8),
    Pair("nine", 9))

fun main() {
    val filename = "input_2023_day01.txt"
    println("day 01 - task 1: ${task1(filename, "main")}")
}

fun task1(filename: String, mainOrTest: String): Int {
    val list = Utils().readFileAsStringList(filename, mainOrTest)

    var sum = 0
    for (string in list) {
        val firstDigit = string.firstOrNull { it.isDigit() }
        val lastDigit = string.lastOrNull { it.isDigit() }
        val toInt = "$firstDigit$lastDigit".toInt()
        sum += toInt
    }

    return sum
}
