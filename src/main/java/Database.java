import java.util.ArrayList;
import java.util.List;

public class Database {

    private ArrayList<Superhero> superheroes = new ArrayList<Superhero>(List.of());

    public void createTestData() {
        createSuperhero("Bobbel", "Samme som heltenavn", 1998, "Tale med dyr", false);
        createSuperhero("Superman", "Clark Kent", 1978, "Flyve", false);
        createSuperhero("Kaptajn Underhyler","Knold", 2017, "Flyve", true);
        createSuperhero("Robin","Jason Todd", 1823, "Super styrke", true);
        createSuperhero("Bolt", "Samme som heltenavn", 2008, "Lasersyn", false);

    }

    public void createSuperhero(String heltenavn, String ægtenavn, int årstal, String superkraft, boolean human) {

        Superhero hero = new Superhero(heltenavn, ægtenavn, årstal, superkraft, human);

        superheroes.add(hero);

    }

    public ArrayList<Superhero> getSuperheroes() {
        return superheroes;
    }

    public Superhero searchFor(String searchTerm) {
        for (Superhero superhero : superheroes) {
            if (superhero.getHelteNavn().equals(searchTerm)) {
                return superhero;
            }
        }return null;
    }
}



