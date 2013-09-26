
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
    public void something() {}
}