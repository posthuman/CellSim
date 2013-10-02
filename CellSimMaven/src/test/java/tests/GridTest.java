package tests;

import java.util.Random;
import rules.Grid;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GridTest {

    Grid grid;
    Random random = new Random();

    @Before
    public void setUp() {
        grid = new Grid(60);
    }

    @Test
    public void constructorInitializesGridCorrectly() {
        assertEquals("000000000000000000000000000000"
                + "000000000000000000000000000000", grid.toString());
    }

    @Test
    public void constructorWorksForDefaultGrid() {
        Grid gridDefault = new Grid();
        assertEquals(100, gridDefault.size());
    }

    @Test
    public void constructorDoesntAcceptZeroOrLessValues() {
        Grid gridZero = new Grid(0);
        assertEquals(100, gridZero.size());
        gridZero = new Grid(-1);
        assertEquals(100, gridZero.size());
    }

    @Test
    public void setsCellValueCorrectly() {
        grid.setCell(25, 1);
        assertEquals(1, grid.getCell(25));
    }

    @Test
    public void returnsSizeCorrectly() {
        assertEquals(60, grid.size());
    }

    @Test
    public void copiesStateCorrectly() {
        for (int i = 0; i < grid.size();) {
            grid.setCell(i, 1);
            i += random.nextInt(9);
        }
        Grid copy = grid.copyGrid();
        assertEquals(grid.toString(), copy.toString());
    }

    @Test
    public void resetsStateCorrectly() {
        for (int i = 0; i < grid.size();) {
            grid.setCell(i, 1);
            i += random.nextInt(9);
        }
        grid.resetGrid();
        assertEquals("000000000000000000000000000000"
                + "000000000000000000000000000000", grid.toString());
    }

    @Test
    public void toStringWorksCorrectly() {
        for (int i = 0; i < grid.size();) {
            grid.setCell(i, 1);
            i += 4;
        }
        assertEquals("100010001000100010001000100010"
                + "001000100010001000100010001000", grid.toString());
    }
}