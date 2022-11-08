package superhero2;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
    Controller controller = new Controller();

    int choice;

    public void startMenu() throws IOException {

        do {
            System.out.println("--------------------------------- \n Welcome to the world of Superheroes!");
            System.out.println("---------------------------------");
            System.out.println(" 1) Create new superhero \n " +
                    "2) View list of all superheroes \n " +
                    "3) Search superhero  \n " +
                    "4) Sorted list of heroes \n " +
                    "5) Edit hero \n " +
                    "6) Delete hero \n " +
                    "7) Save hero \n " +
                    "8) Load data \n " +
                    "9) Exit database \n ---------------------------------");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                controller.createSuperhero();
            } else if (choice == 2) {
                controller.listeMenu();
            } else if (choice == 3) {
                controller.searchHero();
            }else if (choice == 4) {
                controller.sortedList(); //Sorted list by users choice
            } else if (choice == 5) {
                controller.editHero();
            } else if (choice == 6) {
                controller.deleteHero();
            } else if (choice == 7){
                controller.saveData();
            } else if (choice == 8) {
            controller.loadData();
            } else if (choice == 9) {
            System.exit(0);
        }
        }while (choice != 9);

    }
}