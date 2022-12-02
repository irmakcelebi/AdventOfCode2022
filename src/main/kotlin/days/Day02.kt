import java.lang.Exception

fun main() {

    val day = Day02()
    
    day.run()

    day.test1(15)
    day.test2(12)
}

class Day02: Day() {

    override fun solve1(lines: List<String>): Int =
        lines
            .map { it.split(" ") }
            .sumOf { (x,y) ->
                val me = Hand.fromCharacter(y)
                val opponent = Hand.fromCharacter(x)
                me.score + me.play(opponent).score
            }


    override fun solve2(lines: List<String>): Int =
        lines
            .map { it.split(" ") }
            .sumOf { (x, y) ->
                val opponent = Hand.fromCharacter(x)
                val score = Score.fromCharacter(y)
                opponent.playForScore(score).score + score.score
            }
}

enum class Hand(val score: Int) {
    ROCK(1),
    PAPER(2),
    SCISSOR(3);

    companion object {

        fun fromCharacter(char: String) : Hand {
            return when(char) {
                "A", "X" -> ROCK
                "B", "Y" -> PAPER
                "C", "Z" -> SCISSOR
                else -> throw Exception()
            }
        }
    }

    fun play(opponent: Hand) : Score {
        return when (opponent to this) {
            ROCK to ROCK, SCISSOR to SCISSOR, PAPER to PAPER -> Score.DRAW
            ROCK to SCISSOR, SCISSOR to PAPER, PAPER to ROCK -> Score.LOSE
            else -> Score.WIN
        }
    }

    fun playForScore(expectedScore: Score) =  values().first { it.play(this) == expectedScore }

}


enum class Score(val score: Int) {
    WIN(6),
    DRAW(3),
    LOSE(0);


    companion object {

        fun fromCharacter(char: String): Score {
            return when(char) {
                "X" -> LOSE
                "Y" -> DRAW
                "Z" -> WIN
                else -> throw Exception()
            }
        }
    }
}
