package year2022.day04

import java.io.File

// https://adventofcode.com/2022/day/4

const val filename = "input_2022_day04.txt"

fun main() {
    val day = Day04()

    println("day 04 - task 1: ${day.task1(filename, "main")}")
    println("day 04 - task 2: ${day.task2(filename, "main")}")

}

class Day04 {

    fun task1(filename: String, mainOrTest: String): Int {
        val intRangePairs = createIntRangePairsFromInput(mainOrTest, filename)

        return intRangePairs.count { (range1, range2) ->
            range1.minus(range2).isEmpty() || range2.minus(range1).isEmpty()
        }
    }

    fun task2(filename: String, mainOrTest: String): Int {
        val intRangePairs = createIntRangePairsFromInput(mainOrTest, filename)

        return intRangePairs.count { (range1, range2) ->
            range1.intersect(range2).isNotEmpty()
        }
    }


    private fun createIntRangePairsFromInput(
        mainOrTest: String,
        filename: String,
    ): List<Pair<IntRange, IntRange>> {
        return File("src/$mainOrTest/resources/$filename")
            .bufferedReader()
            .readLines()
            .map {
                val sections = it.split(",")
                Pair(
                    createIntRangeFromString(sections[0]),
                    createIntRangeFromString(sections[1])
                )
            }
    }


    private fun createIntRangeFromString(string: String, delimiter: Char = '-'): IntRange {
        return IntRange(string.split(delimiter)[0].toInt(), string.split(delimiter)[1].toInt())
    }
}
