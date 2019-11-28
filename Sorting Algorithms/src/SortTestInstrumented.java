import java.util.Scanner;

/**
 * Lab Session C (based on source code by Charles Hoot)
 * SortTestInstrumented Class is a variation of the SortTest class
 * that is used to test sorting algorithms and generate statistics
 * based on counting the comparison operations during the execution
 * of the sorting algorithm. Uses the SortArrayInstrumented implementation
 * of the sorting algorithms.
 */

public class SortTestInstrumented {

    public static void main(String args[])
    {
        int arraySize;
        int numTrials;
        Integer data[];


        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Shell Sort Test Instrumented Started:");
        System.out.println("Please enter an integer for the size of the array?");

        // Read in an integer value for the array size:
        arraySize = getInt("  The integer value should be greater than or equal to 1: ");

        // Read in an integer value for the number of trials to run:
        System.out.println("How many trials would you like?");
        numTrials = getInt("  It should be an integer value greater than or equal to 1: ");

        // TODO: Instantiate an object (called sai) of the SortArrayInstrumented class:
        SortArrayInstrumented sai = new SortArrayInstrumented();

        // Loop for the number of trials:
        for (int i = 0; i < numTrials; i++) {

            // Generate an array of data containing randomly generated integers:
            data = ArrayUtil.generateRandomArray(arraySize);

            // Use an ArrayUtil method to display the initial unsorted array:
            System.out.println();
            System.out.println("The initial array (Trial = " + (i+1) + ") is: ");
            ArrayUtil.displayArrayContent(data);

            // TODO: Invoke the sort algorithm on the array.
            // TODO: Use the sai object (previously created) to invoke the recursive insertion sort algorithm:
            sai.shellSort(data, arraySize);

            // Display the sorted array:
            System.out.println();
            System.out.println("The shell sorted array (Trial = " + (i+1) + ") is: ");
            ArrayUtil.displayArrayContent(data);

        }

        // TODO: Display the statistics from the trials for the comparisons made.
        // TODO: Need to invoke the appropriate SortArrayInstrumented methods to
        // TODO: return the associated statistics:
        System.out.println("Total comparisons made: " + sai.getTotalComparisons());
        System.out.println("Average comparisons made: " + (sai.getTotalComparisons()/numTrials));
        System.out.println("Minimum comparisons made: " + sai.getMinComparisons());
        System.out.println("Maximum comparisons made: " + sai.getMaxComparisons());

        System.out.println("Shell sort Test Instrumented Ended");
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
