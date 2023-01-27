package h07.arrayoperators;

import java.util.function.DoublePredicate;

import static org.tudalgo.algoutils.student.Student.crash;

/**
 * Class implementing the interface DoubleArrayUnaryOperatorGivingArray,
 * such that the overwritten method applyAsDoubleArray returns an array
 * only containing elements of the given array for which the predicate
 * of the class returns true.
 */
public class ReduceDoubleArray implements DoubleArrayUnaryOperatorGivingArray {

    /**
     * The predicate.
     */
    private final DoublePredicate PREDICATE;

    /**
     * Constructor initializes the predicate for the filter.
     *
     * @param predicate The predicate.
     */
    public ReduceDoubleArray(DoublePredicate predicate) {
        // Assign given parameter to predicate
        this.PREDICATE = predicate;
    }

    /**
     * Returns an array containing all the elements of the given array
     * for which the predicate returns true.
     *
     * @param array The array.
     * @return The result of the filter.
     */
    @Override
    public double[] applyAsDoubleArray(double[] array) {

        if (array == null) {
            return null;
        }

        int length = 0;
        int j = 0;


        for (double e : array) {
            if (PREDICATE.test(e)) {
                length += 1;
            }
        }

        double[] result = new double[length];
        for (double e : array) {
            if (PREDICATE.test(e)) {
                result[j] = e;
                j++;
            }
        }
        return result;
    }
}
