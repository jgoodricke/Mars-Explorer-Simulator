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
* Tests for the rover class. Tests movement and placing.
*
* @author  James Goodricke
* @version 1.0
* @since   2019-03-14 
*/
public class RoverTest {
    /**
     * Test rover can be placed.
     */
    @Test
    public void testPlace() {
        String output;
        System.out.println("place");
        String expected = "P: (3,3)";
        Rover instance = new Rover();
        output = instance.place(3, 3);
        // TODO review te generated test code and remove the default call to fail.
        assertEquals(expected, output);
    }
    
    /**
     * Test rover can't be placed off top of table
     */
    @Test
    public void testPlaceOut() {
        System.out.println("place out of bounds (up)");
        String expected = "";
        Rover instance = new Rover();
        
        //Test Top Side
        instance.place(3, 6);
        assertEquals("Failed on top side (first try)", expected, instance.report());
        
        //Test Bottom Side
        instance.place(3, -1);
        assertEquals("Failed on bottom side", expected, instance.report());
       
        //Test Left Side
        instance.place(-1, 3);
        assertEquals("Failed on left side", expected, instance.report());
        
        //Test Right Side
        instance.place(6, 3);
        assertEquals("Failed on right side", expected, instance.report());   
    }
    
    /**
     * Test rover can report
     */
    @Test
    public void testReport() {
        String output;
        System.out.println("place");
        String expected = "P: (3,3)";
        Rover instance = new Rover();
        instance.place(3, 3);
        output = instance.report();
        // TODO review te generated test code and remove the default call to fail.
        assertEquals(expected, output);
    }

    /**
     * Test the rover can move up
     */
    @Test
    public void testMoveUp() {
        String output;
        System.out.println("move up");
        String expected = "M: (3,3) (3,4)";
        Rover instance = new Rover();
        instance.place(3, 3);
        output = instance.move(3, 4);
        assertEquals("failed moving up", expected, output);
    }
    
    /**
     * Test the rover can move down
     */
    @Test
    public void testMoveDown() {        
        String output;
        System.out.println("move up");
        String expected = "M: (3,3) (3,2)";
        Rover instance = new Rover();
        instance.place(3, 3);
        output = instance.move(3, 2);
        assertEquals("failed moving up", expected, output);
    }
    
    /**
     * Test the rover can move left.
     */
    @Test
    public void testMoveLeft() {
        String output;
        System.out.println("move up");
        String expected = "M: (3,3) (2,3)";
        Rover instance = new Rover();
        instance.place(3, 3);
        output = instance.move(2, 3);
        assertEquals("failed moving up", expected, output);
    }
    
    /**
     * Test the rover can move right
     */
    @Test
    public void testMoveRight() {
        String output;
        System.out.println("move up");
        String expected = "M: (3,3) (4,3)";
        Rover instance = new Rover();
        instance.place(3, 3);
        output = instance.move(4, 3);
        assertEquals("failed moving up", expected, output);
    }
    
    /**
     * Test rover can only move up to adjacent squares
     */
    @Test
    public void testOnlyMoveAdjacent() {
        System.out.println("move fail");
        String expected = "P: (3,3)";
        Rover instance = new Rover();
        instance.place(3, 3);
        instance.move(3, 5);
        assertEquals("Failed moving Up (first try)", expected, instance.report());
        instance.move(3, 0);
        assertEquals("Failed moving down", expected, instance.report());
        instance.move(0, 3);
        assertEquals("Failed moving left", expected, instance.report());
        instance.move(5, 3);
        assertEquals("Failed moving right", expected, instance.report());
    }
    
    /**
     * Test rover can't move before being placed
     */
    @Test
    public void testMoveBeforePlace() {
        System.out.println("move before fail");
        String expected = "";
        Rover instance = new Rover();
        instance.move(3, 3);
        assertEquals(expected, instance.report());
    }
    
    /**
     * Test the rover to a space where the x and y coordinates are the same
     */
    @Test
    public void testMoveToSame() {
        System.out.println("move up");
        String expected = "P: (2,2)";
        Rover instance = new Rover();
        instance.place(3, 2);
        instance.move(2, 2);
        assertEquals("failed moving up", expected, instance.report());
    }
}
