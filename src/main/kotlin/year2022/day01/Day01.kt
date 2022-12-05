package year2022.day01

import util.Utils

fun main() {
    val input = Utils().readFileAsStringList("input_2022_day01.txt")
    val correctInputFormat = convertInputToCorrectFormat(input)

    println("day 01 - task 1: ${task1(correctInputFormat)}")
    println("day 01 - task 2: ${task2(correctInputFormat)}")
}

fun task1(input: List<List<Int>>): Int {
    return input
        .map { it.sum() }
        .maxOf { it }
}


fun task2(input: List<List<Int>>): Int {
    return input
        .map { it.sum() }
        .sorted()
        .takeLast(3)
        .sum()
}

private fun convertInputToCorrectFormat(input: List<String>): List<List<Int>> {
    val allList: MutableList<MutableList<Int>> = mutableListOf()
    val innerList: MutableList<Int> = mutableListOf()

    for (line in input) {
        if (line.isBlank()) {
            allList.add(ArrayList(innerList))
            innerList.clear()
        } else {
            innerList.add(line.toInt())
        }
    }

    return allList
}
