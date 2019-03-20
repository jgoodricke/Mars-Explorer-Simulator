/* 
* This file is part of Mars Explorer Simulator. Mars Explorer Simulator is 
* free software that can be redistributed and/or modified under the terms 
* of the GNU General Public License. See the licence agreement included with 
* the source code, or <https://www.gnu.org/licenses/>, for further details.
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
     * Test placing rover using input.
     */
    @Test
    public void testExecutePlace() {
        System.out.println("executeCommand");
        String result;
        String expected = "P: (3,3)";
        Input instance = new InputImpl();
        result = instance.executeCommand("PLACE " + expected);
        assertEquals(expected, result);
    }
    
    /**
     * Test moving rover using input.
     */
    @Test
    public void testExecuteMove() {
        System.out.println("executeCommand");
        String result;
        String expected = "M: (3,3) (3,4)";
        Input instance = new InputImpl();
        instance.executeCommand("PLACE 3,3");
        result = instance.executeCommand("MOVE " + expected);
        assertEquals(result, expected);
    }
    
    /**
     * Test Command with different formatting.
     */
    @Test
    public void testFormatting() {
        System.out.println("executeCommand");
        String result;
        String expected = "P:(3,3)";
        Input instance = new InputImpl();
        result = instance.executeCommand(" place 3,3 ");
        assertEquals(result, expected);
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
     * Test Command with incorrect arguments.
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

     /**
     * Test Command with incorrect arguments.
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
     * Test class to implement so input can be initialised for testing.
     */
    public class InputImpl extends Input {

        public void runSim() {
        }
    }
    
}
