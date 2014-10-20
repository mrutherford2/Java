
/**
 * Author: Matt Rutherford, Jonathan Boothroyd, Nathan Gamble 
 * Course: COP2551 
 * Project #: 2 Title : Unit Conversion Tool
 * Due Date: 10/4/2013
 *
 */


import java.util.Scanner;

/**
 * Converts original measurements and checks for proper input
 *
 */
public class Project2

{
//Global variable declaration

    public static int fahrenheit;
    public static int feet;
    public static int pounds;
    public static double celsius, kelvin, meters, inches, kilograms, stones;

    public static void main(String[] args)
   
    {
        while(true){
        
        //Instatiates class P2
        Project2 P2 = new Project2();
        
        //Displays Authors and Project name
        System.out.println("Matt Rutherford, Jonathan Boothroyd, Nathan Gamble");
        System.out.println("Project 2- Modularized Conversion Tool\n");

        //Calls getInput method
        if(P2.getInput()) {

	System.out.println();

	//Calls performConversion method
	P2.performConversion(fahrenheit, feet, pounds);

	//Calls displayReport method
	P2.displayReport(fahrenheit, feet, pounds, celsius, meters, 
                kilograms, kelvin, inches, stones);
		}
    }
    }
    

    /**
     * Gets input from the user and checks the format Displays error message if 
     * format is incorrect then returns control to main method
     * 
     *
     * @return
     *
     */
    public boolean getInput()
    {
        //Flag variable for valid input
        boolean isValid = false;
        
        //Gets input from the user	
        Scanner scan = new Scanner(System.in);
        //Takes input from user and parses it as an integer
        try
        {
            System.out.print("Enter a temperature in fahrenheit (integer) [0 - 212]: ");
            fahrenheit = Integer.parseInt(scan.next());
            if (validateInput(fahrenheit, 0, 212))
            {
                System.out.print("Enter a distance in feet (integer) [0 - 100]: ");
                feet = Integer.parseInt(scan.next());
                if (validateInput(feet, 0 , 100))
                {
                    System.out.print("Enter a weight in pounds (integer) [0 - 100]: ");
                    pounds = Integer.parseInt(scan.next());
                    if (validateInput(pounds, 0 , 100))
                    {
                        isValid = true;
                    }
                }
                    
            }
        }
        
        //Displays error message and exits if input is invalid
        catch (Exception e)
        {
            System.out.println("The entered value is invalid");
            System.out.println("");
        }

        return isValid;

    }

    /**
     * Validates the range of the input
     *
     * @return
     */
    public boolean validateInput(int input, int minRange, int maxRange)
    {

        boolean withinRange = true;
        //Checks the range of user input

        if (input < minRange || input > maxRange)
        {
            
            withinRange = false;
            System.out.println("Your input was out of range " + minRange + " - " + maxRange);
            System.out.println("");
        }
        
        //Returns boolean for withinRange
        return withinRange;
    }
    /**
     * Performs all conversions
     */
    public void performConversion(int fahrenheit, int feet, int pounds)
    {

        
        convertTemperature(fahrenheit);
       
        convertDistance(feet);
        
        convertWeight(pounds);
        
    }

    /**
     * Converts temperature
     */
    public void convertTemperature(int fahrenheit)
    {
        celsius = (fahrenheit - 32) * 5 / 9;
        kelvin = (fahrenheit + 459.67) * 5 / 9;
    }

    /**
     * Converts distance
     */
    public void convertDistance(int feet)
    {
        meters = (feet * 0.3048);
        inches = (feet * 12);
    }

    /**
     * Converts weight
     */
    public void convertWeight(int pounds)
    {
        kilograms = (pounds * 0.4536);
        stones = (pounds * 0.0714285714);
    }

    /**
     * Displays results from conversions
     */
    public void displayReport(int fahrenheit, int feet, int pounds, double celcius, double meters,
                                     double kilograms, double kelvin, double inches, double stones)
    {
        System.out.println(fahrenheit + " Fahrenheit is " + celsius + " Celsius and " + kelvin + " Kelvin");
        System.out.println(feet + " Feet is  " + meters + " Meters and " + inches + " Inches");
        System.out.println(pounds + " Pounds is " + kilograms + " Kilograms and " + stones + " Stones");
        System.out.println("");
    }
}




