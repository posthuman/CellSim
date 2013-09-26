package tests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import rules.RuleSet;

public class RuleSetTest {

    RuleSet ruleSet;

    @Before
    public void setUp() {
        ruleSet = new RuleSet("Rule30", 1, "00011110");
    }

    @Test
    public void constructorSetsUpdateRulesCorrectly() {
    }

    /*@Test
    public void setsUpdateRulesCorrectly() {
        //redundant?
    }*/

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
    public void TODO3() {
    }

    @Test
    public void TODO4() {
    }
}