package tests;

import rules.Grid;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GridTest {

    Grid grid;

    @Before
    public void setUp() {
        grid = new Grid(60);
    }

    @Test
    public void constructorInitializesStateCorrectly() {
        assertEquals("000000000000000000000000000000"
                + "000000000000000000000000000000", grid.toString());
    }

    @Test
    public void setCellValue() {
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
            i += 4;
        }
        Grid copy = grid.copyGrid();
        assertEquals(grid.toString(), copy.toString());
    }

    @Test
    public void resetsStateCorrectly() {
        for (int i = 0; i < grid.size();) {
            grid.setCell(i, 1);
            i += 4;
        }
        grid.resetGrid();
        assertEquals("000000000000000000000000000000"
                + "000000000000000000000000000000", grid.toString());
    }

    /*@Test
    public void printsStateCorrectly() {
        for (int i = 0; i < grid.size();) {
            grid.setCell(i, 1);
            i += 4;
        }
    }*/

    @Test
    public void toStringWorksCorrectly() {
        assertEquals("000000000000000000000000000000"
                + "000000000000000000000000000000", grid.toString());
    }
}