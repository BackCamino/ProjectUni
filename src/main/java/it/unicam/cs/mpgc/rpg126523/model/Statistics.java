package it.unicam.cs.mpgc.rpg126523.model;

import lombok.ToString;

import java.util.Map;
import java.util.HashMap;

/**
 * Rappresenta un gruppo di statistiche
 */
@ToString
public class Statistics {

        private Map<TypeStatistic, Integer> values;

        public Statistics(Map<TypeStatistic,Integer> values){
            if(values == null || values.isEmpty()) throw new IllegalArgumentException();
            this.values = new HashMap<>(values);
        }

        public Integer getValueFromStatistic(TypeStatistic type){
            return this.values.get(type);
        }

        public int getModify(TypeStatistic type){
            return (this.values.get(type)-10)/2;
        }

}
