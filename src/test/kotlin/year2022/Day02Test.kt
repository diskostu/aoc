package year2022

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import year2022.day02.task1
import year2022.day02.task2

internal class Day02Test {

    private val filename = "input_2022_day02.txt"
    private val mainOrTest = "test"

    @Test
    fun `should get correct point sum for task 1`() {
        // given

        // when
        val sum = task1(filename, mainOrTest)

        // then
        assertThat(sum).isEqualTo(15)
    }


    @Test
    fun `should get correct point sum for task 2`() {
        // given

        // when
        val sum = task2(filename, mainOrTest)

        // then
        assertThat(sum).isEqualTo(12)
    }
}
