package com.codecool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Fact {
    
    private String id;
    private String description;
    private Map<String, Boolean> evaluation;
    
    public Fact(String id, String description) {
        this.id = id;
        this.description = description;
        this.evaluation = new HashMap<>();
    }
    
    public Set<String> getIdSet() {
        return this.evaluation.keySet();
    }
}
