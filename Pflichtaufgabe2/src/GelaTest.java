import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GelaTest {

    private Mitarbeiter m1 = new Mitarbeiter("Walser", "Frank", 2, false, 1600);
    private Mitarbeiter m2 = new Mitarbeiter("Boss", "Hans", 21, true, 4000);
    private Mitarbeiter m3 = new Mitarbeiter("Flink", "Eva", 10, false, 1750);
    private Azubi a1 = new Azubi("Vogel", "Sven", 2, false, 450, 21, "Fachkraft fuer Lagerlogistik");
    private Azubi a2 = new Azubi("Mueller", "Max", 2, false, 500, 22, "unknown");

    @Test
    public void gehaltErhoehungMitarbeiterTest(){ // to check the increased salary of a employee
        m1.gehaltErhoehung(500);
        assertEquals(2100, m1.getGehalt());
    }

    @Test
    public void gehaltErhoehungAzubiTest(){ //to check the increased salary of a trainee
        a1.gehaltErhoehung(100);
        assertEquals(550, a1.getGehalt());
    }

    @Test
    public void gehaltErhoehungMitarbeiterTestNegative() {  //testing if the negative amount for salary increasement throws the exception
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            m2.gehaltErhoehung(-100);
        });
    }


    @Test
    public void pramieOhneFuehrungsRolleTest(){ // to check the christmas bonus for employee without leading role
        m3.weihnachtenPraemie();
        assertEquals(500, m3.weihnachtenPraemie());
    }


    @Test
    public void pramieMitFuehrungsRolleTest(){ // to check the christmas bonus for employee with leading role
        m2.weihnachtenPraemie();
        assertEquals(1250, m2.weihnachtenPraemie());
    }

    @Test
    public void pramieAzubiTest(){ // to check the christmas bonus for a trainee
        a1.weihnachtenPraemie();
        assertEquals(210, a1.weihnachtenPraemie());
    }

    @Test
    public void bezeichnungSetTest(){ // setter test, giving a new description to a trainee
        a2.setBezeichnung("promotion incoming");
        assertEquals("promotion incoming", a2.getBezeichnung());
    }

    @Test
    public void aendernBetriebsZugehoerigkeitTest(){ // to check the changed service of years of an employee on the company
        m1.setBetriebsZugehoerigkeit(3);
        assertEquals(3, m1.getBetriebsZugehoerigkeit());
    }

    @Test
    public void fuehreungsRolleAzubiTest(){
        // to make sure that there's no leading role for trainee even when the input is given true
        Azubi a3 = new Azubi("Neumann", "Michael", 2, true, 500, 21, "unknown");
        a3.isFuehrungsRolle();
        assertEquals(false, a3.isFuehrungsRolle());
    }


    @Test
    public void promotionMitarbeiterTest(){
        // to give the current employee a leading role, a promotion
        m3.setFuehrungsRolle(true);
        assertEquals(true, m3.isFuehrungsRolle());
    }


    @Test
    public void demotionMitarbeiterTest(){
        // to demote the current boss by taking out his leading role
        m2.setFuehrungsRolle(false);
        assertEquals(false, m2.isFuehrungsRolle());
    }

    @Test
    public void alterAendernTest(){  // to check the changed age of an trainee
        a2.setAlter(23);
        assertEquals(23, a2.getAlter());
    }


}
