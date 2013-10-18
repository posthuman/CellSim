package rules;

/**
 * Wrapper class for arrays used as grid of cells.
 *
 * @author Sami Kosonen
 * @version 0.8
 * @param grid Byte[] array representing cell values.
 */
public class Grid {

    private byte[] grid;

    public Grid() {
        this(100);
    }

    public Grid(int size) {
        if (size < 1) {
            this.grid = new byte[100];
        } else {
            this.grid = new byte[size];
        }
    }

    public byte[] getGrid() {
        return grid;
    }

    public byte getCell(int i) {
        return grid[i];
    }

    public void setCell(int i, byte newValue) {
        grid[i] = newValue;
    }

    public void setGrid(byte[] grid) {
        this.grid = grid;
    }

    public int size() {
        return grid.length;
    }
    
    /**
     * Makes identocal copy of this grid.
     * 
     * @return Return copy of this grid.
     */
    public Grid copyGrid() {
        Grid copy = new Grid(grid.length);
        System.arraycopy(grid, 0, copy.getGrid(), 0, grid.length);
        return copy;
    }
    
    /**
     * Resets all grid values to 0;
     */
    public void resetGrid() {
        grid = new byte[grid.length];
    }

    @Override
    public String toString() {
        String s = "";
        for (int i : grid) {
            s += i;
        }
        return s;
    }
}
