package tests;

import logic.Simulator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import rules.Grid;
import rules.RuleSet;

public class SimulatorTest {

    Simulator sim;

    @Before
    public void setUp() {
        sim = new Simulator(new RuleSet("Rule30", 1, "00011110"), new Grid(50));
    }

    @Test
    public void initializesSimulatorValuesCorrectly() {
        assertEquals(0, sim.getTurns());
        assertEquals(3, sim.getNhSize());
        assertEquals(1, sim.getNhSpan());
        assertEquals(3, sim.getCurrentNeighborhood().length());
        assertEquals(50, sim.getGrid().size());
    }

    @Test
    public void updatesRuleSetCorrectly() {
        sim.setRuleSet(new RuleSet("randomrule", 1, "00110001"));
        assertEquals(3, sim.getRuleSet().getNeighborhoodSize());
        assertEquals("randomrule", sim.getRuleSet().getName());
    }

    @Test
    public void runsSimulationCorrectly() {
        sim.run(true, true, 20);
        String s = "";
        for (Grid g : sim.getSimulation()) {
            s += g.toString();
        }
        assertEquals(
                  "00000000000000000000000001000000000000000000000000"
                + "00000000000000000000000011100000000000000000000000"
                + "00000000000000000000000110010000000000000000000000"
                + "00000000000000000000001101111000000000000000000000"
                + "00000000000000000000011001000100000000000000000000"
                + "00000000000000000000110111101110000000000000000000"
                + "00000000000000000001100100001001000000000000000000"
                + "00000000000000000011011110011111100000000000000000"
                + "00000000000000000110010001110000010000000000000000"
                + "00000000000000001101111011001000111000000000000000"
                + "00000000000000011001000010111101100100000000000000"
                + "00000000000000110111100110100001011110000000000000"
                + "00000000000001100100011100110011010001000000000000"
                + "00000000000011011110110011101110011011100000000000"
                + "00000000000110010000101110001001110010010000000000"
                + "00000000001101111001101001011111001111111000000000"
                + "00000000011001000111001111010000111000000100000000"
                + "00000000110111101100111000011001100100001110000000"
                + "00000001100100001011100100110111011110011001000000"
                + "00000011011110011010011111100100010001110111100000"
                + "00000110010001110011110000011110111011000100010000", s);
    }
    //@Test
    //public void test(){}
    //@Test
    //public void test(){}
    //@Test
    //public void test(){}
}