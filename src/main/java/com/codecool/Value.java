package com.codecool;

import java.util.List;

public abstract class Value {
    List<String> inputPattern;
    boolean selectionType;
    
    public List<String> getInputPattern() {
        return this.inputPattern;
    }
    
    public Boolean getSelectionType() {
        return this.selectionType;
    }
}
