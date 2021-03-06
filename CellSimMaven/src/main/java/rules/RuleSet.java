package rules;

import java.util.HashMap;

/**
 * RuleSet represents rules used in simulation. Different rules produce
 * different cellular automata.
 *
 * @author Sami Kosonen
 * @version 0.8
 * @param name Name of RuleSet. Generated automatically.
 * @param updateRules HashMap with neighborhood pattern as key and cell value as target.
 * @param rule Given rule that is mapped to neighborhood patterns.
 */
public class RuleSet {

    private String name = "";
    private HashMap<String, Byte> updateRules;
    private String[] neighborhoodPatterns; //automatic generation method not yet implemented.
    private String rule;
    private boolean syncronous = true; //asyncronous not implemented yet
    private static final String[] nb1 = {"111", "110", "101", "100",
        "011", "010", "001", "000"};
    private static final String[] nb2 = {"11111", "11110", "11101", "11011", "10111", "01111", "11100", "11010",
        "10110", "01110", "11001", "10101", "01101", "10011", "01011", "00111",
        "11000", "10100", "01100", "10010", "01010", "00110", "10001", "01001",
        "00101", "00011", "10000", "01000", "00100", "00010", "00001", "00000"};

    public RuleSet(int neighborhoodSpan, String rule) {
        this.rule = rule;
        if (neighborhoodSpan == 1) {
            neighborhoodPatterns = nb1;
        } else {
            neighborhoodPatterns = nb2;
        }
        this.name = "Rule" + this.rule;
        setUpdateRules(rule);
    }

    public String getName() {
        return name;
    }

    public String getRule() {
        return rule;
    }
    
    /**
     * Matches given rule string to all different neighborhoods.
     * 
     * @param newRule New rule.
     */
    private void setUpdateRules(String newRule) {
        HashMap<String, Byte> newUpdateRules = new HashMap<>();
        for (int i = 0; i < neighborhoodPatterns.length; i++) {
            newUpdateRules.put(neighborhoodPatterns[i], (byte) Integer.parseInt("" + newRule.charAt(i)));
        }
        updateRules = newUpdateRules;
    }

    public HashMap<String, Byte> getUpdateRules() {
        return updateRules;
    }

    public byte getCellValue(String pattern) {
        return updateRules.get(pattern);
    }

    public int getNeighborhoodSize() {
        return neighborhoodPatterns[0].length();
    }

    /**
     * Checks if given string is valid rule. Returns boolean.
     * 
     * @param ruleCandidate Candidate rule to be evaluated.
     * @return Boolean of result of evaluation.
     */
    
    public boolean isValidRule(String ruleCandidate) {
        if (ruleCandidate == null) {
            return false;
        }
        if (!(ruleCandidate.length() == 8 || ruleCandidate.length() == 32)) {
            return false;
        } else {
            for (int i = 0; i < ruleCandidate.length(); i++) {
                if (!(ruleCandidate.charAt(i) == '0' || ruleCandidate.charAt(i) == '1')) {
                    return false;
                }
            }
        }
        return true;
    }

    private String updateRulesToString() {
        String s = "|";
        for (String k : updateRules.keySet()) {
            s += k + "|";
        }
        s += "\n";

        s += "|";
        String blanks = "";
        for (int i = 0; i < getNeighborhoodSize() / 2; i++) {
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
