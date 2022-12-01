fun main() {

    val day = Day01()

    day.test1(24000)
    day.test2(45000)

    day.run()

}

class Day01: Day() {

    override fun solve1(lines: List<String>): Int = calculateTotalPerElf(lines).max()

    override fun solve2(lines: List<String>): Int = calculateTotalPerElf(lines).sortedDescending().take(3).sum()

    private fun calculateTotalPerElf(lines: List<String>) =
        lines
            .joinToString(" ")
            .split("  ")
            .map {
                val snacks = it.split(" ")
                snacks.sumOf { snack -> snack.toInt() }
            }

}