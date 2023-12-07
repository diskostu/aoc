package year2023.day02

data class GameInstance(val gameId: Int, val cubesCountAndColor: List<CubesCountAndColor>)

data class CubesCountAndColor(val count: Int, val color: String)
