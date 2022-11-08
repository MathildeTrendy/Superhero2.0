package superhero2;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
    Controller controller = new Controller();

    int valg;

    public void startMenu() throws IOException {

        do {
            System.out.println("--------------------------------- \n Welcome to the world of Superheroes!");
            System.out.println("---------------------------------");
            System.out.println(" 1) Create new superhero \n " +
                    "2) Show all superheroes \n " +
                    "3) Search superhero  \n " +
                    "4) Sorted list of heroes \n " +
                    "5) Edit hero \n " +
                    "6) Delete hero \n " +
                    "7) Save hero \n " +
                    "8) Load data \n " +
                    "9) Exit database \n ---------------------------------");

            int valg = scanner.nextInt();
            scanner.nextLine();

            if (valg == 1) {
                controller.createSuperhero();
            } else if (valg == 2) {

                System.out.println("List of superheroes:\n");
                for (Superhero superhero : controller.getListOfAllSuperHeroes()) {
                    System.out.println("Superhero name: " + superhero.getHeroName() + "\n" + "Real name: " + superhero.getRealName() + "\n" + "Creation year: " + superhero.getCreationYear() + "\n" + "Superpower: " + superhero.getSuperpower() + "\n" + "Is human: " + superhero.getHuman() + "\n");
                }


            } else if (valg == 3) {
                controller.searchHero();
            }else if (valg == 4) {
                controller.sortedList(); //Sorted list by users choice
            } else if (valg == 5) {
                controller.editHero();
            } else if (valg == 6) {
                controller.deleteHero();
            } else if (valg == 7){
                controller.saveData();
            } else if (valg == 8) {
            controller.loadData();
            } else if (valg == 9) {
            System.exit(0);
        }
        }while (valg != 9);

    }
}