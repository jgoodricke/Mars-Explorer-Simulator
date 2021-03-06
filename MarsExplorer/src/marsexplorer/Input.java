/* 
* This file is part of Mars Explorer Simulator. Mars Explorer Simulator is 
* free software that can be redistributed and/or modified under the terms 
* of the GNU General Public License. See the licence agreement included with 
* the source code, or <https://www.gnu.org/licenses/>, for further details.
 */

package marsexplorer;

/**
* Interprets input and passes them as commands to a Rover object. 
* Abstract parent class of CLInput and FileInput.
*
* @version 1.0
* @since   2019-03-14 
*/
public abstract class Input {
    private Rover r = new Rover();
    
    //Method for interpreting input Commands and sending them to Rover
    protected String executeCommand(String input){

        //Strip spaces and change case of input
        input =  input.trim();
        input = input.toUpperCase();
        
        //Check report first, as it has no arguments
        if(input.equals("REPORT")){
            return r.report();
        }
        
        //If not report, begin processing input to get command and arguments
        else{
            return moveAndPlace(input);
            //If not reporting, return empty string
        }

    }
    
    //Processes and executes the move and place commands
    private String moveAndPlace(String input) {
        String command; //Holds the input command (MOVE, or PLACE)
        String[] arguments; //Holds x and y position arguments
        boolean argsCorrect = true; //Used in check if arguments are int
        
        int x = -1; //x position argument
        int y = -1; //y position argument
        
        String[] inputSplit; //Temporarily holds input for procesing

        //Split input into command and arguments and check it has two parts
        inputSplit = input.split(" ");
        if (inputSplit.length == 2) {
            
            //Extract command and arguments
            command = inputSplit[0];
            arguments = inputSplit[1].split(",");
            argsCorrect = true;

            //Check number of arguments and if they are integers
            if (arguments.length == 2) {
                try {
                    x = Integer.parseInt(arguments[0]);
                    y = Integer.parseInt(arguments[1]);
                } catch (Exception e) {
                    argsCorrect = false;
                }
            }
            else{
                argsCorrect = false;
            }

            //If arguments are integers, process command
            if (argsCorrect) {
                //Move
                if (command.equals("MOVE")) {
                    String result = r.move(x, y);
                    return result;
                } //Place
                else if (command.equals("PLACE")) {
                    String result = r.place(x, y);
                    return result;
                }
            }
        }
        //If unable to move or place, return empty string.
        return "";
    }
    
    //Main loop of simulation, getting multiple commands from user or file.
    public abstract void runSim();
}
