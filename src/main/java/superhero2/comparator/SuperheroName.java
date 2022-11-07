package superhero2.comparator;

import superhero2.Superhero;

import java.util.Comparator;

public class SuperheroName {
    public class NameComparator implements Comparator<Superhero> {
        public int compare( Superhero a1, Superhero a2) {
            return a1.getHelteNavn().compareToIgnoreCase(a2.getHelteNavn());
        }
    }
}
