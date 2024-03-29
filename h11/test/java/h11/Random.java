package h11;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.tudalgo.algoutils.student.Student.crash;

/**
 * Descendant from {@link java.util.Random}
 * adding extra methods.
 */
public class Random extends AbstractRandom {

    /**
     * Use a unique seed.
     */
    public Random() {
    }

    /**
     * Use the given seed.
     */
    public Random(long seed) {
        super(seed);
    }

    @Override
    @SafeVarargs
    public final <T> Stream<T> choices(T... values) {

        return ints(0, values.length)
            .mapToObj(i -> values[i]);
    }

    @Override
    public String latin(int length) {
        return ints(65, 91)
            .limit(length)
            .mapToObj(i -> Character.toString((char) i))
            .collect(Collectors.joining());

    }
}
