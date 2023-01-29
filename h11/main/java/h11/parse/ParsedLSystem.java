package h11.parse;

import h11.LSystem;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.tudalgo.algoutils.student.Student.crash;

/**
 * One can utilize this class to
 * use the {@link List} of {@link Projection} parsed
 * by the {@link LSystemParser} to implement an {@link LSystem}.
 */
public class ParsedLSystem implements LSystem<Character> {

    /**
     * The projections of the L-System this instance represents.
     */
    private final List<Projection> projections;

    /**
     * @param projections The projections of the L-System this instance represents.
     */
    public ParsedLSystem(List<Projection> projections) {
        if (projections.isEmpty()) {
            throw new IllegalArgumentException("Need at least one projection rule");
        }

        this.projections = projections;
    }

    @Override
    public Character getAxiom() {
        return projections.get(0).source();
    }

    @Override
    public Stream<Character> project(Character ch) {
        return projections.stream()
            .filter(pro -> pro.source() == ch)
            .findFirst()
            .map(pro -> pro.destination().chars().mapToObj(c -> (char) c))
            .orElse(Stream.of(ch));
    }
}
