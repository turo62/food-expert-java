package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class SingleValue extends Value {
    private List<String> param;
    
    public SingleValue(List param, boolean selectionType) {
        this.inputPattern = param;
        this.selectionType = selectionType;
    }
    
    public List<String> getParam() {
        return param;
    }
}
