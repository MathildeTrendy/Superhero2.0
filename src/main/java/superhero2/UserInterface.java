package superhero2;

import java.io.IOException;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Controller controller = new Controller();
    int menuvalg;
    int valg;

    public void startMenu() throws IOException {
        controller.loadData();
        do {
            System.out.println("--------------------------------- \n Velkommen til superhelteverdenen!");
            System.out.println("---------------------------------");
            System.out.println(" 1) Opret ny superhelt \n " +
                    "2) Vis alle superhelte \n " +
                    "3) Vis sortet liste \n " +
                    "3) Søg efter superhelt  \n " +
                    "4) Redigér helt \n " +
                    "5) Slet helt \n " +
                    "6) Gem helt \n " +
                    "7) load data \n " +
                    "9) Luk databasen \n ---------------------------------");


            int valg = scanner.nextInt();
            scanner.nextLine();
            if (valg == 1) {
                controller.opretSuperheroMenu();
            } else if (valg == 2) {
                controller.listeMenu();
            } else if (valg == 3) {
                controller.showSortedList();
            } else if (valg == 4) {
                controller.søgHelt();
            } else if (valg == 5) {
                controller.redigerHelt();
            } else if (valg == 6) {
                controller.sletHelt();
            } else if (valg == 7) {
                controller.gemData();
            } /*else if (valg == 8){
                controller.loadData();
            }*/ else if (valg == 9) {
                System.exit(0);
            }

        } while (valg != 9);
    }
}
