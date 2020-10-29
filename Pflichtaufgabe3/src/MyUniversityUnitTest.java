import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MyUniversityUnitTest {

    private Person p1, p2;
    private Docent d1, d2;
    private Student s1, s2;


    @Before
    public void setUp(){
        p1 = new Person ("Tina", "Mueller", 'f');
        p2 = new Person ("Sam", "Bergmann", 'm');
        d1 = new Docent ("Karl", "Schmidt", 'm', 4);
        d2 = new Docent ("Adele", "Fisher", 'f', 3);
        s1 = new Student ("Hans", "Weber", 'm', 999);
        s2 = new Student ("Carla", "Meyer", 'f', 888);
    }


    //test when the input is given null
    @Test(expected = NullPointerException.class)
    public void emptyOutputListTest(){
        Administration.outputList(null);
    }


    // mixed case
    // test if all types of objects are printed out properly, use one instance of each kind
    @Test
    public void correctInputCaseTest() {
        assertEquals("[Carla Meyer, matriculation number: 888, Tina Mueller, Adele Fisher, fachbereichNummer: 3]", Administration.outputList(new Person[] {s2,p1,d2}));
    }


    // false case
    // test to see if any other string comparison holds
    @Test
    public void falseCaseTest() {
        assertFalse((("[Hans Weber, Sam Bergmann, Karl, fachbererichNummer: 4]").equals(Administration.outputList(new Person[] {s1,p2,d1}))));
    }


    //test for an empty array is given within the list
    @Test(expected = NullPointerException.class)
    public void emptyListTest(){
        Administration.outputList(new Person[] {s1, null, p1});
    }


}
