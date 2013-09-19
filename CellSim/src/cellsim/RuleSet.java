package cellsim;

import java.util.HashMap;

public class RuleSet {

    private HashMap<String, Integer> updateRules;
    private String[] neighborhoods;
    private static final String[] nb1 = {"111", "110", "101", "100",
        "011", "010", "001", "000"};
    private static final String[] nb2 = {"111", "110", "101", "100",
        "011", "010", "001", "000"};

    public RuleSet(int neighborhoodSize, String rule) {
        if (neighborhoodSize == 1) {
            neighborhoods = nb1;
        } else {
            neighborhoods = nb2;
        }
        setUpdateRules(rule);
    }

    public void setUpdateRules(String newRule) {
        HashMap<String, Integer> newUpdateRules = new HashMap<>();
        for (int i = 0; i < neighborhoods.length; i++) {
            newUpdateRules.put(neighborhoods[i], Integer.parseInt("" + newRule.charAt(i)));
        }
        updateRules = newUpdateRules;
    }

    public HashMap<String, Integer> getUpdateRules() {
        return updateRules;
    }
}
