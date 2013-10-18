package ui;

import java.io.BufferedWriter;
import java.io.FileWriter;
import rules.Grid;
import logic.Simulation;

/**
 * This class prints simulations on console and saves them on text files
 * with name of simulation.
 * 
 * @author Sami Kosonen
 * @version 0.8
 * @param simulation Simulation that output class handless.
 */
public class Output {

    private Simulation simulation;

    public Output() {
    }

    public Output(Simulation sim) {
        this.simulation = sim;
    }

    public void setSimulation(Simulation newSim) {
        this.simulation = newSim;
    }

    /**
     * Prints simulation to console.
     */
    public void renderSimulation() {
        for (Grid g : simulation.getSimulation()) {
            renderGrid(g);
            System.out.println("");
        }
        System.out.println("");
    }

    /**
     * Private method to print one grid to console.
     * 
     * @param grid Grid to print
     */
    private void renderGrid(Grid grid) {
        for (int i : grid.getGrid()) {
            if (i == 0) {
                System.out.print(" ");
            } else {
                System.out.print("o");
            }
        }
    }

    private void writeSimulationToFile(String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            writer.write(simulation.getName());
            writer.newLine();
            writer.newLine();

            for (Grid g : simulation.getSimulation()) {

                writeGridToFile(writer, g);
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
        }
    }

    private void writeGridToFile(BufferedWriter writer, Grid g) throws Exception {
        for (byte b : g.getGrid()) {
            if (b == 0) {
                writer.write(" ");
            } else {
                writer.write("o");
            }
        }
    }
    
    /**
     * Saves simulation to txt file with name of simulation as filename.
     * 
     * @return Boolean telling if save successful or not.
     */

    public boolean saveToFile() {
        try {
            writeSimulationToFile(simulation.getName() + ".txt");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
