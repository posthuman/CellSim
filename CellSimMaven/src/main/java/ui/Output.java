package ui;

import rules.Grid;
import java.util.ArrayList;

/**
 * @author Sami Kosonen
 * @version 0.3
 */
public class Output {

    private ArrayList<Grid> simulation;

    public Output() {
        simulation = new ArrayList<>();
    }

    public Output(ArrayList<Grid> sim) {
        this.simulation = sim;
    }

    public void setSimulation(ArrayList<Grid> newSimulation) {
        simulation = newSimulation;
    }

    public void renderSimulation() {
        for (Grid g : simulation) {
            renderGrid(g);
            System.out.println("");
        }
        System.out.println("");
    }

    private void renderGrid(Grid grid) {
        for (int i : grid.getGrid()) {
            if (i == 0) {
                System.out.print(" ");
            } else {
                System.out.print("o");
            }
        }
    }

    public boolean saveToFile() {
        //TODO
        return false;
    }
}
