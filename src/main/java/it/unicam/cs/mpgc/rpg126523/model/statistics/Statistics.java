package it.unicam.cs.mpgc.rpg126523.model.statistics;

import lombok.ToString;

import java.util.Map;
import java.util.HashMap;

/**
 * Rappresenta un gruppo di statistiche che uno studente in base alla classe scelta avra'
 * con valori compresi tra 1-20
 */
@ToString
public class Statistics {

        private final Map<StatisticType, Integer> values;

        public Statistics(Map<StatisticType,Integer> values){
            if(values == null || values.isEmpty()) throw new IllegalArgumentException("Statistiche senza valori");
            for(Integer value : values.values())
                if(value<=0||value>20) throw new IllegalArgumentException("Valori delle statistiche fuori range (1-20)");
            this.values = new HashMap<>(values);
        }

        public Integer getValueFromStatistic(StatisticType type){
            return this.values.get(type);
        }

        public int getModify(StatisticType type){
            return (this.values.get(type)-10)/2;
        }

}
