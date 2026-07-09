package it.unicam.cs.mpgc.rpg126523.model.statistics;


import java.util.Map;

/**
 * Factory per create lo studente discriminato, lui non sa perchè sta qui, ha tutte le statistcihe molto basse
 *
 */
public class DiscriminatedFactory implements StudentClass{
    @Override
    public Statistics createStatistics() {
        return new Statistics(Map.of(StatisticType.COMPOSURE,10,
                StatisticType.INGENUITY,10,
                StatisticType.VIGOR,10));
    }

    @Override
    public String getName() {
        return "Discriminato";
    }
    @Override
    public String toString() {
        return getName();
    }
}
