/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marsexplorer;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jggoo
 */
public class InputTest {
    
    /**
     * Test placing rover using input
     */
    @Test
    public void testExecutePlace() {
        System.out.println("executeCommand");
        String expected = "3,3";
        Input instance = new InputImpl();
        instance.executeCommand("PLACE " + expected);
        assertEquals(instance.executeCommand("REPORT"), expected);
    }
    
    /**
     * Test moving rover using input
     */
    @Test
    public void testExecuteMove() {
        System.out.println("executeCommand");
        String expected = "3,4";
        Input instance = new InputImpl();
        instance.executeCommand("PLACE 3,3" + expected);
        instance.executeCommand("PLACE " + expected);
        assertEquals(instance.executeCommand("REPORT"), expected);
    }
    
    /**
     * Test class to implement input for testing
     */
    public class InputImpl extends Input {

        public void runSim() {
        }
    }
    
}
