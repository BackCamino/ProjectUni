package it.unicam.cs.mpgc.rpg126523.model;

import java.util.HashMap;

/**
 * Rappresenta un gruppo di statistiche
 */
public class Statistics {

        private HashMap<TypeStatistic, Integer> values;

        public Statistics(){
            this.values= new HashMap<>();

        }

        public Statistics(HashMap<TypeStatistic,Integer> values){
            if(values == null || values.isEmpty()) throw new IllegalArgumentException();
        }

        public Integer getValueFromStatistic(TypeStatistic type){
            return values.get(type);
        }



}
