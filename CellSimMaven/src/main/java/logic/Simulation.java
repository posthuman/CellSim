package logic;

import java.util.ArrayList;
import rules.Grid;
import rules.RuleSet;

/**
 * Wrapper class for one full simulation. Used by output class in forming save
 * files and printing results.
 * 
 * @author Sami
 * @version 0.8
 * @param simulation Array of generations calculated by simulator.
 * @param name Automatically generated name based on update rule.
 * @param ruleSet ruleset used to create simulation.
 */
public class Simulation {

    private ArrayList<Grid> simulation;
    private String name;
    private RuleSet ruleSet;

    public Simulation(RuleSet ruleSet, int gridSize, int generations) {
        this.simulation = new ArrayList<>();
        this.ruleSet = ruleSet;
        this.name = ruleSet.getName() + "_" + gridSize + "x" + generations;
    }

    public String getName() {
        return name;
    }

    public RuleSet getRuleSet() {
        return ruleSet;
    }

    public ArrayList<Grid> getSimulation() {
        return simulation;
    }
}
