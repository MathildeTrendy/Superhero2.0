import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Filehandler {
    public ArrayList<Superhero> loadData(ArrayList<Superhero> allSuperHeroes) throws FileNotFoundException {
        Scanner Scan = new Scanner(new File("Superheroes.csv"));

        ArrayList<Superhero> superheroes = new ArrayList<>();

        Scan.nextLine();

        while (Scan.hasNextLine()) {
            String line = Scan.nextLine();
            System.out.println(line);

            Superhero heroObject = splitLines(line);

            superheroes.add(heroObject);
        }
        return superheroes;
    }

    public void gemData(ArrayList<Superhero> superheroes) throws FileNotFoundException {

        PrintStream output = new PrintStream(new File("Superheroes.csv"));

        for (Superhero superhero : superheroes) {
            output.println(superhero.getHelteNavn());
            output.println(superhero.getÆgteNavn());
            output.println(superhero.getÅrstal());
            output.println(superhero.getSuperkraft());
            output.println(superhero.getHuman());
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








}
