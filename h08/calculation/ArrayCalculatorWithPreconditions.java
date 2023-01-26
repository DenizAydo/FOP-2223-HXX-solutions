package h08.calculation;

import h08.preconditions.*;

import static org.tudalgo.algoutils.student.Student.crash;

public class ArrayCalculatorWithPreconditions implements ArrayCalculator {
    /**
     * Adds up all double values in an array of arrays of double values. The double
     * values may not be negative or bigger than max.
     *
     * @param theArray The primary array containing the secondary arrays with their
     *                 double values
     * @param max      The maximum value any double value contained in the arrays may
     *                 have
     * @return double The sum of all double values contained on all secondary
     *                arrays.
     */
    @Override
    public double addUp(double[][] theArray, double max) throws ArrayIsNullException,AtIndexException, WrongNumberException, AtIndexPairException {

        double sum = 0;

        //case 1
        Preconditions.checkPrimaryArrayNotNull(theArray);

        //case 2
        for (int i = 0; i < theArray.length; i++) {
                Preconditions.checkSecondaryArraysNotNull(theArray);


                //case 3
                Preconditions.checkNumberNotNegative(max);

                //case 4
                for (int j = 0; j < theArray[i].length; j++) {
                Preconditions.checkValuesInRange(theArray, max);
                sum += theArray[i][j];

            }
        }
        return sum;
    }
}
