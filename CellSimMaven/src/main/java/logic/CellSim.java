package logic;

import rules.Grid;
import rules.RuleSet;

/**
 * @author Sami Kosonen
 * @version x
 */
public class CellSim {

    public static void main(String[] args) {

        Grid grid = new Grid(500);
        RuleSet ruleSet = new RuleSet("", 1, "00000000");
        Simulator simulator = new Simulator(ruleSet, grid);
        Generator generator = new Generator();

        String rule30 = "00011110";
        simulator.setRuleSet(new RuleSet("Rule 30", 1, rule30));
        simulator.run(false, false, 200);

        String rule110 = "01101110";
        simulator.setRuleSet(new RuleSet("Rule 110", 1, rule110));
        simulator.run();

        String rule137 = "10001001";
        simulator.setRuleSet(new RuleSet("Rule 137", 1, rule137));
        simulator.run(false, false, 200);

        String rule30x4 = rule30 + rule30 + rule30 + rule30;
        simulator.setRuleSet(new RuleSet("rule30x4", 2, rule30x4));
        simulator.run(false, true, 200);

        /*String rule30plus110 = rule30 + rule30 + rule110 + rule110;
        simulator.setRuleSet(new RuleSet("rule30plus110", 2, rule30plus110));
        simulator.run();*/


        /*for (int i = 0; i < 5; i++) {

            String randomRule = generator.randomRuleSimple();
            System.out.println("");
            System.out.println("===============================");
            System.out.println("Random rule generated: " + randomRule);
            System.out.println("===============================");
            System.out.println("");
            simulator.setRuleSet(new RuleSet("", 1, randomRule));
            simulator.run();
        }*/
    }
}
