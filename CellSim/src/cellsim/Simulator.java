package cellsim;

public class Simulator {

    private RuleSet ruleSet;
    private Grid grid;
    private int turns;

    public Simulator(RuleSet ruleSet, Grid grid, int turns) {
        this.ruleSet = ruleSet;
        this.grid = grid;
        this.turns = turns;
    }

    public void run() {
        int t = 1;
        Output output = new Output();
        grid.resetGrid();
        grid.setCell(grid.size() / 2, 1);

        System.out.println("=================");
        System.out.println("Start simulation:");
        System.out.println("=================");
        while (t <= turns) {
            computeNextGeneration();
            output.printGrid(grid);
            t++;
        }
    }

    public void setRuleSet(RuleSet newRuleSet) {
        this.ruleSet = newRuleSet;
    }

    public void computeNextGeneration() {
        StringBuilder currentNeighborhood = new StringBuilder("000");
        Grid temp = grid.copyGrid();

        for (int i = 0; i < grid.size(); i++) {
            currentNeighborhood.delete(0, 3);
            if (i > 0 && i < grid.size() - 1) {
                currentNeighborhood.append(grid.getCell()[i - 1]);
                currentNeighborhood.append(grid.getCell()[i]);
                currentNeighborhood.append(grid.getCell()[i + 1]);
            } else if (i == 0) {
                currentNeighborhood.append(grid.getCell()[grid.size() - 1]);
                currentNeighborhood.append(grid.getCell()[i]);
                currentNeighborhood.append(grid.getCell()[i + 1]);
            } else {
                currentNeighborhood.append(grid.getCell()[i - 1]);
                currentNeighborhood.append(grid.getCell()[i]);
                currentNeighborhood.append(grid.getCell()[0]);
            }
            temp.setCell(i, ruleSet.getUpdateRules().get(currentNeighborhood.toString()));
        }
        this.grid = temp.copyGrid();
    }
}
