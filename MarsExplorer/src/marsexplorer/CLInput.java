/* 
* This file is part of Mars Explorer Simulator. Mars Explorer Simulator is 
* free software that can be redistributed and/or modified under the terms 
* of the GNU General Public License. See the licence agreement included with 
* the source code, or <https://www.gnu.org/licenses/>, for further details.
 */

package marsexplorer;

import java.util.Scanner;

/**
* Reads input commands from a file to be given to a rover object. Inherits most
* of its methods from the Input class.
*
* @author  James Goodricke
* @version 1.0
* @since   2019-03-14 
*/
public class CLInput extends Input {
    public void runSim(){
        Scanner sc = new Scanner(System.in); //Used to read user input from console        

        //Stores console input and output
        String input = "";
        String output = "";
        
        //Print list of commands to user
        System.out.println("Here are the commands you can enter:");
        System.out.println("PLACE X,Y - Places the rover on the grid (e.g. PLACE 3,3).");
        System.out.println("MOVE X,Y - Moves the rover to an adjacent space (e.g. MOVE 3,4).");
        System.out.println("REPORT - Tells you where rover is on the table.");
        System.out.println("QUIT - Exit program.");
        
        //Get input from user and print output until user quits
        while(!input.equals("QUIT")){
           input = sc.nextLine();
           output = executeCommand(input);
           if (! output.equals("")){
               System.out.println(output);
           }
        }
    }
}
