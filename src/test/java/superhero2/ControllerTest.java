package superhero2;

import org.testng.annotations.Test;

import javax.xml.crypto.Data;
import java.util.ArrayList;

import static org.testng.AssertJUnit.assertEquals;

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
        Database database = new Database();
        //Controller controller = new Controller();
        //Arrange

        database.createSuperhero("Superman", "Kent Clark",1980, "Flight", true, 100  );
        database.createSuperhero("Wonder Woman", "Diana Prince", 1890, "Super human strength",true, 100  );
        database.createSuperhero("Bobbel","Bobbel", 2004, "Tale med dyr", false, 70 );
        //Act
        ArrayList <Superhero> searchResult = database.searchFor ("superman");
        //Assert
        assertEquals(1,searchResult.size()); //testsproget - forventer at det er sandt: expected og faktiske*/
        Superhero superhero = searchResult.get(0);
        assertEquals("Superman", superhero.getHeroName());
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