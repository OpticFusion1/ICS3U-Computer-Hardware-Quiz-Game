/*
    Name: Uroosa Imtiaz
    Teacher: Ms. Kresteva
    Date: Thursday, December 20, 2018
    Description: This program was created for use by the TDSB in order to teach students about computer hardware and allow students to test their knowledge.
    The first screen is an animation that will introduce the program to the user. Select '1' in the Main Menu to access instructions. Select '2' in the Main
    Menu to learn about computer hrdware and prepare for the quiz. Select '3', '4', or '5' in the Main Menu to enter the quiz depending on the difficulty.
    Select '6' in the Main Menu to access the scoreboard, and to clear the scoreboard. Select '7' in the Main Menu to automatically close the program. The
    difficulty of quizzes changes according to the number of tries a user gets to select the right answer. The intructions explain how to use the program
    through the Main Menu. The teaching portion consists of all nformation about basic computer hardware including images and acornyms which are tested in the quiz.
    The quiz is divided into two sections: section 1 tests the user's spelling knowledge and section 2 tests the user's ability to identify computer hardware
    by picture or functionality. The scores are automatically stored into a file which is read to show top scores. The questions are read from a text file that
    stores the question bank. The questions and options are fully randomized using java's Math.random command. Each question is multiple choice with 4 options.
    Each quiz consists of 10 non-repeating questions. The scoreboard consists of the top ten scores with the accompanying name and level. The goodbye screen
    contains programmer information as well as closes the open java console.


    Global Variable Dictionary

    Name            Type                    Description

    choice          int                     This variable is used to select options in the main menu.
					    Accepted values: 1 - 7
    right           int                     This variable counts the number of correct answers to the quiz.
					    Accepted values: 0 - 10
    wrong           int                     This variable counts the number of incorrect answers to the quiz.
					    Accepted values: 0 - 10
    length          int                     This variable counts the number of lines in a file that are not null.
					    Accepted values: 0 - length of file
    Line            String                  This variable temporarily stores the current line of a file so the program can check if it is null.
					    Accepted values: null or line in file
    defaultText     Font                    This variable stores the font used mainly for the title and pauseProgram messages.
					    Accepted values: values do not change
    smallText       Font                    This variable stores the font used mainly for the instructions and teaching portion.
					    Accepted values: values do not change
    picture         BufferedImage           This variable stores pictures for display.
					    Accepted values: name of appropriate image for display
    input           BufferedReader          This variable is used to read from files.
					    Accepted values: name of appropriate file for reading
    output          PrintWriter             This variable is used to write to files.
					    Accepted values: name of appropriate file for writing
    skyBlue         Color                   This variable stores the color used for the sky in the desktop of the drawing of a computer used in all
					    public methods besides mainMenu.
					    Accepted values: values do not change
    hillGreen       Color                   This variable stores the color used for the hills in the desktop of the drawing of a computer used in all
					    public methods besides mainMenu.
					    Accepted values: values do not change
    darkWhite       Color                   This variable stores the color mainly used for the parts of the open computer window used in all public
					    methods besides mainMenu.
					    Accepted values: values do not change
*/

import hsa.*;
import java.awt.*;
import java.lang.*;
import javax.imageio.ImageIO;
import java.awt.image.*;
import java.io.*;

public class quizGame extends Thread
{
    Console c; //Output Console
    //Global Declaration Section
    int choice;
    int right = 0;
    int wrong = 0;
    int length;
    String line;
    Font smallText = new Font ("Arial", 1, 10);
    Font defaultFont = new Font ("Times New Roman", 1, 15);
    BufferedImage picture;
    BufferedReader input;
    PrintWriter output;
    Color skyBlue = new Color (46, 122, 236);
    Color hillGreen = new Color (148, 186, 48);
    Color darkWhite = new Color (237, 237, 237);

    /* Purpose: This method is used to introduce the user to the computer hardware quiz program through an animation of a computer monitor with a landscape
    background and a moving mouse clicking on an icon, opening a window with a welcome message and information about the program with computer peripherals
    scrolling down the window. After the window stops scrolling a red loading bar appears, which transitions to the main menu.

    Local Variable Dictionary

    Name            Type                    Description

    x               int                     This variable is used in for loop 1 through 5 for drawing or animation purposes.
					    Possible values: 0 - varying lengths

    Loop/Conditional Structure              Purpose

    For Loop 1                              Draws top row of clouds on computer desktop.
    For Loop 2                              Draws bottom row of clouds on computer desktop.
    For Loop 3                              Animates moving mouse across screen, clicking an icon.
    For Loop 4                              Scrolling effect on open window on desktop.
    For Loop 5                              Loading bar animation.

    If Statement 1                          Used to determine color of eraser for moving mouse animation.

    Try Block 1-7                           Used for delaying animation.
    */
    public void splashScreen ()
    {
	title ();
	c.setColor (Color.gray);
	c.fillRect (20, 50, 600, 440); //draw computer monitor screen
	c.fillRect (280, 490, 100, 30); //monitor neck
	c.setColor (skyBlue);
	c.fillRect (40, 70, 560, 400); //desktop sky
	c.setColor (hillGreen);
	c.fillRect (40, 300, 560, 170); //desktop ground
	c.setColor (Color.black);
	c.fillRect (40, 455, 560, 15); //desktop bottom ribbon
	c.setColor (Color.white);
	c.fillRect (53, 458, 4, 4); //desktop bottom ribbon icons
	c.fillRect (48, 458, 4, 4);
	c.fillRect (53, 463, 4, 4);
	c.fillRect (48, 463, 4, 4);
	c.fillRect (66, 455, 140, 15);
	c.fillRect (581, 459, 11, 8);
	for (int x = 0 ; x <= 500 ; x = x + 200) //for loop 1
	{
	    c.fillOval (530 - x, 100, 35, 35);
	    c.fillOval (505 - x, 100, 35, 35);
	    c.fillOval (490 - x, 117, 35, 35);
	    c.fillOval (515 - x, 117, 35, 35);
	    c.fillOval (545 - x, 117, 35, 35);
	    c.fillOval (530 - x, 135, 35, 35);
	    c.fillOval (505 - x, 135, 35, 35); //cloud top line
	}
	for (int x = 0 ; x <= 500 ; x = x + 200) //for loop 2
	{
	    c.fillOval (430 - x, 200, 35, 35);
	    c.fillOval (405 - x, 200, 35, 35);
	    c.fillOval (390 - x, 217, 35, 35);
	    c.fillOval (415 - x, 217, 35, 35);
	    c.fillOval (445 - x, 217, 35, 35);
	    c.fillOval (430 - x, 235, 35, 35);
	    c.fillOval (405 - x, 235, 35, 35); //cloud bottom line
	}
	c.setFont (smallText);
	c.drawString ("01/6/2019", 474, 466); //desktop bottom ribbon text
	c.drawString ("3:38 PM", 529, 466);
	c.setColor (Color.gray);
	c.fillRect (20, 180, 20, 100); //erase cloud overlapping computer
	c.setColor (Color.black);
	c.drawLine (582, 461, 590, 461); //desktop bottom ribbon right icon black line
	c.drawLine (582, 464, 590, 464);
	c.fillRect (0, 180, 20, 100);
	c.setColor (Color.red);
	c.fillRect (55, 95, 33, 33); //desktop icon
	c.setColor (Color.yellow);
	c.fillRect (55, 145, 33, 33); //desktop icon
	c.setColor (Color.green);
	c.fillRect (55, 195, 33, 33); //desktop icon
	for (int x = 0 ; x < 200 ; x = x + 2) ///for loop 3
	{
	    if (x < 150) //if statement 1
	    {
		c.setColor (hillGreen); //eraser color
	    }
	    else
	    {
		c.setColor (skyBlue); //eraser color
	    }
	    c.fillRect (285 - x, 430 - x, 20, 20); //eraser
	    c.setColor (skyBlue);
	    c.fillRect (150, 270, 30, 30); //eraser
	    c.setColor (Color.white);
	    int[] xPoints = {285 - x, 285 - x, 289 - x, 291 - x, 293 - x, 291 - x, 296 - x}; //mouse animation clicking on icon
	    int[] yPoints = {425 - x, 440 - x, 438 - x, 443 - x, 442 - x, 437 - x, 437 - x};
	    c.fillPolygon (xPoints, yPoints, 7);
	    try //try block 1
	    {
		sleep (15);
	    }
	    catch (Exception e)
	    {
	    }
	}
	try //try block 2
	{
	    sleep (1200);
	}
	catch (Exception e)
	{
	}
	c.fillRect (70, 95, 500, 335);
	c.setColor (darkWhite);
	c.fillRect (558, 95, 12, 335);
	c.setColor (Color.lightGray);
	c.fillRect (70, 95, 500, 15);
	c.fillOval (100, 350, 22, 27);
	c.fillRect (180, 350, 100, 33);
	c.fillRect (350, 350, 80, 50);
	c.fillRect (382, 400, 20, 12);
	c.fillRect (375, 412, 34, 3);
	c.drawArc (490, 350, 40, 50, 0, 180);
	c.fillOval (488, 370, 12, 18);
	c.fillOval (521, 370, 12, 18);
	c.setColor (Color.green);
	c.fillRect (206, 455, 19, 15);
	c.setColor (Color.red);
	c.fillRect (546, 95, 23, 14);
	c.setColor (Color.white);
	c.drawLine (554, 105, 560, 99);
	c.drawLine (560, 105, 554, 99);
	c.setColor (Color.black);
	c.drawRect (525, 99, 8, 8);
	c.fillRect (525, 98, 9, 2);
	c.fillRect (500, 103, 8, 2);
	c.setColor (Color.blue);
	c.fillRect (355, 355, 70, 40); //desktop
	c.setColor (Color.darkGray);
	c.fillRect (102, 359, 18, 2);
	c.fillRect (110, 352, 2, 7);
	c.drawLine (187, 356, 272, 356);
	c.drawLine (187, 361, 272, 361);
	c.drawLine (187, 366, 272, 366);
	c.drawLine (187, 371, 272, 371);
	c.drawLine (187, 376, 272, 376);
	c.fillOval (490, 375, 2, 10); //headphone black portion
	c.fillOval (529, 375, 2, 10); //headphone black portion
	c.setFont (new Font ("Arial", 1, 90));
	c.drawString ("Welcome!", 104, 290);
	c.fillRect (558, 120, 12, 18);
	c.setFont (new Font ("Arial", 1, 12));
	c.drawString ("This program can be used to learn and test yourself on computer hardware.", 102, 320);
	try //try block 3
	{
	    sleep (1200);
	}
	catch (Exception e)
	{
	}
	for (int x = 0 ; x < 90 ; x++) //for loop 4
	{
	    c.setColor (Color.white); //OPEN WINDOW
	    c.fillRect (90, 225 - x, 455, 200);
	    c.setColor (Color.lightGray);
	    c.fillOval (100, 350 - x, 22, 27); //Computer peripherals
	    c.fillRect (180, 350 - x, 100, 33);
	    c.fillRect (350, 350 - x, 80, 50);
	    c.fillRect (382, 400 - x, 20, 12);
	    c.fillRect (375, 412 - x, 34, 3);
	    c.drawArc (490, 350 - x, 40, 50, 0, 180);
	    c.fillOval (488, 370 - x, 12, 18);
	    c.fillOval (521, 370 - x, 12, 18);
	    c.setColor (Color.blue);
	    c.fillRect (355, 355 - x, 70, 40); //desktop on tiny monitor
	    c.setColor (Color.darkGray);
	    c.fillRect (102, 359 - x, 18, 2);
	    c.fillRect (110, 352 - x, 2, 7);
	    c.drawLine (187, 356 - x, 272, 356 - x);
	    c.drawLine (187, 361 - x, 272, 361 - x);
	    c.drawLine (187, 366 - x, 272, 366 - x);
	    c.drawLine (187, 371 - x, 272, 371 - x);
	    c.drawLine (187, 376 - x, 272, 376 - x);
	    c.fillOval (490, 375 - x, 2, 10); //headphone black portion
	    c.fillOval (529, 375 - x, 2, 10); //headphone black portion
	    c.setColor (darkWhite);
	    c.fillRect (558, 119 + x, 12, 18); //scorlling bar on open window eraser
	    c.setColor (Color.darkGray);
	    c.fillRect (558, 120 + x, 12, 18); //scrolling bar on open windoe
	    c.setFont (new Font ("Arial", 1, 90));
	    c.drawString ("Welcome!", 104, 290 - x);
	    c.setFont (new Font ("Arial", 1, 12));
	    c.drawString ("This program can be used to learn and test yourself on Computer Hardware.", 102, 320 - x);
	    try //try block 4
	    {
		sleep (25);
	    }
	    catch (Exception e)
	    {
	    }
	}
	try //try block 5
	{
	    sleep (1200);
	}
	catch (Exception e)
	{
	}
	c.drawString ("Loading...", 300, 360);
	c.drawRect (260, 375, 130, 20); //LOADING BAR OUTLINE
	c.setColor (Color.red);
	for (int x = 0 ; x < 130 ; x++) //for loop 5
	{
	    c.fillRect (260, 375, x, 20); //LOADING BAR FILL
	    try //try block 6
	    {
		sleep (25);
	    }
	    catch (Exception e)
	    {
	    }
	}
	try //try block 7
	{
	    sleep (800);
	}
	catch (Exception e)
	{
	}
    }


    /* Purpose: This method is used to let the user access different parts of the program through a Main Menu. There are no animations, however is a drawing
    of a personal computer. Appropriate user input is required to exit. This method is returned to after every method is finished executing.

     Local Variable Dictionary

     Name            Type                    Description

     choiceS         String                  This variable is used to store the user input from the menu so that the program does not crash. The stored value
					     is then parsed as an integer and used to exit the main menu if it is within the correct range of menu options
					     and is one character.
					     Accepted values: all user input, 1 - 7

     Loop/Conditional Structure              Purpose

     While Loop 1                            Used to loop the main menu until an appropriate option is entered by the user.

     Try Block 1                             Used to catch NumberFormatException in user input.

     If Statement 1                          Used to exit loop if user input is an integer within accepted range of optons from menu.
     */
    public void mainMenu ()
    {
	//Local Variable Declaration Section
	String choiceS;
	while (true) //While Loop 1
	{
	    try //bry block 1
	    {
		title ();
		c.setColor (Color.gray); //computer drawing
		c.fillRect (390, 100, 180, 160); //monitor
		c.fillRect (280, 120, 80, 200); //case
		c.fillRect (460, 260, 40, 25);
		c.fillRect (420, 280, 120, 15);
		c.fillOval (585, 290, 30, 40);
		c.fillRect (390, 310, 180, 55);
		c.setColor (Color.blue);
		c.fillRoundRect (410, 120, 140, 120, 10, 10); ///desktop
		c.fillRect (0, 95, 220, 20);
		c.setColor (Color.white);
		c.fillRect (425, 135, 110, 90); //open desktop window
		c.setColor (Color.green);
		c.fillRect (505, 160, 20, 55); //open desktop window green block
		c.setColor (Color.red);
		c.fillRect (435, 160, 25, 20); //open desktop window red block
		c.fillRect (0, 145, 220, 20); //menu option buttons
		c.fillRect (0, 177, 220, 20);
		c.fillRect (0, 209, 220, 20);
		c.fillRect (0, 241, 220, 20);
		c.fillRect (0, 273, 220, 20);
		c.fillRect (0, 305, 220, 20);
		c.fillRect (0, 337, 220, 20);
		c.setColor (Color.lightGray);
		c.fillRect (425, 135, 110, 7);
		c.fillRect (290, 140, 20, 70);
		c.fillOval (290, 223, 25, 25);
		c.fillRect (280, 260, 60, 5); //strips on computer case
		c.fillRect (280, 280, 60, 5);
		c.fillRect (280, 300, 60, 5);
		c.setColor (Color.darkGray);
		c.fillRect (297, 150, 5, 12);
		c.fillRect (297, 170, 5, 12);
		c.fillRect (297, 190, 5, 12);
		c.fillRect (280, 270, 60, 5);
		c.fillRect (280, 290, 60, 5);
		c.fillRect (585, 306, 30, 2);
		c.fillRect (598, 290, 2, 18);
		c.fillRect (400, 320, 160, 2);
		c.fillRect (400, 330, 160, 2);
		c.fillRect (400, 340, 160, 2);
		c.fillRect (400, 350, 160, 2);
		c.fillRect (120, 435, 400, 30);
		c.setColor (Color.gray);
		c.fillRect (425, 142, 110, 10);
		c.fillRect (505, 310, 15, 55);
		c.setColor (Color.white);
		c.fillRect (515, 138, 3, 2);
		c.fillRect (522, 137, 3, 3);
		c.drawLine (528, 137, 530, 139);
		c.drawLine (528, 139, 530, 137);
		c.fillRect (435, 145, 75, 3);
		c.fillRect (428, 145, 3, 3);
		c.fillRect (525, 145, 5, 3);
		c.fillStar (515, 144, 5, 5);
		c.setColor (Color.white);
		c.drawString ("MAIN MENU", 50, 110); //menu options text
		c.drawString ("1. Instructions", 50, 159);
		c.drawString ("2. Learn Content", 50, 191);
		c.drawString ("3. Beginner Quiz", 50, 223);
		c.drawString ("4. Intermediate Quiz", 50, 255);
		c.drawString ("5. Expert Quiz", 50, 287);
		c.drawString ("6. Scoreboard", 50, 319);
		c.drawString ("7. Exit", 50, 351);
		c.drawString ("Select an option from the Menu: ", 130, 455);
		c.setColor (Color.black);
		c.drawLine (435, 190, 460, 190); //keyboard lines
		c.drawLine (435, 195, 460, 195);
		c.drawLine (435, 200, 460, 200);
		c.drawLine (435, 205, 460, 205);
		c.drawLine (435, 210, 460, 210);
		c.drawLine (470, 165, 495, 165);
		c.drawLine (470, 170, 495, 170);
		c.drawLine (470, 175, 495, 175);
		c.drawLine (470, 180, 495, 180);
		c.drawLine (470, 185, 495, 185);
		c.drawLine (470, 200, 495, 200);
		c.drawLine (470, 205, 495, 205);
		c.drawLine (470, 210, 495, 210);
		c.setCursor (23, 45);
		c.setTextBackgroundColor (Color.darkGray); //box for user input
		choiceS = c.readLine (); //accepts user input and stores
		choice = Integer.parseInt (choiceS); //parses user input
		c.fillRect (520, 435, 120, 30);
		if (choice >= 1 && choice <= 7) //if statement 1
		{
		    break; //if user selects valid menu option, breaks while loop
		}
		else
		{
		    new Message ("Invalid Menu Option. Please choose from options 1 through 7.", "Error."); //error message for wrong range
		}
	    }
	    catch (NumberFormatException e)
	    {
		new Message ("Invalid menu option. Not an integer.", "Error."); //error message for wrong format
	    }
	}
    }


    /* Purpose: This method is used to explain to the user the different program functions and how and where they can access the different parts of the program.
       Mainly expalins how to use menu and what the parts of the menu do.

	Local Variable Dictionary

	Name            Type                    Description

	x               int                     This variable is used in for loop 1 and 2 for drawing clouds in the desktop drawing.
						Possible values: 0 - <500

	Loop/Conditional Structure              Purpose

	 For Loop 1                              Draws top row of clouds on computer desktop.
	 For Loop 2                              Draws bottom row of clouds on computer desktop.

	 Try Block 1                             Used to delay the drawing of the open window and instructions text.
	*/
    public void instructions ()
    {
	title ();
	c.setColor (Color.gray);
	c.fillRect (20, 50, 600, 440);
	c.fillRect (280, 490, 100, 30);
	c.setColor (skyBlue);
	c.fillRect (40, 70, 560, 400);
	c.setColor (hillGreen);
	c.fillRect (40, 300, 560, 170);
	c.setColor (Color.black);
	c.fillRect (40, 455, 560, 15);
	c.setColor (Color.white);
	c.fillRect (53, 458, 4, 4);
	c.fillRect (48, 458, 4, 4);
	c.fillRect (53, 463, 4, 4);
	c.fillRect (48, 463, 4, 4);
	c.fillRect (66, 455, 140, 15);
	c.fillRect (581, 459, 11, 8);
	for (int x = 0 ; x <= 500 ; x = x + 200) //for loop 1
	{
	    c.fillOval (530 - x, 100, 35, 35);
	    c.fillOval (505 - x, 100, 35, 35);
	    c.fillOval (490 - x, 117, 35, 35);
	    c.fillOval (515 - x, 117, 35, 35);
	    c.fillOval (545 - x, 117, 35, 35);
	    c.fillOval (530 - x, 135, 35, 35);
	    c.fillOval (505 - x, 135, 35, 35); //cloud
	}
	for (int x = 0 ; x <= 500 ; x = x + 200) //for loop 2
	{
	    c.fillOval (430 - x, 200, 35, 35);
	    c.fillOval (405 - x, 200, 35, 35);
	    c.fillOval (390 - x, 217, 35, 35);
	    c.fillOval (415 - x, 217, 35, 35);
	    c.fillOval (445 - x, 217, 35, 35);
	    c.fillOval (430 - x, 235, 35, 35);
	    c.fillOval (405 - x, 235, 35, 35); //cloud
	}
	c.setFont (smallText);
	c.drawString ("01/6/2019", 474, 466);
	c.drawString ("3:38 PM", 529, 466);
	c.setColor (Color.gray);
	c.fillRect (20, 180, 20, 100);
	c.setColor (Color.black);
	c.drawLine (582, 461, 590, 461);
	c.drawLine (582, 464, 590, 464);
	c.fillRect (0, 180, 20, 100);
	c.setColor (Color.green);
	c.fillRect (55, 95, 33, 33);
	c.setColor (Color.yellow);
	c.fillRect (55, 145, 33, 33);
	c.setColor (Color.red);
	c.fillRect (55, 195, 33, 33);
	try //try block 1
	{
	    sleep (1000);
	}
	catch (Exception e)
	{
	}
	c.setColor (Color.white);
	c.fillRect (50, 80, 540, 365);
	c.setColor (Color.lightGray);
	c.fillRect (50, 80, 540, 17);
	c.setColor (Color.red);
	c.fillRect (566, 80, 23, 14);
	c.setColor (Color.white);
	c.drawLine (574, 90, 580, 84);
	c.drawLine (580, 90, 574, 84);
	c.setColor (Color.black);
	c.drawRect (545, 84, 8, 8);
	c.fillRect (545, 83, 9, 2);
	c.fillRect (520, 88, 8, 2);
	c.setColor (darkWhite);
	c.fillRect (50, 97, 540, 19);
	c.fillRect (578, 115, 12, 330);
	c.setColor (Color.white);
	c.fillRoundRect (147, 102, 394, 9, 5, 5);
	c.setColor (Color.black);
	c.drawLine (140, 94, 135, 83);
	c.drawLine (53, 83, 135, 83);
	c.drawLine (53, 83, 53, 94);
	c.drawString ("Instructions", 65, 140);
	c.setFont (smallText);
	c.drawLine (582, 461, 590, 461);
	c.drawLine (582, 464, 590, 464);
	c.drawString ("Instructions", 66, 94);
	c.drawString ("https://computer-hardware-quiz/7583/instructions", 156, 110);
	c.drawString ("This program can be used to: ", 65, 160);
	c.drawString ("a)  learn about computer hardware", 100, 180);
	c.drawString ("b)  take multiple-choice quizzes of varying difficulty on computer hardware", 100, 200);
	c.drawString ("To learn about the different parts of a computer and their functiions, select '2' in the menu.", 65, 230);
	c.drawString ("To take a beginner level hardware quiz with 3 chances per question, select '3' in the menu.", 65, 250);
	c.drawString ("To take an intermediate level hardware quiz with 2 chances per question, select '4' in the menu.", 65, 270);
	c.drawString ("To take an expert level hardware quiz with 1 chance per question, select '5' in the menu.", 65, 290);
	c.drawString ("To see the top 10 quiz scores, select '6' in the menu.", 65, 310);
	c.drawString ("To exit the program and automatically close this window, select '7' in the menu.", 65, 330);
	c.drawString ("Each multiple-choice quiz consists of 2 sections of 5 questions each, with 4 options. ", 65, 360);
	c.drawString ("Section 1: Accurate spelling of computer parts", 100, 380);
	c.drawString ("Section 2: Accurate identification of computer parts from pictures/description", 100, 400);
	c.drawString ("You will now return to the Main Menu. Select '1' in the menu to re-read the instructions.", 65, 430);
	c.drawLine (146, 86, 146, 92);
	c.drawLine (143, 89, 149, 89);
	c.setColor (Color.darkGray);
	c.drawLine (58, 106, 68, 106);
	c.drawLine (78, 106, 88, 106);
	c.drawLine (58, 106, 62, 102);
	c.drawLine (58, 106, 62, 110);
	c.drawLine (88, 106, 84, 102);
	c.drawLine (88, 106, 84, 110);
	c.drawArc (100, 101, 10, 10, 0, 315);
	c.drawLine (110, 106, 112, 103);
	c.drawLine (110, 106, 107, 105);
	c.drawLine (122, 105, 122, 111);
	c.drawLine (131, 105, 131, 111);
	c.drawLine (120, 106, 126, 101);
	c.drawLine (133, 106, 126, 101);
	c.drawStar (555, 101, 11, 11);
	c.fillOval (576, 102, 2, 2);
	c.fillOval (576, 106, 2, 2);
	c.fillOval (576, 110, 2, 2);
	c.setColor (Color.gray);
	c.fillRect (578, 200, 12, 20);
	pauseProgram ();
    }


    /* Purpose: This method is used to teach the user about basic computer hardware. The content begins with I/O devices and the definition of a computer
    and transitions into parts of the motherboard and cpu, increasing in difficulty. Pictures are used in addition to descriptions of hardware functions
    so that the user can ientify hardware using visuals which is also tested in the quiz.

	    Local Variable Dictionary

	    Name            Type                    Description

	    x               int                     This variable is used in for loop 1 and 2 for drawing clouds in the desktop drawing.
						    Possible values: 0 - <500

	    Loop/Conditional Structure              Purpose

	     For Loop 1                             Draws top row of clouds on computer desktop.
	     For Loop 2                             Draws bottom row of clouds on computer desktop.

	     Try Block 1                            Used to delay the drawing of the open window and instructions text.
	     Try Block 2                            Used to draw pictures of computer hardware (I/O Devices) and catch IOException.
	     Try Block 3                            Used to draw pictures of computer hardware (Parts of the Motherboard) and catch IOException.

    */
    public void learnHardware ()
    {
	title ();
	c.setColor (Color.gray);
	c.fillRect (20, 50, 600, 440);
	c.fillRect (280, 490, 100, 30);
	c.setColor (skyBlue);
	c.fillRect (40, 70, 560, 400);
	c.setColor (hillGreen);
	c.fillRect (40, 300, 560, 170);
	c.setColor (Color.black);
	c.fillRect (40, 455, 560, 15);
	c.setColor (Color.white);
	c.fillRect (53, 458, 4, 4);
	c.fillRect (48, 458, 4, 4);
	c.fillRect (53, 463, 4, 4);
	c.fillRect (48, 463, 4, 4);
	c.fillRect (66, 455, 140, 15);
	c.fillRect (581, 459, 11, 8);
	for (int x = 0 ; x <= 500 ; x = x + 200) //for loop 1
	{
	    c.fillOval (530 - x, 100, 35, 35);
	    c.fillOval (505 - x, 100, 35, 35);
	    c.fillOval (490 - x, 117, 35, 35);
	    c.fillOval (515 - x, 117, 35, 35);
	    c.fillOval (545 - x, 117, 35, 35);
	    c.fillOval (530 - x, 135, 35, 35);
	    c.fillOval (505 - x, 135, 35, 35); //cloud
	}
	for (int x = 0 ; x <= 500 ; x = x + 200) //for loop 2
	{
	    c.fillOval (430 - x, 200, 35, 35);
	    c.fillOval (405 - x, 200, 35, 35);
	    c.fillOval (390 - x, 217, 35, 35);
	    c.fillOval (415 - x, 217, 35, 35);
	    c.fillOval (445 - x, 217, 35, 35);
	    c.fillOval (430 - x, 235, 35, 35);
	    c.fillOval (405 - x, 235, 35, 35); //cloud
	}
	c.setFont (smallText);
	c.drawString ("01/6/2019", 474, 466);
	c.drawString ("3:38 PM", 529, 466);
	c.setColor (Color.gray);
	c.fillRect (20, 180, 20, 100);
	c.setColor (Color.black);
	c.drawLine (582, 461, 590, 461);
	c.drawLine (582, 464, 590, 464);
	c.fillRect (0, 180, 20, 100);
	c.setColor (Color.green);
	c.fillRect (55, 95, 33, 33);
	c.setColor (Color.yellow);
	c.fillRect (55, 145, 33, 33);
	c.setColor (Color.red);
	c.fillRect (55, 195, 33, 33);
	try //try block 1
	{
	    sleep (1000);
	}
	catch (Exception e)
	{
	}
	c.setColor (Color.yellow);
	c.fillRect (206, 455, 19, 15);
	c.setColor (Color.white);
	c.fillRect (50, 80, 540, 365);
	c.setColor (Color.lightGray);
	c.fillRect (50, 80, 540, 17);
	c.setColor (Color.red);
	c.fillRect (566, 80, 23, 14);
	c.setColor (Color.white);
	c.drawLine (574, 90, 580, 84);
	c.drawLine (580, 90, 574, 84);
	c.setColor (Color.black);
	c.drawRect (545, 84, 8, 8);
	c.fillRect (545, 83, 9, 2);
	c.fillRect (520, 88, 8, 2);
	c.setColor (darkWhite);
	c.fillRect (50, 97, 540, 19);
	c.fillRect (578, 115, 12, 330);
	c.setColor (Color.white);
	c.fillRoundRect (147, 102, 394, 9, 5, 5);
	c.setColor (Color.black);
	c.drawLine (140, 94, 135, 83);
	c.drawLine (53, 83, 135, 83);
	c.drawLine (53, 83, 53, 94);
	c.drawLine (146, 86, 146, 92);
	c.drawLine (143, 89, 149, 89);
	c.drawString ("Hardware", 70, 94);
	c.drawString ("https://computer-hardware-quiz/7583/computer-hardware", 156, 110);
	c.drawString ("Computer hardware is made up of all the physical components of a computer.", 70, 173);
	c.drawString ("A popular type of computer hardware are I/O, or Input/Output devices which are used by the computer", 70, 193);
	c.drawString ("to communicate with the outside world. ", 70, 213);
	c.drawString ("An input device sends information to a computer system for processing, and an output device reprod-", 70, 243);
	c.drawString ("uces or displays the results of that processing. Input devices only allow for input of data to a computer ", 70, 263);
	c.drawString ("and output devices only receive the output of data from another device. ", 70, 283);
	c.drawString ("Common input devices include: mouse, keyboard, scanner, microphone, image scanner, touchpad/", 70, 313);
	c.drawString ("touchscreen, joystick, CD-ROM (Compact Disc Read Only Memory), DVD (Digital Versatile Disc), etc.", 70, 333);
	c.drawString ("Common output devices include: monitor, printer, speakers, headphones, projector, etc. Floppy disks, ", 70, 353);
	c.drawString ("USBs (Universal Serial Bus), external HDDs (Hard Disk Drives), and CD-RW (Compact Disc Rewriteable) ", 70, 373);
	c.drawString ("are both input and output devices. I/O devices are also called peripherals, because they connect", 70, 393);
	c.drawString ("directly to a computer but do not contribute to the computer's primary function, such as computing.", 70, 413);
	c.setColor (Color.red);
	c.drawString ("Page | 1", 300, 433);
	c.setFont (new Font ("Arial", 3, 25));
	c.drawString ("Introduction to Computer Hardware", 70, 150);
	c.setColor (Color.darkGray);
	c.drawLine (58, 106, 68, 106);
	c.drawLine (78, 106, 88, 106);
	c.drawLine (58, 106, 62, 102);
	c.drawLine (58, 106, 62, 110);
	c.drawLine (88, 106, 84, 102);
	c.drawLine (88, 106, 84, 110);
	c.drawArc (100, 101, 10, 10, 0, 315);
	c.drawLine (110, 106, 112, 103);
	c.drawLine (110, 106, 107, 105);
	c.drawLine (122, 105, 122, 111);
	c.drawLine (131, 105, 131, 111);
	c.drawLine (120, 106, 126, 101);
	c.drawLine (133, 106, 126, 101);
	c.drawStar (555, 101, 11, 11);
	c.fillOval (576, 102, 2, 2);
	c.fillOval (576, 106, 2, 2);
	c.fillOval (576, 110, 2, 2);
	c.setColor (Color.gray);
	c.fillRect (578, 200, 12, 20);
	pauseProgram ();
	c.setColor (Color.white);
	c.fillRect (50, 116, 530, 330);
	c.setColor (Color.black);
	try //try block 2
	{
	    picture = ImageIO.read (new File ("mouse.jpg"));
	    c.drawImage (picture, 55, 140, null);
	    picture = ImageIO.read (new File ("keyboard.jpg"));
	    c.drawImage (picture, 228, 160, null);
	    picture = ImageIO.read (new File ("printer.jpg"));
	    c.drawImage (picture, 432, 140, null);
	    picture = ImageIO.read (new File ("microphone.jpg"));
	    c.drawImage (picture, 70, 274, null);
	    picture = ImageIO.read (new File ("cd.jpg"));
	    c.drawImage (picture, 175, 275, null);
	    picture = ImageIO.read (new File ("monitor.jpg"));
	    c.drawImage (picture, 305, 275, null);
	    picture = ImageIO.read (new File ("speaker.jpg"));
	    c.drawImage (picture, 470, 290, null);
	    c.drawString ("Mouse", 110, 140);
	    c.drawString ("Keyboard", 285, 150);
	    c.drawString ("Printer", 480, 140);
	    c.drawString ("Microphone", 115, 305);
	    c.drawString ("CD's", 230, 275);
	    c.drawString ("Monitor", 350, 410);
	    c.drawString ("Speakers", 470, 285);
	    c.setFont (smallText);
	    c.setColor (Color.red);
	    c.drawString ("Page | 2", 300, 433);
	    pauseProgram ();
	    c.setColor (Color.white);
	    c.fillRect (50, 116, 530, 330);
	    c.setColor (Color.black);
	    picture = ImageIO.read (new File ("headphones.jpg"));
	    c.drawImage (picture, 90, 142, null);
	    picture = ImageIO.read (new File ("floppyDisk.jpg"));
	    c.drawImage (picture, 250, 150, null);
	    picture = ImageIO.read (new File ("usb.jpg"));
	    c.drawImage (picture, 400, 150, null);
	    c.drawString ("Headphones", 100, 140);
	    c.drawString ("Floppy Disk", 270, 140);
	    c.drawString ("USB", 425, 160);
	    c.setFont (smallText);
	    c.setColor (Color.red);
	    c.drawString ("Page | 3", 300, 433);
	}
	catch (IOException e)
	{
	}
	c.setColor (Color.black);
	c.drawString ("Parts of the computer that are responsible for its primary function - its non-peripheral devices - are", 70, 295);
	c.drawString ("found in the computer tower case. The two main types of internal memory are RAM (Random Access ", 70, 315);
	c.drawString ("Memory) and ROM (Read Only Memory). RAM is a type of volatile memory, which means that the stored ", 70, 335);
	c.drawString ("information is lost when there is no power. So, RAM is used by the central processing unit (CPU) when", 70, 355);
	c.drawString ("a computer is running to store information that it needs to be used very quickly, but it does not store", 70, 375);
	c.drawString ("any information permanently. ROM a type of non-volatile memory used in computers and other electron-", 70, 395);
	c.drawString ("ic devices. Data stored in ROM can only be modified slowly, with difficulty, or not at all, so it is mainly", 70, 415);
	pauseProgram ();
	c.setColor (Color.white);
	c.fillRect (50, 116, 530, 330);
	c.setColor (Color.red);
	c.setFont (smallText);
	c.drawString ("Page | 4", 300, 433);
	c.setColor (Color.black);
	c.drawString ("used to store firmware (software that is closely tied to specific hardware, and unlikely to need frequent", 70, 143);
	c.drawString ("updates) or application software in plug-in cartridges. The two main types of computer storage devices", 70, 163);
	c.drawString ("are the HDD (Hard Disk Drive) and SSD (Solid State Drive).", 70, 183);
	c.drawString ("HDD is an electromechanical data storage device that uses magnetic storage to store and retrieve dig-", 70, 213);
	c.drawString ("ital information using one or more rigid rapidly rotating disks coated with magnetic material. SSD is a", 70, 233);
	c.drawString ("solid-state storage device that uses integrated circuit assemblies as memory to store data persistently, ", 70, 253);
	c.drawString ("contains nonvolatile flash memory, and is used in place of a hard disk because of its speed.", 70, 273);
	c.drawString ("The motherboard is a printed circuit board that is the foundation of a computer, located on the back side", 70, 303);
	c.drawString ("or at the bottom of the computer case. It allocates power and allows communication to the CPU, RAM,", 70, 323);
	c.drawString ("and all other computer hardware components. The CPU (Computer Processing Unit) is found on the", 70, 343);
	c.drawString ("motherboard and is called the 'brains' of the computer. The (CPU)is a piece of hardware that carries ", 70, 363);
	c.drawString ("out the instructions of a computer program. It performs the basic arithmetical, logical, and input/output", 70, 383);
	c.drawString ("operations of a computer system. The CPU Fan and Heat Sink help keep the CPU cool and prevent it ", 70, 403);
	c.drawString ("from overheating. ", 70, 423);
	pauseProgram ();
	c.setColor (Color.white);
	c.fillRect (50, 116, 530, 330);
	try //try block 3
	{
	    picture = ImageIO.read (new File ("motherboard.jpg"));
	    c.drawImage (picture, 65, 140, null);
	    picture = ImageIO.read (new File ("cpuFan.jpg"));
	    c.drawImage (picture, 400, 140, null);
	    picture = ImageIO.read (new File ("cpu.jpg"));
	    c.drawImage (picture, 227, 140, null);
	    picture = ImageIO.read (new File ("expansionSlots.jpg"));
	    c.drawImage (picture, 65, 290, null);
	    picture = ImageIO.read (new File ("psu.jpg"));
	    c.drawImage (picture, 255, 280, null);
	    picture = ImageIO.read (new File ("discDrive.jpg"));
	    c.drawImage (picture, 410, 290, null);
	}
	catch (IOException e)
	{
	}
	c.setColor (Color.black);
	c.drawString ("Motherboard", 85, 140);
	c.drawString ("CPU", 295, 140);
	c.drawString ("CPU Fan and Heatsink", 405, 140);
	c.drawString ("Expansion Slots", 85, 280);
	c.drawString ("PSU", 295, 280);
	c.drawString ("Optical Disc Drive", 405, 280);
	c.setColor (Color.red);
	c.setFont (smallText);
	c.drawString ("Page | 5", 300, 433);
	pauseProgram ();
	c.setColor (Color.white);
	c.fillRect (50, 116, 530, 330);
	c.setColor (Color.red);
	c.setFont (smallText);
	c.drawString ("Page | 6", 300, 433);
	c.setColor (Color.black);
	c.drawString ("The ALU (Arithmetic Logic Unit) is the part of the CPU that performs the basic arithmetic and logic oper-", 70, 143);
	c.drawString ("ations. The GPU (Graphics Processing Unit) is also located on the motherboard or sometimes and ren-", 70, 163);
	c.drawString ("ders images, animations and video for the computer's screen.", 70, 183);
	c.drawString ("The BIOS Chip (Basic Input/Output System Chip) is a chip located on the motherboard or sometimes ", 70, 213);
	c.drawString ("ipart of the ROM which contains the set of instructions the CPU uses to get the computer system started", 70, 233);
	c.drawString ("after you turn it on. ", 70, 253);
	c.drawString ("An Expansion Slot is a connection or port located inside a computer on the motherboard on which", 70, 283);
	c.drawString ("Expansion Cards can be attached to add functionality to a computer. Common expansion cards are the", 70, 303);
	c.drawString ("sound card, video card, and internal modem card.", 70, 323);
	c.drawString ("The Northbridge/Southbridge chipset make the core logic chipset architecture on a PC motherboard. ", 70, 353);
	c.drawString ("The northbridge is responsible for tasks that require the highest performance, while the southbridge", 70, 373);
	c.drawString ("typically implements the slower capabilities of the motherboard in a northbridge/southbridge chipset", 70, 393);
	c.drawString ("computer architecture.", 70, 413);
	pauseProgram ();
	c.setColor (Color.white);
	c.fillRect (50, 116, 530, 330);
	c.setColor (Color.red);
	c.setFont (smallText);
	c.drawString ("Page | 7", 300, 433);
	c.setColor (Color.black);
	c.drawString ("The Northbridge serves as a four-way intersection connecting the CPU, memory, video card (AGP) bus,", 70, 143);
	c.drawString ("and its partner, the southbridge chip.", 70, 163);
	c.drawString ("The Southbridge is the chip that controls all the computers I/O functions, such as USB, audio, serial,", 70, 193);
	c.drawString ("the system BIOS, the ISA bus, the interrupt controller and the IDE channels.", 70, 213);
	c.drawString ("The PSU (Power Supply Unit) converts mains AC to low-voltage regulated DC power for the internal", 70, 243);
	c.drawString ("components of a computer.", 70, 263);
	c.drawString ("The Optical Disc Drive uses laser light or electromagnetic waves to read or write data to CDs, DVDs,", 70, 293);
	c.drawString ("or Blu-ray discs.", 70, 313);
	pauseProgram ();
    }


    /* Purpose: This method is used for aall levels 1, 2, and 3 of the quiz. It randomly chooses 10 questions and randomizes the order of the four multiple
    choice options. The questions are stored and read from a file called questionBank.txt. For every correct answer, variable right increases by one. For
    every wrong answer, variable wrong increases by one. Two black box return methods are called in this method, one for calcualting the score of the player
    and the other to return the question bank. Lastly, the mmethod will automatically write the users score to the file scoreList.txt.

	  Local Variable Dictionary

	  Name            Type                    Description

	  x               int                     This variable is used in for loop 1 and 2 for drawing clouds in the desktop drawing.
						  It is also used in for loops for various reasons, mainly to fill arrays, write to files, and count
						  questions.
						  Possible values: 0 - <500
	  y               int                     This variable is used in for loops to check arrays for originality.
						  Possible values: 0 - <x
	  j               int                     This variable is used in for loops to check arrays for originality.
						  Possible values: 0 - <x
	  a               int                     This variable is used in 1 for loop to fill an array.
						  Possible values: 0 - <4
	  tries           int                     This variable stores the number of tries the user has remaining and increases by one for every valid
						  incorrect answer the user gives. The number of tries available depends on the difficulty of the quiz.
						  Possible values: 0, 1, 2
	  numTries        int                     This variable stores how many tries a user has to get the correct answer and dependds on the level of
						  difficulty the user chose in the Menu.
						  Possible values: 1, 2, 3
	  level           int                     This variable is stores the level the user has chosen in Main Menu and used to write to scoreList.txt.
						  Possible values: 1, 2, 3
	  question        int[10]                 This array stores the order of questions in a quiz, and contains 10 unique numbers from 1-44.
						  Possible values: 1-44
	  option          int[4]                  This array stores the order of question options and contains 4 unique numbers from 0-3.
						  Possible values: 0-3
	  name            String                  This variable is used to store the user's name and write it to scoreList.txt.
						  Possible values: all
	  answer          String                  This variable is used to store the user's answer to a quiz question.
						  Possible values: a, b, c, d (lowercase/uppercase)
	  image           String                  This variable is used to store the names of images to be drawn in the quiz.
						  Possible values: existing pictures
	  options         String[4]               This variable is used to store the options for a specific question to be outputted in a random order.
						  options[0] always contains the correct answer for a specific question to make processing easier.
						  Possible values: options for current question
	  fileContent     String[length]          This variable is used to store the contents of the file scoreList.txt to write back the contents and
						  the new score, name, and level after each quiz automatically.
						  Possible values: content of fileScore.txt
	  unique          boolean                 This variable is used to determine in the question and option arrays whether a value in the array is
						  unique or not.
						  Possible values: true, false

	  Loop/Conditional Structure              Purpose

	  For Loop 1                              Draws top row of clouds on computer desktop.
	  For Loop 2                              Draws bottom row of clouds on computer desktop.
	  For Loop 3                              Used to fill question array.
	  For Loop 4                              Used to test question array for uniqueness when value less than 3.
	  For Loop 5                              Used to test question array for uniqueness when value less than 3.
	  For Loop 6                              Used to test question array for uniqueness when value greater than 3.
	  For Loop 7                              Used to test question array for uniqueness when value greater than 3.
	  For Loop 8                              Used to count number of questions and display 10 questions.
	  For Loop 9                              Used to fill option array.
	  For Loop 10                             Used to test option array for uniqueness.
	  For Loop 11                             Used to test option array for uniqueness.
	  For Loop 12                             Used to fill fileContent array from scoreList.txt.
	  For Loop 13                             Used to write fileContent array to file scoreList.txt.

	  While loop 1                            Used to fill question array until every member is unique when location is less than 3.
	  While loop 2                            Used to fill question array until every member is unique when location is greater than 3.
	  While loop 3                            Used to fill option array until every member is unique.
	  While loop 4                            Used to ask the same question over again until the user gives the right anseer or takes the
						  appropriate number of tries.
	  While loop 5                            Used to find length of scoreList.txt to copy its contents.

	  If Statement 1                          Used to fill question array depending on location.
	  If Statement 2                          Used to check question array for originality when location < 3.
	  If Statement 3                          Used to check question array for originality when location < 3.
	  If Statement 4                          Used to break while loop 1 if question array is unique.
	  If Statement 5                          Used to check question array for originality when location > 3.
	  If Statement 6                          Used to check question array for originality when location > 3.
	  If Statement 7                          Used to break while loop 1 if question array is unique.
	  If Statement 8                          Used to check option array for originality.
	  If Statement 9                          Used to check option array for originality.
	  If Statement 10                         Used to break while loop 2 if option array is original.
	  If Statement 11                         Used to print quiz section title depending on question type and number.
	  If Statement 12                         Used to initialize options array, image string, and print questions.
	  If Statement 13                         Used to draw images if question requires identification of hardware from picture.
	  If Statement 14                         Used to display questions and options in specific area on screen based on question number and length.
	  If Statement 15                         Used to check if answer was in appropriate range (a, b, c, or d).
	  If Statement 16                         Used to count number of tries, right or wrong answers, give error or success messages to the user,
						  and to break while loop 4.
	  If Statement 17                         Used to print score on screen in specific location depending on length and value.

	  Switch Block 1                          Used to initialize variable numTries and level based on the user's choice in Main Menu.

	  Try Block 1                             Used to delay the drawing of the open window and instructions text.
	  Try Block 2                             Used to draw pictures of computer hardware for section 2 of the quiz and catch IOException.

	  */
    public void quiz ()
    {
	//Local Variable Declaration Section
	int tries;
	int numTries;
	int level;
	int question[] = new int [10];
	int option[] = new int [4];
	String answer = null;
	String name = null;
	String image = null;
	String options[] = new String [4];
	boolean unique = false;
	right = 0;
	wrong = 0;
	title ();
	c.setColor (Color.gray);
	c.fillRect (20, 50, 600, 440);
	c.fillRect (280, 490, 100, 30);
	c.setColor (skyBlue);
	c.fillRect (40, 70, 560, 400);
	c.setColor (hillGreen);
	c.fillRect (40, 300, 560, 170);
	c.setColor (Color.black);
	c.fillRect (40, 455, 560, 15);
	c.setColor (Color.white);
	c.fillRect (53, 458, 4, 4);
	c.fillRect (48, 458, 4, 4);
	c.fillRect (53, 463, 4, 4);
	c.fillRect (48, 463, 4, 4);
	c.fillRect (66, 455, 140, 15);
	c.fillRect (581, 459, 11, 8);
	for (int x = 0 ; x <= 500 ; x = x + 200) //for loop 1
	{
	    c.fillOval (530 - x, 100, 35, 35);
	    c.fillOval (505 - x, 100, 35, 35);
	    c.fillOval (490 - x, 117, 35, 35);
	    c.fillOval (515 - x, 117, 35, 35);
	    c.fillOval (545 - x, 117, 35, 35);
	    c.fillOval (530 - x, 135, 35, 35);
	    c.fillOval (505 - x, 135, 35, 35); //cloud
	}
	for (int x = 0 ; x <= 500 ; x = x + 200) //for loop 2
	{
	    c.fillOval (430 - x, 200, 35, 35);
	    c.fillOval (405 - x, 200, 35, 35);
	    c.fillOval (390 - x, 217, 35, 35);
	    c.fillOval (415 - x, 217, 35, 35);
	    c.fillOval (445 - x, 217, 35, 35);
	    c.fillOval (430 - x, 235, 35, 35);
	    c.fillOval (405 - x, 235, 35, 35); //cloud
	}
	c.setFont (smallText);
	c.drawString ("01/6/2019", 474, 466);
	c.drawString ("3:38 PM", 529, 466);
	c.setColor (Color.gray);
	c.fillRect (20, 180, 20, 100);
	c.setColor (Color.black);
	c.drawLine (582, 461, 590, 461);
	c.drawLine (582, 464, 590, 464);
	c.fillRect (0, 180, 20, 100);
	c.setColor (Color.green);
	c.fillRect (55, 95, 33, 33);
	c.setColor (Color.yellow);
	c.fillRect (55, 145, 33, 33);
	c.setColor (Color.red);
	c.fillRect (55, 195, 33, 33);
	try //try block 1
	{
	    sleep (1000);
	}
	catch (Exception e)
	{
	}
	c.setColor (Color.white);
	c.fillRect (70, 95, 500, 335);
	c.setColor (darkWhite);
	c.fillRect (558, 95, 12, 335);
	c.setColor (Color.lightGray);
	c.fillRect (70, 95, 500, 15);
	c.setColor (Color.green);
	c.fillRect (206, 455, 19, 15);
	c.setColor (Color.red);
	c.fillRect (546, 95, 23, 14);
	c.setColor (Color.white);
	c.drawLine (554, 105, 560, 99);
	c.drawLine (560, 105, 554, 99);
	c.setColor (Color.darkGray);
	c.fillRect (558, 120, 12, 18);
	c.setColor (Color.black);
	c.drawRect (525, 99, 8, 8);
	c.fillRect (525, 98, 9, 2);
	c.fillRect (500, 103, 8, 2);
	switch (choice) //switch block 1
	{
	    case 3:
		{
		    numTries = 3;
		    level = 1;
		}
	    case 4:
		{
		    numTries = 2;
		    level = 2;
		}
	    default:
		{
		    numTries = 1;
		    level = 3;
		}
	}
	for (int x = 0 ; x < 10 ; x++) //for loop 3
	{
	    if (x < 3) //if statement 1
	    {
		question [x] = (int) ((13) * Math.random () + 1);
		for (int y = 0 ; y < x ; y++) //for loop 4
		{
		    if (question [x] == question [y]) //if statement 2
		    {
			while (true) //while loop 1
			{
			    unique = true;
			    question [x] = (int) ((13) * Math.random () + 1);
			    for (int j = 0 ; j < x ; j++) //for loop 5
			    {
				if (question [x] == question [j]) //if statement 3
				{
				    unique = false;
				}
			    }
			    if (unique == true) //if statement 4
			    {
				break;
			    }
			}
		    }
		}
	    }
	    else if (x >= 3)
	    {
		question [x] = (int) ((31) * Math.random () + 14);
		for (int y = 0 ; y < x ; y++) //for loop 6
		{
		    if (question [x] == question [y]) //if statement 5
		    {
			while (true) //while loop 2
			{
			    unique = true;
			    question [x] = (int) ((31) * Math.random () + 14);
			    for (int j = 0 ; j < x ; j++) //for loop 7
			    {
				if (question [x] == question [j]) //if statement 6
				{
				    unique = false;
				}
			    }
			    if (unique == true) //if statement 7
			    {
				break;
			    }
			}
		    }
		}
	    }
	}
	c.setTextBackgroundColor (Color.white);
	c.setTextColor (Color.black);
	c.setFont (new Font ("Arial", 8, 23));
	c.drawString ("Enter your name: ", 170, 278);
	c.setCursor (14, 46);
	name = c.readLine ();
	c.setColor (Color.white);
	c.fillRect (70, 125, 470, 305);
	c.setColor (darkWhite);
	c.fillRect (558, 260, 12, 70);
	c.setColor (skyBlue);
	c.fillRect (570, 260, 30, 40);
	c.fillRect (40, 270, 30, 30);
	c.setColor (hillGreen);
	c.fillRect (570, 300, 30, 130);
	c.fillRect (40, 300, 30, 130);
	c.setColor (Color.gray);
	c.fillRect (600, 260, 20, 130);
	c.fillRect (20, 260, 20, 130);
	c.setColor (Color.black);
	c.fillRect (620, 260, 20, 130);
	c.fillRect (0, 260, 20, 130);
	c.setColor (Color.darkGray);
	for (int x = 0 ; x < 10 ; x++) //for loop 8
	{
	    tries = 0;
	    for (int a = 0 ; a < 4 ; a++) //for loop 9
	    {
		unique = false;
		option [a] = (int) ((4) * Math.random () + 0);
		for (int b = 0 ; b < a ; b++) //for loop 10
		{
		    if (option [a] == option [b]) //if statement 8
		    {
			while (true) //while loop 3
			{
			    unique = true;
			    option [a] = (int) ((4) * Math.random () + 0);
			    for (int j = 0 ; j < a ; j++) //for loop 11
			    {
				if (option [a] == option [j]) //if statement 9
				{
				    unique = false;
				}
			    }
			    if (unique == true) //if statement 10
			    {
				break;
			    }
			}
		    }
		}
	    }
	    while (true) //while loop 4
	    {
		c.setColor (Color.white);
		c.fillRect (70, 125, 480, 305);
		c.setColor (Color.black);
		c.setFont (new Font ("Arial", 8, 30));
		if (x < 3) //if statement 11
		{
		    c.drawString ("Quiz Section 1: Spelling", 100, 165);
		}
		else
		{
		    c.drawString ("Quiz Section 2: Identification", 100, 165);
		}
		c.setFont (new Font ("Helvetica", 5, 13));
		if (question [x] == 1) //if statement 12
		{
		    options [0] = "Arithmetic Logic Unit";
		    options [1] = "Arithmetric Logic Unif";
		    options [2] = "Arithmetic Logik Unlt";
		    options [3] = "Aruithmetic L0gic Unit";
		}
		else if (question [x] == 2)
		{
		    options [0] = "Computer Processing Unit";
		    options [1] = "ComPuter Unit";
		    options [2] = "Conputer Polling Unit";
		    options [3] = "Computer Procesing Unif";
		}
		else if (question [x] == 3)
		{
		    options [0] = "Random Access Memory";
		    options [1] = "Radom Accecs Memory";
		    options [2] = "Randomn Access Memery";
		    options [3] = "Random Acsess Memojy";
		}
		else if (question [x] == 4)
		{
		    options [0] = "Read Only Memory";
		    options [1] = "Reid Omly Memojy";
		    options [2] = "Read Onley Memory";
		    options [3] = "Raed Only Memery";
		}
		else if (question [x] == 5)
		{
		    options [0] = "Digital Versatile Disc";
		    options [1] = "Digital Versatle Disk";
		    options [2] = "Digitle Vertatile Disc";
		    options [3] = "Dijital Versatile Disk";
		}
		else if (question [x] == 6)
		{
		    options [0] = "Compact Disc Read Only Memory";
		    options [1] = "Comact Disk Read Onley Memory";
		    options [2] = "Compact Disc Raed Only Memery";
		    options [3] = "Conpact Disc Read Only Memorjy";
		}
		else if (question [x] == 7)
		{
		    options [0] = "Compact Disc Rewriteable";
		    options [1] = "Comact Disc Rewritebale";
		    options [2] = "Compact Disk Rewriteabel";
		    options [3] = "Conpact Disk Rewriteable";
		}
		else if (question [x] == 8)
		{
		    options [0] = "Graphics Processing Unit";
		    options [1] = "Graphic Procecsing Unit";
		    options [2] = "Grafics Processing Unif";
		    options [3] = "Graphics Procesing Unlt";
		}
		else if (question [x] == 9)
		{
		    options [0] = "Universal Serial Bus";
		    options [1] = "Universel Series Bus";
		    options [2] = "Universel Serial Bust";
		    options [3] = "Uniwersal Series Bus";
		}
		else if (question [x] == 10)
		{
		    options [0] = "Solid State Drive";
		    options [1] = "Social Stafe Drive";
		    options [2] = "Solide State Drive";
		    options [3] = "Solid Safe Drove";
		}
		else if (question [x] == 11)
		{
		    options [0] = "Hard Disk Drive";
		    options [1] = "Hard Diske Drove";
		    options [2] = "Hold Disk Dr1ve";
		    options [3] = "Hold Disc Drive";
		}
		else if (question [x] == 12)
		{
		    options [0] = "Basic Input Output System";
		    options [1] = "Basic Indoor/Outdoor System";
		    options [2] = "Bacis Input Output Systeme";
		    options [3] = "Basic Input Outpot Systom";
		}
		else if (question [x] == 13)
		{
		    options [0] = "Power Supply Unit";
		    options [1] = "Poer Supply Un1t";
		    options [2] = "Power Sanctions Unit";
		    options [3] = "Position Supply Unit";
		}
		if (question [x] == 14)
		{
		    image = "floppyDisk.jpg";
		    options [0] = "Floppy Disk";
		    options [1] = "Motherboard";
		    options [2] = "CPU";
		    options [3] = "Expansion Slots";
		}
		else if (question [x] == 15)
		{
		    image = "keyboard.jpg";
		    options [0] = "Keyboard";
		    options [1] = "Mouse";
		    options [2] = "Speakers";
		    options [3] = "BIOS";
		}
		else if (question [x] == 16)
		{
		    image = "mouse.jpg";
		    options [0] = "Mouse";
		    options [1] = "SDD";
		    options [2] = "Joystick";
		    options [3] = "Keyboard";
		}
		else if (question [x] == 17)
		{
		    image = "usb.jpg";
		    options [0] = "USB";
		    options [1] = "Floppy Disk";
		    options [2] = "DVD";
		    options [3] = "Optical Drive";
		}
		else if (question [x] == 18)
		{
		    image = "cd.jpg";
		    options [0] = "CD";
		    options [1] = "Speaker";
		    options [2] = "Motherboard";
		    options [3] = "Printer";
		}
		else if (question [x] == 19)
		{
		    image = "monitor.jpg";
		    options [0] = "Monitor";
		    options [1] = "Keyboard";
		    options [2] = "GPU";
		    options [3] = "TV Output Screen";
		}
		else if (question [x] == 20)
		{
		    image = "speaker.jpg";
		    options [0] = "Speakers";
		    options [1] = "Microphone Set";
		    options [2] = "Scanner";
		    options [3] = "Headphones";
		}
		else if (question [x] == 21)
		{
		    image = "printer.jpg";
		    options [0] = "Printer";
		    options [1] = "Peripheral";
		    options [2] = "Case";
		    options [3] = "Desktop";
		}
		else if (question [x] == 22)
		{
		    image = "microphone.jpg";
		    options [0] = "Microphone";
		    options [1] = "Headphones";
		    options [2] = "Joystick";
		    options [3] = "Heat Sink";
		}
		else if (question [x] == 23)
		{
		    image = "headphones.jpg";
		    options [0] = "Headphones";
		    options [1] = "Microphones";
		    options [2] = "CD Headset";
		    options [3] = "Optical Disc Drive";
		}
		else if (question [x] == 24)
		{
		    image = "motherboard.jpg";
		    options [0] = "Motherboard";
		    options [1] = "CD-RW";
		    options [2] = "CPU";
		    options [3] = "Circuit head";
		}
		else if (question [x] == 25)
		{
		    image = "discDrive.jpg";
		    options [0] = "Optical Disc Drive";
		    options [1] = "GPU";
		    options [2] = "Floppy Disk";
		    options [3] = "Expansion Slot";
		}
		else if (question [x] == 26)
		{
		    image = "psu.jpg";
		    options [0] = "Power Supply Unit";
		    options [1] = "Computer Tower Case";
		    options [2] = "CPU";
		    options [3] = "Motherboard";
		}
		else if (question [x] == 27)
		{
		    image = "cpuFan.jpg";
		    options [0] = "CPU Fan and Heat Sink";
		    options [1] = "Speaker";
		    options [2] = "Air Dispenser";
		    options [3] = "Scanner";
		}
		else if (question [x] == 28)
		{
		    image = "expansionSlots.jpg";
		    options [0] = "Expansion Slots";
		    options [1] = "CPU";
		    options [2] = "Expansion Card";
		    options [3] = "Optical Disc Drive";
		}
		else if (question [x] == 29)
		{
		    image = "cpu.jpg";
		    options [0] = "CPU";
		    options [1] = "Motherboard Gates";
		    options [2] = "Floppy Disk";
		    options [3] = "Power Supply Unit";
		}
		else if (question [x] == 30)
		{
		    image = "case.jpg";
		    options [0] = "Computer Tower Case";
		    options [1] = "Monitor";
		    options [2] = "Speaker";
		    options [3] = "Power Supply Unit";
		}
		else if (question [x] == 31)
		{
		    options [0] = "ALU";
		    options [1] = "Mathboard";
		    options [2] = "Motherboard";
		    options [3] = "GPU";
		}
		else if (question [x] == 32)
		{
		    options [0] = "Monitor";
		    options [1] = "Graphics Processing Unit";
		    options [2] = "Display Screen";
		    options [3] = "Printer";
		}
		else if (question [x] == 33) //check!
		{
		    options [0] = "RAM";
		    options [1] = "Floppy Disk";
		    options [2] = "USB";
		    options [3] = "ROM";
		}
		else if (question [x] == 34)
		{
		    options [0] = "GPU";
		    options [1] = "CPU";
		    options [2] = "CD-RW";
		    options [3] = "Visuals Microprocessor";
		}
		else if (question [x] == 35) //A/An ____________ is a socket on the motherboard that expansion cards plug into.
		{
		    c.drawString ((x + 1) + ". " + question (34).substring (0, 63), 110, 205);
		    c.drawString (question (34).substring (64), 125, 230);
		    options [0] = "Expansion Slot";
		    options [1] = "CPU";
		    options [2] = "Arithmetic Logic Unit";
		    options [3] = "Hard Drive";
		}

		else if (question [x] == 36) //A chip made of millions of microscopic transistors, referred to as the 'brains' of the computer.
		{
		    c.drawString ((x + 1) + ". " + question (35).substring (0, 66), 110, 205);
		    c.drawString (question (35).substring (67), 125, 230);
		    options [0] = "CPU";
		    options [1] = "Desktop";
		    options [2] = "Expansion Cards";
		    options [3] = "Optical Disc Drive";
		}

		else if (question [x] == 37) //A/An ____________ uses laser light or electromagnetic waves to read or write data to CDs, DVDs, or Blu-ray discs.
		{
		    c.drawString ((x + 1) + ". " + question (36).substring (0, 62), 110, 205);
		    c.drawString (question (36).substring (63), 125, 230);
		    options [0] = "Optical Disc Drive";
		    options [1] = "CD-ROM";
		    options [2] = "CD-RAM";
		    options [3] = "Floppy Disk Writer";
		}
		else if (question [x] == 38) //A type of non-volatile memory used in computers and other electronic devices.
		{
		    c.drawString ((x + 1) + ". " + question (37).substring (0, 57), 110, 205);
		    c.drawString (question (37).substring (58), 125, 230);
		    options [0] = "ROM";
		    options [1] = "RAM";
		    options [2] = "BIOS";
		    options [3] = "Hardware Memory";
		}
		else if (question [x] == 39) //Non-volatile firmware used to perform hardware initialization during the booting process, and to provide runtime services for operating systems and programs.
		{
		    c.drawString ((x + 1) + ". " + question (38).substring (0, 61), 110, 205);
		    c.drawString (question (38).substring (62, 125), 125, 230);
		    c.drawString (question (38).substring (126), 125, 255);
		    options [0] = "BIOS";
		    options [1] = "Booting Software";
		    options [2] = "Solid State Drive";
		    options [3] = "RAM";
		}

		else if (question [x] == 40) //Converts mains AC to low-voltage regulated DC power for the internal components of a computer.
		{
		    c.drawString ((x + 1) + ". " + question (39).substring (0, 55), 110, 205);
		    c.drawString (question (39).substring (56), 125, 230);
		    options [0] = "Power Supply Unit";
		    options [1] = "Fiber Optic Cable";
		    options [2] = "Energy Convertor";
		    options [3] = "AC/DC Transistor";
		}
		else if (question [x] == 41) //Holds together many of the crucial components of a computer, including the central processing unit (CPU), memory and connectors for input and output devices.
		{
		    c.drawString ((x + 1) + ". " + question (40).substring (0, 60), 110, 205);
		    c.drawString (question (40).substring (61, 127), 125, 230);
		    c.drawString (question (40).substring (128), 125, 255);
		    options [0] = "Motherboard";
		    options [1] = "Computer Procesing Unit";
		    options [2] = "Storage Chip";
		    options [3] = "BIOS";
		}
		else if (question [x] == 42) //A cursor control device used in computer games and assistive technology.
		{
		    c.drawString ((x + 1) + ". " + question (41).substring (0, 61), 110, 205);
		    c.drawString (question (41).substring (61), 125, 230);
		    options [0] = "Joystick";
		    options [1] = "Keyboard";
		    options [2] = "Gaming Control Stick";
		    options [3] = "Gaming Mouse";
		}

		else if (question [x] == 43) //The ____________ is located on the motherboard and serves as a four-way intersection connecting the CPU, memory, video card (AGP) bus, and its partner, the south bridge chip.
		{
		    c.drawString ((x + 1) + ". " + question (42).substring (0, 62), 110, 205);
		    c.drawString (question (42).substring (63, 123), 125, 230);
		    c.drawString (question (42).substring (124), 125, 255);
		    options [0] = "Northbridge";
		    options [1] = "Combined Chipset";
		    options [2] = "Motherboard Central Chip";
		    options [3] = "GPU";
		}
		else if (question [x] == 44) //The ____________ is located on the core logic chipset architecture on a PC motherboard and typically implements slower capabilities of the motherboard than its counterpart.
		{
		    c.drawString ((x + 1) + ". " + question (43).substring (0, 71), 110, 205);
		    c.drawString (question (43).substring (72, 138), 125, 230);
		    c.drawString (question (43).substring (139), 125, 255);
		    options [0] = "Southbridge";
		    options [1] = "Northbridge";
		    options [2] = "ALU";
		    options [3] = "Combined Chipset";
		}
		if ((question [x] >= 14) && (question [x] <= 30)) //if statement 13
		{
		    try //try block 2
		    {
			picture = ImageIO.read (new File (image));
			c.drawImage (picture, 340, 230, null);
		    }
		    catch (IOException e)
		    {
		    }
		}
		if (x < 3 || question [x] <= 34) //if statement 14
		{
		    c.drawString ((x + 1) + ". " + question (question [x] - 1), 110, 205);
		    c.drawString ("a)   " + options [option [0]], 120, 235);
		    c.drawString ("b)   " + options [option [1]], 120, 265);
		    c.drawString ("c)   " + options [option [2]], 120, 295);
		    c.drawString ("d)   " + options [option [3]], 120, 325);
		    c.drawString ("Answer: ", 120, 375);
		    c.setCursor (19, 23);
		}
		else if (question [x] >= 35 && question [x] <= 42 && question [x] != 39 && question [x] != 41)
		{
		    c.drawString ("a)   " + options [option [0]], 120, 265);
		    c.drawString ("b)   " + options [option [1]], 120, 295);
		    c.drawString ("c)   " + options [option [2]], 120, 325);
		    c.drawString ("d)   " + options [option [3]], 120, 355);
		    c.drawString ("Answer: ", 120, 395);
		    c.setCursor (20, 23);
		}
		else
		{
		    c.drawString ("a)   " + options [option [0]], 120, 285);
		    c.drawString ("b)   " + options [option [1]], 120, 315);
		    c.drawString ("c)   " + options [option [2]], 120, 345);
		    c.drawString ("d)   " + options [option [3]], 120, 375);
		    c.drawString ("Answer: ", 120, 415);
		    c.setCursor (21, 23);
		}
		answer = c.readLine ();
		c.setColor (darkWhite);
		c.fillRect (558, 260, 12, 170);
		c.setColor (skyBlue);
		c.fillRect (570, 260, 30, 40);
		c.fillRect (40, 270, 30, 30); //in case other parts of the screen get erased
		c.setColor (hillGreen);
		c.fillRect (570, 300, 30, 130);
		c.fillRect (40, 300, 30, 130);
		c.setColor (Color.gray);
		c.fillRect (600, 260, 20, 170);
		c.fillRect (20, 260, 20, 170);
		c.setColor (Color.black);
		c.fillRect (620, 260, 20, 170);
		c.fillRect (0, 260, 20, 170);
		if ((answer.equalsIgnoreCase ("a")) || (answer.equalsIgnoreCase ("b")) || (answer.equalsIgnoreCase ("c")) || (answer.equalsIgnoreCase ("d"))) //if statement 15
		{
		    if (((option [0] == 0) && (answer.equalsIgnoreCase ("a"))) || ((option [1] == 0) && (answer.equalsIgnoreCase ("b"))) || ((option [2] == 0) && (answer.equalsIgnoreCase ("c"))) || ((option [3] == 0) && (answer.equalsIgnoreCase ("d")))) //if statement 16
		    {
			new Message ("Good job! You found the right answer.", "CORRECT!!");
			right++;
			break;
		    }
		    else if (((tries == 2) && (choice == 3)) || ((tries == 1) && (choice == 4)) || (choice == 5))
		    {
			new Message ("Oops! You chose the wrong answer.", "INCORRECT!!");
			wrong++;
			break;
		    }
		    else if (((tries == 1) && (choice == 3)) || ((tries == 0) && (choice == 4)))
		    {
			new Message ("Try again. One chance left!", "Wrong!");
			tries++;
		    }
		    else if ((tries == 0) && (choice == 3))
		    {
			new Message ("Try again. Two chances left!", "Wrong!");
			tries++;
		    }
		}
		else
		{
		    new Message ("Invalid quiz answer. Please enter a, b, c, or d.", "Error.");
		}
	    }
	}
	c.setColor (Color.white);
	c.fillRect (70, 125, 470, 305);
	c.setColor (Color.orange);
	c.setFont (new Font ("Arial", Font.BOLD, 40));
	c.drawString ("CONGRATULATIONS!", 110, 185);
	c.fillStar (120, 205, 45, 45);
	c.fillStar (120, 270, 45, 45);
	c.fillStar (120, 335, 45, 45);
	c.fillStar (470, 205, 45, 45);
	c.fillStar (470, 270, 45, 45);
	c.fillStar (470, 335, 45, 45);
	c.setColor (Color.black);
	c.setFont (new Font ("Arial", 8, 32));
	c.drawString ("YOUR SCORE:", 210, 245);
	c.drawRect (210, 280, 220, 100);
	c.setColor (Color.red);
	c.setFont (new Font ("Arial", Font.BOLD, 85));
	if (scoreCalculate (right) == 100) //if statement 17
	{
	    c.drawString (scoreCalculate (right) + "%", 212, 360);
	}
	else if (scoreCalculate (right) == 0)
	{
	    c.drawString (scoreCalculate (right) + "%", 262, 360);
	}
	else
	{
	    c.drawString (scoreCalculate (right) + "%", 235, 360);
	}
	try //try block 3
	{
	    length = 0;
	    input = new BufferedReader (new FileReader ("scoreList.txt"));
	    while ((line = input.readLine ()) != null) //while loop 5
	    {
		length++;
	    }
	    input = new BufferedReader (new FileReader ("scoreList.txt"));
	    //declaration
	    String[] fileContent = new String [length];
	    for (int x = 0 ; x < length ; x++) //for loop 12
	    {
		fileContent [x] = input.readLine ();
	    }
	    input.close ();
	    output = new PrintWriter (new FileWriter ("scoreList.txt"), true);
	    for (int x = 0 ; x < length ; x++) //for loop 13
	    {
		output.println (fileContent [x]);
	    }
	    output.println (scoreCalculate (right));
	    output.println (level);
	    output.println (name);
	    output.close ();
	}
	catch (IOException e)
	{
	}
	pauseProgram ();
    }


    /* Purpose: This method is used to read from the file questionBank.txt, store it in an array, and return a specific member of that array specified
    in the parameters (int num). Called in public void method quiz().

	       Local Variable Dictionary

	       Name            Type                    Description

	       x               int                     This variable is used in for loop 1 to read lines from the questionBank.txt file.
						       Possible values: 0 - <44
	       questionBank    String[44]              This array stores the contents of the questionBank.txt file.


	       Loop/Conditional Structure              Purpose

	       For Loop 1                              Reads Lines from questionBank.txt.

	       Try Block 1                             Used to read from file and catch IOException.
    */
    private String question (int num)
    {
	//Local Variable Declaration Section
	String[] questionBank = new String [44];
	try //try block 1
	{
	    input = new BufferedReader (new FileReader ("questionBank.txt"));
	    for (int x = 0 ; x < 44 ; x++)
	    {
		questionBank [x] = input.readLine ();
	    }
	    input.close ();
	}
	catch (IOException e)
	{
	}
	return questionBank [num]; //returns array member based on parameters when called
    }


    /* Purpose: This method is used to return the user's percentge score baased on the amount of correct answers. The parameters are int right, which
    is the amount of correct answers. Called in public void method quiz().
    */
    private int scoreCalculate (int right)
    {
	return (right * 10);
    }


    /* Purpose: This method is used to read from the file scoreList.txt, store it into three different arrays, sort the data and display the sorted data.
    If the user chooses to clear the file, it will clear the file.

	    Local Variable Dictionary

	    Name            Type                    Description

	    x               int                     This variable is used in for loop 1 and 2 for drawing clouds in the desktop drawing.
						    It is also used in other for loops to read from the file scoreList.txt.
						    Possible values: 0 - <500
	    i               int                     This variable is used to bubblesort the scores.
						    Possible values: 0 - scores.length
	    j               int                     This variable is used to bubblesort the scores.
						    Possible values: 0 - scores.length
	    sort            int                     This variable temporarily stores values from scores array for bubblesorting.
						    Possible values: scores array
	    sorted          int[]                   This variable is used to store the sorted integer vales of the scores plus the level.
						    Possible values: 1 - 103
	    clear           String                  This variable stores the user input and is used to clear the file or not.
						    Possible values: a, b
	    scores          String[]                This variable is used to store the scores in the file scoreList.txt.
						    Possible values: 0 - 100
	    level           String[]                This variable is used to store the levels in the file scoreList.txt.
						    Possible values: 1 - 3
	    name            String[]                This variable is used to store the names in the file scoreList.txt.
						    Possible values: all

	    Loop/Conditional Structure              Purpose

	    For Loop 1                              Draws top row of clouds on computer desktop.
	    For Loop 2                              Draws bottom row of clouds on computer desktop.
	    For Loop 3                              Draws stars on either side of the scoreboard.
	    For Loop 4                              Used to fill name, level, and scores arrays from scoreList.txt.
	    For Loop 5                              Used to fill sorted array.
	    For Loop 6                              Used to bubblesort sorted array.
	    For Loop 7                              Used to bubblesort sorted array.
	    For Loop 8                              Used to print scoreboard.

	    If Statement 1                          Used to bubble sort scores array.
	    If Statement 2                          Used to print 10 scores on the scoreboard.

	    Try Block 1                             Used to delay the drawing of the open window and instructions text.
	    Try Block 2                             Used to read from file scoreList.txt.
	    Try Block 3                             Used to clear file scoreList.txt.

	    While Loop 1                            Used to count number of lines in scoreList.txt.
	    While Loop 2                            Used to errortrap string clear and breaks if an appropriate user input is entered.
    */
    public void scores ()
    {
	//Local Variable Declaration Section (1)
	String clear = null;
	title ();
	c.setColor (Color.gray);
	c.fillRect (20, 50, 600, 440);
	c.fillRect (280, 490, 100, 30);
	c.setColor (skyBlue);
	c.fillRect (40, 70, 560, 400);
	c.setColor (hillGreen);
	c.fillRect (40, 300, 560, 170);
	c.setColor (Color.black);
	c.fillRect (40, 455, 560, 15);
	c.setColor (Color.white);
	c.fillRect (53, 458, 4, 4);
	c.fillRect (48, 458, 4, 4);
	c.fillRect (53, 463, 4, 4);
	c.fillRect (48, 463, 4, 4);
	c.fillRect (66, 455, 140, 15);
	c.fillRect (581, 459, 11, 8);
	for (int x = 0 ; x <= 500 ; x = x + 200) //for loop 1
	{
	    c.fillOval (530 - x, 100, 35, 35);
	    c.fillOval (505 - x, 100, 35, 35);
	    c.fillOval (490 - x, 117, 35, 35);
	    c.fillOval (515 - x, 117, 35, 35);
	    c.fillOval (545 - x, 117, 35, 35);
	    c.fillOval (530 - x, 135, 35, 35);
	    c.fillOval (505 - x, 135, 35, 35); //cloud
	}
	for (int x = 0 ; x <= 500 ; x = x + 200) //for loop 2
	{
	    c.fillOval (430 - x, 200, 35, 35);
	    c.fillOval (405 - x, 200, 35, 35);
	    c.fillOval (390 - x, 217, 35, 35);
	    c.fillOval (415 - x, 217, 35, 35);
	    c.fillOval (445 - x, 217, 35, 35);
	    c.fillOval (430 - x, 235, 35, 35);
	    c.fillOval (405 - x, 235, 35, 35); //cloud
	}
	c.setFont (smallText);
	c.drawString ("01/6/2019", 474, 466);
	c.drawString ("3:38 PM", 529, 466);
	c.setColor (Color.gray);
	c.fillRect (20, 180, 20, 100);
	c.setColor (Color.black);
	c.drawLine (582, 461, 590, 461);
	c.drawLine (582, 464, 590, 464);
	c.fillRect (0, 180, 20, 100);
	c.setColor (Color.red);
	c.fillRect (55, 95, 33, 33);
	c.setColor (Color.yellow);
	c.fillRect (55, 145, 33, 33);
	c.setColor (Color.green);
	c.fillRect (55, 195, 33, 33);
	try // try block 1
	{
	    sleep (1000);
	}
	catch (Exception e)
	{
	}
	c.setColor (Color.white);
	c.fillRect (70, 95, 500, 335);
	c.setColor (darkWhite);
	c.fillRect (558, 95, 12, 335);
	c.setColor (Color.lightGray);
	c.fillRect (70, 95, 500, 15);
	c.setColor (Color.yellow);
	c.fillRect (206, 455, 19, 15);
	c.setColor (Color.orange);
	c.fillStar (115, 120, 45, 45);
	c.fillStar (475, 120, 45, 45);
	for (int x = 0 ; x < 210 ; x = x + 30) //for loop 3
	{
	    c.fillStar (110, 205 + x, 20, 20);
	    c.fillStar (500, 205 + x, 20, 20);
	}
	c.setColor (Color.red);
	c.fillRect (546, 95, 23, 14);
	c.setColor (Color.white);
	c.drawLine (554, 105, 560, 99);
	c.drawLine (560, 105, 554, 99);
	c.setColor (Color.black);
	c.drawRect (525, 99, 8, 8);
	c.fillRect (525, 98, 9, 2);
	c.fillRect (500, 103, 8, 2);
	c.setColor (Color.darkGray);
	c.setFont (new Font ("Arial", Font.BOLD, 45));
	c.drawString ("High Scores", 187, 162);
	c.fillRect (558, 120, 12, 18);
	c.setFont (new Font ("Arial", Font.BOLD, 14));
	c.drawString ("Name", 155, 195);
	c.drawString ("Level", 300, 195);
	c.drawString ("Score", 440, 195);
	try //try block 2
	{
	    length = 0;
	    input = new BufferedReader (new FileReader ("scoreList.txt"));
	    while ((line = input.readLine ()) != null) //while loop 1
	    {
		length++;
	    }
	    input = new BufferedReader (new FileReader ("scoreList.txt"));
	    //Local Variable Declaration Section
	    String[] scores = new String [(length / 3)];
	    String[] level = new String [(length / 3)];
	    String[] name = new String [(length / 3)];
	    int[] sorted = new int [scores.length];
	    for (int x = 0 ; x < length / 3 ; x++) //for loop 4
	    {
		scores [x] = input.readLine ();
		level [x] = input.readLine ();
		name [x] = input.readLine ();
	    }
	    input.close ();
	    for (int x = 0 ; x < scores.length ; x++) //for loop 5
	    {
		sorted [x] = Integer.parseInt (scores [x]) + Integer.parseInt (level [x]); //fills array sorted with current values - saved or unsaved
	    }
	    for (int i = 0 ; i < scores.length ; i++) //for loop 6 - sorts data
	    {
		for (int j = 0 ; j < scores.length - 1 ; j++) //for loop 7
		{
		    if (sorted [i] > sorted [j]) //if statement 1
		    {
			int sort = sorted [i];
			sorted [i] = sorted [j];
			sorted [j] = sort;
			String nameSort = name [i];
			name [i] = name [j];
			name [j] = nameSort;
			String levelSort = level [i];
			level [i] = level [j];
			level [j] = levelSort;
		    }
		}
	    }
	    c.setFont (smallText);
	    c.setColor (Color.black);
	    for (int i = 0 ; i < scores.length ; i++)  //for loop 8 - prints sorted data
	    {
		if (i < 10) //if statement 2
		{
		    c.drawString (name [i], 155, 220 + (i * 20));
		    c.drawString (level [i], 317, 220 + (i * 20));
		    c.drawString ("" + (sorted [i] - (sorted [i] % 10)), 450, 220 + (i * 20));
		}
	    }
	}
	catch (IOException e)
	{
	}
	pauseProgram ();
	while (true) //while loop 2
	{
	    try // try block 3
	    {
		title ();
		c.println ("Would you like to clear this file?");
		c.println ("a) YES");
		c.println ("b) NO");
		c.print ("Choice: ");
		clear = c.readLine ();
		if (clear.equalsIgnoreCase ("a")) //if statement 3
		{
		    output = new PrintWriter (new FileWriter ("scoreList.txt"));
		    output.close ();
		    break;
		}
		else if (clear.equalsIgnoreCase ("b"))
		{
		    break;
		}
		else
		{
		    new Message ("Invalid option. Please select either A or B.", "Error!");
		}
	    }
	    catch (IOException e)
	    {
	    }
	}
    }


    /* Purpose: This method is used to display a goodbye message to the user and automatically close the console.

	       Loop/Conditional Structure              Purpose

	       For Loop 1                              Draws top row of clouds on computer desktop.
	       For Loop 2                              Draws bottom row of clouds on computer desktop.
	       For Loop 3                              Draws top row of clouds on computer desktop.
	       For Loop 4                              Draws bottom row of clouds on computer desktop.

	       Try Block 1                             Used to delay the erasing of the window on the desktop.
	       Try Block 2                             Used to delay closing of console.
    */
    public void goodbye ()
    {
	title ();
	c.setColor (Color.gray);
	c.fillRect (20, 50, 600, 440);
	c.fillRect (280, 490, 100, 30);
	c.setColor (skyBlue);
	c.fillRect (40, 70, 560, 400);
	c.setColor (hillGreen);
	c.fillRect (40, 300, 560, 170);
	c.setColor (Color.black);
	c.fillRect (40, 455, 560, 15);
	c.setColor (Color.white);
	c.fillRect (53, 458, 4, 4);
	c.fillRect (48, 458, 4, 4);
	c.fillRect (53, 463, 4, 4);
	c.fillRect (48, 463, 4, 4);
	c.fillRect (66, 455, 140, 15);
	c.fillRect (581, 459, 11, 8);
	for (int x = 0 ; x <= 500 ; x = x + 200) //for loop 1
	{
	    c.fillOval (530 - x, 100, 35, 35);
	    c.fillOval (505 - x, 100, 35, 35);
	    c.fillOval (490 - x, 117, 35, 35);
	    c.fillOval (515 - x, 117, 35, 35);
	    c.fillOval (545 - x, 117, 35, 35);
	    c.fillOval (530 - x, 135, 35, 35);
	    c.fillOval (505 - x, 135, 35, 35); //cloud
	}
	for (int x = 0 ; x <= 500 ; x = x + 200) //for loop 2
	{
	    c.fillOval (430 - x, 200, 35, 35);
	    c.fillOval (405 - x, 200, 35, 35);
	    c.fillOval (390 - x, 217, 35, 35);
	    c.fillOval (415 - x, 217, 35, 35);
	    c.fillOval (445 - x, 217, 35, 35);
	    c.fillOval (430 - x, 235, 35, 35);
	    c.fillOval (405 - x, 235, 35, 35); //cloud
	}
	c.setFont (smallText);
	c.drawString ("01/6/2019", 474, 466);
	c.drawString ("3:38 PM", 529, 466);
	c.setColor (Color.gray);
	c.fillRect (20, 180, 20, 100);
	c.setColor (Color.black);
	c.drawLine (582, 461, 590, 461);
	c.drawLine (582, 464, 590, 464);
	c.fillRect (0, 180, 20, 100);
	c.setColor (Color.red);
	c.fillRect (55, 95, 33, 33);
	c.setColor (Color.yellow);
	c.fillRect (55, 145, 33, 33);
	c.setColor (Color.green);
	c.fillRect (55, 195, 33, 33);
	c.setColor (Color.white);
	c.fillRect (70, 95, 500, 335);
	c.setColor (darkWhite);
	c.fillRect (558, 95, 12, 335);
	c.setColor (Color.lightGray);
	c.fillRect (70, 95, 500, 15);
	c.fillOval (100, 350, 22, 27);
	c.fillRect (180, 350, 100, 33);
	c.fillRect (350, 350, 80, 50);
	c.fillRect (382, 400, 20, 12);
	c.fillRect (375, 412, 34, 3);
	c.drawArc (490, 350, 40, 50, 0, 180);
	c.fillOval (488, 370, 12, 18);
	c.fillOval (521, 370, 12, 18);
	c.setColor (Color.green);
	c.fillRect (206, 455, 19, 15);
	c.setColor (Color.red);
	c.fillRect (546, 95, 23, 14); //20 y= 15
	c.setColor (Color.white);
	c.drawLine (554, 105, 560, 99);
	c.drawLine (560, 105, 554, 99);
	c.setColor (Color.black);
	c.drawRect (525, 99, 8, 8);
	c.fillRect (525, 98, 9, 2);
	c.fillRect (500, 103, 8, 2);
	c.setColor (Color.blue);
	c.fillRect (355, 355, 70, 40); //desktop
	c.setColor (Color.darkGray);
	c.fillRect (102, 359, 18, 2);
	c.fillRect (110, 352, 2, 7);
	c.drawLine (187, 356, 272, 356);
	c.drawLine (187, 361, 272, 361);
	c.drawLine (187, 366, 272, 366);
	c.drawLine (187, 371, 272, 371);
	c.drawLine (187, 376, 272, 376);
	c.fillOval (490, 375, 2, 10); //headphone black portion
	c.fillOval (529, 375, 2, 10); //headphone black portion
	c.setFont (new Font ("Arial", 1, 88));
	c.drawString ("Good Bye!", 95, 240);
	c.fillRect (558, 120, 12, 18);
	c.setFont (new Font ("Arial", 1, 12));
	c.drawString ("Thanks for using this program to learn and test yourself on computer hardware!", 90, 285);
	c.drawString ("By: Uroosa Imtiaz", 270, 315);
	try //try block 1
	{
	    sleep (2500);
	}
	catch (Exception e)
	{
	}
	c.setColor (skyBlue);
	c.fillRect (40, 70, 560, 400);
	c.setColor (hillGreen);
	c.fillRect (40, 300, 560, 170);
	c.setColor (Color.black);
	c.fillRect (40, 455, 560, 15);
	c.setColor (Color.white);
	c.fillRect (53, 458, 4, 4);
	c.fillRect (48, 458, 4, 4);
	c.fillRect (53, 463, 4, 4);
	c.fillRect (48, 463, 4, 4);
	c.fillRect (66, 455, 140, 15);
	c.fillRect (581, 459, 11, 8);
	for (int x = 0 ; x <= 500 ; x = x + 200) //for loop 3
	{
	    c.fillOval (530 - x, 100, 35, 35);
	    c.fillOval (505 - x, 100, 35, 35);
	    c.fillOval (490 - x, 117, 35, 35);
	    c.fillOval (515 - x, 117, 35, 35);
	    c.fillOval (545 - x, 117, 35, 35);
	    c.fillOval (530 - x, 135, 35, 35);
	    c.fillOval (505 - x, 135, 35, 35); //cloud
	}
	for (int x = 0 ; x <= 500 ; x = x + 200) //foor loop 4
	{
	    c.fillOval (430 - x, 200, 35, 35);
	    c.fillOval (405 - x, 200, 35, 35);
	    c.fillOval (390 - x, 217, 35, 35);
	    c.fillOval (415 - x, 217, 35, 35);
	    c.fillOval (445 - x, 217, 35, 35);
	    c.fillOval (430 - x, 235, 35, 35);
	    c.fillOval (405 - x, 235, 35, 35); //cloud
	}
	c.setColor (Color.gray);
	c.fillRect (20, 180, 20, 100);
	c.setColor (Color.black);
	c.drawLine (582, 461, 590, 461);
	c.drawLine (582, 464, 590, 464);
	c.fillRect (0, 180, 20, 100);
	c.setColor (Color.red);
	c.fillRect (55, 95, 33, 33);
	c.setColor (Color.yellow);
	c.fillRect (55, 145, 33, 33);
	c.setColor (Color.green);
	c.fillRect (55, 195, 33, 33);
	try ///try block 2
	{
	    sleep (1500);
	}
	catch (Exception e)
	{
	}
	c.close ();
    }


    /* Purpose: This method is used to keep messages on screen when it is called until the user clicks a key on the keyboard.
    */
    public void pauseProgram ()
    {
	c.setColor (Color.white);
	c.setFont (defaultFont);
	c.drawString ("Press any key to continue...", 440, 510);
	c.getChar ();
    }


    /* Purpose: This method is used to clear the screen and draw the title at the beginning of each method.
    */
    private void title ()
    {
	c.setTextBackgroundColor (Color.black);
	c.clear ();
	c.setColor (Color.white);
	c.setTextColor (Color.white);
	c.setFont (defaultFont);
	c.drawString ("Computer Hardware Learning Quiz", 205, 30);
    }


    /* Purpose: This method is used to initialize the object of a class so the program can execute and give a size/title to the output console.
    */
    public quizGame ()
    {
	c = new Console (26, 80, "Computer Hardware Learning Quiz"); //constructs class
    }


    /* Purpose: This method is used to call all the methods in the program so they execute in a specific order.

       Local Variable Dictionary

       Name            Type                    Description

       m               Console                 This variable is used to create an instance of the quizGame Class

       While Loop Purpose: Will execute program continuously until exit is selected in main menu. Only once it is exited goodbye is called.

       If Statement Purpose: Will exit loop if 7 is selected, open instructions if 1 is selected, open teaching portion if 2 is selected, open quiz if 3, 4
			     or 5 is selected, and open scoreboard if 6 is selected.
    */
    public static void main (String[] args)
    {
	quizGame m;
	m = new quizGame ();
	m.splashScreen ();
	while (true) //while loop
	{
	    m.mainMenu ();
	    if (m.choice == 1) //if statement
	    {
		m.instructions ();
	    }
	    else if (m.choice == 2)
	    {
		m.learnHardware ();
	    }
	    else if (m.choice >= 3 && m.choice <= 5)
	    {
		m.quiz ();
	    }
	    else if (m.choice == 6)
	    {
		m.scores ();
	    }
	    else
	    {
		break;
	    }
	}
	m.goodbye ();
    } // main method
} // quizGame Class

/* Refrences:
https://en.wikipedia.org/wiki/Solid-state_drive
https://en.wikipedia.org/wiki/Hard_disk_drive
https://en.wikipedia.org/wiki/Power_supply_unit_(computer)
https://en.wikipedia.org/wiki/Northbridge_(computing)
https://en.wikipedia.org/wiki/Southbridge_(computing)
https://en.wikipedia.org/wiki/Expansion_card
https://en.wikipedia.org/wiki/Central_processing_unit
https://www.pcmag.com/encyclopedia/term/43886/gpu
https://en.wikipedia.org/wiki/Random-access_memory
https://en.wikipedia.org/wiki/Read-only_memory
https://www.computerhope.com/issues/ch001361.htm
https://www.computerhope.com/issues/ch001355.htm
*/
