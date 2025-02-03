package org.machinecoding.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class GameMovementStrategyTest {

    private DiceMovementStrategy diceMovementStrategy;
    private TeleporterMovementStrategy teleporterMovementStrategy;
    private GameMovementStrategy gameMovementStrategy;

    @BeforeEach
    void setUp() {
        diceMovementStrategy = Mockito.mock(DiceMovementStrategy.class);
        teleporterMovementStrategy = Mockito.mock(TeleporterMovementStrategy.class);
        gameMovementStrategy = new GameMovementStrategy(diceMovementStrategy, teleporterMovementStrategy);
    }

    // Test Scenario: Test the move method to ensure it correctly calculates the new position using both dice and teleporter strategies, and updates diceValue and teleporterValue accordingly.
    @Test
    void testMoveMethodCalculatesNewPositionAndUpdatesValues() {
        int initialPosition = 0;
        when(diceMovementStrategy.move(initialPosition)).thenReturn(5);
        when(teleporterMovementStrategy.move(5)).thenReturn(10);

        int finalPosition = gameMovementStrategy.move(initialPosition);

        assertEquals(10, finalPosition);
        assertEquals(5, gameMovementStrategy.getDiceValue());
        assertEquals(5, gameMovementStrategy.getTeleporterValue());
    }

    // Test Scenario: Test if the GameMovementStrategy correctly utilizes the DiceMovementStrategy to calculate the diceValue when move is called.
    @Test
    void testDiceValueCalculation() {
        int initialPosition = 2;
        when(diceMovementStrategy.move(initialPosition)).thenReturn(7);

        gameMovementStrategy.move(initialPosition);

        assertEquals(5, gameMovementStrategy.getDiceValue());
    }

    // Test Scenario: Test the behavior of GameMovementStrategy when teleporterMovementStrategy returns a position that is significantly different from the diceMovementStrategy's result, ensuring teleporterValue is calculated correctly.
    @Test
    void testTeleporterValueWithSignificantDifference() {
        int initialPosition = 3;
        when(diceMovementStrategy.move(initialPosition)).thenReturn(8);
        when(teleporterMovementStrategy.move(8)).thenReturn(20);

        gameMovementStrategy.move(initialPosition);

        assertEquals(12, gameMovementStrategy.getTeleporterValue());
    }

    // Test Scenario: Verify that the diceValue is correctly updated after the move method is called, reflecting the difference between the initial position and the position after the dice movement strategy is applied.
    @Test
    void testDiceValueUpdateAfterMove() {
        int initialPosition = 4;
        when(diceMovementStrategy.move(initialPosition)).thenReturn(9);

        gameMovementStrategy.move(initialPosition);

        assertEquals(5, gameMovementStrategy.getDiceValue());
    }

    // Test Scenario: Test teleporterValue calculation when teleporterMovementStrategy moves the position forward.
    @Test
    void testTeleporterValueCalculationForwardMove() {
        int initialPosition = 5;
        when(diceMovementStrategy.move(initialPosition)).thenReturn(10);
        when(teleporterMovementStrategy.move(10)).thenReturn(15);

        gameMovementStrategy.move(initialPosition);

        assertEquals(5, gameMovementStrategy.getTeleporterValue());
    }

    // Test Scenario: Test the constructor to ensure it correctly initializes the GameMovementStrategy with given DiceMovementStrategy and TeleporterMovementStrategy instances.
    @Test
    void testConstructorInitialization() {
        GameMovementStrategy strategy = new GameMovementStrategy(diceMovementStrategy, teleporterMovementStrategy);
        assertEquals(diceMovementStrategy, strategy.diceMovementStrategy);
        assertEquals(teleporterMovementStrategy, strategy.teleporterMovementStrategy);
    }

    // Test Scenario: Verify that the GameMovementStrategy constructor correctly assigns the provided DiceMovementStrategy instance to the diceMovementStrategy field, ensuring that subsequent calls to move() use this instance for dice movement calculations.
    @Test
    void testDiceMovementStrategyAssignmentInConstructor() {
        GameMovementStrategy strategy = new GameMovementStrategy(diceMovementStrategy, teleporterMovementStrategy);
        assertEquals(diceMovementStrategy, strategy.diceMovementStrategy);
    }

    // Test Scenario: Verify that the teleporterMovementStrategy correctly updates the teleporterValue after moving from the diceMovedPosition, ensuring the teleporterValue reflects the difference between the teleporterMovedPosition and diceMovedPosition.
    @Test
    void testTeleporterMovementStrategyUpdatesTeleporterValue() {
        int initialPosition = 6;
        when(diceMovementStrategy.move(initialPosition)).thenReturn(11);
        when(teleporterMovementStrategy.move(11)).thenReturn(16);

        gameMovementStrategy.move(initialPosition);

        assertEquals(5, gameMovementStrategy.getTeleporterValue());
    }

    // Test Scenario: Test the move method with a starting position of 0, ensuring the dice and teleporter strategies are called correctly, and the final position is calculated accurately.
    @Test
    void testMoveMethodWithStartingPositionZero() {
        int initialPosition = 0;
        when(diceMovementStrategy.move(initialPosition)).thenReturn(3);
        when(teleporterMovementStrategy.move(3)).thenReturn(8);

        int finalPosition = gameMovementStrategy.move(initialPosition);

        assertEquals(8, finalPosition);
    }

    // Test Scenario: Test the move method to ensure it correctly updates diceValue when diceMovementStrategy returns a positive move.
    @Test
    void testDiceValueUpdateWithPositiveMove() {
        int initialPosition = 7;
        when(diceMovementStrategy.move(initialPosition)).thenReturn(12);

        gameMovementStrategy.move(initialPosition);

        assertEquals(5, gameMovementStrategy.getDiceValue());
    }

    // Test Scenario: Verify that the diceValue is correctly updated when the move method is called, ensuring it reflects the difference between the new position after dice movement and the initial position.
    @Test
    void testDiceValueCorrectUpdateAfterMove() {
        int initialPosition = 8;
        when(diceMovementStrategy.move(initialPosition)).thenReturn(13);

        gameMovementStrategy.move(initialPosition);

        assertEquals(5, gameMovementStrategy.getDiceValue());
    }

    // Test Scenario: Test teleporter movement when dice movement results in a position that triggers a teleportation event.
    @Test
    void testTeleporterMovementOnDiceTrigger() {
        int initialPosition = 9;
        when(diceMovementStrategy.move(initialPosition)).thenReturn(14);
        when(teleporterMovementStrategy.move(14)).thenReturn(19);

        gameMovementStrategy.move(initialPosition);

        assertEquals(5, gameMovementStrategy.getTeleporterValue());
    }

    // Test Scenario: Test teleporterValue calculation when teleporterMovementStrategy moves forward by 5 positions from a diceMovedPosition of 10.
    @Test
    void testTeleporterValueCalculationWithForwardMove() {
        int initialPosition = 10;
        when(diceMovementStrategy.move(initialPosition)).thenReturn(15);
        when(teleporterMovementStrategy.move(15)).thenReturn(20);

        gameMovementStrategy.move(initialPosition);

        assertEquals(5, gameMovementStrategy.getTeleporterValue());
    }

    // Test Scenario: Verify that the move method correctly updates the teleporterMovedPosition based on the teleporterMovementStrategy's move result, ensuring the teleporterValue reflects the difference between the teleporterMovedPosition and diceMovedPosition.
    @Test
    void testTeleporterMovedPositionUpdate() {
        int initialPosition = 11;
        when(diceMovementStrategy.move(initialPosition)).thenReturn(16);
        when(teleporterMovementStrategy.move(16)).thenReturn(21);

        gameMovementStrategy.move(initialPosition);

        assertEquals(5, gameMovementStrategy.getTeleporterValue());
    }

    // Test Scenario: Verify that the getDiceValue() method returns the correct dice movement value after a move operation is performed.
    @Test
    void testGetDiceValueMethod() {
        int initialPosition = 12;
        when(diceMovementStrategy.move(initialPosition)).thenReturn(17);

        gameMovementStrategy.move(initialPosition);

        assertEquals(5, gameMovementStrategy.getDiceValue());
    }

    // Test Scenario: Verify that getTeleporterValue() returns the correct teleporter movement value after move() is called.
    @Test
    void testGetTeleporterValueMethod() {
        int initialPosition = 13;
        when(diceMovementStrategy.move(initialPosition)).thenReturn(18);
        when(teleporterMovementStrategy.move(18)).thenReturn(23);

        gameMovementStrategy.move(initialPosition);

        assertEquals(5, gameMovementStrategy.getTeleporterValue());
    }
}