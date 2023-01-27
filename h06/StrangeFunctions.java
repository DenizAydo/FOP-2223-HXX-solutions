package h06;

import static org.tudalgo.algoutils.student.Student.crash;

/**
 * A collection of strange functions.
 */
public class StrangeFunctions {

    /**
     * A strange function.
     *
     * @param m a number
     * @param n another number
     * @return a mysterious result
     */
    public static double strangeFunction1(int m, int n) {

        if (m < n) {
            return m;
        } else {
            if (0 > (m%n)) {
                return strangeFunction1(m - (m % n), n);
            } else {
                return (double)m / (double)n;
            }
        }
    }

    /**
     * Just another strange function.
     *
     * @param m just a number
     * @param n just another number
     * @return just another mysterious result
     */
    public static double strangeFunction2(int m, int n) {
        return m < n ? m : 0 > (m % n) ? strangeFunction2(m - (m % n), n) : m / (double) n;
    }

    /**
     * Oh, there is a third strange function?
     *
     * @param m a number
     * @param n another number
     * @return just another mysterious result
     */
    public static boolean understandable1(double m, double n) {

        if (m <= 0 && n <= 0) {
            return true;
        }
        else if ( m <= 0 || n<= 0) {
            return false;
        }
        else if (m < n) {
            return understandable1(m - 1, m + (2  * n));
        }
        else {
            return understandable1(m, m - n);
        }
    }

    /**
     * How much more strange functions are there?
     * @param m a number
     * @param n another number
     * @return just another mysterious result
     */
    public static boolean understandable2(double m, double n) {
        return ((m <= 0) && (n <= 0)) ? true : (((m <= 0) || (n <= 0)) ? false : ((m < n) ? understandable2(m - 1, m + (2 * n)) : understandable2(m, m - n)));
    }

    /**
     * A simple function to transform arrays in a strange way.
     *
     * @param array the array to transform
     */
    public static void transformArray1(double[] array) {

        {
            for (int i = 0; i < array.length; i++) {
                if (i == array.length - 1) {
                    array[i] += 1;
                } else {
                    array[i] += array[i + 1];
                }
            }
        }
    }

    /**
     * Another simple function to transform arrays in a strange way.
     *
     * @param array the array to transform
     */
    public static void transformArray2(double[] array) {

        doTheRecursion(array, 0);
    }

    /**
     * This function is doing the recursive work!
     *
     * @param array the array to transform
     * @param i the index of the current element
     */
    public static void doTheRecursion(double[] array, int i) {

        if (i == array.length) {
            return;
        }
        if (i == array.length - 1) {
            array[i] += 1;
        } else {
            array[i] += array[i + 1];
        }
        doTheRecursion(array, i + 1);
    }

}


