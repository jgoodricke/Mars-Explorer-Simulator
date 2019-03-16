Mars Explorer Simulator(Simple Version)
===================

Description
-----------

- The application is a simulation of a mars explorer moving on a square tabletop,
  of dimensions 5 units x 5 units.
- The explorer is free to roam around the surface of the table, but must be
  prevented from falling to destruction. Any movement that would result in the
  explorer falling from the table must be prevented, however further valid
  movement commands must still be allowed.
- The explorer only can move to the sorrounding units vertically or horizontally.

Create an application that can read in commands of the following (textual) form:

    PLACE X,Y
    MOVE X,Y
    REPORT

- PLACE will put the mars explorer on the table in position X,Y.
    - The origin (0,0) can be considered to be the bottom left most corner. 
    - The first valid command to the explorer is a PLACE command, after that, any
    sequence of commands may be issued, in any order, including another PLACE
    command. The application should discard all commands in the sequence until
    a valid PLACE command has been executed.

- REPORT will announce the X,Y of the explorer, and the positions of blocks.
    - A explorer that is not on the table can choose to ignore the REPORT command.

- MOVE will find the proper path to move from the original position 
    to the target position X,Y through units along the path. Command will 
    print out the positions of path and change the postion to new destination.
    - A explorer that is not on the table can choose to ignore the MOVE command.
    - A explorer can choose to ignore the MOVE command, which is no 
        movement required. 
    - A explorer can only move nearest position vertically or horizontally. e.g. 
        A explorer with position (0,0) can only move to (0,1), (1,0) positions instead of (1,1).
    - A explorer  can choose to ignore the position which is not on the table


- Input can be from a file, or from standard input, as the developer chooses.
- Provide test data to exercise the application.
- The application must be a command line application.


Constraints
-----------

- The explorer must not fall off the table during movement. This also
  includes the initial placement of the toy explorer.
- Any move that would cause the explorer to fall must be ignored.

Example Input and Output
------------------------

### Example a

    PLACE 0,0
    REPORT

Expected output:

    P:(0,0)  

### Example b

    PLACE 0,0
    MOVE 0,1


Expected output:

    M: (0,0) (0,1)

### Example c

    PLACE 0,0
    MOVE 1,1
    REPORT

Expected output:

    M: (0,0) (0,1) (1,1)
    P: (1,1)



Deliverables
------------

Please provide your source code, and any test code/data you using in
developing your solution.

Please engineer your solution to a standard you consider suitable for
production. It is not required to provide any graphical output showing the
movement of the toy explorer.

Please do not put your name in any of the submitted code since this makes 
it harder for us to review your submission anonymously.

## Test Cases

### Test Case 1 – Accessing Manual and File Input 

Description: Checks if the user can access the file input and manual input interfaces correctly from the starting screen.

Module: main method

Test Steps:

Enter the command for manual and file input from the main screen

Expected Result: Successful access for both

Result: Successful access for both

### Test Case 2 – User Must Enter Valid Selction on Start Screen

Description: Check that the user cannot get past the main screen without entering a valid input 

Module: main method

Test Steps: 

Enter the following commands:
3

-1

1.5

Command Line Input

True

Expected Result: Unable to pass start screen.

Result: Unable to pass start screen.

### Test Case 3 – File Input – Testing Bounds and Reporting 

Description: User will enter file input mode, and submit a file that will side of the table, attempt to move off the table, and report. 

Test Data:

PLACE 3,3

MOVE 2,3

MOVE 1,3

MOVE 0,3

MOVE -1,3

REPORT

MOVE 1,3

MOVE 2,3

MOVE 3,3

MOVE 4,3

MOVE 5,3

MOVE 6,3

REPORT

MOVE 4,3

MOVE 3,3

MOVE 3,2

MOVE 3,1

MOVE 3,0

MOVE 3,-1

REPORT

MOVE 3,1

MOVE 3,2

MOVE 3,3

MOVE 3,4

MOVE 3,5

MOVE 3,6

REPORT

Test Steps: 

Copy the above data into a text file and place in the project folder. 

Start the program in file input mode

Expected Result: 

0,3

5,3

3,0

3,5

Result: 

0,3

5,3

3,0

3,5

### Test Case 4 – User Input – Testing Bounds and Reporting 

Description: This test is the same as test 3, except it is performed in CL Input mode.

Test Steps: 

Enter the following commands:

PLACE 3,3

MOVE 2,3

MOVE 1,3

MOVE 0,3

MOVE -1,3

REPORT

MOVE 1,3

MOVE 2,3

MOVE 3,3

MOVE 4,3

MOVE 5,3

MOVE 6,3

REPORT

MOVE 4,3

MOVE 3,3

MOVE 3,2

MOVE 3,1

MOVE 3,0

MOVE 3,-1

REPORT

MOVE 3,1

MOVE 3,2

MOVE 3,3

MOVE 3,4

MOVE 3,5

MOVE 3,6

REPORT

Test Steps: 

Copy the above data into a text file and place in the project folder. 

Start the program in file input mode

Expected Result: 

0,3

5,3

3,0

3,5

Result: 

0,3

5,3

3,0

3,5

### Test Case 5 – Must Place Rover First

Description: User will enter CL input mode, and enter all the available commands without placing the rover first. This will ensure users can’t give the rover commands before he is placed. 

Test Steps: 

Enter the following commands:

MOVE 0,0

REPORT

PLACE 0,0

REPORT


Expected Result: 

(No Report)

0,0

Result: 

(No Report)

0,0