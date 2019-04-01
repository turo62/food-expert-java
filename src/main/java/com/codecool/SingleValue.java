package com.codecool;

import java.util.ArrayList;

public class SingleValue extends Value {
    private String param;
    
    public SingleValue(String param, Boolean selectionType) {
        this.inputPattern = new ArrayList<>();
        this.inputPattern.add(param);
        this.selectionType = selectionType;
    }
}
