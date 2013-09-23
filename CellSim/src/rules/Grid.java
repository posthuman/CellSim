package rules;

public class Grid {

    private int[] grid;

    public Grid() {
        this(100);
    }

    public Grid(int size) {
        this.grid = new int[size];
    }

    public int[] getGrid() {
        return grid;
    }

    public int getCell(int i) {
        return grid[i];
    }

    public boolean setCell(int i, int newValue) {
        try {
            grid[i] = newValue;
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public int size() {
        return grid.length;
    }

    public Grid copyGrid() {
        Grid copy = new Grid(grid.length);
        System.arraycopy(grid, 0, copy.getGrid(), 0, grid.length);
        return copy;
    }

    public void resetGrid() {
        grid = new int[grid.length];
    }

    @Override
    public String toString() {
        String s = "";
        for (int i : grid) {
            s += "" + i;
        }
        return s;
    }
}
