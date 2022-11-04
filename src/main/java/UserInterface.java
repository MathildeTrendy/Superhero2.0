import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Controller controller = new Controller();

    int menuvalg;
    int valg;

    public void startMenu() {
        do {
            System.out.println("--------------------------------- \n Velkommen til superhelteverdenen!");
            System.out.println("---------------------------------");
            System.out.println(" 1) Opret ny superhelt \n 2) Vis alle superhelte \n 3) Søg efter superhelt  \n 4) rediger helt \n 5) slet helt \n 6) gem helte  \n 9) Luk databasen \n ---------------------------------");


            int valg = scanner.nextInt();
            scanner.nextLine();
            if (valg == 1) {
                controller.opretSuperheroMenu();
            } else if (valg == 2) {
                controller.listeMenu();
            } else if (valg == 3) {
                controller.søgHelt();
            } else if (valg == 4) {
                controller.redigerHelt();
            } else if (valg == 5) {
                controller.sletHelt();
            } else if (valg == 6) {
                controller.gemHelt();
            } else if (valg == 9) {
                System.exit(0);
            }

        } while (valg != 9);
    }





}
