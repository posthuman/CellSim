package cellsim;

public class CellSim {

    public static void main(String[] args) {

        Grid grid = new Grid(400);
        RuleSet ruleSet = new RuleSet(1, "00000000");
        Simulator simulator = new Simulator(ruleSet, grid, 200);
        Generator generator = new Generator();

        String rule30 = "00011110";
        simulator.setRuleSet(new RuleSet(1, rule30));
        simulator.run();

        String rule110 = "01101110";
        simulator.setRuleSet(new RuleSet(1, rule110));
        simulator.run();


        for (int i = 0; i < 10; i++) {

            String randomRule = generator.randomRuleSimple();
            System.out.println("");
            System.out.println("===============================");
            System.out.println("Random rule generated: " + randomRule);
            System.out.println("===============================");
            System.out.println("");
            simulator.setRuleSet(new RuleSet(1, randomRule));
            simulator.run();
        }
    }
}
