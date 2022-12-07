package year2022

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import year2022.day05.Day05

internal class Day05Test {

    private val filename = "input_2022_day05.txt"
    private val mainOrTest = "test"

    @Test
    fun `should get correct result for task 1`() {
        // given
        val sut = Day05()

        // when
        val sum = sut.task1(filename, mainOrTest)

        // then
        assertThat(sum).isEqualTo("CMZ")
    }


    @Test
    fun `should get correct result for task 2`() {
        // given
        val sut = Day05()

        // when
        val sum = sut.task2(filename, mainOrTest)

        // then
        assertThat(sum).isEqualTo("MCD")
    }
}
