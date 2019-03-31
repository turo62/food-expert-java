package com.codecool;

import java.util.List;

public abstract class Value {
    List<String> inputPattern;
    boolean selectionType;
    
    public Value() {
        this.inputPattern = inputPattern;
        this.selectionType = selectionType;
    }
    
    public void setSelectionType(Boolean type) {
        this.selectionType = type;
    }
    
    public void setInputPattern(List inputPattern) {
        this.inputPattern = inputPattern;
    }
    public List<String> getInputPattern() {
        return this.inputPattern;
    }
    
    public Boolean getSelectionType() {
        return this.selectionType;
    }
}
