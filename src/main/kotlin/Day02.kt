import util.Utils

fun main() {
    val input = Utils().readFileAsPairStringIntList("input_day02.txt")
    task1(input) // 1660158
    //task2(input) // ???
}

fun task1(input: List<Pair<String, Int>>) {
    var posX = 0
    var depth = 0
    for (pair in input) {
        when (pair.first) {
            "forward" -> posX += pair.second
            "up" -> depth -= pair.second
            "down" -> depth += pair.second
        }
    }

    println("task1 = ${posX * depth}")
}

private fun task2(input: List<Int>) {


}
