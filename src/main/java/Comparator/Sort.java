package Comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Sort {

        public static <Superhero> void main(String[] args) {

            Superhero s1 = new Superhero();
            Superhero s2 = new Superhero();
            Superhero s3 = new Superhero();

            Superhero[] superheroes = {s1, s2, s3}; //for at sortere skal vi lave en kontrakt

            ArrayList<Superhero> supeheroes = new ArrayList<Superhero>(List.of(s1, s2, s3));

            Arrays.sort(superheroes, new NameComparator());
            System.out.println("array sorteret efter navn. " + Arrays.toString(supeheroes));

            Collections.sort(superheroes, new RealNameComparator());
        }
    }
}
