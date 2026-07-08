package it.unicam.cs.mpgc.rpg126523.model.statistics;

import java.util.Map;

/**
 * Factory per la creazione dello studente diligente, con una buona propensioe allo studio ma una scarsa tanacia fisica
 */
public class OverachieverFactory implements StudentClass {

    @Override
    public Statistics createStatistics() {
        return new Statistics(
                Map.of(StatisticType.INGENUITY,18,
                        StatisticType.VIGOR,12,
                        StatisticType.COMPOSURE,14));

    }

    @Override
    public String getName() {
        return "Diligente";
    }
}
