package superhero2;

import org.testng.annotations.Test;

    class ControllerTest {

    @Test
    void createSuperhero() {
    }

    @Test
    void listeMenu() {
    }

    @Test
    void searchHero() {
        Controller controller = new Controller();
        //Arrange
       //controller.createSuperhero("Hans", realName, creationYear, superpower, human, strength  );
       //controller.createSuperhero("Bjarne", realName, creationYear, superpower, human, strength  );
        //Act
        //ArrayList <Superhero> searchResult = controller.searchHero("Hans");
        //Assert
        //assertEquals(1,searchResult.size()); //testsproget - forventer at det er sandt: expected og faktiske
    }

    @Test
    void searchHeroIgnoreCase() {
        /*Controller controller = new Controller();
        //Arrange
        controller.createSuperhero("Hans", realName, creationYear, superpower, human, strength  );
        controller.createSuperhero("Bjarne", realName, creationYear, superpower, human, strength  );
        //Act
        ArrayList <Superhero> searchResult = controller.searchHero("haNS");
        //Assert
        assertEquals(1,searchResult.size()); //testsproget - forventer at det er sandt: expected og faktiske*/
    }

    @Test
    void editHero() {
    }

    @Test
    void loadData() {
    }

    @Test
    void saveData() {
    }

    @Test
    void deleteHero() {
    }

    @Test
    void sortedList() {
    }
}