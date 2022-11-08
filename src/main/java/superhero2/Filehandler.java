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

        ArrayList<Superhero> superheroes = new ArrayList<>();

        while (Scan.hasNextLine()) {
            String line = Scan.nextLine();
            System.out.println(line);

            Superhero heroObject = splitLines(line);

            superheroes.add(heroObject);
        }
        return superheroes;
    }

    public void saveData(ArrayList<Superhero> superheroes) throws FileNotFoundException {

        PrintStream output = new PrintStream(new File(path));

        //navn;ægtenavn;
        for (Superhero superhero : superheroes) {
            output.print(superhero.getHeroName());
            output.print(";");
            output.print(superhero.getRealName());
            output.print(";");
            output.print(superhero.getCreationYear());
            output.print(";");
            output.print(superhero.getSuperpower());
            output.print(";");
            output.print(superhero.getHuman());
            output.print(";");
            output.print(superhero.getStrength());
            output.println();
        }
    }

    private Superhero splitLines(String linje) {
        String[] splits = linje.split(";");

        Superhero heroData = new Superhero();

        heroData.setHeroName(splits[0]);
        heroData.setRealName(splits[1]);
        int CreationYear = Integer.parseInt(splits[2]);
        heroData.setSuperpower(splits[3]);
        boolean human = Boolean.parseBoolean(splits[4]);
        Double Strength = Double.parseDouble(splits[5]);
        heroData.setHuman(human);

        return heroData;
    }

    }
