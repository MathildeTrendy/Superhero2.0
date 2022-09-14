import java.util.Scanner;
public class Main {

    Scanner scanner = new Scanner(System.in);
    Database database = new Database();

    int menuvalg;
    int valg;


    public void startMenu() {
        database.createTestData();
        do {
            System.out.println("--------------------------------- \n Velkommen til superhelteverdenen!");
            System.out.println("---------------------------------");
            System.out.println(" 1) Opret ny superhelt \n 2) Søg efter superhelt \n 5) Vis alle superhelte  \n 9) Luk databasen \n ---------------------------------");


            int valg = scanner.nextInt();
            scanner.nextLine();
            if (valg == 1) {
                opretSuperheroMenu();
            }
            else if (valg == 2){
                søgHelt();
            }
            else if (valg == 9) {
                System.exit(0);

            } else if (valg == 5) {
                listeMenu();
            }

        } while (valg != 9);
    }



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
        for (Superhero superhero : database.getSuperheroes()){
            System.out.println("Heltenavn: " + superhero.getHelteNavn() + "\n" + "Rigtige navn: " + superhero.getÆgteNavn() + "\n" + "Oprindelsesår: " + superhero.getÅrstal() + "\n" + "Superkraft: " + superhero.getSuperkraft() + "\n" + "Er et menneske: " + superhero.getHuman() + "\n");

        }
    }

    public void søgHelt() {
        System.out.println("---------------------------------\nSøg efter superhelt:");
        String searchTerm = scanner.nextLine();
        Superhero fundet = database.searchFor(searchTerm);
        if (fundet == null){
            System.out.println("Intet resultat");
            System.out.println("---------------------------------");
        }
        else{
        System.out.println("Heltenavn: " + fundet.getHelteNavn() + "\n" + "Rigtige navn: " + fundet.getÆgteNavn() + "\n" +
        "Oprindelsesår: " + fundet.getÅrstal() + "\n" + "Superkraft: " + fundet.getSuperkraft() + "\n" + "Er et menneske: " + fundet.getHuman());
        }


    }

//Programmet startes
    public static void main(String[] args) {
        Main program = new Main();
        program.startMenu();
    }
}












