package it.unicam.cs.mpgc.rpg126523.model.interfaces;

/**
 * Interfaccia risorsa
 */
public interface Resource {

    String getName();

    int getValue();

    void increment();

    void increment(int delta);

    void decrement();

    void decrement(int delta);


}
