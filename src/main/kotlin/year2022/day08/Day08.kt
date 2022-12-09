package year2022.day08

import util.Utils

// https://adventofcode.com/2022/day/8

private const val filename = "input_2022_day08.txt"


fun main() {
    val day = Day08()

    println("day 08 - task 1: ${day.task1(filename, "main")}")
    println("day 08 - task 2: ${day.task2(filename, "main")}")
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

                val leftIsLower = getTreesHorizontal(treeLine, 0, treeIndex).max() < tree
                val rightIsLower = getTreesHorizontal(treeLine, treeIndex + 1, treeLine.length).max() < tree

                val columnTreesTop = getTreesVertical(input, treeIndex, 0, lineIndex)
                val topIsLower = columnTreesTop.max() < tree

                val columnTreesBottom = getTreesVertical(input, treeIndex, lineIndex + 1, input.size)
                val bottomIsLower = columnTreesBottom.max() < tree

                if (leftIsLower || rightIsLower || topIsLower || bottomIsLower) visibleTrees++
            }
        }

        return visibleTrees
    }


    fun task2(filename: String, mainOrTest: String): Int {
        val input = Utils().readFileAsStringList(filename, mainOrTest)

        val scenicScores = mutableListOf<Int>()

        // exclude the first and the last line from input
        for (lineIndex in 1 until input.lastIndex) {
            val treeLine = input[lineIndex]

            // exclude the first and the last tree from the line
            for (treeIndex in 1 until treeLine.lastIndex) {
                val tree = treeLine[treeIndex].digitToInt()

                val leftTreesReversed = getTreesHorizontal(treeLine, 0, treeIndex).reversed()
                val leftVisible = findVisibleTreesNextToTree(leftTreesReversed, tree)

                val rightTrees = getTreesHorizontal(treeLine, treeIndex + 1, treeLine.length)
                val rightVisible = findVisibleTreesNextToTree(rightTrees, tree)

                var columnTreesTop = getTreesVertical(input, treeIndex, 0, lineIndex)
                columnTreesTop = columnTreesTop.reversed().toMutableList()
                val topVisible = findVisibleTreesNextToTree(columnTreesTop, tree)

                val columnTreesBottom = getTreesVertical(input, treeIndex, lineIndex + 1, input.size)
                val bottomVisible = findVisibleTreesNextToTree(columnTreesBottom, tree)

                scenicScores.add(leftVisible * rightVisible * topVisible * bottomVisible)
            }
        }

        return scenicScores.max()
    }


    private fun getTreesHorizontal(
        treeLine: String,
        fromValue: Int,
        untilValue: Int,
    ) =
        treeLine
            .substring(fromValue until untilValue)
            .map { it.digitToInt() }


    private fun getTreesVertical(
        input: List<String>,
        treeIndex: Int,
        fromValue: Int,
        untilValue: Int,
    ): MutableList<Int> {
        val columnTreesBottom = mutableListOf<Int>()
        for (tempLineIndex in fromValue until untilValue) {
            input[tempLineIndex]
            columnTreesBottom.add(input[tempLineIndex][treeIndex].digitToInt())
        }

        return columnTreesBottom
    }

    private fun findVisibleTreesNextToTree(trees: List<Int>, tree: Int): Int {
        return if (trees.max() < tree) trees.size
        else trees.indexOfFirst { it >= tree } + 1
    }
}
