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
                        Collections.sort(superheroesDB, new NameComparator());
                    }

                    case 2 -> {
                        System.out.println("Superheroes by real name: ");
                        Collections.sort(superheroesDB, new NameComparator());
                    }

                    case 3 -> {
                        System.out.println("Superheroes by year of origin: ");
                        Collections.sort(superheroesDB, new CreationYear());
                    }

                    case 4 -> {
                        System.out.println("Superheroes by type of superpowers: ");
                        Collections.sort(superheroesDB, new SuperPower());
                    }

                    case 5 -> {
                        System.out.println("Superheroes by strenght: ");
                        Collections.sort(superheroesDB, new Strength());
                    }

                    case 6 -> {
                        System.out.println("Superheroes by human status: ");
                        Collections.sort(superheroesDB, new Human());
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



