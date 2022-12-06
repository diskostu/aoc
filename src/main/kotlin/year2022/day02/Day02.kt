package year2022.day02

import util.Utils

// https://adventofcode.com/2022/day/2

private enum class RockPaperScissorPoints(val item1: String, val item2: String, val points: Int) {
    ROCK("A", "X", 1),
    PAPER("B", "Y", 2),
    SCISSORS("C", "Z", 3),
}

fun main() {
    val filename = "input_2022_day02.txt"
    println("day 02 - task 1: ${task1(filename, "main")}")
    println("day 02 - task 2: ${task2(filename, "main")}")
}

fun task1(filename: String, mainOrTest: String): Int {
    val linePairs = Utils().readLinesAsStringPairs(filename, mainOrTest)

    var sum = 0
    for (linePair in linePairs) {
        val itemPoint = when (linePair.second) {
            RockPaperScissorPoints.ROCK.item2 -> RockPaperScissorPoints.ROCK.points
            RockPaperScissorPoints.PAPER.item2 -> RockPaperScissorPoints.PAPER.points
            else -> RockPaperScissorPoints.SCISSORS.points
        }

        var roundPoint = 0
        if ((linePair.first == RockPaperScissorPoints.ROCK.item1 && linePair.second ==
                    RockPaperScissorPoints.PAPER.item2) || (linePair.first ==
                    RockPaperScissorPoints.PAPER.item1 && linePair.second ==
                    RockPaperScissorPoints.SCISSORS.item2) || (linePair.first ==
                    RockPaperScissorPoints.SCISSORS.item1 && linePair.second ==
                    RockPaperScissorPoints.ROCK.item2)
        ) {
            roundPoint = 6
        } else if ((linePair.first == RockPaperScissorPoints.ROCK.item1 && linePair.second ==
                    RockPaperScissorPoints.ROCK.item2) || (linePair.first ==
                    RockPaperScissorPoints.PAPER.item1 && linePair.second ==
                    RockPaperScissorPoints.PAPER.item2) || (linePair.first ==
                    RockPaperScissorPoints.SCISSORS.item1 && linePair.second ==
                    RockPaperScissorPoints.SCISSORS.item2)
        ) {
            roundPoint = 3
        }

        sum += itemPoint + roundPoint
    }

    return sum
}


fun task2(filename: String, mainOrTest: String): Int {
    val linePairs = Utils().readLinesAsStringPairs(filename, mainOrTest)

    println("linePairs = $linePairs")

    var sum = 0
    for (linePair in linePairs) {
        val roundPoint = when (linePair.second) {
            RockPaperScissorPoints.ROCK.item2 -> 0
            RockPaperScissorPoints.PAPER.item2 -> 3
            else -> 6
        }

        val itemToChoose: RockPaperScissorPoints
        when (linePair.second) {
            RockPaperScissorPoints.ROCK.item2 -> {
                itemToChoose = when (linePair.first) {
                    RockPaperScissorPoints.ROCK.item1 -> {
                        RockPaperScissorPoints.SCISSORS
                    }

                    RockPaperScissorPoints.PAPER.item1 -> {
                        RockPaperScissorPoints.ROCK
                    }

                    else -> {
                        RockPaperScissorPoints.PAPER
                    }
                }
            }

            RockPaperScissorPoints.PAPER.item2 -> {
                itemToChoose = when (linePair.first) {
                    RockPaperScissorPoints.ROCK.item1 -> {
                        RockPaperScissorPoints.ROCK
                    }

                    RockPaperScissorPoints.PAPER.item1 -> {
                        RockPaperScissorPoints.PAPER
                    }

                    else -> {
                        RockPaperScissorPoints.SCISSORS
                    }
                }
            }

            else -> {
                itemToChoose = when (linePair.first) {
                    RockPaperScissorPoints.ROCK.item1 -> {
                        RockPaperScissorPoints.PAPER
                    }

                    RockPaperScissorPoints.PAPER.item1 -> {
                        RockPaperScissorPoints.SCISSORS
                    }

                    else -> {
                        RockPaperScissorPoints.ROCK
                    }
                }
            }
        }

        sum += roundPoint + itemToChoose.points
    }

    return sum
}
