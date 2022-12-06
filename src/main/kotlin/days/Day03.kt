package days

import Day

fun main() {
    val day = Day03()

    day.test1(157)

    day.test2(70)

    day.run()

}

class Day03 : Day() {

    private lateinit var charPriorities: HashMap<Char, Int>

    init {
        initPriorities()
    }

    override fun solve1(lines: List<String>) = lines
        .map { it.chunked(it.length / 2).map { compartment -> compartment.toList() } }
        .sumOf { (first, second) -> first.intersect(second).sumOf { valueOf(it)!! } }

    override fun solve2(lines: List<String>) = lines
        .map { it.toList() }
        .chunked(3)
        .flatMap { (elf1, elf2, elf3) -> elf1.intersect(elf2.intersect(elf3)) }
        .sumOf { valueOf(it)!! }


    private fun initPriorities() {
        charPriorities = HashMap()
        ('a'..'z').toList()
            .plus('A'..'Z').toList()
            .mapIndexed { index, c -> charPriorities[c] = index + 1 }
    }

    private fun valueOf(char: Char) = charPriorities[char]

}