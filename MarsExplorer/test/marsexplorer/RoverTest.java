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
* @version 1.0
* @since   2019-03-14 
*/
public class RoverTest {
    /**
     * Test rover can be placed.
     */
    @Test
    public void testPlace() {
        System.out.println("place");
        String expected = "3,3";
        Rover instance = new Rover();
        instance.place(3, 3);
        // TODO review te generated test code and remove the default call to fail.
        assertEquals(expected, instance.report());
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
     * Test the rover can move up
     */
    @Test
    public void testMove() {
        System.out.println("move up");
        String expected = "3,4";
        Rover instance = new Rover();
        instance.place(3, 3);
        instance.move(3, 4);
        assertEquals("failed moving up", expected, instance.report());
    }
    
    /**
     * Test the rover can move down
     */
    @Test
    public void testMoveDown() {
        System.out.println("move down");
        String expected = "3,2";
        Rover instance = new Rover();
        instance.place(3, 3);
        instance.move(3, 2);
        assertEquals(expected, instance.report());
    }
    
    /**
     * Test the rover can move left.
     */
    @Test
    public void testMoveLeft() {
        System.out.println("move left");
        String expected = "2,3";
        Rover instance = new Rover();
        instance.place(3, 3);
        instance.move(2, 3);
        assertEquals(expected, instance.report());
    }
    
    /**
     * Test the rover can move right
     */
    @Test
    public void testMoveRight() {
        System.out.println("move right");
        String expected = "4,3";
        Rover instance = new Rover();
        instance.place(3, 3);
        instance.move(4, 3);
        assertEquals(expected, instance.report());
    }
    
    /**
     * Test rover can only move up to adjacent squares
     */
    @Test
    public void testOnlyMoveAdjacent() {
        System.out.println("move fail");
        String expected = "3,3";
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
}
