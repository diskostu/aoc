package year2022.day08

import util.Utils

// https://adventofcode.com/2022/day/8

private const val filename = "input_2022_day08.txt"


fun main() {
    val day = Day08()

    println("day 08 - task 1: ${day.task1(filename, "main")}")
//    println("day 07 - task 2: ${day.task2(filename, "main")}")
}

class Day08 {

    fun task1(filename: String, mainOrTest: String): Int {
        val input = Utils().readFileAsStringList(filename, mainOrTest)

        // first, count all the surrounding trees
        val inputLineLength = input[0].length
        var visibleTrees = inputLineLength * 2 + input.size * 2 - 4

        // exclude the first and the last line from input
        for (lineIndex in 1 until input.lastIndex) {
            val treeLine = input[lineIndex]

            // exclude the first and the last tree from the line
            for (treeIndex in 1 until treeLine.lastIndex) {
                val tree = treeLine[treeIndex].digitToInt()

                val leftIsLower = treeLine
                    .substring(0 until treeIndex)
                    .map { it.digitToInt() }
                    .max() < tree
                val rightIsLower = treeLine
                    .substring(treeIndex + 1 until treeLine.length)
                    .map { it.digitToInt() }
                    .max() < tree

                val columnTreesTop = mutableListOf<Int>()
                for (tempLineIndex in 0 until lineIndex) {
                    input[tempLineIndex]
                    columnTreesTop.add(input[tempLineIndex][treeIndex].digitToInt())
                }
                val topIsLower = columnTreesTop.max() < tree

                val columnTreesBottom = mutableListOf<Int>()
                for (tempLineIndex in lineIndex + 1 until input.size) {
                    input[tempLineIndex]
                    columnTreesBottom.add(input[tempLineIndex][treeIndex].digitToInt())
                }
                val bottomIsLower = columnTreesBottom.max() < tree

                if (leftIsLower || rightIsLower || topIsLower || bottomIsLower) visibleTrees++
            }
        }

        return visibleTrees
    }


    fun task2(filename: String, mainOrTest: String): Int {
        val input = Utils().readFileAsStringList(filename, mainOrTest)
        input.forEach { println(it) }

        // first, count all the surrounding trees
        val inputLineLength = input[0].length
        var visibleTrees = inputLineLength * 2 + input.size * 2 - 4

        // exclude the first and the last line from input
        for (lineIndex in 1 until input.lastIndex) {
            val treeLine = input[lineIndex]
            println("treeLine = ${treeLine}")

            // exclude the first and the last tree from the line
            for (treeIndex in 1 until treeLine.lastIndex) {
                val tree = treeLine[treeIndex].digitToInt()

                println("current tree in line $lineIndex, column $treeIndex is $tree")

                val leftTreesReversed = treeLine
                    .substring(0 until treeIndex)
                    .map { it.digitToInt() }
                    .reversed()
                val leftTreesVisible = findVisibleTreesNextToTree(leftTreesReversed, tree)

                val rightTrees = treeLine
                    .substring(treeIndex + 1 until treeLine.length)
                    .map { it.digitToInt() }
                val rightTreesVisible = findVisibleTreesNextToTree(rightTrees, tree)

                println("leftTreesVisible = ${leftTreesVisible}")
                println("rightTreesVisible = ${rightTreesVisible}")
            }
        }

        return visibleTrees
    }

    private fun findVisibleTreesNextToTree(trees: List<Int>, tree: Int): Int {
        return if (trees.max() < tree) trees.size
        else trees.indexOfFirst { it >= tree } + 1
    }
}
