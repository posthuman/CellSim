package ui;

import java.io.BufferedWriter;
import java.io.FileWriter;
import rules.Grid;
import logic.Simulation;

/**
 * @author Sami Kosonen
 * @version 0.8
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

    public void renderSimulation() {
        for (Grid g : simulation.getSimulation()) {
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

    public boolean saveToFile() {
        try {
            writeSimulationToFile(simulation.getName() + ".txt");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
