package superhero2;

import java.util.ArrayList;

public class Database {

    //Attributes
    private ArrayList<Superhero> superheroesDB = new ArrayList<>();

    // Getter for arraylist of superheroes
    public ArrayList<Superhero> getAllSuperHeroes() {
        return superheroesDB;
    }

    public void createSuperhero(String heroName, String realName, int creationYear, String superpower, boolean human, double strength) {

        Superhero hero = new Superhero(heroName, realName, creationYear, superpower, human, strength);
        superheroesDB.add(hero);
    }

    public ArrayList<Superhero> searchFor(String searchTerm) {
        ArrayList<Superhero> searchResult = new ArrayList<>();

        for (Superhero superhero : superheroesDB) {
            if (superhero.getHeroName().equalsIgnoreCase(searchTerm)) {
                searchResult.add(superhero);
            }
        }
        return searchResult;
    }

    public boolean deleteSuperhero(Superhero superhero) {
        boolean succes;
        succes = superheroesDB.remove(superhero);
        return succes;
    }

    public void updateSuperheroList(ArrayList<Superhero> superheroes) {
        superheroesDB = superheroes;
    } //TODO update method for which updates?

    public ArrayList<Superhero> SortedList() {

        return null;
    }

}



