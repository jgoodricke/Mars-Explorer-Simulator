/* 
* This file is part of Mars Explorer Simulator. Mars Explorer Simulator is 
* free software that can be redistributed and/or modified under the terms 
* of the GNU General Public License. See the licence agreement included with 
* the source code, or <https://www.gnu.org/licenses/>, for further details.
 */

package marsexplorer;

import java.util.Scanner;


/**
* The application is a simulation of a mars explorer moving on a square 
* tabletop, of dimensions 5 units x 5 units.The explorer is free to roam around
* the surface of the table, but must be cannot move off the table.
*
* @version 1.0
* @since   2019-03-14 
*/
public class MarsExplorer {

    public static void main(String[] args) {
        boolean selectionNotValid = true; //Used to determine if user has selected a valid option
        String userInput; //Stores user selection for processing
        
        Scanner sc = new Scanner(System.in);    //Used to read user input from console
        
        Input In  = new CLInput(); //Input object, set as CLInput by default
        
        //Instruct user to select command line or file input
        System.out.println("Please select from one of the following options:");
        System.out.println("1. Command line input");
        System.out.println("2. File input");
        
        //get response from user
        while(selectionNotValid){
            userInput = sc.nextLine();
            //Exit loop if selected CLInput (already set by default)
            if (userInput.equals("1")){
                selectionNotValid = false;
            }
            //Change input to FileInput and exit loop
            else if (userInput.equals("2")){
                selectionNotValid = false;
                In = new FileInput();
            }
            //Continue asking user for input until they make a valid selection
            else{
                System.out.println("Sorry, that was not a valid selection.");
            }
        }
        //Once input type selected, execute simulation.
        In.runSim();
    }
    
}
