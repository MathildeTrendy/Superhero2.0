package superhero2;

import superhero2.comparator.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Database {

    private ArrayList<Superhero> superheroesDB = new ArrayList<>();

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

    public ArrayList<Superhero> getAllSuperHeroes() {
        return superheroesDB;
    }

    public boolean deleteSuperhero(Superhero superhero) {
        boolean succes;
        succes = superheroesDB.remove(superhero);
        return succes;
    }

    public void updateSuperheroList(ArrayList<Superhero> superheroes) {
        superheroesDB = superheroes;
    }

    public void SortedList() {

}

}



