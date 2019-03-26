package com.codecool;

import java.util.ArrayList;

public class SingleValue extends Value {
    
    public SingleValue(String param, Boolean selectionType) {
        this.inputPattern = new ArrayList<>();
        inputPattern.add(param);
        this.selectionType = selectionType;
    }
}
