package logic;

/**
 * Generates random RuleSet's and returns them. All methods static.
 * 
 * @author Sami Kosonen
 * @version 0.5
 */
import java.util.Random;
import rules.RuleSet;

public class Generator {

    /**
     * Generates random new RuleSet and returns it. Generates with equal
     * probability RuleSet's with neighborhood span of 1 or 2. No parameters.
     *
     * @return Returns new random RuleSet that is instantiated fully.
     */
    public static RuleSet generateRandomRuleSet() {
        Random random = new Random();
        String rule;
        RuleSet randomRS;
        if (random.nextInt(2) == 0) {
            rule = randomRule(8);
            randomRS = new RuleSet(1, rule);
        } else {
            rule = randomRule(32);
            randomRS = new RuleSet(2, rule);
        }
        return randomRS;
    }

    /**
     * Helper method that generates random rule for elementary CA.
     *
     * @param length Length of generated rule.
     * @return Random string representing binary rule.
     */
    private static String randomRule(int length) {
        Random random = new Random();
        String randomRule = "";
        for (int i = 0; i < length; i++) {
            randomRule += "" + random.nextInt(2);
        }
        return randomRule;
    }
}
