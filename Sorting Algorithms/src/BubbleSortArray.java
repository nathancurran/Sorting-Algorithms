/**
 * Lab Session C (based on source code by Charles Hoot)
 * Class for sorting an array of Comparable objects from smallest to
 * largest using the bubble Sort algorithm.
 */

public class BubbleSortArray {

    /**************************************************************
     * ITERATIVE BUBBLE SORT
     **************************************************************/

    /** Sorts the first n objects in an array into ascending order.
     * This initial method is a wrapper for the actual bubbleSort method.
     * @param arr An array of Comparable objects.
     * @param n An integer > 0.
     */
    public static <T extends Comparable<? super T>>
    void bubbleSort(T[] arr, int n)
    {
        // Invoke the bubbleSort algorithm:
        bubbleSort(arr, 0, n-1);
    }

    private static <T extends Comparable<? super T>>
    void bubbleSort(T[] arr, int first, int last) {

        for (int index = first; index < last; index++) {
            for(int j=1; j < (arr.length-index); j++){
                if (arr[j].compareTo(arr[j-1])<0) {
                    swap(arr, index, j);
                }


            }

            // TODO: Use ArrayUtil method to output the array after the swap:
            ArrayUtil.displayArrayContent(arr);
        }
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
}

