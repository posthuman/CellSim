package tests;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import rules.Grid;
import ui.Output;

public class OutputTest {

    Output output;

    @Before
    public void setUp() {
        output = new Output(new ArrayList<Grid>());
    }

    @Test
    public void hello() {
        assertEquals(true,true);
    }
}