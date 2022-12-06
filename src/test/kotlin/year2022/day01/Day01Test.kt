package year2022.day01

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day01Test {

    private val filename = "input_2022_day01.txt"
    private val mainOrTest = "test"

    @Test
    fun `should get correct calories sum`() {
        // given

        // when

        val calorieSum = task1(filename, mainOrTest)

        // then
        assertThat(calorieSum).isEqualTo(24000)
    }

    @Test
    fun `should get correct max three calories sum`() {
        // given

        // when
        val calorieSum = task2(filename, mainOrTest)

        // then
        assertThat(calorieSum).isEqualTo(45000)
    }
}
