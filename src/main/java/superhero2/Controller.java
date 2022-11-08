package superhero2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Controller {
    Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
    private Database database = new Database();

    public void createSuperhero(String heroName, String realName, int creationYear, String superpower, boolean human, double strength) {
        database.createSuperhero( heroName, realName, creationYear, superpower, human, strength);
    }

    public ArrayList<Superhero> getListOfAllSuperHeroes() {
        return database.getAllSuperHeroes();
    }

    public void searchHero() {
        System.out.println("---------------------------------\nSearch for superhero:");

        System.out.println("Type the name of your favorite superhero");
        String searchTerm = scanner.next();
        ArrayList<Superhero> searchResult = database.searchFor(searchTerm);

        if (searchResult.isEmpty()) {
            System.out.println("No hero found");

        } else {
            System.out.println("Superhero found: ");
            for (Superhero superhero : searchResult) {
                System.out.println(superhero);
            }
        }
    }

    public void editHero() {
        System.out.println("Type the name of the superhero you'll like to edit:");
        String searchTerm = scanner.next();
        ArrayList<Superhero> searchResult = database.searchFor(searchTerm);

        if (searchResult.isEmpty()) {
            System.out.println("No superhero found.");

        } else {
            System.out.println("Superhero found: ");
            for (int i = 0; i < searchResult.size(); i++) {
                System.out.println(((i) + 1) + ") " + searchResult.get(i));
            }
            System.out.println("\nWhat number does the superhero have, that you'll like to edit?:");
            int number = scanner.nextInt();
            scanner.nextLine();
            Superhero hero = searchResult.get(number - 1);


            System.out.println("Type the new superhero name er press 'enter' to keep the present name:");
            String heroName = scanner.nextLine();

            if (!heroName.isEmpty()) {
                hero.setHeroName(heroName);
            }
            System.out.println("Type the new name or press 'enter':");
            String realName = scanner.nextLine();

            if (!realName.isEmpty()) {
                hero.setRealName(realName);
            }

            System.out.println("Type the new superpower or press 'enter':");
            String superpower = scanner.nextLine();

            if (!superpower.isEmpty()) {
                hero.setSuperpower(superpower);
            }


            boolean writingError = false;
            do {
                try {
                    System.out.println("Type creation year for your superhero:");
                    String creationYear = scanner.nextLine();
                    if (!creationYear.isEmpty()) {
                        hero.setCreationYear(Integer.parseInt(creationYear));
                    }
                    writingError = false;

                } catch (NumberFormatException e) {
                    System.out.println("Error occurred - try again.");
                    writingError = true;
                }

            } while (writingError == true);

            System.out.println("Superhero changed to:\n " + hero);
        }
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

    public void deleteHero() {

        System.out.println("Search for the hero you want to remove from database:");
        String searchTerm = scanner.next();
        ArrayList<Superhero> searchResult = database.searchFor(searchTerm);

        if (searchResult.isEmpty()) {
            System.out.println("No superhero(es) found.\n");

        } else {
            System.out.println("Superhero(es) found: ");
            for (int i = 0; i < searchResult.size(); i++) {
                System.out.println(((i) + 1) + ") " + searchResult.get(i));
            }
            System.out.println("\nWhat number does the superhero have, that you want to delete?:");
            int number = scanner.nextInt();
            scanner.nextLine();
            Superhero superhero = searchResult.get(number - 1);

            System.out.println("Are you sure, you want to delete the superhero? (true/false): ");
            boolean delete = scanner.nextBoolean();
            if (delete == true) {
                database.deleteSuperhero(superhero);

                System.out.println("Superhero deleted from database.");

            } else if (delete == false) {
                System.out.println("Superhero not deleted.");

            }
        }
    }

    public void sortedList() {
        Database database = new Database();
        database.SortedList();
    }



}











