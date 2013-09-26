package rules;

import java.util.HashMap;

public class RuleSet {

    private String name = "";
    private HashMap<String, Integer> updateRules;
    private String[] neighborhoodPatterns;
    private boolean syncronous = true;
    private static final String[] nb1 = {"111", "110", "101", "100",
        "011", "010", "001", "000"};
    private static final String[] nb2 = {"11111", "11110", "11101", "11011", "10111", "01111", "11100", "11010",
        "10110", "01110", "11001", "10101", "01101", "10011", "01011", "00111",
        "11000", "10100", "01100", "10010", "01010", "00110", "10001", "01001",
        "00101", "00011", "10000", "01000", "00100", "00010", "00001", "00000"};

    public RuleSet(String name, int neighborhoodSize, String rule) {
        if (neighborhoodSize == 1) {
            neighborhoodPatterns = nb1;
        } else {
            neighborhoodPatterns = nb2;
        }
        this.name = name;
        setUpdateRules(rule);
    }

    private void setUpdateRules(String newRule) {
        HashMap<String, Integer> newUpdateRules = new HashMap<>();
        for (int i = 0; i < neighborhoodPatterns.length; i++) {
            newUpdateRules.put(neighborhoodPatterns[i], Integer.parseInt("" + newRule.charAt(i)));
        }
        updateRules = newUpdateRules;
    }

    public HashMap<String, Integer> getUpdateRules() {
        return updateRules;
    }
    
    public int getCellValue(String pattern){  
        return updateRules.get(pattern);
    }

    public int getNeighborhoodSize() {
        return neighborhoodPatterns[0].length();
    }

    private String updateRulesToString() {
        String s = "|";
        for (String k : updateRules.keySet()) {
            s += k + "|";
        }
        s += "\n";

        s += "|";
        String blanks = "";
        for (int i = 0; i < getNeighborhoodSize()/2; i++) {
            blanks += " ";
        }
        for (String k : updateRules.keySet()) {
            s += blanks + updateRules.get(k) + blanks + "|";
        }
        return s;
    }

    @Override
    public String toString() {
        String s = "Ruleset parameters: \n";
        s += this.name + "\n";
        s += "Neighborhood size: " + getNeighborhoodSize() + "\n";
        s += "Rule table: \n";
        s += updateRulesToString();
        return s;
    }
}
