package it.unicam.cs.mpgc.rpg126523.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnergyTest {

    private Energy energy;

    @BeforeEach
    void setUp() {
        energy = new Energy();
    }

    @Test
    void constructorThrowsWhenValueIsInvalid(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Energy(-5);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Energy(31);
        });
    }

    @Test
    void initialValueIsMaxValue() {
        assertEquals(Energy.MAX_VALUE, energy.getValue());
    }

    @Test
    void nameIsEnergia() {
        assertEquals("Energia", energy.getName());
    }

    @Test
    void decrementReducesValueByOne() {
        energy.decrement();
        assertEquals(Energy.MAX_VALUE - 1, energy.getValue());
    }

    @Test
    void decrementValueByDelta(){
        energy.decrement(5);
        assertEquals(25, energy.getValue());
        energy.decrement(10);
        assertEquals(15, energy.getValue());
    }

    @Test
    void decrementDoesNotGoBelowZero() {
        for (int i = 0; i < Energy.MAX_VALUE + 5; i++) {
            energy.decrement();
        }
        assertEquals(0, energy.getValue());
    }

    @Test
    void incrementDoesNotExceedMaxValue() {
        energy.increment();
        assertEquals(Energy.MAX_VALUE, energy.getValue());
    }

    @Test
    void incrementValueByDelta(){
        energy.decrement(10);
        energy.increment(5);
        assertEquals(25, energy.getValue());
    }

}