/*
 * The Binary Search program
 *
 * @author  Liam Fletcher
 * @version 1.0
 * @since   2021-12-01
 */

import java.util.Scanner;
import java.util.Random;

public final class BinarySearch {
    private BinarySearch() {}
    /**
     * the number two hundred and fifty.
     */
    public static final int THF = 100;
    /**
     * the number 999.
     */
    public static final int NNN = 999;
    /**
     * This function uses binary search 
     * @param userArray
     * @param userNumber
     * @param lowIndex
     * @param highIndex
     * @return
     * returns search
     */
    static String binarySearch(final int[] userArray, final int userNumber,
        final int lowIndex, final int highIndex) {
        if (lowIndex > highIndex) {
            return "-1";
        } else {
            int middleIndex = (int) Math.floor((lowIndex + highIndex) / 2);

            // Searching for number in array 
            if (userArray[middleIndex] < userNumber) {
                return binarySearch(userArray, userNumber, middleIndex + 1, highIndex);
            } else if (userArray[middleIndex] > userNumber) {
                return binarySearch(userArray, userNumber, lowIndex, middleIndex - 1);
            } else {
                String answer = Integer.toString(middleIndex);
                return answer;
            }
        }
    }

    /**
     * This function sorts an array 
     * @return
     * returns array
     * @param array
     */
    static int[] sort(final int[] array) {
        // Sorting the array
        for (int arrayCounter = 0; arrayCounter < array.length; arrayCounter++) {
            for (int sortCounter = arrayCounter + 1; sortCounter < array.length; sortCounter++) {
                if (array[arrayCounter] > array[sortCounter]) {
                    int swapNumber = array[sortCounter];
                    array[sortCounter] = array[arrayCounter];
                    array[arrayCounter] = swapNumber;
                }
            }
        }
        return array;
    }

    /**
     * This function allows the user to search a list of 100 numbers 
     * @param args
     */
    public static void main(final String[] args) {
        try {
            Random randNumber = new Random();
            int[] randomNumberArray = new int[THF];

            for (int counter = 0; counter < randomNumberArray.length; counter++) {
                randomNumberArray[counter] = randNumber.nextInt(NNN) + 1;
            }

            int[] numberArray = sort(randomNumberArray);

            // Input
            Scanner userInput = new Scanner(System.in);
            System.out.print("What number are you searching for in the array");
            System.out.print(" (integer between 0 and 999): ");
            int searchNumber = userInput.nextInt();
            System.out.println();

            if (searchNumber > NNN || searchNumber < 0) {
                throw new Exception();
            } else {

                String printList = "Sorted like of numbers: ";
                for (int printCounter = 0; printCounter < numberArray.length; printCounter++) {
                    printList = printList + numberArray[printCounter] + ", ";
                }
                System.out.println(printList);


                String searchResult = binarySearch(numberArray, searchNumber,
                    0, numberArray.length - 1);

                // Output
                System.out.println();
                System.out.println("Your number is in index: " + searchResult);
            }

            // Catches 
        } catch (Exception e) {
            System.out.println();
            System.out.println("Invalid Input");
        }
    }
}
