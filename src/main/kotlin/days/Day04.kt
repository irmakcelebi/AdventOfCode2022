package days

import Day

fun main() {
    val day = Day04()

    day.test1(2)

    day.test2(4)

    day.run()
}

class Day04 : Day() {

    override fun solve1(lines: List<String>) = lines
        .map { it.split(',') }
        .count { (elf1, elf2) ->
            val section1 = Section.from(elf1)
            val section2 = Section.from(elf2)
            section2.isCoveredBy(section1) || section1.isCoveredBy(section2)
        }


    override fun solve2(lines: List<String>) = lines
        .map { it.split(',') }
        .count { (elf1, elf2) ->
            val section1 = Section.from(elf1)
            val section2 = Section.from(elf2)
            section1.isOverlappingWith(section2)
        }

}

class Section(private val start: Int, private val to: Int) {

    fun isCoveredBy(other: Section): Boolean {
        return other.start <= this.start && other.to >= this.to
    }

    fun isOverlappingWith(other: Section) = other.toList().intersect(this.toList()).isNotEmpty()
    
    private fun toList(): List<Int> = (start..to).toList()

    companion object {

        fun from(elf: String): Section {
            val startEnd = elf.split('-').map { it.toInt() }
            return Section(startEnd[0], startEnd[1])
        }

    }


}

