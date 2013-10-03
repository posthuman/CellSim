package logic;

/**
 * @author Sami Kosonen
 * @version 0.1
 */
import java.util.Random;

public class Generator {
    
    /**
     * Placeholder method that only generates random rule for elementary CA. 
     * 
     * @return Random string of 8 bits
     */
    public String randomRuleSimple() {
        Random random = new Random();
        String randomRule = "";
        for (int i = 0; i < 8; i++) {
            randomRule += "" + random.nextInt(2);
        }
        return randomRule;
    }
}
