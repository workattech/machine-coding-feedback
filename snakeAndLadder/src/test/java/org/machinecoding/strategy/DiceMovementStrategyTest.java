package org.machinecoding.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.machinecoding.models.Dice;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class DiceMovementStrategyTest {

    private DiceMovementStrategy diceMovementStrategy;
    private List<Dice> mockDices;

    @BeforeEach
    void setUp() {
        mockDices = List.of(Mockito.mock(Dice.class), Mockito.mock(Dice.class));
        diceMovementStrategy = new DiceMovementStrategy(mockDices);
    }

    // Test Scenario: Test the DiceMovementStrategy class to ensure it correctly implements the MovementStrategy interface,
    // focusing on the move method's ability to calculate the new position based on dice rolls.
    @ParameterizedTest
    @CsvSource({
            "0, 3, 4, 7",
            "5, 2, 6, 13",
            "10, 1, 1, 12"
    })
    void testMoveMethodCalculatesNewPosition(int initialPosition, int roll1, int roll2, int expectedPosition) {
        when(mockDices.get(0).roll()).thenReturn(roll1);
        when(mockDices.get(1).roll()).thenReturn(roll2);

        int newPosition = diceMovementStrategy.move(initialPosition);

        assertEquals(expectedPosition, newPosition);
    }

    // Test Scenario: Test the move method with an empty list of dice to ensure it returns the initial position without changes.
    @Test
    void testMoveMethodWithEmptyDiceList() {
        DiceMovementStrategy strategyWithNoDice = new DiceMovementStrategy(List.of());
        int initialPosition = 10;

        int newPosition = strategyWithNoDice.move(initialPosition);

        assertEquals(initialPosition, newPosition);
    }

    // Test Scenario: Test the move method with maximum dice roll values to ensure it calculates the correct new position.
    @Test
    void testMoveMethodWithMaximumDiceRolls() {
        when(mockDices.get(0).roll()).thenReturn(6);
        when(mockDices.get(1).roll()).thenReturn(6);
        int initialPosition = 0;

        int newPosition = diceMovementStrategy.move(initialPosition);

        assertEquals(12, newPosition);
    }

    // Test Scenario: Test the move method with minimum dice roll values to ensure it calculates the correct new position.
    @Test
    void testMoveMethodWithMinimumDiceRolls() {
        when(mockDices.get(0).roll()).thenReturn(1);
        when(mockDices.get(1).roll()).thenReturn(1);
        int initialPosition = 0;

        int newPosition = diceMovementStrategy.move(initialPosition);

        assertEquals(2, newPosition);
    }
}