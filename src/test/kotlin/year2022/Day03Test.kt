package year2022

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import year2022.day03.Day03

internal class Day03Test {

    private val filename = "input_2022_day03.txt"
    private val mainOrTest = "test"

    @Test
    fun `should get correct sum for task 1`() {
        // given
        val sut = Day03()

        // when
        val sum = sut.task1(filename, mainOrTest)

        // then
        assertThat(sum).isEqualTo(157)
    }


    @Test
    fun `should get correct sum for task 2`() {
        // given
        val sut = Day03()

        // when
        val sum = sut.task2(filename, mainOrTest)

        // then
        assertThat(sum).isEqualTo(70)
    }
}
