package logic;

import logic.Generator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import rules.RuleSet;

public class GeneratorTest {

    @Before
    public void setUp() {
        Generator gn = new Generator();
    }

    @Test
    public void generatesCorrectRuleStrings() {
        RuleSet rs;
        for (int i = 0; i < 30; i++) {
            rs = Generator.generateRandomRuleSet();
            assertEquals(true, rs.isValidRule(rs.getRule()));
        }
    }
}