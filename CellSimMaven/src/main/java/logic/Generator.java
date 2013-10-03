package logic;

/**
 * @author Sami Kosonen
 * @version 0.1
 */
import java.util.Random;

public class Generator {
    
    //placeholder method
    public String randomRuleSimple() {
        Random random = new Random();
        String randomRule = "";
        for (int i = 0; i < 8; i++) {
            randomRule += "" + random.nextInt(2);
        }
        return randomRule;
    }
}
