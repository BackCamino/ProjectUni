package it.unicam.cs.mpgc.rpg126523.model.consequences;

/**
 * Interfaccia che offre il comportamento di gestire una conseguenza passata
 */
public interface ConsequencesApplier {
    /**
     * Applica all'oggetto una conseguenza passata
     * @param consequences valori che modificheranno lo stato dell'oggetto
     */
    public void applyConsequences(Consequences consequences );
}
