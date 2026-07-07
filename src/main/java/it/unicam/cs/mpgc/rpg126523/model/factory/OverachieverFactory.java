package it.unicam.cs.mpgc.rpg126523.model.factory;

import it.unicam.cs.mpgc.rpg126523.model.Statistics;
import it.unicam.cs.mpgc.rpg126523.model.StatisticType;

import java.util.Map;

/**
 * Factory per la creazione dello studente diligente, con una buona propensioe allo studio ma una scarsa tanacia fisica
 */
public class OverachieverFactory extends StatisticsFactory {

    @Override
    public Statistics createStatistics() {
        return new Statistics(
                Map.of(StatisticType.INGENUITY,18,
                        StatisticType.VIGOR,12,
                        StatisticType.COMPOSURE,14));

    }
}
