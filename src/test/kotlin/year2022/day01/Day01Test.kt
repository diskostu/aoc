package year2022.day01

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class Day01Test {

    private lateinit var calories: List<List<Int>>

    @BeforeEach
    fun init() {
        calories = listOf(
            listOf(1000, 2000, 3000),
            listOf(4000),
            listOf(5000, 6000),
            listOf(7000, 8000, 9000),
            listOf(10000)
        )

        println("calories = $calories")
    }


    @Test
    fun `should get correct calories sum`() {
        // given

        // when
        val calorieSum = task1(calories)

        // then
        assertThat(calorieSum).isEqualTo(24000)
    }

    @Test
    fun `should get correct max three calories sum`() {
        // given

        // when
        val calorieSum = task2(calories)

        // then
        assertThat(calorieSum).isEqualTo(45000)
    }
}
