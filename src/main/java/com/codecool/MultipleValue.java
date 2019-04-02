package com.codecool;

import java.util.List;

public class MultipleValue extends Value {
    List<String> params;
    
    public MultipleValue(List<String> params, boolean selectionType) {
        this.inputPattern = params;
        this.selectionType = selectionType;
    }
    
    public List<String> getParams() {
        return params;
    }
}
