package it.unicam.cs.mpgc.rpg126523.model.factory;

import it.unicam.cs.mpgc.rpg126523.model.Gender;
import it.unicam.cs.mpgc.rpg126523.model.Statistics;
import it.unicam.cs.mpgc.rpg126523.model.TypeStatistic;
import it.unicam.cs.mpgc.rpg126523.model.interfaces.Student;

import java.util.Map;

/**
 * Factory per la creazione dello studente diligente, con una buona propensioe allo studio ma una scarsa tanacia fisica
 */
public class OverachieverFactory extends StatisticsFactory {

    @Override
    public Statistics createStatistics() {
        return new Statistics(
                Map.of(TypeStatistic.INGENUITY,18,
                        TypeStatistic.VIGOR,12,
                        TypeStatistic.COMPOSURE,14));

    }
}
