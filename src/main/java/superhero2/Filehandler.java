package superhero2;

import superhero2.comparator.*;

import javax.naming.Name;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Filehandler {
    private String path = "data/Superheroes.csv";
    public ArrayList<Superhero> loadData () throws FileNotFoundException {
        Scanner Scan = new Scanner(new File(path));

        ArrayList<Superhero> superheroesforfsake = new ArrayList<>();

        //Scan.nextLine();

        while (Scan.hasNextLine()) {
            String line = Scan.nextLine();
            System.out.println(line);

            Superhero heroObject = splitLines(line);

            superheroesforfsake.add(heroObject);
        }
        return superheroesforfsake;
    }

    public void gemData(ArrayList<Superhero> superheroes) throws FileNotFoundException {

        PrintStream output = new PrintStream(new File(path));

        //navn;ægtenavn;
        for (Superhero superhero : superheroes) {
            output.print(superhero.getHelteNavn());
            output.print(";");
            output.print(superhero.getÆgteNavn());
            output.print(";");
            output.print(superhero.getÅrstal());
            output.print(";");
            output.print(superhero.getSuperkraft());
            output.print(";");
            output.print(superhero.getHuman());
            output.println();
        }
    }

    private Superhero splitLines(String linje) {
        String[] splits = linje.split(";");

        Superhero helteData = new Superhero();

        helteData.setHelteNavn(splits[0]);
        helteData.setÆgteNavn(splits[1]);

        int Årstal = Integer.parseInt(splits[2]);

        helteData.setSuperkraft(splits[3]);

        boolean human = Boolean.parseBoolean(splits[4]);
        helteData.setHuman(human);

        return helteData;
    }

    //Sort entries, using Arraylist of superheroes
    // Collections.sort(ar, new Sortbyroll());
    /*public void sort(){
        Collections.sort(superheroesforfsake, new NameComparator());
        Collections.sort(superheroes, new Strength());
        Collections.sort(superheroes, new SuperheroName());
        Collections.sort(superheroes, new SuperPower());
        Collections.sort(superheroes, new CreationYear());
        Collections.sort(superheroes, new Human());
    }
*/
    public void SortedList() {
        Scanner scanner = new Scanner(System.in);
        int userInput = 0;
        boolean isRunning = true;

        while (userInput != 7) {
            System.out.println("Chose how you would like to sort your list:");
            System.out.println("1) by superhero name");
            System.out.println("2) by real name");
            System.out.println("3) by year of origin");
            System.out.println("4) by type of superpowers");
            System.out.println("5) by strenght of superhero");
            System.out.println("6) by human status");
            System.out.println("7) Quit to main menu");

            do {
                userInput = scanner.nextInt();
                scanner.nextLine();

                switch (userInput) {
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
    }}
