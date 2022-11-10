package superhero2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Filehandler {
    private final String path = "data/Superheroes.csv";

    public ArrayList<Superhero> loadData() throws FileNotFoundException {
        Scanner scan = new Scanner(new File(path));
        ArrayList<Superhero> superheroes = new ArrayList<>();

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            Superhero heroObject = splitLines(line);

            superheroes.add(heroObject);
        }
        return superheroes;
    }

    public void saveData(ArrayList<Superhero> superheroes) throws FileNotFoundException {

        PrintStream output = new PrintStream(path);

        for (Superhero superhero : superheroes) {
            output.print(superhero.getHeroName());
            output.print(";");
            output.print(superhero.getRealName());
            output.print(";");
            output.print(superhero.getCreationYear());
            output.print(";");
            output.print(superhero.getSuperpower());
            output.print(";");
            output.print(superhero.isHuman());
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
        int creationYear = Integer.parseInt(splits[2]);
        heroData.setCreationYear(creationYear);
        heroData.setSuperpower(splits[3]);
        boolean human = Boolean.parseBoolean(splits[4]);
        heroData.setHuman(human);
        Double strength = Double.parseDouble(splits[5]);
        heroData.setStrength(strength);

        return heroData;
    }
}
