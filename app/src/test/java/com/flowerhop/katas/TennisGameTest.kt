package com.flowerhop.katas

import org.junit.Assert.*
import org.junit.Test

class TennisGameTest {
    @Test
    fun `new game has no winner`() {
        // Arrange
        val newGame = Game()

        // Assert
        assertThrows(NoWinnerException::class.java) {
            // Act
            newGame.getWinner()
        }
    }

    @Test
    fun `players are all love in a new game`() {
        // Arrange
        val game = Game()
        val expected = "Love, Love"

        // Act
        val scores = game.getScores()

        // Assert
        assertEquals(expected, scores)
    }

    @Test
    fun `player 1 get the first point, we should get 10, Love`() {
        // Arrange
        val game = Game()
        val expect = "Fifteen, Love"

        // Act
        game.player1Wins()
        val scores = game.getScores()

        // Assert
        assertEquals(expect, scores)
    }

    @Test
    fun `player 1 wins the last ball when game scores is 40, 30`() {
        // Arrange
        val game = Game()
        game.player1Wins()
        game.player1Wins()
        game.player1Wins()
        game.player2Wins()
        game.player2Wins()
        val expected = "Player 1 wins."

        // Act
        game.player1Wins()
        val winner = game.getWinner()

        // Assert
        assertEquals(expected, winner)
    }
}