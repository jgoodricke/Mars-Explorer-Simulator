/* 
* This file is part of Mars Explorer Simulator. Mars Explorer Simulator is 
* free software that can be redistributed and/or modified under the terms 
* of the GNU General Public License. See the licence agreement included with 
* the source code, or <https://www.gnu.org/licenses/>, for further details.
 */

package marsexplorer;

import java.util.Scanner;
import java.io.BufferedReader; 
import java.io.FileReader;
import java.io.File;


/**
* Reads input commands from the command line to given to a rover object. 
* Inherits most of its methods from the Input class.
*
* @author  James Goodricke
* @version 1.0
* @since   2019-03-14 
*/
public class FileInput extends Input {
    public void runSim(){
        
        //Objects for reading user input and file input
        Scanner sc = new Scanner(System.in);
        BufferedReader br;
        File file;
        String filepath;
        
        //Stores input from file and output from rover
        String input = ""; 
        String output = "";
        boolean moreFile = true;
        
        //Give instructions about where to place file before continuing.
        System.out.println ("Please specify the path to your input file:");
        filepath = sc.nextLine();
        
        //Strip double quotes from start and end of filepath
        filepath = filepath.replaceAll("^\"|\"$", "");
        
        //Attempt to access file. If unable to access file, terminate program.
        try{
           file = new File(filepath);
           br = new BufferedReader(new FileReader(file));
        }
        catch(Exception  e){
            System.out.println("Error: File not found.");
            return;
        }      
        
        //Contunue reading file until no lines left
        do {
            //Attempt to read file. If unable to, report error and terminate program
            try{
                input = br.readLine();
            }
            catch(Exception E){
                System.out.println("Error: Unable to read next line in file.");
                break;
            }
            //Print input from file, execute input and print relevant output
            if(input != null){
                System.out.println(input);
                output = executeCommand(input);
                if(output != ""){
                    System.out.println(output);
                }
            }
        } while (input != null);
        
        //Pause program before terminating
        System.out.println ("Press Enter key to continue.");
        sc.nextLine();
    }
}