package edu.guilford;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class CarSort {
    public static void main(String[] args) {
        // Create an array of 'n' cars (user input)
        Scanner input = new Scanner(System.in);
        System.out.println("How many cars would you like to generate?");
        int n = input.nextInt();
        // Create an array of 'n' cars
        Car[] cars = new Car[n];
        // Populate the array with 'n' cars
        for (int i = 0; i < n; i++) {
            cars[i] = new Car();
        }
        // Print the array of cars (unsorted)
        // System.out.println("Here are the cars (unsorted):");
        // for (int i = 0; i < n; i++) {
        // System.out.println(cars[i]);
        // }

        // Sort the array of cars by mileage
        // Create an array of integers to hold the mileage values
        int[] mileage = new int[n];
        // Populate the array of integers with the mileage values
        for (int i = 0; i < n; i++) {
            mileage[i] = cars[i].getMileage();
        }

        // Shuffle the array of integers
        shuffle(mileage); // this shuffle is redudnant, but it's here for the sake of consistency

        // Print the array of integers (unsorted)
        // System.out.println("\nHere are the mileage values (unsorted):");
        // System.out.println(showData(mileage));

        // Time how long it takes to sort the array using selection sort (O(n^2))
        long startTimeSS = System.nanoTime();

        // Sort the array of integers
        SortAndSearch.selectionSort(mileage);

        // Get the end time
        long endTimeSS = System.nanoTime();

        // Calculate the elapsed time in milliseconds and print out
        long elapsedTimeSS = endTimeSS - startTimeSS;
        System.out.println("\nSelection sort took " + (elapsedTimeSS / 1.e6) + " milliseconds. (Data was shuffled.)");

        // Print the sorted array of integers
        // System.out.println("Here are the mileage values (sorted using selection sort
        // (O(n^2))):");
        // System.out.println(showData(mileage));

        // Shuffle the array, then sort it again using quicksort (O(log2n))
        shuffle(mileage);

        long startTimeQS = System.nanoTime();
        SortAndSearch.quickSort(mileage, 0, mileage.length - 1);
        long endTimeQS = System.nanoTime();
        long elapsedTimeQS = endTimeQS - startTimeQS;
        System.out.println("\nQuicksort took " + (elapsedTimeQS / 1.e6) + " milliseconds. (Data was shuffled.)");

        // Print the sorted array of integers
        // System.out.println("Here are the mileage values (sorted using quicksort
        // (O(log2n))):");
        // System.out.println(showData(mileage));

        shuffle(mileage);

        // Time how long it takes to find values in the array using linear search and
        // binary search

        // Get a random value from the array
        int randomValue = mileage[(int) (Math.random() * mileage.length)];

        // Time how long it takes to find the random value using linear search
        long startTimeLS = System.nanoTime();
        int indexLS = SortAndSearch.linearSearch(mileage, randomValue);
        long endTimeLS = System.nanoTime();
        long elapsedTimeLS = endTimeLS - startTimeLS;
        System.out.println("\nLinear search took " + (elapsedTimeLS / 1.e6) + " milliseconds. (Data was shuffled.))");

        // Time how long it takes to find the random value using binary search
        long startTimeBS = System.nanoTime();
        int indexBS = SortAndSearch.binarySearch(mileage, randomValue);
        long endTimeBS = System.nanoTime();
        long elapsedTimeBS = endTimeBS - startTimeBS;
        System.out.println("Binary search took " + (elapsedTimeBS / 1.e6) + " milliseconds. (Data was shuffled.)");

        SortAndSearch.quickSort(mileage, 0, mileage.length - 1);

        // Time how long it takes to find values in the array using linear search and
        // binary search

        // Get a random value from the array
        randomValue = mileage[(int) (Math.random() * mileage.length)];

        // Time how long it takes to find the random value using linear search
        startTimeLS = System.nanoTime();
        indexLS = SortAndSearch.linearSearch(mileage, randomValue);
        endTimeLS = System.nanoTime();
        elapsedTimeLS = endTimeLS - startTimeLS;
        System.out.println(
                "\nLinear search took " + (elapsedTimeLS / 1.e6) + " milliseconds. (Data was already sorted.))");

        // Time how long it takes to find the random value using binary search
        startTimeBS = System.nanoTime();
        indexBS = SortAndSearch.binarySearch(mileage, randomValue);
        endTimeBS = System.nanoTime();
        elapsedTimeBS = endTimeBS - startTimeBS;
        System.out
                .println("Binary search took " + (elapsedTimeBS / 1.e6) + " milliseconds. (Data was already sorted.)");

    }

    // Add a static method to shuffle the array
    public static void shuffle(int[] array) {
        // Loop over all elements in the array
        for (int i = 0; i < array.length; i++) {
            // Generate a random index between 0 and array.length - 1
            int randomIndex = (int) (Math.random() * array.length);
            // Swap the current element with the element at the random index
            swap(array, i, randomIndex);
        }
    }

    // Add a static method to swap to elements in an array
    public static void swap(int[] array, int i, int j) {
        // Store the value of the first element in a temporary variable
        int temp = array[i];
        // Set the value of the first element to the value of the second element
        array[i] = array[j];
        // Set the value of the second element to the value of the first element
        array[j] = temp;
    }

    // Create a method to show the data in an array in a nicely formatted way
    public static String showData(int[] array) {
        // Create a StringBuilder object
        StringBuilder sb = new StringBuilder();
        // Loop over all elements in the array
        for (int i = 0; i < array.length; i++) {
            // Append the current element to the StringBuilder object
            sb.append(array[i]);
            // Append a comma and a space to the StringBuilder object
            sb.append(", ");
        }
        // If there are no more elements in the array, remove the last comma and space
        sb.delete(sb.length() - 2, sb.length());
        // Return the StringBuilder object as a String
        return sb.toString();
    }

}
