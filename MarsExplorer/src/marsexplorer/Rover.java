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
 * @version 1.0
 * @since 2019-03-14
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

    //Places the rover on the table
    public String place(int x, int y) {
        if (inBounds(x, y)) {
            posX = x;
            posY = y;

            //Output Results
            String xStr = Integer.toString(posX);
            String yStr = Integer.toString(posY);

            return "P: (" + xStr + "," + yStr + ")";
        }
        return "";
    }

    //Checks if a space is within the bounds of the table
    private boolean inBounds(int x, int y) {
        if (x <= maxX && x >= minX && y <= maxY && y >= minY) {
            return true;
        }
        return false;
    }

    //Moves the rover to an adjacent space
    public String move(int x, int y) {
        //Check movement position is on the same row or collumn as current position (but not both)
        if ((x == posX || y == posY) && !(x == posX && y == posY)) {

            //Check movement position is adjacent to current position
            if ((x == posX - 1 || x == posX + 1) || (y == posY - 1 || y == posY + 1)) {

                //Check position to move to is on the table
                if (inBounds(x, y)) {
                    String oldXStr = Integer.toString(posX);
                    String oldYStr = Integer.toString(posY);

                    String newXStr = Integer.toString(x);
                    String newYStr = Integer.toString(y);

                    posX = x;
                    posY = y;
                    return "M: (" + oldXStr + "," + oldYStr + ") (" + newXStr + "," + newYStr + ")";
                }
            }
        }
        return "";
    }

    //Report the rovers current position
    public String report() {
        //If rover has already been placed, report results
        if (posX != -1 && posY != -1) {

            String xStr = Integer.toString(posX);
            String yStr = Integer.toString(posY);

            return "P: (" + xStr + "," + yStr + ")";
        }
        //Return blank string if rover hasn't been placed
        return "";
    }

    public Rover() {
        posX = -1;
        posY = -1;

        maxX = 4;
        maxY = 4;
        minX = 0;
        minY = 0;
    }
}
