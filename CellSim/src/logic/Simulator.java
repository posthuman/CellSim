package logic;

import rules.Grid;
import rules.RuleSet;
import ui.Output;
import java.util.ArrayList;

public class Simulator {

    private ArrayList<Grid> simulation = new ArrayList<>();
    private RuleSet ruleSet;
    private Grid grid;
    private Grid temp;
    private Output output = new Output();
    private StringBuilder currentNeighborhood = new StringBuilder();
    private int nhSize;
    private int nhSpan;
    private int turns;

    public Simulator(RuleSet ruleSet, Grid grid, int turns) {
        this.ruleSet = ruleSet;
        this.grid = grid;
        this.temp = grid.copyGrid();
        this.turns = turns;
        this.nhSize = ruleSet.getNeighborhoodSize();
        this.nhSpan = ruleSet.getNeighborhoodSize() / 2;
        this.currentNeighborhood.setLength(ruleSet.getNeighborhoodSize());
    }

    public void run() {
        run(false, true);
    }

    public void run(boolean p, boolean s) {
        int t = 1;
        simulation.clear();

        //reset simulation settings
        simulation.clear();
        grid.resetGrid();
        grid.setCell(grid.size() / 2, 1); //initial seed cell. TODO make configurable

        System.out.println("=================");
        System.out.println("Start simulation:");
        System.out.println(ruleSet);
        System.out.println("=================");
        while (t <= turns) {
            computeNextGeneration();
            simulation.add(grid);
            t++;
        }
        if (s) {
            System.out.println("Simulation saved: " + output.saveToFile());
        }

        if (p) {
            output.setSimulation(simulation);
            output.renderSimulation();
        }
    }

    public void setRuleSet(RuleSet newRuleSet) {
        ruleSet = newRuleSet;
        nhSize = ruleSet.getNeighborhoodSize();
        nhSpan = ruleSet.getNeighborhoodSize() / 2;
        currentNeighborhood.setLength(ruleSet.getNeighborhoodSize());
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
                currentNeighborhood.append(grid.getGrid()[i - j]);
            }
        } else if (i < nhSpan) {
            for (int j = nhSpan; j > 0; j--) {
                currentNeighborhood.append(grid.getGrid()[grid.size() - j - 1]);
            }
            for (int j = 0; j <= nhSpan; j++) {
                currentNeighborhood.append(grid.getGrid()[j]);
            }
        } else {
            for (int j = nhSpan - 1; j > -1 * nhSpan; j--) {
                currentNeighborhood.append(grid.getGrid()[i - j - 1]);
            }
            for (int j = 0; j < 2; j++) {
                currentNeighborhood.append(grid.getGrid()[j]);
            }
        }
    }
}
