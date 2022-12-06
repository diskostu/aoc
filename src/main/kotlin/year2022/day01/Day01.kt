package year2022.day01

import util.Utils

fun main() {
    val filename = "input_2022_day01.txt"
    println("day 01 - task 1: ${task1(filename, "main")}")
    println("day 01 - task 1: ${task2(filename, "main")}")
}

fun task1(filename: String, mainOrTest: String): Int {
    val list = Utils().readFileAsIntListSeparated(filename, mainOrTest)
    return list
        .map { it.sum() }
        .maxOf { it }
}


fun task2(filename: String, mainOrTest: String): Int {
    val list = Utils().readFileAsIntListSeparated(filename, mainOrTest)

    return list
        .map { it.sum() }
        .sorted()
        .takeLast(3)
        .sum()
}
