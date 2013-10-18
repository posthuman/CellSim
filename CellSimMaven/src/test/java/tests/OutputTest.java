package tests;


import logic.Simulation;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import ui.Output;

public class OutputTest {

    Output output;

    @Before
    public void setUp() {
        output = new Output();
    }

    @Test
    public void hello() {
        assertEquals(true,true);
    }
}