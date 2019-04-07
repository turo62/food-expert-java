package com.codecool.containers;

import java.util.List;

public class MultipleValue extends Value {
    private List<String> params;
    
    public MultipleValue(List<String> params, boolean selectionType) {
        this.inputPattern = params;
        this.selectionType = selectionType;
    }
    
    public List<String> getParams() {
        return params;
    }
}
