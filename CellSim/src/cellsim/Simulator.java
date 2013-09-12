package cellsim;

import java.util.HashMap;

public class Simulator {

    private HashMap<String, Integer> rule;
    private int turns;
    private static final String[] neighborhoods = {"111", "110", "101", "100",
        "011", "010", "001", "000"};

    public Simulator() {
        this(100);
    }

    public Simulator(int turns) {
        rule = new HashMap<String, Integer>();
        this.turns = turns;
    }

    public void setRule(String newRule) {
        for (int i = 0; i < neighborhoods.length; i++) {
            rule.put(neighborhoods[i], Integer.parseInt("" + newRule.charAt(i)));
        }
    }

    public void run(State state) {
        int turn = 1;
        String currentNeighborhood;
        state.setCell(state.size() / 2, 1);

        State temp = state.copyState();

        System.out.println("=================");
        System.out.println("Start simulation:");
        System.out.println("=================");
        while (turn <= turns) {
            for (int i = 0; i < state.size(); i++) {
                if (i == 0) {
                    currentNeighborhood = "" + state.getState()[state.size() - 1]
                            + state.getState()[i] + state.getState()[(i + 1)];
                } else if (i == state.size() - 1) {
                    currentNeighborhood = "" + state.getState()[(i - 1)]
                            + state.getState()[i] + state.getState()[0];
                } else {
                    currentNeighborhood = "" + state.getState()[(i - 1)]
                            + state.getState()[i] + state.getState()[(i + 1)];
                }
                temp.setCell(i, rule.get(currentNeighborhood));
            }
            state = temp.copyState();
            state.printState();
            turn++;
        }
    }

    private void printRule() {
        for (String s : neighborhoods) {
            System.out.println("" + rule.get(s));
        }
    }

    private boolean createNeightborhood(int size) {
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Updater test");
        State cells = new State(50);
        String rule = "00011110";

        for (String s : neighborhoods) {
            System.out.println(s);
        }

        Simulator updater = new Simulator(10);
        updater.setRule(rule);

        updater.printRule();

        //updater.run(cells);

    }
}
