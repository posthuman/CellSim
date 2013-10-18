package rules;

/**
 * @author Sami Kosonen
 * @version 0.8
 */
public class Grid {

    private byte[] grid;
    private StringBuilder gridString;

    public Grid() {
        this(100);
    }

    public Grid(int size) {
        if (size < 1){
            this.grid = new byte[100];
        }else{
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

    public Grid copyGrid() {
        Grid copy = new Grid(grid.length);
        System.arraycopy(grid, 0, copy.getGrid(), 0, grid.length);
        return copy;
    }

    public void resetGrid() {
        grid = new byte[grid.length];
    }

    @Override
    public String toString() {
        gridString = new StringBuilder("");
        String s = "";
        for (int i : grid) {
            s+=i;
        }
        return s;
    }
}
