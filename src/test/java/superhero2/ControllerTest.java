package superhero2;

import org.testng.annotations.Test;

import javax.xml.crypto.Data;
import java.util.ArrayList;

import static org.testng.AssertJUnit.assertEquals;

class ControllerTest {
    public Controller controller = new Controller();


    @Test
    void searchHeroIgnoreCase() {
        Database database = new Database();

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
    void sortedHeroName() {
        //Arrange
        controller.createSuperhero("Superman", "Kent Clark",1980, "Flight", true, 100  );
        controller.createSuperhero("Wonder Woman", "Diana Prince", 1890, "Super human strength",true, 100  );
        controller.createSuperhero("Bobbel","Bobbel", 2004, "Tale med dyr", false, 70 );
        controller.sortedList("Hero name","");
        //Act
        ArrayList <Superhero> test = controller.getListOfAllSuperHeroes();

        //Assert
        assertEquals("Superman",test.get(1).getHeroName());
        assertEquals("Wonder Woman",test.get(2).getHeroName());
        assertEquals("Bobbel",test.get(0).getHeroName());
    }
}