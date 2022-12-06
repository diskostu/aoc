package year2022.day03

import util.Utils

// https://adventofcode.com/2022/day/3

const val filename = "input_2022_day03.txt"

fun main() {
    val day03 = Day03()
    println("day 03 - task 1: ${day03.task1(filename, "main")}")
    println("day 03 - task 2: ${day03.task2(filename, "main")}")
}

class Day03 {

    fun task1(filename: String, mainOrTest: String): Int {
        val input = Utils().readFileAsStringList(filename, mainOrTest)

        var sum = 0
        for (line in input) {
            val chunked = line.chunked(line.length / 2)
            val intersect = chunked[0].toSet().intersect(chunked[1].toSet()).first()
            sum += getPositionInAlphabetFor(intersect)
        }

        return sum
    }


    fun task2(filename: String, mainOrTest: String): Int {
        val input = Utils().readFileAsStringList(filename, mainOrTest)

        var sum = 0
        for (i in 0..input.lastIndex step 3) {
            val matchingChar =
                input[i].toSet()
                    .intersect(input[i + 1].toSet())
                    .intersect(input[i + 2].toSet())
                    .first()
            sum += getPositionInAlphabetFor(matchingChar)
        }

        return sum
    }

    private fun getPositionInAlphabetFor(char: Char): Int {
        return if (char.isUpperCase()) {
            Character.getNumericValue(char) + 17
        } else {
            Character.getNumericValue(char) - 9
        }
    }
}
