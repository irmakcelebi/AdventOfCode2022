import utils.readInput

abstract class Day {

    private val day = getDay()

    fun run() {

        println("############## Day $day ##############")

        println("############## Part 1 ##############")
        println(solve1(readInput("day$day")))

        println("############# Part 2 ##############")
        println(solve2(readInput("day$day")))

    }

    fun test1(expected: Any) = test(solve1(readInput("day${day}_test")), expected)

    fun test2(expected: Any) = test(solve2(readInput("day${day}_test")), expected)

    abstract fun solve1(lines: List<String>) : Any

    abstract fun solve2(lines: List<String>) : Any

    private fun getDay(): String {
        return javaClass.simpleName.replace("Day", "")
    }

    private fun test(expected: Any, actual: Any) {
        try {
            check(expected == actual)
        } catch (e: Exception) {
            println("Expected $expected but was $actual.")
        }
    }
}
