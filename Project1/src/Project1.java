/**
 * Author: Matt Rutherford, Jonathan Boothroyd, Nathan Gamble
 * Course: COP2551
 * Project #: 1
 * Title : Unit Conversion Tool
 * Due Date: 9/13/13
 *
 */

import java.util.Scanner;

/**
 * Converts from original to metric
 *
 */

public class Project1 {




    public static void main(String[] args)
    {
       //declares variables for temp, distance, and weight
       int temp;
       int distance;
       int weight;
       double celsius, meters, kilos;

       //Displays Names of Authors and Project, \n is an escape character for a new line
       System.out.println("Matt Rutherford, Jonathan Boothroyd, Nathan Gamble");
       System.out.println("Project 1- Unit Conversion Tool\n");


        //Gets input from keyboard
        Scanner scan = new Scanner (System.in);
        System.out.print("Enter a temperature in Farenheit: ");
        temp= scan.nextInt();
        System.out.print("Enter a distance in feet: ");
        distance=scan.nextInt();
        System.out.print("Enter a weight in pounds: ");
        weight=scan.nextInt();

        //Prints blank line
        System.out.println("");

        //Calculates and then displays results
        celsius= (temp -32) * 5/9;
        System.out.println (temp + " Fahrenheit is " + celsius +" Celsius");

        meters= (distance*0.3048);
        System.out.println (distance + " Feet is  " + meters+ " Meters");

        kilos= (weight*0.4536);
        System.out.println (weight+ " Pounds is " + kilos + " Kilograms");


    }

} 