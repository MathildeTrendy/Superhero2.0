package superhero2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    Scanner scanner = new Scanner(System.in);
    private Database database = new Database();

    public void addSuperhero() {

        System.out.println("Add superhero Menu\n");

        System.out.println("Type a superhero name (fx Superman):");
        String heroName = scanner.nextLine();

        System.out.println("Type superhero name :");
        String realName = scanner.nextLine();

        System.out.println("Type superhero superpower:");
        String superpower = scanner.nextLine();

        System.out.println("Is the superhero a human? (True/False):");
        boolean human = scanner.nextLine().substring(0, 1).equalsIgnoreCase("j");//?

        System.out.println("Type creation year:");
        int creationYear = scanner.nextInt();

        System.out.println("Type superhero-strength");
        double strenght = scanner.nextInt();

        database.createSuperhero(heroName, realName, creationYear, superpower, human, strenght);
    }

    public void listeMenu() {
        System.out.println("List of superheroes:\n");
        for (Superhero superhero : database.getAllSuperHeroes()) {
            System.out.println("heroName: " + superhero.getHeroName() + "\n" + "Real name: " + superhero.getRealName() +
                    "\n" + "Creation Year: " + superhero.getCreationYear() + "\n" + "superpower: " + superhero.getSuperpower() + "\n" + "Is human: " + superhero.getHuman() + "\n");

        }
    }
    public void searchHero() {
        System.out.println("---------------------------------\nSearch superhero:");

        System.out.println("Type the name of the superhero you'll like to search for");
        String searchTerm = scanner.next();
        ArrayList<Superhero> searchResult = database.searchFor(searchTerm);

        if (searchResult.isEmpty()) {
            System.out.println("No superheroes found");

        } else {
            System.out.println("Superheroes found: ");
            for (Superhero superhero : searchResult) {
                System.out.println(superhero);
            }
        }
    }
    public void editHero() {
        System.out.println("Add name of superhero you want to edit:");
        String searchTerm = scanner.next();
        ArrayList<Superhero> searchResult = database.searchFor(searchTerm);

        if (searchResult.isEmpty()) {
            System.out.println("No superheroes found.");

        } else {
            System.out.println("Superheroes found: ");
            for (int i = 0; i < searchResult.size(); i++) {
                System.out.println(((i) + 1) + ") " + searchResult.get(i));
            }
            System.out.println("\nWhich number of the superheroes would you like to edit?:");
            int number = scanner.nextInt();
            scanner.nextLine();
            Superhero hero = searchResult.get(number - 1);


            System.out.println("Type the new superheroName or press 'enter' to keep present name:");
            String heroName = scanner.nextLine();

            if (!heroName.isEmpty()) {
                hero.setHeroName(heroName);
            }
            System.out.println("Type the new name or press enter:");
            String realName = scanner.nextLine();

            if (!realName.isEmpty()) {
                hero.setRealName(realName);
            }

            System.out.println("Type the new superpower or press enter:");
            String superpower = scanner.nextLine();

            if (!superpower.isEmpty()) {
                hero.setSuperpower(superpower);
            }


            boolean writingError = false;
            do {
                try {
                    System.out.println("Write creationYear for your superhero:");
                    String creationYear = scanner.nextLine();
                    if (!creationYear.isEmpty()) {
                        hero.setCreationYear(Integer.parseInt(creationYear));
                    }
                    writingError = false;

                } catch (NumberFormatException e) {
                    System.out.println("Error - Try again.");
                    writingError = true;
                }

            } while (writingError == true);

            System.out.println("Superhero changed to:\n " + hero);
        }
    }

    public void loadData() throws IOException {
        Filehandler filehandler = new Filehandler();
        ArrayList<Superhero> superheroes= filehandler.loadData();
        database.updateSuperheroList(superheroes);
    }


    public void gemData() throws IOException {
        Filehandler filehandler = new Filehandler();
        filehandler.gemData(database.getAllSuperHeroes());
        loadData();
    }

    public void deleteHero() {

        System.out.println("Search for a hero, you'll like to be removed from the database:");
        String searchTerm = scanner.next();
        ArrayList<Superhero> searchResult = database.searchFor(searchTerm);

        if (searchResult.isEmpty()) {
            System.out.println("No superhero(es) found.\n");

        } else {
            System.out.println("Superhero(es) found: ");
            for (int i = 0; i < searchResult.size(); i++) {
                System.out.println(((i) + 1) + ") " + searchResult.get(i));
            }
            System.out.println("\nWhich number of the superheroes, would you du like to remove?:");
            int number = scanner.nextInt();
            scanner.nextLine();
            Superhero superhero = searchResult.get(number - 1);

            System.out.println("Are you sure, you want to delete the superhero? (true/false): ");
            boolean delete = scanner.nextBoolean();
            if (delete == true) {
                database.deleteSuperhero(superhero);

                System.out.println("Superhero deleted from database.");

            } else if (delete == false) {
                System.out.println("Wont delete superhero.");

            }
        }
    }

    public void createSuperHero() {
    }

    public void saveData() {
    }
}







