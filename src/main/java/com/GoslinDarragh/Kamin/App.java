package com.GoslinDarragh.Kamin;


import java.util.Date;
import java.util.Scanner;
/*****************************************************************
*
* Date: 2017
* @author COR
*
*
* The purpose of this application is to provide an example for the following:
*
* - Demonstrates the use of development tools : GIT, MAVEN, Eclipse
* - Demonstrates how to use Eclipse
* - Provides a refresher of OOP in Java
* - Provide an introduction to project file structure layout - MAVEN Archetype
*
*****************************************************************/
public class App
{
public static void main( String[] args )
{
// To view the arguments being entered
seeCommandlineInput(args);
// To instantiate App class based in the parameters entered at the commandline
actionCommandlineInput(args);
}
// DATA
//............................................................
//define attributes
private Scanner someInput;
private Date today;
// CONSTRUCTORS
//............................................................
public App()
{
this.someInput = new Scanner(System.in);
//do something here
System.out.println(" \n Soon ... stuff will happen here");
//pause before exit (this is only useful if an error occurs)
System.out.println(" \n Press enter to exit the program");
this.someInput.nextLine();
//close the program without error
System.exit(0);
}
// METHODS used by main() or debug methods - note they are static methods
//............................................................
/**
* action the arguments presented at the command line
* instantiate the App class based on the arguments passed
*/
private static void actionCommandlineInput( String args[] )
{
// no special instantiation yet as don't pass args to it
App anApp = new App();
}
/**
* View the arguments presented at the commandline
* This is for debug and demo purposes
*/
private static void seeCommandlineInput( String args[] )
{
if (args.length == 0)
{
System.out.println("There were no commandline arguments passed!");
}
else
{
// display the command line entered
for(int i = 0; i < args.length; i++)
{
System.out.println(args[i]);
}
}
}
}//EOC