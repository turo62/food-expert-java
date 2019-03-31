package com.codecool;

import java.util.ArrayList;

public class SingleValue extends Value {
    private String param;
    
    public SingleValue(String param, Boolean selectionType) {
        this.param = param;
        this.selectionType = selectionType;
    }
}
