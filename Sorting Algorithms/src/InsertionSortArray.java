/**
 * Lab Session C (based on source code by Charles Hoot)
 * Class for sorting an array of Comparable objects from smallest to
 * largest using the Insertion Sort algorithm.
 */

public class InsertionSortArray {

    /**************************************************************
     * ITERATIVE INSERTION SORT
     **************************************************************/

    /** Sorts the first n objects in an array into ascending order.
     * This initial method is a wrapper for the actual insertionSort method.
     * @param arr An array of Comparable objects.
     * @param n An integer > 0.
     */
    public static <T extends Comparable<? super T>>
    void insertionSort(T[] arr, int n)
    {
        // Invoke the insertionSort algorithm:
        insertionSort(arr, 0, n-1);
    }

    /** Sorts the first n objects in an array into ascending order.
     * @param arr An array of Comparable objects.
     * @param first An integer >= 0.
     * @param last An integer > first and < arr.length.
     */
    private static <T extends Comparable<? super T>>
    void insertionSort(T[] arr, int first, int last) {

        // Variable to hold object that is next to be inserted:
        T nextToInsert;

        //Loop through the array, insert each unsorted item in order:
        for (int unsorted = first + 1; unsorted <= last; unsorted++) {

            // TODO: Get the next item (nextToInsert) in the unsorted array to be inserted:
            nextToInsert = arr[unsorted];

            // TODO: Insert the (next) item in order into the array (between first and unsorted-1):
            insertInOrder(nextToInsert, arr, first, unsorted-1);

            // TODO: Output the current state of the array:
            ArrayUtil.displayArrayContent(arr);
        }
    }


    /** Private helper method to insert anEntry into the sorted entries in a portion of the
     *  sorted array arr[begin] through arr[end].
     * @param anEntry The entry to be inserted into the sorted portion of the array.
     * @param arr An array of Comparable objects.
     * @param begin An integer >= 0 and < arr.length.
     * @param end An integer > first and < arr.length.
     */
    private static <T extends Comparable<? super T>>
    void insertInOrder(T anEntry, T[] arr, int begin, int end) {

        //Index of the last entry in the sorted portion of array:
        int index = end;

        // Insert the entry into the appropriate position in the array.
        // Shift (make room), if necessary, in the sorted portion of the array for the entry.
        // TODO: replace the false part of the conditional clause with the appropriate comparison
        // TODO: using compareTo method from Comparable:
        while ((index >= begin) && (anEntry.compareTo(arr[index]) <= 0)) {

            // Shift (make room) to the right of the current index for the entry:
            arr[index + 1] = arr[index];

            // Decrement the index:
            index--;
        }

        // Insert the entry into the array:
        arr[index + 1] = anEntry;

    }


    /**************************************************************
     * RECURSIVE INSERTION SORT WITH A RECURSIVE INSERT
     **************************************************************/

    /** Sorts the first n objects in an array into ascending order.
     * @param arr An array of Comparable objects.
     * @param n An integer > 0.
     */
    public static <T extends Comparable<? super T>>
    void insertionSortRecursive(T[] arr, int n)
    {
        // TODO: Invoke the insertionSortRecursive algorithm:
        insertionSortRecursive(arr, 0, n-1);
    }


    /** Recursively sorts the objects in a range of locations in an array into ascending order.
     * @param arr An array of Comparable objects.
     * @param first An integer > 0 and < arr.length.
     * @param last An integer > first and < arr.length.
     */
    private static <T extends Comparable<? super T>>
    void insertionSortRecursive(T[] arr, int first, int last)
    {
        if (first < last)
        {
            // TODO: Invoke insertion sort to sort all but the last entry (first, last -1):
            insertionSortRecursive(arr, first, last-1);

            // TODO: Insert the last entry into the array in sorted order (between first and last-1):
            insertInOrderRecursive(arr[last], arr, first, last-1);

            // TODO: Output the current state of the array:
            ArrayUtil.displayArrayContent(arr);

        }
    }


    /** Recursively insert a value into its correct location
     * @param anEntry The item to insert.
     * @param arr An array of Comparable objects.
     * @param begin An integer >= 0 that is the index of the first
     * array entry to consider.
     * @param end An integer >= 0 that is the index of the last
     * array entry to consider.
     */
    private static <T extends Comparable<? super T>>
    void insertInOrderRecursive(T anEntry, T[] arr, int begin, int end)
    {
        // Inserts entry into the sorted array entry's a[first] through a[last].
        // TODO: Compare the entry with the last entry in the current array.
        // TODO: replace the conditional (true) using compareTo method from Comparable:
        if (anEntry.compareTo(arr[end]) >= 0) {

            // Entry is greater than or equal to the last entry in the array.
            // TODO: Insert the entry into the array after the last entry (end + 1):
            arr[end + 1] = anEntry;

        } else if (begin < end) {

            // Entry less than the last entry in the array AND index of the first entry
            // is less than the index of the last entry (to consider).
            // Shift (make room) to the right of the current index for the last entry
            // and assign the last entry to the newly (shifted) position in the array:
            arr[end + 1] = arr[end];

            // TODO: Make recursive call on insertInOrderRecursive method
            // TODO: to insert the entry into the array (smaller problem with end-1):
            insertInOrderRecursive(anEntry, arr, begin, end-1);

        } else {

            // Entry less than the last entry in the array AND index of the first entry
            // is equal to the index of the last entry (to consider).
            // Shift (make room) to the right of the current index for the last entry
            // and assign the last entry to the newly (shifted) position in the array:
            arr[end + 1] = arr[end];

            // Insert the entry into the array at position of the last entry:
            arr[end] = anEntry;
        }
    }
}

