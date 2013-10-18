package logic;

import rules.Grid;
import rules.RuleSet;
import ui.Output;

/**
 * @author Sami Kosonen
 * @version 0.8
 */
public class Simulator {

    private Simulation simulation;
    private RuleSet ruleSet;
    private Grid grid;
    private Grid temp;
    private StringBuilder currentNeighborhood = new StringBuilder();
    private int nhSize;
    private int nhSpan;
    private int generations;

    public Simulator(RuleSet ruleSet, Grid grid) {

        this.ruleSet = ruleSet;
        this.grid = grid;
        this.temp = grid.copyGrid();
        this.nhSize = ruleSet.getNeighborhoodSize();
        this.nhSpan = ruleSet.getNeighborhoodSize() / 2;
        this.currentNeighborhood.setLength(ruleSet.getNeighborhoodSize());
        this.generations = 100;
        simulation = new Simulation(ruleSet, grid.size(), generations);
    }

    public Simulation getSimulation() {
        return simulation;
    }

    public RuleSet getRuleSet() {
        return ruleSet;
    }

    public Grid getGrid() {
        return grid;
    }

    public Grid getTemp() {
        return temp;
    }

    public int getNhSize() {
        return nhSize;
    }

    public int getNhSpan() {
        return nhSpan;
    }

    public int getGenerations() {
        return generations;
    }

    public StringBuilder getCurrentNeighborhood() {
        return currentNeighborhood;
    }

    public void setGenerations(int generations) {
        this.generations = generations;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
        this.temp = grid.copyGrid();
    }

    public void setSimulation(Simulation simulation) {
        this.simulation = simulation;
    }

    /**
     * Run simulation using ruleSet specified for simulator. Clears any
     * previously used values so that same simulator object can be used to run
     * multiple ruleSets.
     *
     * @param print Specifies if result is printed after simulation is over.
     * @param save Specifies if simulation is saved for later use.
     * @param generations Number of generations (i.e. turns) simulation is run.
     */
    public void run(boolean print, boolean save) {
        int t = 2;

        //reset simulation settings
        simulation = new Simulation(ruleSet, grid.size(), generations);
        Output output = new Output(simulation);
        simulation.getSimulation().clear();
        grid.resetGrid();
        grid.setCell(grid.size() / 2, (byte) 1); //initial seed cell. TODO make configurable
        simulation.getSimulation().add(grid);

        System.out.println("=================");
        System.out.println("Start simulation:");
        System.out.println(ruleSet.toString());
        System.out.println("=================");
        while (t <= generations) {
            computeNextGeneration();
            simulation.getSimulation().add(grid);
            t++;
        }
        if (save) {
            System.out.println("Simulation saved: " + output.saveToFile());
        }

        if (print) {
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

    private void computeNextGeneration() {
        byte cell;

        for (int i = 0; i < grid.size(); i++) {
            determineCurrentNeighborhood(i);
            cell = (byte) ruleSet.getCellValue(currentNeighborhood.toString());
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
