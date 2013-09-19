package cellsim;

public class Simulator {

    private RuleSet ruleSet;
    private Grid grid;
    private Grid temp;
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
        int nSize = ruleSet.getNeighborhoodSize();
        int nSpan = ruleSet.getNeighborhoodSize() / 2;
        StringBuilder currentNeighborhood = new StringBuilder(nSize);

        int cell;

        for (int i = 0; i < grid.size(); i++) {
            currentNeighborhood.delete(0, nSize);

            if (i > nSpan - 1 && i < grid.size() - nSpan) {
                for (int j = nSpan; j >= -1*nSpan; j--) {
                    currentNeighborhood.append(grid.getCell()[i - j]);
                }
            } else if (i < nSpan) {
                for (int j = nSpan; j > 0; j--) {
                    currentNeighborhood.append(grid.getCell()[grid.size() - j - 1]);
                }
                for (int j = 0; j <= nSpan; j++) {
                    currentNeighborhood.append(grid.getCell()[j]);
                }
            } else {
                for (int j = nSpan - 1; j > -1*nSpan; j--) {
                    currentNeighborhood.append(grid.getCell()[i - j - 1]);
                }
                for (int j = 0; j < 2; j++) {
                    currentNeighborhood.append(grid.getCell()[j]);
                }
            }
            cell = ruleSet.getCellValue(currentNeighborhood.toString());
            temp.setCell(i, cell);
        }
        this.grid = temp.copyGrid();
    }
}
