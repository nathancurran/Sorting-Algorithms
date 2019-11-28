import java.util.Scanner;

/**
 * Lab Session C (based on source code by Charles Hoot)
 * SortTest Class used to test sorting algorithms
 */

public class SortTest
{
    public static void main(String args[])
    {
        int arraySize;
        Integer dataSelectionSort[];
        Integer dataInsertionSort[];
        Integer dataShellSort[];
        Integer initialArray[];

        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Sort Test Started:");
        System.out.println("Please enter an integer for the size of the array?");

        // Read in an integer value for the array size:
        arraySize = getInt("  The integer value should be greater than or equal to 1: ");

        // Generate an array of data containing randomly generated integers:
        initialArray = ArrayUtil.generateRandomArray(arraySize);
        dataSelectionSort = ArrayUtil.duplicateArray(initialArray);
        dataInsertionSort = ArrayUtil.duplicateArray(initialArray);
        dataShellSort = ArrayUtil.duplicateArray(initialArray);

        // TODO: Use an ArrayUtil method to display the initial unsorted array:
        System.out.println();
        System.out.println("The initial array is: ");
        ArrayUtil.displayArrayContent(initialArray);


        //TODO: Invoke the Selection Sort algorithm on the array:
        System.out.println();
        System.out.println("Sorting using Selection Sort (Recursive): ");
        SelectionSortArray.selectionSortRecursive(dataSelectionSort, arraySize);

        // TODO: Display the sorted array:
        System.out.println();
        System.out.println("The sorted array is: ");
        ArrayUtil.displayArrayContent(dataSelectionSort);

        System.out.println("Selection Sort Test Ended");
        System.out.println("-------------------------------------------------------------------------------");

        //TODO: Invoke the Insertion Sort algorithm on the array:
        System.out.println();
        System.out.println("Sorting using Insertion Sort (Recursive): ");
        InsertionSortArray.insertionSortRecursive(dataInsertionSort, arraySize);

        // TODO: Display the sorted array:
        System.out.println();
        System.out.println("The sorted array is: ");
        ArrayUtil.displayArrayContent(dataInsertionSort);

        System.out.println("Insertion Sort Test Ended");
        System.out.println("-------------------------------------------------------------------------------");

        //TODO: Invoke the Shell Sort algorithm on the array:
        System.out.println();
        System.out.println("Sorting using Shell Sort (Iterative): ");
        ShellSortArray.shellSort(dataShellSort, arraySize);

        // TODO: Display the sorted array:
        System.out.println();
        System.out.println("The sorted array is: ");
        ArrayUtil.displayArrayContent(dataShellSort);

        System.out.println("Shell Sort Test Ended");
        System.out.println("-------------------------------------------------------------------------------");

    }

    /**
     * Private method to get an integer value from user input
     * @return An integer.
     */
    private static int getInt(String rangePrompt)
    {
        Scanner input;

        // Integer with a default value of 10:
        int nResult = 10;

        // Wrap attempt to read from input in a try-catch block
        // so as to handle any exceptions that may arise:
        try {
            input = new Scanner(System.in);
            System.out.println(rangePrompt);
            nResult = input.nextInt();
        }
        catch(NumberFormatException e) {
            System.out.println("Warning: could not convert input to an integer");
            System.out.println(e.getMessage());
            System.out.println("Warning: will use 10 as the default value");
        }
        catch(Exception e) {
            System.out.println("Warning: there was an error with System.in");
            System.out.println(e.getMessage());
            System.out.println("Warning: will use 10 as the default value");
        }
        return nResult;
    }

}

