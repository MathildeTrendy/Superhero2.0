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

        //Scan.nextLine();

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
            output.print(superhero.getStrength());
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
        Double Strenght = Double.parseDouble(splits[5]);

        return helteData;
    }

    }
