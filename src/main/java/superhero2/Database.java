package superhero2;

import java.util.ArrayList;

public class Database {

    private ArrayList<Superhero> superheroesDB = new ArrayList<>();

    public void createSuperhero(String heltenavn, String ægtenavn, int årstal, String superkraft, boolean human, double strength) {

        Superhero hero = new Superhero(heltenavn, ægtenavn, årstal, superkraft, human, strength);
        superheroesDB.add(hero);
    }

    public ArrayList<Superhero> searchFor(String searchTerm) {
        ArrayList<Superhero> searchResult = new ArrayList<>();

        for (Superhero superhero : superheroesDB) {
            if (superhero.getHelteNavn().equalsIgnoreCase(searchTerm)) {
                searchResult.add(superhero);
            }
        }
        return searchResult;
    }

    public ArrayList<Superhero> getAllSuperHeroes() {
        return superheroesDB;
    }

    public boolean deleteSuperhero(Superhero superhero) {
        boolean succes;
        succes = superheroesDB.remove(superhero);
        return succes;

   /* superhero2.Superhero[] superhero = {}
        Array.sort(superheros, new NameComparator());
        System.out.println("superhero2.Superhero List - Sorteret efter navn" + superheroes);

}/*

    */
    }

    public void updateSuperheroList(ArrayList<Superhero> superheroes) {
        superheroesDB = superheroes;
    }
}



