package it.unicam.cs.mpgc.rpg126523.model;

import it.unicam.cs.mpgc.rpg126523.model.interfaces.ValueAdjustable;

public abstract class AbstractValutable implements ValueAdjustable {
    //TODO: Da migliorare i comportamteni
    protected final int minValue;
    protected final int maxValue;
    protected int value;

    protected AbstractValutable(int minValue, int maxValue, int initialValue) {
        if (minValue > maxValue || initialValue < minValue || initialValue > maxValue)
            throw new IllegalArgumentException("Valori non conformi");
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.value = initialValue;
    }

    @Override
    public int getValue() { return value; }

    @Override
    public void increment(int delta) {
        if (delta < 0) throw new IllegalArgumentException("Delta deve essere positivo");
        value = Math.min(value + delta, maxValue);
    }

    @Override
    public void decrement(int delta) {
        if (delta < 0) throw new IllegalArgumentException("Delta deve essere positivo");
        value = Math.max(value - delta, minValue);
    }
}