package it.unicam.cs.mpgc.rpg126523.view;

public class GameController implements HasNavigator{
    private Navigator navigator;
    @Override
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }
}
