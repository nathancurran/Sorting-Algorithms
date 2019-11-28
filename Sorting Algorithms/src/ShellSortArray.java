/**
 * Lab Session C (based on source code by Charles Hoot)
 * Class for sorting an array of Comparable objects from smallest to
 * largest using the Shell Sort algorithm.
 */

public class ShellSortArray {

    /** Sorts the first n objects in an array into ascending order.
     * This initial method is a wrapper for the actual shellSort method.
     * @param arr An array of Comparable objects.
     * @param n An integer > 0.
     */
    public static <T extends Comparable<? super T>>
    void shellSort(T[] arr, int n)
    {
        // Invoke the shellSort algorithm:
        shellSort(arr, 0, n-1);
    }


    /** Sorts the first n objects in an array into ascending order.
     * Use incremental insertion sort with different increments to
     * sort a range of values in the array.
     * @param arr An array of Comparable objects.
     * @param first An integer >= 0.
     * @param last An integer > first and < arr.length.
     */
    private static <T extends Comparable<? super T>>
    void shellSort(T[] arr, int first, int last) {

        // Size of the array (number of array entries):
        int n = last - first + 1;

        // TODO: Determine the interval (gap/space) to use.
        // TODO: For this example the interval should be half of the size of the array:
        int interval = n/2;

        // Perform the interval-based insertion sort:
        while (interval > 0) {

            for (int begin = first; begin < first + interval; begin++) {

                // TODO: Invoke incrementalInsertionSort method to move the element.
                // TODO: Note the arguments that must be passed to the incrementalInsertionSort method:
                incrementalInsertionSort(arr, first, last, interval);

                // TODO: Display the current state of the array:
                ArrayUtil.displayArrayContent(arr);
            }

            // TODO: Recalculate the interval (halve the value of interval):
            interval = interval/2;
        }
    }


    /** Sorts equally spaced entries of an array into ascending order.
     @param arr An array of Comparable objects.
     @param first The integer index of the first array entry to
     consider; first >= 0 and < arr.length.
     @param last The integer index of the last array entry to
     consider; last >= first and < arr.length.
     @param interval the difference between the indices of the
     entries to sort.
     */
    private static <T extends Comparable<? super T>>
    void incrementalInsertionSort(T[] arr, int first, int last, int interval) {
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
            while ((index >= first) && (nextToInsert.compareTo(arr[index]) < 0)){

                // Shift (make room) to the right of the current index + interval for the current item:
                arr[index + interval] = arr[index];

                // Decrement the index by the interval:
                index = index - interval;
            }

            // Insert the entry into the array:
            arr[index + interval] = nextToInsert;
        }
    }
}

