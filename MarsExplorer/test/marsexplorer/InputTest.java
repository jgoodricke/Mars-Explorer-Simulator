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
* Tests for the input class. Tests placing, moving and formatting commands.
*
* @version 1.0
* @since   2019-03-14 
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
        instance.executeCommand("PLACE 3,3");
        instance.executeCommand("MOVE " + expected);
        assertEquals(instance.executeCommand("REPORT"), expected);
    }
    
    /**
     * Test Incorrect Command
     */
    @Test
    public void testIncorrectCommand() {
        System.out.println("executeCommand");
        String expected = "3,3";
        Input instance = new InputImpl();
        instance.executeCommand("PLACE " + expected);
        instance.executeCommand("EXPLODE");
        assertEquals(expected, instance.executeCommand("REPORT"));
    }

    /**
     * Test Command with different formatting
     */
    @Test
    public void testFormatting() {
        System.out.println("executeCommand");
        String expected = "3,3";
        Input instance = new InputImpl();
        instance.executeCommand(" place 3,3 ");
        assertEquals(instance.executeCommand("REPORT"), expected);
    }

    /**
     * Test Command with incorrect arguments
     */
    @Test
    public void testIncorrectArguments() {
        System.out.println("executeCommand");
        String expected = "3,3";
        Input instance = new InputImpl();
        instance.executeCommand("PLACE " + expected);
        instance.executeCommand("MOVE three,four");
        assertEquals(instance.executeCommand("REPORT"), expected);
    }
    //Too many arguments
     /**
     * Test Command with incorrect arguments
     */
    @Test
    public void testTooManyArguments() {
        System.out.println("executeCommand");
        String expected = "3,3";
        Input instance = new InputImpl();
        instance.executeCommand("PLACE " + expected);
        instance.executeCommand("MOVE 3,3,3");
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
