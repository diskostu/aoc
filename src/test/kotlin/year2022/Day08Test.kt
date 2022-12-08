package year2022

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import year2022.day08.Day08

internal class Day08Test {

    private val filename = "input_2022_day08.txt"
    private val mainOrTest = "test"

    @Test
    fun `should get correct result for task 1`() {
        // given
        val sut = Day08()

        // when
        val sum = sut.task1(filename, mainOrTest)

        // then
        assertThat(sum).isEqualTo(21)
    }


    @Test
    fun `should get correct result for task 2`() {
        // given
        val sut = Day08()

        // when
        val sum = sut.task2(filename, mainOrTest)

        // then
        assertThat(sum).isEqualTo(8)
    }
}
