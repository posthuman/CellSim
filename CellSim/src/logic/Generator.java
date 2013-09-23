package cellsim;

import java.util.Random;

public class Generator {

    public String randomRuleSimple() {
        Random random = new Random();
        String randomRule = "";
        for (int i = 0; i < 8; i++) {
            randomRule += "" + random.nextInt(2);
        }
        return randomRule;
    }
}
