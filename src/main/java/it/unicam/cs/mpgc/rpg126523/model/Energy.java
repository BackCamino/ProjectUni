package it.unicam.cs.mpgc.rpg126523.model;

import it.unicam.cs.mpgc.rpg126523.model.interfaces.Resource;

public class Energy implements Resource {
    public final static int MAX_VALUE=30;
    public int value;
    public final String name;
    public Energy(){
        this.value=MAX_VALUE;
        name="Energia";
    }

    public Energy(int value){
        if(value>MAX_VALUE||value<=0)
            throw new IllegalArgumentException("Valore non conforme");
        this.value=value;
        name="Energia";
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void increment() {
        if (this.value++ >= MAX_VALUE)
            this.value = MAX_VALUE;
    }

    @Override
    public void increment(int delta) {
        if(delta<0)
            throw new IllegalArgumentException("Delta deve essere positivo");
        if ((this.value+=delta) >= MAX_VALUE)
            this.value = MAX_VALUE;

    }

    @Override
    public void decrement() {
        if (this.value-- <= 0)
            this.value = 0;

    }

    @Override
    public void decrement(int delta) {
        if(delta<0)
            throw new IllegalArgumentException("Delta deve essere positivo");
        if ((this.value-=delta) <= 0)
            this.value = 0;
    }
}
