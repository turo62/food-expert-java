package com.codecool;

import java.util.Map;

public class ESProvider {
    Printing printing;
    private RuleRepository ruleRepository;
    private FactRepository factRepository;
    private Map<String, Boolean> userInput;
    private Fact fact;
    
    public ESProvider(FactParser factParser, RuleParser ruleParser) {
        this.factRepository = factParser.getFactRepository();
    this.ruleRepository = ruleParser.getRuleRepository();
}

}
