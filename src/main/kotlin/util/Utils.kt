package util

import java.io.File

class Utils {

    fun readFileAsStringList(fileName: String, mainOrTest: String): List<String> =
        File("src/$mainOrTest/resources/$fileName").bufferedReader().readLines()

    fun readLinesAsStringPairs(
        fileName: String,
        mainOrTest: String,
    ): List<Pair<String, String>> {
        val lines = File("src/$mainOrTest/resources/$fileName").bufferedReader().readLines()

        val pairList = mutableListOf<Pair<String, String>>()
        for (line in lines) {
            val split = line.split(" ")
            pairList.add(Pair(split[0], split[1]))
        }

        return pairList
    }


    fun readFileAsIntListLineBreaks(fileName: String): List<Int> =
        File("src/main/resources/$fileName").bufferedReader().readLines().map { it.toInt() }

    fun readFileAsIntListCommaSeparated(fileName: String) =
        File("src/main/resources/$fileName")
            .bufferedReader()
            .readLines()[0]
            .split(",")
            .map { it.toInt() }


    fun readFileAsIntListSeparatedLists(
        fileName: String,
        mainOrTest: String,
    ): MutableList<MutableList<Int>> {
        val lines = File("src/$mainOrTest/resources/$fileName")
            .bufferedReader()
            .readLines()

        val allList: MutableList<MutableList<Int>> = mutableListOf()
        val innerList: MutableList<Int> = mutableListOf()

        for (line in lines) {
            if (line.isBlank()) {
                allList.add(ArrayList(innerList))
                innerList.clear()
            } else {
                innerList.add(line.toInt())
            }
        }

        allList.add(ArrayList(innerList))

        return allList
    }

    fun readFileAsPairStringIntList(fileName: String): List<Pair<String, Int>> {
        val lines = File("src/main/resources/$fileName").bufferedReader().readLines()
        val pairList = mutableListOf<Pair<String, Int>>()
        for (line in lines) {
            val split = line.split(" ")
            pairList.add(Pair(split[0], split[1].toInt()))
        }

        return pairList
    }
}
