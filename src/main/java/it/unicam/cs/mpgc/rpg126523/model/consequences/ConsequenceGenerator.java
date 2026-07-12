package it.unicam.cs.mpgc.rpg126523.model.consequences;

/**
 * Generatore di conseguenze, l'oggetto che implementa questa interfaccia sarà in grado di create una Conseguenza
 */
public interface ConsequenceGenerator {
    /**
     * In base ai propri valori l'oggetto crea una conseguenza
     * @return conseguenze creato dall'oggetto e che possono essere utilizzate da un @ConsequencesApplier
     */
    Consequences generateConsequences();
}
