package superhero2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    Scanner scanner = new Scanner(System.in);
    private Database database = new Database();

    public void opretSuperheroMenu() {

        System.out.println("Oprettelse af superhelt\n");

        System.out.println("Indtast en superhelts navn (fx Superman):");
        String heltenavn = scanner.nextLine();

        System.out.println("Indtast superheltens rigtige navn:");
        String ægtenavn = scanner.nextLine();

        System.out.println("Indtast superheltens superkræfter:");
        String superkraft = scanner.nextLine();

        System.out.println("Er superhelten et menneske? (Ja/Nej):");
        boolean human = scanner.nextLine().substring(0, 1).equalsIgnoreCase("j");

        System.out.println("Indtast superheltens oprindelsesår:");
        int årstal = scanner.nextInt();

        System.out.println("indtast superhelte-styrke");
        double strenght = scanner.nextInt();

        database.createSuperhero(heltenavn, ægtenavn, årstal, superkraft, human, strenght);
    }

    public void listeMenu() {
        System.out.println("Liste over superhelte:\n");
        for (Superhero superhero : database.getAllSuperHeroes()) {
            System.out.println("Heltenavn: " + superhero.getHelteNavn() + "\n" + "Rigtige navn: " + superhero.getÆgteNavn() + "\n" + "Oprindelsesår: " + superhero.getÅrstal() + "\n" + "Superkraft: " + superhero.getSuperkraft() + "\n" + "Er et menneske: " + superhero.getHuman() + "\n");

        }
    }

    public void showSortedList() {
        System.out.println("Chose how you would like to sort your list:");
        System.out.println("1) by superhero name");
        System.out.println("2) by real name");
        System.out.println("3) by year of origin");
        System.out.println("4) by type of superpowers");
        System.out.println("5) by strenght of superhero");
        System.out.println("6) by human status");
        System.out.println("7) Quit to main menu");

        boolean isRunning = true;
        while (isRunning) {
            int userChoice = 1;

            switch (userChoice) {
                case 1 -> {
                    System.out.println("Superheroes by name: ");
                }
                case 2 -> {
                    System.out.println("Superheroes by real name: ");
                }
                case 3 -> {
                    System.out.println("Superheroes by year of origin: ");
                }
                case 4 -> {
                    System.out.println("Superheroes by type of superpowers: ");
                }
                case 5 -> {
                    System.out.println("Superheroes by strenght: ");
                }
                case 6 -> {
                    System.out.println("Superheroes by human status: ");
                }
                case 7 -> {
                    System.out.println("Returning to menu");
                    isRunning = false;
                }
                default -> {
                    System.out.println("I don't understand that command, which type of sorted list would you like?");
                    System.out.println("If you wish to return to menu, type quit");
                }
            }

        }
    }

    public void søgHelt() {
        System.out.println("---------------------------------\nSøg efter superhelt:");

        System.out.println("Indtast navnet på den superhelt du ønsker at finde");
        String searchTerm = scanner.next();
        ArrayList<Superhero> searchResult = database.searchFor(searchTerm);

        if (searchResult.isEmpty()) {
            System.out.println("Ingen superhelte fundet");

        } else {
            System.out.println("Superhelte fundet: ");
            for (Superhero superhero : searchResult) {
                System.out.println(superhero);
            }
        }
    }

    public void redigerHelt() {
        System.out.println("Indtast navnet på den superhelt du ønsker at redigere:");
        String searchTerm = scanner.next();
        ArrayList<Superhero> searchResult = database.searchFor(searchTerm);

        if (searchResult.isEmpty()) {
            System.out.println("Ingen superhelte fundet.");

        } else {
            System.out.println("Superhelte fundet: ");
            for (int i = 0; i < searchResult.size(); i++) {
                System.out.println(((i) + 1) + ") " + searchResult.get(i));
            }
            System.out.println("\nHvilket nr. har superhelten du vil redigere?:");
            int number = scanner.nextInt();
            scanner.nextLine();
            Superhero hero = searchResult.get(number - 1);


            System.out.println("Indtast det nye superheltenavn eller tryk 'enter' for at beholde det nuværende:");
            String helteNavn = scanner.nextLine();

            if (!helteNavn.isEmpty()) {
                hero.setHelteNavn(helteNavn);
            }
            System.out.println("Indtast det nye navn eller tryk enter:");
            String ægteNavn = scanner.nextLine();

            if (!ægteNavn.isEmpty()) {
                hero.setÆgteNavn(ægteNavn);
            }

            System.out.println("Indtast den nye superkraft eller tryk enter:");
            String superkraft = scanner.nextLine();

            if (!superkraft.isEmpty()) {
                hero.setSuperkraft(superkraft);
            }


            boolean writingError = false;
            do {
                try {
                    System.out.println("Skriv oprindelsesåret for din superhelt:");
                    String årstal = scanner.nextLine();
                    if (!årstal.isEmpty()) {
                        hero.setÅrstal(Integer.parseInt(årstal));
                    }
                    writingError = false;

                } catch (NumberFormatException e) {
                    System.out.println("Der opstod en fejl - Prøv igen.");
                    writingError = true;
                }

            } while (writingError == true);

            System.out.println("Superhelt ændret til:\n " + hero);
        }
    }

    public void loadData() throws FileNotFoundException {
        Filehandler filehandler = new Filehandler();
        ArrayList<Superhero> superheroes = filehandler.loadData();
        database.updateSuperheroList(superheroes);
    }

    public void gemData() throws FileNotFoundException {
        Filehandler filehandler = new Filehandler();
        filehandler.gemData(database.getAllSuperHeroes());
        loadData();
    }

    public void sletHelt() {

        System.out.println("Søg efter den helt du vil slette fra databasen:");
        String searchTerm = scanner.next();
        ArrayList<Superhero> searchResult = database.searchFor(searchTerm);

        if (searchResult.isEmpty()) {
            System.out.println("Ingen superhelt(e) fundet.\n");

        } else {
            System.out.println("Superhelt(e) fundet: ");
            for (int i = 0; i < searchResult.size(); i++) {
                System.out.println(((i) + 1) + ") " + searchResult.get(i));
            }
            System.out.println("\nHvilket nr. har superhelten du vil slette?:");
            int number = scanner.nextInt();
            scanner.nextLine();
            Superhero superhero = searchResult.get(number - 1);

            System.out.println("Er du sikker på, at du vil slette superhelten? (true/false): ");
            boolean delete = scanner.nextBoolean();
            if (delete == true) {
                database.deleteSuperhero(superhero);

                System.out.println("Superhelt slettet fra database.");

            } else if (delete == false) {
                System.out.println("Sletter ikke superhelt.");

            }
        }
    }
}











