package org.ffernandez.patrones.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Observable {

    protected List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    public void removeObserver(Observer obs) {
        observers.remove(obs);
    }


    public void notifyObservers() {
        notifyObservers(null);
    }


    public void notifyObservers(String obj){
        for (Observer obs : this.observers) {
            obs.update(this, obj);
        }
    }



}
