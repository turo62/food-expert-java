package com.codecool.containers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FactRepository {
    private List<Fact> facts;
    private Iterator<Fact> factIterator;
    
    public FactRepository() {
        this.facts = new ArrayList<>();
        this.factIterator = new Factiterator();
    }
    
    public void addFact(Fact fact) {
        this.facts.add(fact);
    }
    
    public Iterator<Fact> getIterator() {
        return this.factIterator;
    }
    
    private class Factiterator implements Iterator {
        private int index;
        public boolean hasNext() {
            if (index < facts.size()) {
                return true;
            }
            return false;
        }
    
        public Fact next() {
            return facts.get(index++);
        }
    }
}
