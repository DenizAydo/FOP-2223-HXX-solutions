package h07.arrayoperators;

import java.util.Arrays;
import java.util.function.DoubleBinaryOperator;

import static org.tudalgo.algoutils.student.Student.crash;

/**
 * Class implementing the interface DoubleArrayBinaryOperatorGivingArray,
 * such that the overwritten method applyAsDoubleArray returns an array
 * only containing as many elements as the smaller array of the given
 * ones.
 * Applies the operator to the elements in the old arrays and fills the
 * new array with the results.
 */
public class PairwiseDoubleArrayBinaryOperatorGivingScalar implements DoubleArrayBinaryOperatorGivingScalar {

    /**
     * First operator, "Komponentenverkn端pfung" (join-fct).
     */
    private final DoubleBinaryOperator OPERATOR_1;

    /**
     * Second operator, "Faltungsoperation" (fold-fct).
     */
    private final DoubleBinaryOperator OPERATOR_2;

    /**
     * Initial value (init).
     */
    private double init;

    /**
     * Constructor initializes the operators ("Komponentenverkn端pfung" and "Faltungsoperation")
     * and the initial value (init).
     *
     * @param operator1     The first operator, "Komponentenverkn端pfung" (join-fct).
     * @param operator2     The second operator, "Faltungsoperation" (fold-fct).
     * @param d             The initial value (init).
     */
    public PairwiseDoubleArrayBinaryOperatorGivingScalar(DoubleBinaryOperator operator1, DoubleBinaryOperator operator2, double d) {
        // Assign first parameter to first operator
        this.OPERATOR_1 = operator1;

        // Assign second parameter to second operator
        this.OPERATOR_2 = operator2;

        // Assign third parameter to initial value
        this.init = d;
    }

    /**
     * Returns a scalar that is the result of the application of the two operators
     * ("Komponentenverkn端pfung" and "Faltungsoperation") on the two given arrays
     * according to the following racket code:
     *
     * ( define (apply lst1 lst2 join-fct fold-fct init )
     *      ( cond
     *          [ ( or ( empty? lst1 ) ( empty? lst2 ) ) init ]
     *          [ else ( fold-fct
     *                  ( join-fct ( first lst1 ) ( first lst2 ) )
     *                  ( apply ( rest lst1 ) ( rest lst2 ) join-fct fold-fct init ) ] ) )
     *
     * @param left      The first array.
     * @param right     The second array.
     * @return          The result of the fold.
     */
    @Override
    public double applyAsDoubleArray(double[] left, double[] right) {

        double r = 0;
        int arrayLength = Math.min(left.length, right.length);
        int i = arrayLength - 1;

        if (left.length == 0 || right.length == 0) {

            return this.init;

        } else {


            double walt = this.OPERATOR_1.applyAsDouble(left[arrayLength - 1], right[arrayLength - 1]);
            r = this.OPERATOR_2.applyAsDouble(walt, this.init);


            while (i-- > 0){
                walt = this.OPERATOR_1.applyAsDouble(left[i], right[i]);

                r = this.OPERATOR_2.applyAsDouble(walt, r);
            }

            return r;
        }
    }
}
