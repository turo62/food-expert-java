package com.codecool;

import java.util.List;

public abstract class Value {
    List<String> inputPattern;
    Boolean selectionType;
    
    public List<String> getInputPattern() {
        return inputPattern;
    }
    
    public Boolean getSelectionType() {
        return selectionType;
    }
}
