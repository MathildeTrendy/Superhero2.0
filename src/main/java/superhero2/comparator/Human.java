package superhero2.comparator;

import superhero2.Superhero;

import java.util.Comparator;

public class Human implements Comparator<Superhero> {
    public int compare(Superhero a1, Superhero a2) {
        return Boolean.compare(a1.isHuman(), a2.isHuman());
    }
}
