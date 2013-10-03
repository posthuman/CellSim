package logic;

import rules.Grid;
import rules.RuleSet;
import ui.Output;
import java.util.ArrayList;

/**
 * @author Sami Kosonen
 * @version 0.3
 */
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

    public Simulator(RuleSet ruleSet, Grid grid) {
        this.ruleSet = ruleSet;
        this.grid = grid;
        this.temp = grid.copyGrid();
        this.nhSize = ruleSet.getNeighborhoodSize();
        this.nhSpan = ruleSet.getNeighborhoodSize() / 2;
        this.currentNeighborhood.setLength(ruleSet.getNeighborhoodSize());
    }

    public ArrayList<Grid> getSimulation() {
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

    public int getTurns() {
        return turns;
    }

    public StringBuilder getCurrentNeighborhood() {
        return currentNeighborhood;
    }

    public void run() {
        run(false, true, 100);
    }

    
/**
 * Run simulation using ruleSet specified for simulator. Clears any previously used 
 * values so that same simulator object can be used to run multiple ruleSets.
 *
 * @param   print   Specifies if result is printed after simulation is over.
 * @param   save    Specifies if simulation is saved for later use.
 * @param   turns   Number of turns simulation is run.
 */
    
    public void run(boolean print, boolean save, int turns) {
        int t = 1;

        //reset simulation settings
        this.turns = turns;
        simulation.clear();
        grid.resetGrid();
        grid.setCell(grid.size() / 2, 1); //initial seed cell. TODO make configurable
        simulation.add(grid);
        
        System.out.println("=================");
        System.out.println("Start simulation:");
        System.out.println(ruleSet);
        System.out.println("=================");
        while (t <= turns) {
            computeNextGeneration();
            simulation.add(grid);
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
