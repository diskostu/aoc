package year2022.day06

import util.Utils

// https://adventofcode.com/2022/day/6

private const val filename = "input_2022_day06.txt"

private const val CHARS_TO_READ_AT_ONCE_TASK1 = 4
private const val CHARS_TO_READ_AT_ONCE_TASK2 = 14


fun main() {
    val day = Day06()

    println("day 06 - task 1: ${day.task1(filename, "main")}")
    println("day 06 - task 2: ${day.task2(filename, "main")}")
}

class Day06 {

    fun task1(filename: String, mainOrTest: String): Int {
        return i(filename, mainOrTest, CHARS_TO_READ_AT_ONCE_TASK1)
    }


    fun task2(filename: String, mainOrTest: String): Int {
        return i(filename, mainOrTest, CHARS_TO_READ_AT_ONCE_TASK2)
    }


    private fun i(filename: String, mainOrTest: String, charsToReadAtOnce: Int): Int {
        val input = Utils().readFileAsStringList(filename, mainOrTest)[0]

        for (i in 0..input.lastIndex) {
            val distinctSize =
                input.substring(i, i + charsToReadAtOnce).toList().distinct().size

            if (distinctSize == charsToReadAtOnce) {
                return i + charsToReadAtOnce
            }
        }

        return 0
    }
}
