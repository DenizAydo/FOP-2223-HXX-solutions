package h11;

import java.util.stream.Stream;

import static org.tudalgo.algoutils.student.Student.crash;

/**
 * An implementation of an {@link LSystem}
 * called the {@link Algae} that can be unused
 * to compute the Fibonacci number.
 * <p>
 * There are two possible tokens,
 * called {@link Variable}s: <code>A, B</code>
 * and two projections
 * <pre>
 *     A -> AB,
 *     B -> A
 * </pre>
 * <code>A</code> is the axiom.
 */
public class Algae implements LSystem<Algae.Variable> {

    /**
     * The two variables used by this {@link LSystem}.
     */
    public enum Variable { A, B }

    @Override
    public Variable getAxiom() {
        return Variable.A;
    }

    @Override
    public Stream<Variable> project(Variable v) {
        if (v.equals(Variable.A)) {
            return Stream.of(Variable.A, Variable.B);
        } else {
            return Stream.of(Variable.A);
        }
    }
}
