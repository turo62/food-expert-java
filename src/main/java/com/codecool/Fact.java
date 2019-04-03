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
    
    public String getId() {
        return this.id;
    }
    
    public Set<String> getIdSet() {
        return this.evaluation.keySet();
    }
    
    public void setFactValueById(String id, Boolean value) {
        this.evaluation.put(id, value);
    }
    
    public Boolean getValueById(String id) {
        return this.evaluation.get(id);
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public Map getEvaluation() {
        return this.evaluation;
    }
}
