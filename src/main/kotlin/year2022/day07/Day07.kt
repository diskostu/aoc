package year2022.day07

import util.Utils

// https://adventofcode.com/2022/day/7

private const val filename = "input_2022_day07.txt"

private const val DIR_AT_MOST_SIZE = 100000


fun main() {
    val day = Day07()

    println("day 07 - task 1: ${day.task1(filename, "main")}")
//    println("day 07 - task 2: ${day.task2(filename, "main")}")
}

class Day07 {

    fun task1(filename: String, mainOrTest: String): Int {
        val input = Utils().readFileAsStringList(filename, mainOrTest)
        input.forEach { println(it) }

        for (line in input) {

        }

        return 0
    }
}
