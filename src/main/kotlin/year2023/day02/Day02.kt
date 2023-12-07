package year2023.day02

import util.Utils

fun main() {
    val list = Utils().readFileAsStringList("input_2023_day02.txt", "main")
    println("day 02 - task 1: ${task1(list)}")
    println("day 02 - task 2: ${task2(list)}")
}

fun task1(list: List<String>): Int {
    var gameIdSum = 0
    for (inputLine in list) {
        val gameInstance = createGameInstance(inputLine)
        var isValidGame = true
        for (cubesCountAndColor in gameInstance.cubesCountAndColor) {
            if (exceedsMax(cubesCountAndColor)) {
                isValidGame = false
                break
            }
        }

        if (isValidGame) {
            gameIdSum += gameInstance.gameId
        }
    }

    return gameIdSum
}

fun task2(list: List<String>): Int {
    var sum = 0
    for (inputLine in list) {
        val gameInstance = createGameInstance(inputLine)

        sum += gameInstance.cubesCountAndColor.filter { it.color == "red" }.maxOf { it.count } *
                gameInstance.cubesCountAndColor.filter { it.color == "green" }.maxOf { it.count } *
                gameInstance.cubesCountAndColor.filter { it.color == "blue" }.maxOf { it.count }
    }

    return sum
}

private fun createGameInstance(inputLine: String): GameInstance {
    val gameInstance = GameInstance(
        gameId = inputLine.split(":")[0].split(" ")[1].toInt(),
        cubesCountAndColor = inputLine.split(":")[1].trim().split("; ")
            .flatMap { block ->
                block.split(", ")
                    .map {
                        val (count, color) = it.split(" ")
                        CubesCountAndColor(count.toInt(), color)
                    }
            })

    return gameInstance
}


private fun exceedsMax(cubesCountAndColor: CubesCountAndColor): Boolean {
    return when {
        cubesCountAndColor.color == "red" && cubesCountAndColor.count > 12 -> true
        cubesCountAndColor.color == "green" && cubesCountAndColor.count > 13 -> true
        cubesCountAndColor.color == "blue" && cubesCountAndColor.count > 14 -> true
        else -> false
    }
}
