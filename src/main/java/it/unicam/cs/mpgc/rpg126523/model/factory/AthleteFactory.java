package it.unicam.cs.mpgc.rpg126523.model.factory;

import it.unicam.cs.mpgc.rpg126523.model.Statistics;
import it.unicam.cs.mpgc.rpg126523.model.TypeStatistic;

import java.util.Map;

/**
 * Studente atlata con una forte resistenza fisica e una buona propensione allo stress
 */
public class AthleteFactory extends StatisticsFactory {

    @Override
    public Statistics createStatistics() {
        return new Statistics(
                Map.of(TypeStatistic.VIGOR, 18,
                        TypeStatistic.INGENUITY, 12,
                        TypeStatistic.COMPOSURE, 14));
    }
}