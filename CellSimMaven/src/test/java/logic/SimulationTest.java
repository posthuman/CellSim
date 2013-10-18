/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import logic.Simulation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import rules.RuleSet;

/**
 *
 * @author Sami
 */
public class SimulationTest {
    
    private Simulation sim;
    
    @Before
    public void setUp() {
        sim = new Simulation(new RuleSet(1, "10010101"), 20, 20);
    }

    @Test
    public void setsNameOfSimulationCorrectly() {
        assertEquals("Rule10010101_20x20", sim.getName());
        Simulation simLarge = new Simulation(new RuleSet(2, "10010101100101011001010110010101"), 200, 1000);
        assertEquals("Rule10010101100101011001010110010101_200x1000", simLarge.getName());
    }
}