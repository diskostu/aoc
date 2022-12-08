package year2022

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import year2022.day06.Day06

internal class Day06Test {

    private val filename = "input_2022_day06.txt"
    private val mainOrTest = "test"

    @Test
    fun `should get correct result for task 1`() {
        // given
        val sut = Day06()

        // when
        val sum = sut.task1(filename, mainOrTest)

        // then
        assertThat(sum).isEqualTo(10)
    }


    @Test
    fun `should get correct result for task 2`() {
        // given
        val sut = Day06()

        // when
        val sum = sut.task2(filename, mainOrTest)

        // then
        assertThat(sum).isEqualTo(29)
    }
}
