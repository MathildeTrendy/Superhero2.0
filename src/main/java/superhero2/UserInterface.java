package superhero2;

import superhero2.comparator.*;

import javax.naming.Name;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class UserInterface {
    Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
    Controller controller = new Controller();

    int valg;

    public void startMenu() throws IOException {

        do {
            System.out.println("--------------------------------- \n Welcome to the world of Superheroes!");
            System.out.println("---------------------------------");
            System.out.println(" 1) Create new superhero \n " +
                    "2) Show list of all superheroes \n " +
                    "3) Search for a superhero  \n " +
                    "4) Sort list of heroes \n " +
                    "5) Edit hero \n " +
                    "6) Delete hero \n " +
                    "7) Save data \n " +
                    "8) Load data \n " +
                    "9) Exit database \n ---------------------------------");


            int valg = scanner.nextInt();
            scanner.nextLine();

            if (valg == 1) {
                System.out.println("Create superhero\n");

                System.out.println("Type a superhero name(fx Superman):");
                String heroName = scanner.nextLine();

                System.out.println("Type the superheroes real name:");
                String realName = scanner.nextLine();

                System.out.println("Type superpower:");
                String superpower = scanner.nextLine();

                System.out.println("Is the superhero a human(yes/no):");
                boolean human = scanner.nextLine().substring(0, 1).equalsIgnoreCase("j");

                System.out.println("Type the creation year of the superhero:");
                int creationYear = scanner.nextInt();

                System.out.println("Type superhero strength");
                double strength = scanner.nextDouble();
                System.out.println("In order to save, load and see your superheroes, follow the main menu");
                controller.createSuperhero(heroName, realName, creationYear, superpower, human, strength);

            } else if (valg == 2) {
                System.out.println("List of superheroes:\n");
                for (Superhero superhero : controller.getListOfAllSuperHeroes()) {
                    System.out.println("Superhero name: " + superhero.getHeroName()
                            + "\n" + "Real name: " + superhero.getRealName()
                            + "\n" + "Creation year: " + superhero.getCreationYear()
                            + "\n" + "Superpower: " + superhero.getSuperpower()
                            + "\n" + "Is human: " + superhero.getHumanternary()
                            + "\n" + "Strength: " + superhero.getStrength() + "\n");
                }

            } else if (valg == 3) {
                System.out.println("---------------------------------\nSearch for superhero:");

                System.out.println("Type the name of your favorite superhero");
                String searchTerm = scanner.next();
                ArrayList<Superhero> searchResult = controller.searchFor(searchTerm);

                if (searchResult.isEmpty()) {
                    System.out.println("No hero found");

                } else {
                    System.out.println("Superhero found: ");
                    for (Superhero superhero : searchResult) {
                        System.out.println(superhero);
                    }
                }

            } else if (valg == 4) {
                Scanner scanner = new Scanner(System.in);
                int userInput = 0;
                boolean isRunning = true;

                while (userInput != 7) {
                    System.out.println("Choose how you would like to sort your heroes: ");
                    System.out.println("1) by superhero name");
                    System.out.println("2) by real name");
                    System.out.println("3) by year of origin");
                    System.out.println("4) by type of superpowers");
                    System.out.println("5) by strength of superhero");
                    System.out.println("6) by human status");
                    System.out.println("7) Quit to main menu");

                    do {
                        userInput = scanner.nextInt();
                        scanner.nextLine();

                        switch (userInput) {
                            case 1 -> {
                                //Arrays.sort(Superhero, new NameComparator());
                                System.out.println("List is sorted by their real name : ");
                            }
                            case 2 -> {
                                System.out.println("Superheroes by Superhero name: ");
                            }
                            case 3 -> {
                                System.out.println("Superheroes by year of origin: ");
                            }
                            case 4 -> {
                                System.out.println("Superheroes by type of superpowers: ");
                            }
                            case 5 -> {
                                System.out.println("Superheroes by strength: ");

                            }
                            case 6 -> {
                                System.out.println("Superheroes by human status: ");
                                //Collections.sort(Su, new Human());
                            }
                            case 7 -> {
                                System.out.println("Returning to main menu");
                                isRunning = false;
                            }
                            default -> {
                                System.out.println("I don't understand that command, which type of sorted list would you like?");
                                System.out.println("If you wish to return to menu, type 7");
                            }
                        }
                    } while (isRunning);
                }
            } else if (valg == 5) {
                System.out.println("Type the name of the superhero you'd like to edit:");
                String searchTerm = scanner.next();
                ArrayList<Superhero> searchResult = controller.searchFor(searchTerm);

                if (searchResult.isEmpty()) {
                    System.out.println("No superhero found");

                } else {
                    System.out.println("Superhero found: ");
                    for (int i = 0; i < searchResult.size(); i++)
                        System.out.println(((i) + 1) + ") " + searchResult.get(i));
                }
                System.out.println("\nWhat number does the superhero have, that you'd like to edit?:");
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

                System.out.println("Type the new strength for the hero or press 'enter':");
                String strength = scanner.nextLine();
                if (!strength.isEmpty()){
                    hero.setStrength(Double.parseDouble(strength));
                }

                System.out.println("Superhero changed to:\n " + hero);

                System.out.println("Remember to save (type '7) to save your changes");

            } else if (valg == 6) {
                System.out.println("Search for the hero you want to remove from the database:");
                String searchTerm = scanner.next();
                ArrayList<Superhero> searchResult = controller.searchFor(searchTerm);

                if (searchResult.isEmpty()) {
                    System.out.println("No superhero(es) found.\n");

                } else {
                    System.out.println("Superhero(es) found: ");
                    for (int i = 0; i < searchResult.size(); i++) {
                        System.out.println(((i) + 1) + ") " + searchResult.get(i));
                    }
                    System.out.println("\nWhat number does the superhero have, that you wish to delete?:");
                    int number = scanner.nextInt();
                    scanner.nextLine();
                    Superhero superhero = searchResult.get(number - 1);

                    System.out.println("Are you sure, you want to delete the superhero? (true/false): ");
                    boolean delete = scanner.nextBoolean();
                    if (delete == true) {
                        controller.deleteSuperhero(superhero);

                        System.out.println("Superhero deleted from database.");

                    } else if (delete == false) {
                        System.out.println("Superhero not deleted.");

                    }
                }
            } else if (valg == 7) {
                controller.saveData();
                System.out.println("Data saved");
            } else if (valg == 8) {
                controller.loadData();
                System.out.println("Data loaded");
            } else if (valg == 9) {
                System.exit(0);
            }


        } while (valg != 9);


    }

}