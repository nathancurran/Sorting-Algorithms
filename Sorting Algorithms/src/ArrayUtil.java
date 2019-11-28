import java.util.Random;

/**
 * Lab Session C (based on source code by Charles Hoot)
 * ArrayUtil Class used to provide some utility methods
 * for the array sorting algorithms
 */

public class ArrayUtil {

    /**
     * Method to display the contents of an array of objects as a String
     * @param  data The array to display.
     */
    public static void displayArrayContent(Object [] data)
    {
        System.out.println(getString(data));
    }

    /**
     * Method to return the contents of an array of objects as a String
     * A displayable representation of an array of Objects where toString is
     * applied on each object in the array
     * @param   data    The array to display.
     * @return  A printable string.
     */
    private static String getString(Object [] data)
    {
        String resultString = new String("[ ");

        for(int i = 0; i< data.length; i++) {
            resultString = resultString + data[i].toString() + " ";
        }
        resultString = resultString + "]";

        return resultString;
    }

    /**
     * Method to generate an array of random integer values.  The values will be between 0 and size.
     * @param   size    The size of the array to generate.
     * @return  The array of integers.
     */
    public static Integer[] generateRandomArray(int size)
    {
        Integer resultArray[] = new Integer[size];
        Random generator = new Random();

        for(int i = 0; i< size; i++) {
            int value = generator.nextInt(size);
            resultArray[i] = value;
        }
        return resultArray;
    }


    /**
     * Method to duplicate the content of an array.
     * @param  orig The source array to copy.
     * @return The array containing a copy of the values in the source array.
     */
    public static Integer[] duplicateArray(Object [] orig)
    {
        int size = orig.length;
        Integer resultArray[] = new Integer[size];

        for(int i = 0; i< size; i++) {
            resultArray[i] = (Integer) orig[i];
        }
        return resultArray;
    }
}

