import com.sun.istack.internal.NotNull;

/**
 * Lab Session C (based on source code by Charles Hoot)
 * Class for sorting an array of Comparable objects from smallest to
 * largest using the Selection Sort algorithm.
 */

public class SelectionSortArray {

    /**************************************************************
     * ITERATIVE SELECTION SORT
     **************************************************************/

    /** Sorts the first n objects in an array into ascending order.
     * This initial method is a wrapper for the actual selectionSort method.
     * @param arr An array of Comparable objects.
     * @param n An integer > 0.
     */
    public static <T extends Comparable<? super T>>
    void selectionSort(T[] arr, int n)
    {
        // Invoke the selectionSort algorithm:
        selectionSort(arr, 0, n-1);
    }

    /** Sorts the first n objects in an array into ascending order.
     * @param arr An array of Comparable objects.
     * @param first An integer >= 0.
     * @param last An integer > first and < arr.length.
     */
    private static <T extends Comparable<? super T>>
    void selectionSort(T[] arr, int first, int last) {

        //Loop through the array, obtaining the index of the smallest item and swapping
        //the current item with the smallest item:
        for (int index = first; index < last; index++) {

            // TODO: Identify the index of the smallest entry in the array:
            int indexOfNextSmallest = getIndexOfSmallest(arr, index, last);

            // TODO: Swap the two items (current item, indexOfNextSmallest):
            swap(arr, index, indexOfNextSmallest);

            // TODO: Use ArrayUtil method to output the array after the swap:
            ArrayUtil.displayArrayContent(arr);
        }
    }

    /** Private method to finds the index of the smallest value in an array a.
     * @param arr An array of Comparable objects.
     * @param first An integer >= 0 and < arr.length that is the index of the first
     * array entry to consider.
     * @param last An integer >= 0 and < arr.length that is the index of the last
     * array entry to consider.
     * @return The index of the smallest value among
     * arr[first], arr[first+1], . . . , arr[last].
     */
    private static <T extends Comparable<? super T>>
    int getIndexOfSmallest(T[] arr, int first, int last) {

        // Set the current smallest value:
        T minVal = arr[first];

        // Set the index of the current smallest value:
        int indexMin = first;

        //Loop through the remainder of the array:
        for (int index = first + 1; index <= last; index++) {

            // Compare the value at arr[index] with the current smallest value.
            // If its less, then set the current smallest value to arr[index]
            // and set the index of the current smallest value to index.
            // TODO: Replace the conditional with an appropriate comparison (less than comparison)
            // TODO: using the compareTo() method from Comparable:
            if (arr[index].compareTo(minVal) < 0) {
                minVal = arr[index];
                indexMin = index;
            }
        }
        return indexMin;
    }

    /** Method to swap the array entries arr[i] and arr[j].
     * @param arr An array of objects.
     * @param from An integer >= 0 and < arr.length.
     * @param to An integer >= 0 and < arr.length.
     */
    private static <T>
    void swap(T[] arr, int from, int to) {

        // Temporarily store the object to be moved:
        T temp = arr[from];

        // TODO: Swap the two entries (arr[from], arr[to]):
        arr[from] = arr[to];
        arr[to] = temp;
    }


    /**************************************************************
     * RECURSIVE SELECTION SORT
     **************************************************************/

    public static <T extends Comparable<? super T>>
    void selectionSortRecursive(T[] arr, int n) {

        // TODO: Invoke the selectionSortRecursive algorithm:
        selectionSortRecursive(arr, 0, n-1);

    }

    private static <T extends Comparable<? super T>>
    void selectionSortRecursive(T[] arr, int first, int last) {

        if (first < last) {

            // TODO: Identify the index of the smallest entry in the array:
            int indexOfNextSmallest = getIndexOfSmallest(arr, first, last);

            // TODO: Swap the two items:
            swap(arr, indexOfNextSmallest, first);

            // TODO: Output the array after the swap:
            ArrayUtil.displayArrayContent(arr);

            // TODO: Make the recursive call:
            selectionSortRecursive(arr, first+1, last);
        }
    }

}

