package year2022.day07

data class Directory(
    val name: String,
    val files: MutableList<File>,
    val directories: MutableList<Directory>,
) {

    fun getDirectFileSizes(): Int {
        return files.sumOf { it.fileSize }
    }


    fun getTotalSize(): Int {
        val size = getDirectFileSizes() + directories.sumOf { it.getTotalSize() }
        println("calculating total size of directory $name: result is $size")
        return size
    }
}
