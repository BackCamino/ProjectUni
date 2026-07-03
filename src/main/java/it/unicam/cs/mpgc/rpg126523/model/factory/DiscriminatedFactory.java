package it.unicam.cs.mpgc.rpg126523.model.factory;

import it.unicam.cs.mpgc.rpg126523.model.Statistics;
import it.unicam.cs.mpgc.rpg126523.model.TypeStatistic;


import java.util.Map;

/**
 * Factory per create lo studente discriminato, lui non sa perchè sta qui, ha tutte le statistcihe molto basse
 *
 */
public class DiscriminatedFactory extends StatisticsFactory{
    @Override
    public Statistics createStatistics() {
        return new Statistics(Map.of(TypeStatistic.COMPOSURE,10,
                TypeStatistic.INGENUITY,10,
                TypeStatistic.VIGOR,10));
    }
}
