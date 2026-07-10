package it.unicam.cs.mpgc.rpg126523.model.resource;

public interface ValueAdjustable {

    /**
     *
     * @return il valore che varia
     */
    int getValue();

    /**
    * Incrementa il valore della risorsa di un delta specificato nei parametri
    * @param delta unità che verrà aggiunta alla risorsa
    * @throws IllegalArgumentException se delta non è positivo
    */
    void increment(int delta);

    /**
    * Decrementa il valore della risorsa di un delta specificato nei parametri
    * @param delta unità di valore sottratta alla risorsa
    * @throws IllegalArgumentException se delta non è positivo
    */
    void decrement(int delta);

}
