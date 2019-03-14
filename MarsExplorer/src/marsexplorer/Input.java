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
* @author  James Goodricke
* @version 1.0
* @since   2019-03-14 
*/
public abstract class Input {
    protected String executeCommand(String input){
        //TODO: Finish This
        return null;
    }
    
    private String[] format(String input){
         //TODO: Finish This
         return null;
    }
    
    public abstract void runSim();
}
