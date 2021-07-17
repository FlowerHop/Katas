package com.flowerhop.katas

class Player {
    var score: Score = Score.Love

    fun wins() {
        score = when (score) {
            Score.Love -> Score.Fifteen
            Score.Fifteen -> Score.Thirty
            Score.Thirty -> Score.Forty
            Score.Forty -> Score.Forty
        }
    }
}

enum class Score {
    Love, Fifteen, Thirty, Forty
}
