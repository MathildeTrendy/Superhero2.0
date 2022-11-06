import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Filehandler {

    private Superhero splitLines(String linje) {
        String[] splits = linje.split(";");
        Superhero helteData = new Superhero();

        helteData.setHelteNavn(splits[0]);
        helteData.setÆgteNavn(splits[1]);
        helteData.setÅrstal(Integer.parseInt(splits[2]));
        helteData.setSuperkraft(splits[3]);
        helteData.setHuman(Boolean.parseBoolean(splits[4]));

        return helteData;
    }


    public void LoadData (ArrayList<Superhero> superheroes) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("Data/Superheroes.csv"));
        superheroes.clear();
        scan.nextLine();

        while(scan.hasNextLine()){
            String linje = scan.nextLine();
            Superhero superhero = splitLines(linje);
            superheroes.add(superhero);
        }
    }

    public void gemData (ArrayList<Superhero> superheroes) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("Data/Superheroes.csv"));
        for (Superhero superhero: superheroes){
            output.println(superhero.getHelteNavn());
            output.println(superhero.getÆgteNavn());
            output.println(superhero.getÅrstal());
            output.println(superhero.getSuperkraft());
            output.println(superhero.getHuman());
        }

    }
}
