import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private ArrayList<Superhero> superheroes = new ArrayList<Superhero>(List.of());


    public void createSuperhero(String heltenavn, String ægtenavn, int årstal, String superkraft, boolean human) {

        Superhero hero = new Superhero(heltenavn, ægtenavn, årstal, superkraft, human);

        superheroes.add(hero);
    }

    public ArrayList<Superhero> getSuperheroes() {
        return superheroes;
    }

    public Superhero searchFor(String searchTerm) {
        for (Superhero superhero : superheroes) {
            if (superhero.getHelteNavn().equalsIgnoreCase(searchTerm)) {
                return superhero;
            }
        }
        return null;
    }

   /* Superhero[] superhero = {}
        Array.sort(superheros, new NameComparator());
        System.out.println("Superhero List - Sorteret efter navn" + superheroes);

}/*

    */
}



