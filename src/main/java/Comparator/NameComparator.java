package Comparator;

import Data.Superhero;
import java.util.Comparator;


    public class NameComparator implements Comparator<Superhero> {
        public int compare( Superhero a1, Superhero a2) {
            return a1.getÆgteNavn().compareToIgnoreCase(a2.getÆgteNavn());
        }
    }
