package tests;

import cellsim.State;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StateTest {

    State state;

    @Before
    public void setUp() {
        state = new State(60);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void constructorInitializesStateCorrectly() {
        assertEquals("000000000000000000000000000000"
                + "000000000000000000000000000000", state.toString());
    }

    @Test
    public void setCellValue() {
        state.setCell(25, 1);
        assertEquals(1, state.getCell(25));
    }

    @Test
    public void returnsSizeCorrectly() {
        assertEquals(60, state.size());
    }

    @Test
    public void copiesStateCorrectly() {
        for (int i = 0; i < state.size();) {
            state.setCell(i, 1);
            i += 4;
        }
        State copy = state.copyState();
        assertEquals(state.toString(), copy.toString());
    }

    @Test
    public void resetsStateCorrectly() {
        for (int i = 0; i < state.size();) {
            state.setCell(i, 1);
            i += 4;
        }
        state.resetState();
        assertEquals("000000000000000000000000000000"
                + "000000000000000000000000000000", state.toString());
        
    }
}