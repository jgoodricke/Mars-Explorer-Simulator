/* 
* This file is part of Mars Explorer Simulator. Mars Explorer Simulator is 
* free software that can be redistributed and/or modified under the terms 
* of the GNU General Public License. See the licence agreement included with 
* the source code, or <https://www.gnu.org/licenses/>, for further details.
 */

package marsexplorer;

/**
* Representation of the mars rover. Knows its own position on the table, and 
* can move to adjacent spaces and report its position.
*
* @author  James Goodricke
* @version 1.0
* @since   2019-03-14 
*/
public class Rover {
    //Position on grid
    private int posX;
    private int posY;
    
    //Grid maximum and minimun size
    private int maxX;
    private int maxY;
    private int minX;
    private int minY;
    
    public void place(int x, int y){
        if(inBounds(x, y)){
            posX = x;
            posY = y;
        }
    }
    
    private boolean inBounds(int x, int y){
        if(x <= maxX && x >= minX && y <= maxY && y >= minY ){
            return true;
        }
        return false;
    }
    
    public void move(int x, int y){
        //Check movement position is on the same row or collumn as current position (but not both)
        if((x == posX || y == posY) && !(x == posX && y == posY)){
            
            //Check movement position is adjacent to current position
            if((x == posX - 1 || x == posX + 1) || (y == posY - 1 || y == posY + 1)){
                
                //Check position to move to is on the table
                if(inBounds(x, y)){
                    posX = x;
                    posY = y;
                }
            }
        }
    }
    
    public String report(){
        if(posX != -1 && posY != -1){
            return Integer.toString(posX) + "," + Integer.toString(posY);
        }
        return "";
    }
    
    public Rover(){
        posX = -1;
        posY = -1;
    
        maxX = 5;
        maxY = 5;
        minX = 0;
        minY = 0;
    }
}
