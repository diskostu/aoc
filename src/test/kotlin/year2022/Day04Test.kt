package year2022

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import year2022.day04.Day04

internal class Day04Test {

    private val filename = "input_2022_day04.txt"
    private val mainOrTest = "test"

    @Test
    fun `should get correct sum for task 1`() {
        // given
        val sut = Day04()

        // when
        val sum = sut.task1(filename, mainOrTest)

        // then
        assertThat(sum).isEqualTo(2)
    }


    @Test
    fun `should get correct sum for task 2`() {
        // given
        val sut = Day04()

        // when
        val sum = sut.task2(filename, mainOrTest)

        // then
        assertThat(sum).isEqualTo(4)
    }
}
