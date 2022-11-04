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

        System.out.println("Er superhelten et menneske? (alternativ et rumvæsen):");
        boolean human = scanner.nextBoolean();

        System.out.println("Indtast superheltens oprindelsesår:");
        int årstal = scanner.nextInt();

        database.createSuperhero(heltenavn, ægtenavn, årstal, superkraft, human);
    }

    public void listeMenu() {
        System.out.println("Liste over superhelte:\n");
        for (Superhero superhero : database.getSuperheroes()) {
            System.out.println("Heltenavn: " + superhero.getHelteNavn() + "\n" + "Rigtige navn: " + superhero.getÆgteNavn() + "\n" + "Oprindelsesår: " + superhero.getÅrstal() + "\n" + "Superkraft: " + superhero.getSuperkraft() + "\n" + "Er et menneske: " + superhero.getHuman() + "\n");

        }
    }

    public void søgHelt() {
        System.out.println("---------------------------------\nSøg efter superhelt:");

        String searchTerm = scanner.nextLine();
        Superhero fundet = database.searchFor(searchTerm);
        if (fundet == null) {
            System.out.println("Intet resultat");
            System.out.println("---------------------------------");
        } else {
            System.out.println("Heltenavn: " + fundet.getHelteNavn() + "\n" + "Rigtige navn: " + fundet.getÆgteNavn() + "\n" +
                    "Oprindelsesår: " + fundet.getÅrstal() + "\n" + "Superkraft: " + fundet.getSuperkraft() + "\n" + "Er et menneske: " + fundet.getHuman());
        }
    }

    public static void redigerHelt() {

    }

    public static void gemHelt() {

    }

    public void sletHelt() {
        String searchTerm = scanner.nextLine();

        ArrayList<Superhero> searchresults = database.searchFor(searchTerm);

            if (searchresults.isEmpty()) {
                System.out.println("Ingen resultater fundet med søgeterm: " + searchTerm);
            } else {
                int index = 1;
                for (Superhero searchResults : searchresults) {
                    System.out.println(index++ + ") " + searchResults.getHelteNavn());
                }
                System.out.println("Vælg den superhelt du vil slette: ");
                int superheroPick = 1;

                superheroPick = Integer.parseInt(scanner.nextLine());
                Superhero sletHelt = searchresults.get(superheroPick - 1);

                database.sletHelt(sletHelt);
                System.out.println(sletHelt.getHelteNavn() + " er nu slettet fra databasen");
            }
        }
    }
    }
