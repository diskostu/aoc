package year2022.day05

import util.Utils

// https://adventofcode.com/2022/day/5

const val filename = "input_2022_day05.txt"


fun main() {
    val day = Day05()

    println("day 05 - task 1: ${day.task1(filename, "main")}")
    println("day 05 - task 2: ${day.task2(filename, "main")}")
}

class Day05 {

    fun task1(filename: String, mainOrTest: String): String {
        val input = Utils().readFileAsStringList(filename, mainOrTest)

        val stackMap: MutableMap<Int, MutableList<String>> = createStackMap(input)
        val movesReduced = createMoves(input)

        for (move in movesReduced) {
            val countBoxes = move[0].toInt()
            val fromStack = move[1].toInt()
            val toStack = move[2].toInt()

            repeat(countBoxes) {
                val last = stackMap[fromStack]!!.removeLast()
                stackMap[toStack]!!.add(last)
            }
        }

        return stackMap.toSortedMap().values.joinToString(separator = "") { it.last() }
    }


    fun task2(filename: String, mainOrTest: String): String {
        val input = Utils().readFileAsStringList(filename, mainOrTest)

        val stackMap: MutableMap<Int, MutableList<String>> = createStackMap(input)
        val movesReduced = createMoves(input)

        for (move in movesReduced) {
            val countBoxes = move[0].toInt()
            val fromStack = move[1].toInt()
            val toStack = move[2].toInt()

            stackMap[toStack]!!.addAll(stackMap[fromStack]!!.takeLast(countBoxes))
            repeat(countBoxes) { stackMap[fromStack]!!.removeLast() }
        }

        return stackMap.toSortedMap().values.joinToString(separator = "") { it.last() }
    }

    private fun createStackMap(input: List<String>): MutableMap<Int, MutableList<String>> {
        val stacks = input
            .filter { it.contains("[") }

        val stackMap: MutableMap<Int, MutableList<String>> = mutableMapOf()
        for (stack in stacks) {
            val chunked = stack.chunked(4)
            for ((index, chunk) in chunked.withIndex()) {
                if (chunk.isBlank()) continue

                val mapKey = index + 1
                stackMap.putIfAbsent(mapKey, mutableListOf())
                stackMap[mapKey]?.add(chunk.replace("[", "").replace("]", "").trim())
            }
        }
        stackMap.map { it.value.reverse() }
        return stackMap
    }

    private fun createMoves(input: List<String>): List<List<String>> {
        val moves = input
            .filter { it.contains("move") }

        return moves
            .asSequence()
            .map { it.replace("move", "") }
            .map { it.replace("from", "") }
            .map { it.replace("to", "") }
            .map { it.trim() }
            .map { it.split("\\s+".toRegex()) }
            .toList()
    }
}
