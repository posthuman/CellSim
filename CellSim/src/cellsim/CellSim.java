package cellsim;

public class CellSim {

    public static void main(String[] args) {
        
        State cells = new State(500);

        Simulator simulator = new Simulator(200);
        String rule30 = "00011110";
        simulator.setRule(rule30);
        simulator.run(cells);
        
        cells.resetState();
        String rule110 = "01101110";
        simulator.setRule(rule110);
        simulator.run(cells);
        
        /*
        cells.resetState();
        String randomRule = randomRule();
        updater.setRule(randomRule);
        updater.run(cells);*/
    }

    private static String randomRule() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
