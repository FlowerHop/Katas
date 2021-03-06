package com.flowerhop.katas.tennis

import com.flowerhop.katas.tennis.exception.NoWinnerException

class Game private constructor(val player1: Player, val player2: Player) {
    companion object {
        fun create(player1: Player, player2: Player): Game {
            return Game(player1, player2)
        }
    }

    private var advantagePlayer: Player? = null
    private var winner: Player? = null

    fun getWinner(): Player {
        if (winner == null) throw NoWinnerException("No winner.")
        return winner!!
    }

    // No action when game is finished
    fun player1Wins() {
        if (winner != null) return

        if (player1.score != Score.Forty) {
            player1.wins()
            return
        }

        // Play 1 is 40
        if (isInDeuce()) {
            advantagePlayer = player1
            return
        }

        if (player2.score != Score.Forty) {
            winner = player1
            return
        }

        if (advantagePlayer == player1) {
            winner = player1
            return
        }

        advantagePlayer = null
    }

    // No action when game is finished
    fun player2Wins() {
        if (winner != null) return

        if (player2.score != Score.Forty) {
            player2.wins()
            return
        }

        if (isInDeuce()) {
            advantagePlayer = player2
            return
        }

        if (player1.score != Score.Forty) {
            winner = player2
            return
        }

        if (advantagePlayer == player2) {
            winner = player2
            return
        }

        advantagePlayer = null
    }

    fun isInDeuce(): Boolean {
        return advantagePlayer == null
                && player1.score == Score.Forty
                && player2.score == Score.Forty
    }
}
