package com.codecool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
        int index;
        
        @Override
        public boolean hasNext() {
            return index < facts.size();
        }
        
        @Override
        public Fact next() {
            if (this.hasNext()) {
                return facts.get(index++);
            } else {
                return null;
            }
        }
    }
}
