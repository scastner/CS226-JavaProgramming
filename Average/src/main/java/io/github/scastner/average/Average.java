/*
 * Name: Sean Castner
 * Course: CS226 - Java Programming
 * Due Date: April 22, 2020
 */

package io.github.scastner.average;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Average is a small program that uses the Scanner class to retrieve integers as input from
 * the user and calculate the average. Entered values will be printed after all input is complete,
 * along with the calculated average.
 *
 * @author Sean Castner
 */

public class Average {
    // Class variable to hold all input values
    private final ArrayList<Integer> inputs;

    /**
     * Entry point into application
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        Average avg = new Average();
        avg.RequestInputs(6);
        avg.CalculateAndPrintAverage();
    }

    /**
     * Average class constructor which initializes the input list
     */
    public Average() {
        inputs = new ArrayList<>();
    }

    /**
     * Uses the Scanner class to request input integers from the user
     *
     * @param numberOfInputs Number of integers to request from the user
     */
    public void RequestInputs(int numberOfInputs) {
        // Create an instance of the Scanner class using the system input stream
        Scanner scanner = new Scanner(System.in);

        // Print a brief message to instruct the user
        System.out.println("Please enter " + numberOfInputs + " integers");

        // Loop for the numberOfInputs, requesting integer input from the user
        for (int i = 0; i < numberOfInputs; i++) {
            // Print, without a new line, so the cursor is placed after the colon
            System.out.print("Integer " + (i + 1) + ": ");
            // Check if the input is a valid integer
            if (scanner.hasNextInt()) {
                // Retrieve the input value and store it in the list
                inputs.add(scanner.nextInt());
            } else {
                // Let the user know that their last input was invalid
                System.out.println("Invalid input!");
                // Skip the bad input
                scanner.nextLine();
                // Go back to the previous input request and attempt to retrieve valid input again
                i--;
            }
        }
    }

    /**
     * Calculates the average for all input integers and prints the result
     */
    public void CalculateAndPrintAverage() {
        // Sum of all inputs, used to calculate the average
        int sum = 0;

        // Print without a new line
        System.out.print("The average of ");
        // Loop through each input value to print a comma separated list on one line
        for (int i = 0; i < inputs.size(); i++) {
            // Add the input value to the sum
            sum += inputs.get(i);

            // Print the input value
            System.out.print(inputs.get(i).toString());
            if (i < inputs.size() - 2) {
                // Add a comma after printing each value (but not the last 2 that are printed)
                System.out.print(", ");
            } else if (i < inputs.size() - 1) {
                // Add "and" before the last value is printed
                System.out.print(" and ");
            }
        }

        // Calculate and print the average
        System.out.print(" is " + ((double) sum / inputs.size()));
    }
}
