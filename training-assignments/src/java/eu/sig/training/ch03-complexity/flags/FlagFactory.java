import java.util.List;
import java.util.Map;
import java.util.Collections;
import static java.util.Map.entry;

public class FlagFactory {
    private static final Map<Nationality, List<Color>> FLAG_COLORS = Map.ofEntries(
        entry(Nationality.DUTCH, List.of(Color.RED, Color.WHITE, Color.BLUE)),
        entry(Nationality.GERMAN, List.of(Color.BLACK, Color.RED, Color.YELLOW)),
        entry(Nationality.BELGIAN, List.of(Color.BLACK, Color.YELLOW, Color.RED)),
        entry(Nationality.FRENCH, List.of(Color.BLUE, Color.WHITE, Color.RED)),
        entry(Nationality.ITALIAN, List.of(Color.GREEN, Color.WHITE, Color.RED)),
        entry(Nationality.ROMANIA, List.of(Color.BLUE, Color.YELLOW, Color.RED)),
        entry(Nationality.IRELAND, List.of(Color.GREEN, Color.WHITE, Color.ORANGE)),
        entry(Nationality.HUNGARIAN, List.of(Color.RED, Color.WHITE, Color.GREEN)),
        entry(Nationality.BULGARIAN, List.of(Color.WHITE, Color.GREEN, Color.RED)),
        entry(Nationality.RUSSIA, List.of(Color.WHITE, Color.BLUE, Color.RED)),
        entry(Nationality.UKRAINE, List.of(Color.BLUE, Color.YELLOW))
    );

    private static final List<Color> DEFAULT_FLAG = List.of(Color.GRAY);

    public List<Color> getFlagColors(Nationality nationality) {
        return FLAG_COLORS.getOrDefault(nationality, DEFAULT_FLAG);
    }
}
