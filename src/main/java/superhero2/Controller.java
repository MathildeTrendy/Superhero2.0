package superhero2;

import superhero2.comparator.FlexibleComparator;

import java.io.FileNotFoundException;
import java.util.*;

public class Controller {

    Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
    private Database database = new Database();

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
        database.deleteSuperhero();
        saveData();
    //TODO: TODO: Hvad skal der ske her, efter de er rykket til UI?
    }

    public ArrayList<Superhero> sortedList(String sortedInput){
        Comparator comparator = new FlexibleComparator(sortedInput);
        database.getAllSuperHeroes().sort(comparator);
        return database.getAllSuperHeroes();
        }
    public ArrayList<Superhero> sortedList(String primary, String secondary) {
        Comparator comparator = new FlexibleComparator(primary);
        database.getAllSuperHeroes().sort(comparator.thenComparing(new FlexibleComparator(secondary)));
        return database.getAllSuperHeroes();
    }
}












