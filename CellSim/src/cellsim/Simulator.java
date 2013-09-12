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
        int t = 1;
        state.setCell(state.size() / 2, 1);

        System.out.println("=================");
        System.out.println("Start simulation:");
        System.out.println("=================");
        while (t <= turns) {
            state = computeStep(state);
            state.printState();
            t++;
        }
    }

    public State computeStep(State state) {
        String currentNeighborhood;
        State temp = state.copyState();

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
        return state;
    }

    private boolean createNeightborhood(int size) {
        return false;
    }
}
