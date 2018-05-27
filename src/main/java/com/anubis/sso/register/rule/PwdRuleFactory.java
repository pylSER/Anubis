package com.anubis.sso.register.rule;

public class PwdRuleFactory {

    public PwdRule getPwdRule(String ruleType){
        switch (ruleType){
            case "noRule":
                return new NoRule();
            //you can add your own encrypt method if necessary
            default:
                return new NoRule();
        }
    }
}
