package it.unicam.cs.mpgc.rpg126523.model.resource;

public abstract class AbstractValue implements ValueAdjustable {
    private final int minValue;
    private final int maxValue;
    private int value;

    protected AbstractValue(int minValue, int maxValue, int initialValue) {
        if (minValue > maxValue || initialValue < minValue || initialValue > maxValue)
            throw new IllegalArgumentException("Valori non validi");
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.value = initialValue;
    }

    @Override
    public int getValue() { return value; }

    @Override
    public void increment(int delta) {
        if (delta < 0) throw new IllegalArgumentException("Delta non valido, deve essere positivo");
        value = Math.min(value + delta, maxValue);
    }

    @Override
    public void decrement(int delta) {
        if (delta < 0) throw new IllegalArgumentException("Delta non valido, deve essere positivo");
        value = Math.max(value - delta, minValue);
    }
}