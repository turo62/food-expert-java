package com.codecool;

import java.util.Iterator;
import java.util.List;

public class FactRepository {
    private List<Fact> facts;
    private Iterator<Fact> factIterator;
    
    public FactRepository() {
        this.facts = facts;
        this.factIterator = factIterator;
    }
    
    public void addFact(Fact fact) {
        this.facts.add(fact);
    }
    
    public Iterator<Fact> getIterator() {
        return this.factIterator;
    }
    
    private class Factiterator implements Iterator {
        int index = 0;
        
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
