package h11.parse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.tudalgo.algoutils.student.Student.crash;

/**
 * An implementation of the {{@link LSystemParser}
 * implementing the following file format:
 * <pre>
 *     # Comments begin with a `#`
 *     # source of the first projection is the axiom
 *     A -> AB
 *     # More rules follow with each new line
 *     A -> AB
 * </pre>
 */
public class LSystemParserImpl implements LSystemParser {

    @Override
    public List<Projection> parse(Stream<String> lines) {
        List<String> lineList = lines.toList();
        List<Projection> projections = new ArrayList<>();

        for (String line : lineList) {
            line = line.split("#")[0];

            if (!line.trim().isEmpty()) {
                String[] parts = line.split("->");
                if (parts.length != 2) {
                    throw new IllegalArgumentException(line);
                }
                String source = parts[0].trim();
                String target = parts[1].trim();
                projections.add(new Projection(source, target));
            }
        }
        return projections;
    }
}
