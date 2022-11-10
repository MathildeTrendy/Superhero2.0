package superhero2;

import superhero2.comparator.*;

import javax.naming.Name;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class UserInterface {
    Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
    Controller controller = new Controller();

    int userChoice;

    public void startMenu() throws IOException {
        controller.loadData();
        do {
            System.out.println("--------------------------------- \n Welcome to the world of Superheroes!");
            System.out.println("---------------------------------");
            System.out.println(" 1) Create new superhero \n " +
                    "2) Show list of all superheroes \n " +
                    "3) Search for a superhero  \n " +
                    "4) Edit hero \n " +
                    "5) Delete hero \n " +
                    "6) Save data \n " +
                    "7) Sort list of heroes \n " +
                    "8) Sort list of heroes by two parameters \n" +
                    "9) Exit database \n ---------------------------------");


            int userChoice = scanner.nextInt();
            scanner.nextLine();

            if (userChoice == 1) {
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

            } else if (userChoice == 2) {
                System.out.println("List of superheroes:\n");
                for (Superhero superhero : controller.getListOfAllSuperHeroes()) {
                    System.out.println("Superhero name: " + superhero.getHeroName()
                            + "\n" + "Real name: " + superhero.getRealName()
                            + "\n" + "Creation year: " + superhero.getCreationYear()
                            + "\n" + "Superpower: " + superhero.getSuperpower()
                            + "\n" + "Human: " + superhero.getHumanternary()
                            + "\n" + "Strength: " + superhero.getStrength() + "\n");
                }

            } else if (userChoice == 3) {
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

            } else if (userChoice == 4) {
                System.out.println("Type the name of the superhero you'd like to edit:");
                String searchTerm = scanner.next();
                ArrayList<Superhero> searchResult = controller.searchFor(searchTerm);

                if (searchResult.isEmpty()) {
                    System.out.println("No superhero found");

                } else {
                    System.out.println("Superhero found: ");
                    for (int i = 0; i < searchResult.size(); i++)
                        System.out.println(((i) + 1) + ") " + searchResult.get(i));

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
                    if (!strength.isEmpty()) {
                        hero.setStrength(Double.parseDouble(strength));
                    }

                    System.out.println("Superhero changed to:\n " + hero);

                    System.out.println("Remember to save (type '7') to save your changes");
                }

            } else if (userChoice == 5) {
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
            } else if (userChoice == 6) {
                controller.saveData();
                System.out.println("Data saved");

            } else if (userChoice == 7) {
                Scanner scanner = new Scanner(System.in);
                int userInput = 0;
                boolean isRunning;
                String sortedInput = "";

                    // Menu for list of sorted superheroes
                    System.out.println("Choose how you would like to sort your heroes: ");
                    System.out.println("1) By superhero name");
                    System.out.println("2) By real name");
                    System.out.println("3) By year of origin");
                    System.out.println("4) By type of superpowers");
                    System.out.println("5) By strength of superhero");
                    System.out.println("6) By human status");
                    System.out.println("7) Quit to main menu");

                    ArrayList<Superhero> sortedList = controller.getListOfAllSuperHeroes();

                    try {
                        userInput = scanner.nextInt();
                        scanner.nextLine();
                        switch (userInput) {
                            case 1 -> {
                                Collections.sort(sortedList, new NameComparator());
                                System.out.println("List is sorted by their real name : " + sortedList);
                            }
                            case 2 -> {
                                Collections.sort(sortedList, new SuperheroName());
                                System.out.println("Superheroes by Superhero name: " + sortedList);
                            }
                            case 3 -> {
                                Collections.sort(sortedList, new CreationYear());
                                System.out.println("Superheroes by year of origin: " + sortedList);
                            }
                            case 4 -> {
                                Collections.sort(sortedList, new SuperPower());
                                System.out.println("Superheroes by type of superpowers: " + sortedList);
                            }
                            case 5 -> {
                                Collections.sort(sortedList, new Strength());
                                System.out.println("Superheroes by strength: " + sortedList);

                            }
                            case 6 -> {
                                Collections.sort(sortedList, new Human());
                                System.out.println("Superheroes by human status: " + sortedList);
                                //Collections.sort(Su, new Human());
                            }
                            case 7 -> {
                                System.out.println("Returning to main menu");
                                isRunning = false;
                            }
                        }

                        isRunning = false;
                    } catch (InputMismatchException e) {
                        System.out.println("I don't understand that command, which type of sorted list would you like?");
                        System.out.println("If you wish to return to menu, type 7");
                        isRunning = true;
                        scanner.nextLine();
                    }
                }
                else if (userChoice == 8) {
            Scanner scanner1 = new Scanner(System.in);
            int userInput1 = 0;
            String primary = "";
            String secondary = "";
            boolean isRunning;

            System.out.println("Sort superheroes by a requested primary and secondary attribute, begin with primary value ");
            System.out.println("""
                    1. Superhero name 
                    2. Superhero real name 
                    3. Superhero creation year 
                    4. Superpower
                    5. Superhero human status
                    6. Strength """);

            System.out.println("9. exit ");
            // Do-while loop that´s keep looping through if userinput is true

            ArrayList<Superhero> sortedListsecondaryandprimary = controller.getListOfAllSuperHeroes();

                try {
                    userInput1 = scanner1.nextInt();
                    scanner1.nextLine();
                    switch (userInput1) {
                        case 1 -> {
                            Collections.sort(sortedListsecondaryandprimary, new NameComparator());
                            primary = "Sort superheroes by Superhero name: ";
                        }
                        case 2 -> {
                            primary = "Sort superheroes by real name: ";
                        }
                        case 3 -> {
                            primary = "Sort superheroes by year of origin: ";
                        }
                        case 4 -> {
                            primary = "Superheroes by type of superpowers: ";
                        }
                        case 5 -> {
                            primary = "Superheroes by human status: ";
                        }
                        case 6 -> {
                            primary = "Superheroes by strength: ";
                        }
                    }

                    System.out.println("Choose your requested secondary value");
                    System.out.println("""
                            1. Superhero name 
                            2. Superhero real name 
                            3. Superhero creation year 
                            4. Superpower
                            5. Superhero human status
                            6. Strength 
                            7. None """);

                    int secondInput = scanner.nextInt();
                    scanner1.nextLine();

                    switch (secondInput) {
                        case 1 -> {
                            secondary = "Sort your second requested value as superheroes by Superhero name: ";
                        }
                        case 2 -> {
                            secondary = "Sort your second requested value as superheroes by  real name: ";
                        }
                        case 3 -> {
                            secondary = "Sort your second requested value as superheroes by year of origin: ";
                        }
                        case 4 -> {
                            secondary = "Sort your second requested value as superheroes by superpowers: ";
                        }
                        case 5 -> {
                            secondary = "Sort your second requested value as superheroes by human status: ";
                        }
                        case 6 -> {
                            secondary = "Sort your second requested value as superheroes by strength: ";
                        }
                        case 7 -> {
                            secondary = "None";
                        }
                    }
                    System.out.println(sortedListsecondaryandprimary);

                    isRunning = false;
                } catch (InputMismatchException e) {
                    System.out.println("Unkown command, try again");
                    isRunning = true;
                    scanner.nextLine();
                }}

        } while (userChoice != 9);
    System.exit(0);
}}