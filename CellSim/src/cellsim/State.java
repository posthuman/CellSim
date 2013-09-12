package cellsim;

public class State {

    private int[] state;

    public State() {
        this(100);
    }

    public State(int size) {
        this.state = new int[size];
    }

    public int[] getState() {
        return state;
    }

    public int getCell(int i) {
        return state[i];
    }

    public boolean setCell(int i, int newValue) {
        try {
            state[i] = newValue;
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public int size() {
        return state.length;
    }

    public State copyState() {
        State copy = new State(state.length);
        System.arraycopy(state, 0, copy.getState(), 0, state.length);
        return copy;
    }

    public void printState() {
        for (int i : state) {
            if (i == 0) {
                System.out.print(" ");
            } else {
                System.out.print("o");
            }
        }
        System.out.println("");
    }

    public void resetState() {
        state = new int[state.length];
    }

    @Override
    public String toString() {
        String s = "";
        for (int i : state) {
            s += "" + i;
        }
        return s;
    }
}
