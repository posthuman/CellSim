package cellsim;

public class Simulator {

    private RuleSet ruleSet;
    private Grid grid;
    private Grid temp;
    private StringBuilder currentNeighborhood = new StringBuilder();
    private int nhSize;
    private int nhSpan;
    private int turns;

    public Simulator(RuleSet ruleSet, Grid grid, int turns) {
        this.ruleSet = ruleSet;
        this.grid = grid;
        this.temp = grid.copyGrid();
        this.turns = turns;
    }

    public void run() {
        int t = 1;
        Output output = new Output();
        grid.resetGrid();
        grid.setCell(grid.size() / 2, 1);
        nhSize = ruleSet.getNeighborhoodSize();
        nhSpan = ruleSet.getNeighborhoodSize() / 2;
        currentNeighborhood.setLength(ruleSet.getNeighborhoodSize());

        System.out.println("=================");
        System.out.println("Start simulation:");
        System.out.println(ruleSet);
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
        int cell;

        for (int i = 0; i < grid.size(); i++) {
            determineCurrentNeighborhood(i);
            cell = ruleSet.getCellValue(currentNeighborhood.toString());
            temp.setCell(i, cell);
        }
        this.grid = temp.copyGrid();
    }

    private void determineCurrentNeighborhood(int i) {
        currentNeighborhood.delete(0, nhSize);

        if (i > nhSpan - 1 && i < grid.size() - nhSpan) {
            for (int j = nhSpan; j >= -1 * nhSpan; j--) {
                currentNeighborhood.append(grid.getCell()[i - j]);
            }
        } else if (i < nhSpan) {
            for (int j = nhSpan; j > 0; j--) {
                currentNeighborhood.append(grid.getCell()[grid.size() - j - 1]);
            }
            for (int j = 0; j <= nhSpan; j++) {
                currentNeighborhood.append(grid.getCell()[j]);
            }
        } else {
            for (int j = nhSpan - 1; j > -1 * nhSpan; j--) {
                currentNeighborhood.append(grid.getCell()[i - j - 1]);
            }
            for (int j = 0; j < 2; j++) {
                currentNeighborhood.append(grid.getCell()[j]);
            }
        }
    }
}
