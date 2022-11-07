package superhero2.comparator;
import superhero2.Superhero;
import java.util.Comparator;

public class Strength implements Comparator<Superhero> {
        public int compare(Superhero a1, Superhero a2) {
            return Double.compare(a1.getStrength(), a2.getStrength());
        }
    }

