package com.flowerhop.katas

class Player(val name: String) {
    var score: Score = Score.Love

    fun wins() {
        score = when (score) {
            Score.Love -> Score.Fifteen
            Score.Fifteen -> Score.Thirty
            Score.Thirty -> Score.Forty
            Score.Forty -> Score.Forty
        }
    }

    override fun toString(): String {
        return name
    }
}

enum class Score {
    Love, Fifteen, Thirty, Forty
}
