package year2022.day01

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day01Test {

    @Test
    fun `should get correct calories sum`() {
        // given
        val filename = "input_2022_day01.txt"

        // when
        val calorieSum = task1(filename, "test")

        // then
        assertThat(calorieSum).isEqualTo(24000)
    }

    @Test
    fun `should get correct max three calories sum`() {
        // given
        val filename = "input_2022_day01.txt"

        // when
        val calorieSum = task2(filename, "test")

        // then
        assertThat(calorieSum).isEqualTo(45000)
    }
}
