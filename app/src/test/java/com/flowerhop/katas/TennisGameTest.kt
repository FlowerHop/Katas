package com.flowerhop.katas

import org.junit.Assert.*
import org.junit.Test

class TennisGameTest {
    @Test
    fun `Ken and Flower can join a new tennis game`() {
        // Arrange
        val ken = Player("Ken")
        val flower = Player("Flower")
        val game = Game.create(ken, flower)
        val expectedPlayers = "Ken, Flower"

        // Act
        val players = game.getPlayers()

        // Assert
        assertEquals(expectedPlayers, players)
    }

    @Test
    fun `new game has no winner`() {
        // Arrange
        val ken = Player("Ken")
        val flower = Player("Flower")
        val newGame = Game.create(ken, flower)

        // Assert
        assertThrows(NoWinnerException::class.java) {
            // Act
            newGame.getWinner()
        }
    }

    @Test
    fun `players are all love in a new game`() {
        // Arrange
        val ken = Player("Ken")
        val flower = Player("Flower")
        val newGame = Game.create(ken, flower)
        val expected = "Love, Love"

        // Act
        val scores = newGame.getScores()

        // Assert
        assertEquals(expected, scores)
    }

    @Test
    fun `player 1 get the first point, we should get 15, Love`() {
        // Arrange
        val ken = Player("Ken")
        val flower = Player("Flower")
        val game = Game.create(ken, flower)
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
        val ken = Player("Ken")
        val flower = Player("Flower")
        val game = Game.create(ken, flower)
        game.player1Wins()
        game.player1Wins()
        game.player1Wins()
        game.player2Wins()
        game.player2Wins()
        val expected = "Ken wins."

        // Act
        game.player1Wins()
        val winner = game.getWinner()

        // Assert
        assertEquals(expected, winner)
    }

    @Test
    fun `player 2 wins the last ball when game scores is 30, 40`() {
        // Arrange
        val ken = Player("Ken")
        val flower = Player("Flower")
        val game = Game.create(ken, flower)
        game.player1Wins()
        game.player1Wins()
        game.player2Wins()
        game.player2Wins()
        game.player2Wins()
        val expected = "Flower wins."

        // Act
        game.player2Wins()
        val winner = game.getWinner()

        // Assert
        assertEquals(expected, winner)
    }

    @Test
    fun `When score is 40, 40 and no player with advantage, it is in deuce`() {
        // Arrange
        val game = createDeuceGame()

        // Act
        // Assert
        assertTrue(game.isInDeuce())
    }

    @Test
    fun `It's not in deuce when there is a player with advantage`() {
        // Arrange
        val game = createDeuceGame()
        game.player1Wins()

        // Act
        // Assert
        assertFalse(game.isInDeuce())
    }

    @Test
    fun `It's in deuce when player 1 loses with advantage`() {
        // Arrange
        val game = createDeuceGame()
        game.player1Wins()

        // Act
        game.player2Wins()

        // Assert
        assertTrue(game.isInDeuce())
    }

    @Test
    fun `Player 2 wins the game when player 2 win the last ball with advantage`() {
        // Arrange
        val game = createDeuceGame()
        game.player2Wins()
        val expected = "Flower wins."

        // Act
        game.player2Wins()
        val winner = game.getWinner()

        // Assert
        assertEquals(expected, winner)
    }

    private fun createDeuceGame(): Game {
        return Game.create(Player("Ken"), Player("Flower")).apply {
            player1Wins()
            player1Wins()
            player1Wins()
            player2Wins()
            player2Wins()
            player2Wins()
        }
    }
}