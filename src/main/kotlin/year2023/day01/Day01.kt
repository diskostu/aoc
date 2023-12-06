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
    Pair("nine", 9)
)

fun main() {
    val list = Utils().readFileAsStringList("input_2023_day01.txt", "main")
//    println("day 01 - task 1: ${task1(list)}")
    println("day 01 - task 2: ${task2(list)}")
}

fun task1(list: List<String>): Int {
    var sum = 0
    for (string in list) {
        val firstDigit = string.firstOrNull { it.isDigit() }
        val lastDigit = string.lastOrNull { it.isDigit() }
        val toInt = "$firstDigit$lastDigit".toInt()
        sum += toInt
    }

    return sum
}


fun task2(list: List<String>): Int {
    var sum = 0
    for (string in list) {
        val firstDigit = getFirstDigitOrWordDigitInString(string)
        val lastDigit = getLastDigitOrWordDigitInString(string)
        sum += "$firstDigit$lastDigit".toInt()
    }

    return sum
}


private fun getFirstDigitOrWordDigitInString(string: String): Int {
    var currentIndex = Int.MAX_VALUE
    var currentDigitWord = ""
    for (digitWord in digitMap.keys) {
        val indexOf = string.indexOf(digitWord)
        if (indexOf in 0..<currentIndex) {
            currentIndex = indexOf
            currentDigitWord = digitWord
        }
    }

    val firstOrNull = string.firstOrNull { it.isDigit() }
    return if (firstOrNull != null && string.indexOf(firstOrNull) < currentIndex) {
        firstOrNull.digitToInt()
    } else {
        digitMap[currentDigitWord]!!
    }
}


private fun getLastDigitOrWordDigitInString(string: String): Int {
    var currentIndex = 0
    var currentDigitWord = ""
    for (digitWord in digitMap.keys) {
        val indexOf = string.lastIndexOf(digitWord)
        if (indexOf > currentIndex) {
            currentIndex = indexOf
            currentDigitWord = digitWord
        }
    }

    val lastOrNull = string.lastOrNull { it.isDigit() }
    return if (lastOrNull != null && string.indexOf(lastOrNull) >= currentIndex) {
        lastOrNull.digitToInt()
    } else {
        digitMap[currentDigitWord]!!
    }
}
