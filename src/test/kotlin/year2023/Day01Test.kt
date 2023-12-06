package year2023

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import util.Utils
import year2023.day01.task1
import year2023.day01.task2

internal class Day01Test {


    @Test
    fun `should get correct result for task 1`() {
        // arrange
        val list = Utils().readFileAsStringList("input_2023_day01_task1.txt", "test")

        // act
        val result = task1(list)

        // assert
        assertThat(result).isEqualTo(142)
    }


    @Test
    fun `should get correct result for task 2`() {
        // arrange
        val list = Utils().readFileAsStringList("input_2023_day01_task2.txt", "test")

        // act
        val result = task2(list)

        // assert
        assertThat(result).isEqualTo(358)
    }
}
