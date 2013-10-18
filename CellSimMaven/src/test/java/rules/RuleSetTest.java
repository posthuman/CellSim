package rules;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import rules.RuleSet;

public class RuleSetTest {

    RuleSet ruleSet;

    @Before
    public void setUp() {
        ruleSet = new RuleSet(1, "00011110");
    }

    @Test
    public void constructorSetsUpdateRulesCorrectly() {
    }

    @Test
    public void returnsCorrectCellValue() {
        assertEquals(0, ruleSet.getCellValue("111"));
        assertEquals(1, ruleSet.getCellValue("100"));
        assertEquals(0, ruleSet.getCellValue("000"));
        assertEquals(1, ruleSet.getCellValue("010"));
    }

    @Test
    public void returnsNeighborhoodSizeCorrectly() {
        assertEquals(3, ruleSet.getNeighborhoodSize());
    }

    @Test
    public void validatesRuleStringsCorrectly() {
        assertEquals(false, ruleSet.isValidRule(""));
        assertEquals(false, ruleSet.isValidRule(null));
        assertEquals(false, ruleSet.isValidRule("10012111"));
        assertEquals(false, ruleSet.isValidRule("d23dd32"));
        assertEquals(false, ruleSet.isValidRule("101011"));
        assertEquals(false, ruleSet.isValidRule("1010101010010101010100101010000"));
        assertEquals(false, ruleSet.isValidRule("1010101010010101012322frfr10000"));
        assertEquals(true, ruleSet.isValidRule("00000000"));
        assertEquals(true, ruleSet.isValidRule("11111111"));
        assertEquals(true, ruleSet.isValidRule("00101110"));
        assertEquals(true, ruleSet.isValidRule("00000000000000000000000000000000"));
        assertEquals(true, ruleSet.isValidRule("11111111111111111111111111111111"));
        assertEquals(true, ruleSet.isValidRule("11001100111000111001000111000111"));
    }

    @Test
    public void toStringReturnsCorrectString() {
        assertEquals(
                "Ruleset parameters: \n"
                + "Rule10001001\n"
                + "Neighborhood size: 3\n"
                + "Rule table: \n"
                + "|010|110|111|011|000|001|101|100|\n"
                + "| 0 | 0 | 1 | 1 | 1 | 0 | 0 | 0 |", new RuleSet(1, "10001001").toString());
    }

    @Test
    public void TODO4() {
    }
}
