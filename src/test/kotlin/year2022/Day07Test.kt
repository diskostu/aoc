package year2022

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import year2022.day07.Day07
import year2022.day07.Directory
import year2022.day07.File

internal class Day07Test {

    private val filename = "input_2022_day07.txt"
    private val mainOrTest = "test"

    @Test
    fun `should get correct result for task 1`() {
        // given
        val sut = Day07()

        // when
        val sum = sut.task1(filename, mainOrTest)

        // then
        assertThat(sum).isEqualTo(95437)
    }


    @Test
    fun `should calculate correct directory sizes`() {
        // given
        val file1 = File("file1", 11)
        val file2 = File("file2", 2)
        val file3 = File("file3", 3)
        val file4 = File("file4", 4)
        val file5 = File("file5", 5)
        val file6 = File("file6", 6)

        val dir1 = Directory("dir1", mutableListOf(file1, file2), mutableListOf())
        val dir2 = Directory("dir2", mutableListOf(file3, file4), mutableListOf(dir1))
        val dir3 = Directory("dir3", mutableListOf(file5), mutableListOf(dir2))
        val dir4 = Directory("dir4", mutableListOf(file6), mutableListOf(dir3))

        // when / then
        assertThat(dir1.getDirectFileSizes()).isEqualTo(13)
        assertThat(dir1.getTotalSize()).isEqualTo(13)

        assertThat(dir2.getDirectFileSizes()).isEqualTo(7)
        assertThat(dir2.getTotalSize()).isEqualTo(20)

        assertThat(dir3.getDirectFileSizes()).isEqualTo(5)
        assertThat(dir3.getTotalSize()).isEqualTo(25)

        assertThat(dir4.getDirectFileSizes()).isEqualTo(6)
        assertThat(dir4.getTotalSize()).isEqualTo(31)
    }
}
