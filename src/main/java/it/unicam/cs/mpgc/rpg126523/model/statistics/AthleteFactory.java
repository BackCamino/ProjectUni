package it.unicam.cs.mpgc.rpg126523.model.statistics;

import java.util.Map;

/**
 * Studente atlata con una forte resistenza fisica e una buona propensione allo stress
 */
public class AthleteFactory implements StudentClass {

    @Override
    public Statistics createStatistics() {
        return new Statistics(
                Map.of(StatisticType.VIGOR, 18,
                        StatisticType.INGENUITY, 12,
                        StatisticType.COMPOSURE, 14));
    }

    @Override
    public String getName() {
        return "Atleta";
    }
}