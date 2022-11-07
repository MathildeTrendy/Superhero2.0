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
            System.out.println("--------------------------------- \n Welcome to the Superhero World!");
            System.out.println("---------------------------------");
            System.out.println(" 1) Create new superhero \n " +
                    "2) Show all superheroes \n " +
                    "3) Search superhero  \n " +
                    "4) Edit hero \n " +
                    "5) Delete hero \n " +
                    "6) Save hero \n " +
                    "7) Load data \n " +
                    "9) Exit database \n ---------------------------------");


            int valg = scanner.nextInt();
            scanner.nextLine();
            if (valg == 1) {
                controller.createSuperHero();//??
            } else if (valg == 2) {
                controller.listeMenu();
            } else if (valg == 3) {
                controller.searchHero();
            } else if (valg == 4) {
                controller.editHero();
            } else if (valg == 5) {
                controller.deleteHero();
            } else if (valg == 6) {
                controller.saveData(); //??
            } /*else if (valg == 7){
                controller.loadData();
            }*/ else if (valg == 9) {
                System.exit(0);
            }

        } while (valg != 9);
    }
}
