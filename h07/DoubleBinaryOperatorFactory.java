package h07;

import h07.doubleoperators.*;

import java.util.function.DoubleBinaryOperator;

import static org.tudalgo.algoutils.student.Student.crash;

/**
 * Class to build an operator with the buildOperator()-method
 */
public class DoubleBinaryOperatorFactory {

    /**
     * Returns a lambda-expression that is logically equivalent to the implementation
     * of applyAsDouble in DoubleSumWithCoefficientsOp. If the object encapsulates
     * a PairOfDoubleCoefficients, the coefficients for the expression are taken
     * directly from said object.
     *
     * @param obj   The object specifying the operation.
     * @return      The lambda-expression.
     */
    private static DoubleBinaryOperator doubleSumWithCoefficientsOpAsLambda(Object obj) {

        if (obj instanceof PairOfDoubleCoefficients) {
            PairOfDoubleCoefficients p = (PairOfDoubleCoefficients) obj;

            return (x, y) -> {
                return p.coeff1 * x + p.coeff2 * y;
            };
        }
        else {
            return null;
        }

    }

    /**
     * Returns a lambda-expression that is logically equivalent to the implementation
     * of applyAsDouble in EuclideanNorm.
     *
     * @return  The lambda-expression
     */
    private static DoubleBinaryOperator euclideanNormAsLambda() {

        return (x, y) -> { return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)); };

    }

    /**
     * Returns a lambda-expression that is logically equivalent to the implementation
     * of applyAsDouble in DoubleMaxOfTwo. If the object encapsulates a Boolean and if
     * said Boolean encapsulates true, a lambda-expression is returned. If it encapsulates
     * false a method reference is returned.
     *
     * @param obj   The object specifying the operation.
     * @return      The lambda-expression.
     */
    private static DoubleBinaryOperator doubleMaxOfTwoAsLambda(Object obj) {

        if (!(obj instanceof Boolean)) {
            return null;
        }
        boolean prob = (Boolean) obj;
        if (prob) {

            return (i, j) -> i < j ? j : i;

        } else {

            return Math::max;
        }
    }

    /**
     * Returns a lambda-expression that is logically equivalent to the implementation
     * of applyAsDouble in ComposedDoubleBinaryOperator. If the object encapsulates
     * a TripleOfDoubleBinaryOperators, the operators for the expression are taken
     * directly from said object.
     *
     * @param obj   The object specifying the operation.
     * @return      The lambda-expression.
     */
    private static DoubleBinaryOperator composedDoubleBinaryOperatorAsLambda(Object obj) {


        if (obj instanceof TripleOfDoubleBinaryOperators triple) {
            return (x, y) -> triple.operator3.applyAsDouble(triple.operator1.applyAsDouble(x, y), triple.operator2.applyAsDouble(x, y));
        }


        else {
            return null;
        }
    }

    /**
     * Returns an operator depending on the given input parameters.
     *
     * @param str   The type of the operator.
     * @param obj   The (optional) features of the operator.
     * @param bool  The style of operator creation.
     * @return      The operator.
     */
    public static Object buildOperator(String str, Object obj, boolean bool) {

        if (!str.equals("Coeffs") && !str.equals("Euclidean") && !str.equals("Max") && !str.equals("Composed")) {
            return null;
        }
        if (bool) {
            return buildOperatorWithNew(str, obj);
        }
        else {
            return buildOperatorWithLambda(str, obj);
        }
    }

    /**
     * Returns an operator that is created solely by using new.
     *
     * @param str   The type of the operator.
     * @param obj   The (optional) features of the operator.
     * @return      The operator.
     */
    private static Object buildOperatorWithNew(String str, Object obj) {

        switch(str) {
            case "Coeffs":

                if (obj instanceof PairOfDoubleCoefficients pair) {
                    return new DoubleSumWithCoefficientsOp(pair.coeff1, pair.coeff2);
                } else {
                    return null;
                }
            case "Euclidean":
                return new EuclideanNorm();

            case "Max":
                return new DoubleMaxOfTwo();

            case "Composed":

                if (obj instanceof TripleOfDoubleBinaryOperators triple) {
                    return new ComposedDoubleBinaryOperator(triple.operator1, triple.operator2, triple.operator3);
                } else {
                    return null;
                }
            default:
                return null;
        }
    }

    /**
     * Returns an operator that is created solely by using a lambda-expression.
     *
     * @param str   The type of the operator.
     * @param obj   The (optional) features of the operator.
     * @return      The operator.
     */
    private static Object buildOperatorWithLambda(String str, Object obj) {

        return switch (str) {
            case "Coeffs" -> doubleSumWithCoefficientsOpAsLambda(obj);
            case "Euclidean" -> euclideanNormAsLambda();
            case "Max" -> doubleMaxOfTwoAsLambda(obj);
            case "Composed" -> composedDoubleBinaryOperatorAsLambda(obj);
            default -> null;
        };
    }

}
