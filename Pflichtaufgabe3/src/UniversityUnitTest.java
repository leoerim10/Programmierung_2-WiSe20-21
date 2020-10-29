import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class UniversityUnitTest {

    private Person p1, p2;
    private Docent d1;
    private Student s1, s2, s3;

    @Before
    public void setUp() {
        p1 = new Person ("Martina", "Zuse", 'f');
        p2 = new Person ("Angela", "Bart", 'f');

        d1 = new Docent ("Martin", "Busch", 'm', 4);

        s1 = new Student ("Thomas", "Bart", 'm', 343);
        s2 = new Student ("Angela", "Mueller", 'f', 120);
        s3 = new Student ("Jan", "Kaper", 'd', 123);
    }

    @Test
    public void testCreateListStudents() {
        assertArrayEquals(new Student[] {s1, s2, s3}, Administration.createList(s1, s2, s3));
    }

    @Test
    public void testCreateListMiexed() {
        assertArrayEquals(new Person[] {p1, d1, s2}, Administration.createList(p1, d1, s2));
    }

    @Test
    public void testCreateListOne() {
        assertArrayEquals(new Docent[] {d1}, Administration.createList(d1));
    }


    @Test
    public void testSortListOne() {
        Docent[] list = {d1};
        assertArrayEquals(list, Administration.sortList(list));
    }

    @Test
    public void testSortListBestCase() {
        Person[] list = {s1, p2, d1};
        assertArrayEquals(list, Administration.sortList(list));
    }

    @Test
    public void testSortListHappyPath() {
        Person[] list = {p1, d1, s1, p2};
        Person[] erg = {s1, p2, d1, p1};
        assertArrayEquals(erg, Administration.sortList(list));
    }

    @Test(expected = NullPointerException.class)
    public void testSortListException() {
        Administration.sortList(null);
    }

    @Test
    public void testCountFemaleNobody() {
        assertEquals(0, Administration.countFemale(new Person[] {d1, s1, s3}));
    }

    @Test
    public void testCountFemaleHappyPath() {
        assertEquals(2, Administration.countFemale(new Person[] {p1, d1, s1, s2, s3}));
    }

    @Test(expected = NullPointerException.class)
    public void testCountFemaleException() {
        Administration.countFemale(null);
    }

    @Test
    public void testOutputListNormal() {
        assertEquals("[Martina Zuse, Angela Bart, Thomas Bart, matriculation number: 343]", Administration.outputList(new Person[] {p1, p2, s1}));
    }



}
