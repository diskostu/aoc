package year2021

import util.Utils

fun main() {
    val input = Utils().readFileAsPairStringIntList("input_2021_day02.txt")
    task1(input) // 1660158
    task2(input) // 1604592846
}

private fun task1(input: List<Pair<String, Int>>) {
    var posX = 0
    var depth = 0
    for (pair in input) {
        when (pair.first) {
            "forward" -> posX += pair.second
            "up" -> depth -= pair.second
            "down" -> depth += pair.second
        }
    }

    println("year2021.task1 = ${posX * depth}")
}

private fun task2(input: List<Pair<String, Int>>) {
    var posX = 0
    var depth = 0
    var aim = 0
    for (pair in input) {
        when (pair.first) {
            "forward" -> {
                posX += pair.second
                depth += aim*pair.second
            }
            "up" -> aim -= pair.second
            "down" -> aim += pair.second
        }
    }

    println("year2021.task2 = ${posX * depth}")
}
