/**
 * Lab Session C (based on source code by Charles Hoot)
 * Class for sorting an array of Comparable objects from smallest to
 * largest using a number of algorithms.
 *
 * Each algorithm incorporates comparison counting statistics.
 * Note: the various sort methods are no longer static so that they can
 * access the private variables of the class.
 */

public class SortArrayInstrumented {

    /**************************************************************
     * COMPARISON STATISTICS
     **************************************************************/

    /**
     * Private variables for the class that will be used to compute statistics.
     */
    private long comparisons;
    private long totalComparisons;
    private long maxComparisons;
    private long minComparisons;

    /**
     * Default constructor for the SortArrayInstrumented class.
     * It will initialize all the variables that hold the statistical information
     */
    public SortArrayInstrumented() {
        // TODO: initialize all the private variables (minComparisons should
        // TODO: be initialized to Long.MAX_VALUE):
        comparisons = 0;
        totalComparisons = 0;
        maxComparisons = 0;
        minComparisons = Long.MAX_VALUE;
    }

    /**
     * Accesor methods for the statistics
     */

    // TODO: Add a public accessor method getTotalComparisons() to return the totalComparisons variable:
    public long getTotalComparisons() {
        return totalComparisons;
    }

    // TODO: Add a public accessor method getMinComparisons() to return the minComparisons variable:
    public long getMinComparisons() {
        return minComparisons;
    }

    // TODO: Add a public accessor method getMaxComparisons() to return the maxComparisons variable:
    public long getMaxComparisons() {
        return maxComparisons;
    }


    /**
     * Method to start collecting data:
     */
    // TODO: Add a private method startStatistics that sets comparison to 0:
    private void startStatistics() {
        comparisons = 0;
    }


    /**
     * Method to stop collecting data and compute the resulting
     * statistics.
     */
    // TODO: Add a private method endStatistics that generates the values for
    // TODO: the variables totalComparisons, minComparisons and maxComparisons:
    private void endStatistics() {
        // adds to the total comparisons counter
        totalComparisons += comparisons;

        // set the minComparisons to the variable with the least
        if (comparisons < minComparisons) {
            minComparisons = comparisons;
        }

        // set the maxComparisons to the variable with the most
        if (comparisons > maxComparisons) {
            maxComparisons = comparisons;
        }

    }

    /**************************************************************
     * SORTING ALGORITHMS
     **************************************************************/

    // TODO: Add sorting algorithms here:
    /**************************************************************
     * SHELL SORT ALGORITHM
     **************************************************************/

    /**
     * Sorts the first n objects in an array into ascending order.
     * This initial method is a wrapper for the actual shellSort method.
     *
     * @param arr An array of Comparable objects.
     * @param n   An integer > 0.
     */
    public <T extends Comparable<? super T>>
    void shellSort(T[] arr, int n) {
        startStatistics();

        // Invoke the shellSort algorithm:
        shellSort(arr, 0, n - 1);

        endStatistics();
    }


    /**
     * Sorts the first n objects in an array into ascending order.
     * Use incremental insertion sort with different increments to
     * sort a range of values in the array.
     *
     * @param arr   An array of Comparable objects.
     * @param first An integer >= 0.
     * @param last  An integer > first and < arr.length.
     */
    private <T extends Comparable<? super T>>
    void shellSort(T[] arr, int first, int last) {

        // Size of the array (number of array entries):
        int n = last - first + 1;

        // TODO: Determine the interval (gap/space) to use.
        // TODO: For this example the interval should be half of the size of the array:
        int interval = n / 2;

        // Perform the interval-based insertion sort:
        while (interval > 0) {

            for (int begin = first; begin < first + interval; begin++) {

                // TODO: Invoke incrementalInsertionSort method to move the element.
                // TODO: Note the arguments that must be passed to the incrementalInsertionSort method:
                incrementalInsertionSort(arr, first, last, interval);

                // TODO: Display the current state of the array:
                //ArrayUtil.displayArrayContent(arr);
            }

            // TODO: Recalculate the interval (halve the value of interval):
            interval = interval / 2;
        }
    }


    /**
     * Sorts equally spaced entries of an array into ascending order.
     *
     * @param arr      An array of Comparable objects.
     * @param first    The integer index of the first array entry to
     *                 consider; first >= 0 and < arr.length.
     * @param last     The integer index of the last array entry to
     *                 consider; last >= first and < arr.length.
     * @param interval the difference between the indices of the
     *                 entries to sort.
     */
    private <T extends Comparable<? super T>>
    void incrementalInsertionSort(T[] arr, int first, int last, int interval) {

        comparisons++;

        int unsorted, index;

        //Loop through the array, insert each unsorted item in order:
        for (unsorted = first + interval; unsorted <= last; unsorted = unsorted + interval) {

            // Get the next item in the unsorted array to be inserted:
            T nextToInsert = arr[unsorted];

            // Set the index to the first entry in the unsorted part of the array (unsorted - interval):
            index = unsorted - interval;

            // Insert the entry into the appropriate position in the array.
            // Shift (make room), if necessary, in the sorted portion of the array for the entry.
            // TODO: replace the false part of the conditional clause with the appropriate comparison
            // TODO: using compareTo method from Comparable:
            while ((index >= first) && (nextToInsert.compareTo(arr[index]) < 0)) {

                // Shift (make room) to the right of the current index + interval for the current item:
                arr[index + interval] = arr[index];

                // Decrement the index by the interval:
                index = index - interval;
            }

            // Insert the entry into the array:
            arr[index + interval] = nextToInsert;

            if (index >= first) {
                comparisons++;
            }
        }
    }
}
