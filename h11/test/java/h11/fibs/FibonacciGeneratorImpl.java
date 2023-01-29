package h11.fibs;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.tudalgo.algoutils.student.Student.crash;

/**
 * A basic implementation of the {@link FibonacciGenerator}
 * using {@link Stream} to compute the sequence.
 */
public class FibonacciGeneratorImpl implements FibonacciGenerator {

    @Override
    public List<Integer> generate(int numberOfFibs) {
        FibonacciPair pair = new FibonacciPair();
        return Stream.iterate(pair, FibonacciPair::next)
            .map(FibonacciPair::a)
            .limit(numberOfFibs)
            .collect(Collectors.toList());
    }
}
