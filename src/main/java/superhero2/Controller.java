package superhero2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Controller {

    Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
    private final Database database = new Database();

    public void createSuperhero(String heroName, String realName, int creationYear, String superpower, boolean human, double strength) {
        database.createSuperhero(heroName, realName, creationYear, superpower, human, strength);
    }

    public ArrayList<Superhero> getListOfAllSuperHeroes() {
        return database.getAllSuperHeroes();
    }

    public ArrayList<Superhero> searchFor(String searchTerm) {
        return database.searchFor(searchTerm);
    }

    public void editSuperhero() {
        // TODO: Hvad skal der ske her, efter de er rykket til UI?
    }

    public void loadData() throws FileNotFoundException {
        Filehandler filehandler = new Filehandler();
        ArrayList<Superhero> superheroes = filehandler.loadData();
        database.updateSuperheroList(superheroes);
    }

    public void saveData() throws FileNotFoundException {
        Filehandler filehandler = new Filehandler();
        filehandler.saveData(database.getAllSuperHeroes());
        //loadData();
    }

    public void deleteSuperhero(Superhero superhero) throws FileNotFoundException {
        database.deleteSuperhero(deleteSuperhero);
        saveData();
    //TODO: TODO: Hvad skal der ske her, efter de er rykket til UI?
    }

    public void sortedList() {
        Database database = new Database();
        database.SortedList();
    }


}











