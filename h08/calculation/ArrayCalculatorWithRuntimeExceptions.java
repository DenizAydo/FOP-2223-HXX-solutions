package h08.calculation;

import static org.tudalgo.algoutils.student.Student.crash;

public class ArrayCalculatorWithRuntimeExceptions implements ArrayCalculator {
    /**
     * Adds up all double values in an array of arrays of double values. The double
     * values may not be negative or bigger than max.
     *
     * @param theArray The primary array containing the secondary arrays with their
     *                 double values
     * @param max      The maximum value any double value contained in the arrays may
     *                 have
     * @return double The sum of all double values contained on all secondary
     * arrays.
     */
    @Override
    public double addUp(double[][] theArray, double max) {

        double sum = 0;

        // case 1
        if (theArray == null) {
            throw new NullPointerException("Primary array is void!");
        }

        //case 2
        for (double[] secondArray : theArray) {
            if (secondArray == null) {
                throw new NullPointerException("Secondary array at <i> is void!");
            }

            //case 3
            for (double value : secondArray) {
                if (max < 0) {
                    throw new ArithmeticException("Upper bound is negative!");
                }

                //case 4
                if (value < 0 || value > max) {
                    throw new ArithmeticException("Value at (<i>,<j>) is not in range!");
                }

                sum += value;
            }
        }
        return sum;
    }
}

