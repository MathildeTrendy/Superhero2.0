package superhero2;

import superhero2.comparator.FlexibleComparator;

import java.io.FileNotFoundException;
import java.util.*;

public class Controller {

    Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
    private final Database database = new Database();
    boolean isChanged = false;

    public void createSuperhero(String heroName, String realName, int creationYear, String superpower, boolean human, double strength) {
        database.createSuperhero(heroName, realName, creationYear, superpower, human, strength);
        isChanged = true;
    }

    public ArrayList<Superhero> getListOfAllSuperHeroes() {
        return database.getAllSuperHeroes();
    }

    public ArrayList<Superhero> searchFor(String searchTerm) {
        return database.searchFor(searchTerm);
    }

    public void editSuperhero() {
        isChanged = true;
    }

    public void loadData() throws FileNotFoundException {
        Filehandler filehandler = new Filehandler();
        ArrayList<Superhero> superheroes = filehandler.loadData();
        database.updateSuperheroList(superheroes);
        isChanged = true;
    }

    public void saveData() throws FileNotFoundException {
        Filehandler filehandler = new Filehandler();
        filehandler.saveData(database.getAllSuperHeroes());
        isChanged = true;
        loadData();
    }

    public void deleteSuperhero(Superhero superhero) throws FileNotFoundException {
        database.deleteSuperhero(superhero);
        isChanged = true;
        saveData();
        loadData();
    }

    public ArrayList<Superhero> sortedList(String sortedInput){
        Comparator comparator = new FlexibleComparator(sortedInput);
        database.getAllSuperHeroes().sort(comparator);
        return database.getAllSuperHeroes();
        }
    public ArrayList<Superhero> sortedList(String primary, String secondary) {
        Comparator comparator = new FlexibleComparator(primary);
        database.getAllSuperHeroes().sort(comparator.thenComparing(new FlexibleComparator(secondary)));
        if (!secondary.equals("None")){
            database.getAllSuperHeroes().sort(comparator.thenComparing(new FlexibleComparator(secondary)));
        }else{
            database.getAllSuperHeroes().sort(comparator);

        }
        return database.getAllSuperHeroes();
    }
}












