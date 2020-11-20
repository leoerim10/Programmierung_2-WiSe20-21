import org.junit.BeforeClass;
import org.junit.Test;

public class UnitTestReisen {

    private static TuiReisen tui1, tui2;
    private static Bus bus1;
    private static Bahn bahn1;

    @BeforeClass
    public static void setUp() throws Exception {
        bus1 = new Bus(80.5, 3);
        bahn1 = new Bahn(120, 5);
        tui1 = new TuiReisen(bus1, bahn1);
        Privatperson p1 = new Privatperson("Robert", "Neumann");
        Student s1 = new Student("Hans", "Maier", "HTW-Berlin");
        Student s2 = new Student("Angela", "Elbig", "HTW-Berlin");
        Student s3 = new Student("Maria", "Hellmann", "HU-Berlin");

    }

    /* ********************** Bus *************************** */

    // Fehlerfall Durchschnittsgeschwindigkeit vom Bus < 0
    @Test(expected = IllegalArgumentException.class)
    public void testBusVFehler() {
        Bus bus = new Bus(-1, 3);
        assertNull(bus);
    }

    // Grenzfall max. Platzanzahl im Bus = 0
    @Test(expected = IllegalArgumentException.class)
    public void testBusPlatzanzahlFehler() {
        Bus bus = new Bus(80, 0);
        assertNull(bus);
    }

    // Normallfall Bus
    @Test
    public void testBusVNormal() {
        Bus bus = new Bus(80.5, 48);
        assertEquals(80.5, bus.getGeschwindigkeit(), 0);
        assertEquals(48, bus.getAnzahlPlaetze(), 0);
    }

    /* ********************** Bahn *************************** */

    // Fehlerfall Durchschnittsgeschwindigkeit von der Bahn < 0
    @Test(expected = IllegalArgumentException.class)
    public void testBahnVFehler() {
        Bahn bahn = new Bahn(-10, 100);
        assertNull(bahn);
    }

    // Grenzfall max. Platzanzahl in der Bahn = 0
    @Test(expected = IllegalArgumentException.class)
    public void testBahnPlatzanzahlFehler() {
        Bahn bahn = new Bahn(100, 0);
        assertNull(bahn);
    }

    // Normallfall Bahn
    @Test
    public void testBahnVNormal() {
        Bahn bahn = new Bahn(110.5, 230);
        assertEquals(110.5, bahn.getGeschwindigkeit(), 0);
        assertEquals(230, bahn.getAnzahlPlaetze(), 0);
    }

    /* ********************** Kunden *************************** */
    @Test
    public void testStudentName() {
        Privatperson p = new Student("Martha", "Mayer", "HTW");
        assertEquals("Martha", p.getVorname());
        assertEquals("Mayer", p.getNachname());
    }

    // die nachfolgenden Tests testen, ob jede empfangene Nachricht korrekt
    // gez�hlt wird

    @Test
    public void testNachrichtEmpfangenEinmal() {

        Student s = new Student("Martha", "Mayer", "HTW");
        int init = s.getAnzahlNachrichten();
        s.empfangeNachricht("Busreise gebucht");
        assertEquals(init + 1, s.getAnzahlNachrichten());
    }

    @Test
    public void testNachrichtEmpfangenZweimal() {

        Student s = new Student("Martha", "Mayer", "HTW");
        int init = s.getAnzahlNachrichten();
        s.empfangeNachricht("Busreise gebucht");
        s.empfangeNachricht("Busreise storniert");
        assertEquals(init + 2, s.getAnzahlNachrichten());
    }

    @Test
    public void testNachrichtEmpfangenKeinmal() {

        Student s = new Student("Martha", "Mayer", "HTW");
        assertEquals(0, s.getAnzahlNachrichten());
    }

    /* ******************* Reiseanbieter TuiReisen ******************** */

    // testet, ob bei Buchungsbest�tigung eine Nachricht an den Kunden versandt
    // wird
    @Test
    public void testBuchungBestaetigen() {
        Privatperson p = new Privatperson("Martha", "Mayer");
        tui1.buchungBestaetigen(p, Reiseanbieter.BUS);
        assertEquals(1, p.getAnzahlNachrichten());
    }

    // testet, ob bei Buchungsablehnung eine Nachricht an den Kunden versandt
    // wird
    @Test
    public void testBuchungAblehnen() {
        Privatperson p = new Privatperson("Martha", "Mayer");
        tui1.buchungAblehnen(p, Reiseanbieter.BAHN);
        assertEquals(1, p.getAnzahlNachrichten());
    }

    // testet, ob bei Buchungsablehnung und -best�tigung Nachrichten an den
    // Kunden versandt werden
    @Test
    public void testBuchungNachrichten() {
        Privatperson p = new Privatperson("Martha", "Mayer");
        tui1.buchungAblehnen(p, Reiseanbieter.BAHN);
        tui1.buchungBestaetigen(p, Reiseanbieter.BUS);
        tui1.buchungBestaetigen(p, Reiseanbieter.EGAL);
        assertEquals(3, p.getAnzahlNachrichten());
    }

    // testet, ob bei Stornobest�tigung eine Nachricht an den Kunden versandt
    // wird
    @Test
    public void testStornoBestaetigen() {
        Privatperson p = new Privatperson("Martha", "Mayer");
        tui1.stornoBestaetigen(p, Reiseanbieter.BAHN);
        assertEquals(1, p.getAnzahlNachrichten());
    }

    // testet, ob bei Stornoablehnung eine Nachricht an den Kunden versandt
    // wird
    @Test
    public void testStornoAblehnen() {
        Privatperson p = new Privatperson("Martha", "Mayer");
        tui1.stornoAblehnen(p, Reiseanbieter.BUS);
        assertEquals(1, p.getAnzahlNachrichten());
    }

    // testet, ob bei Stornoablehnung und -best�tigung Nachrichten an den
    // Kunden versandt werden
    @Test
    public void testStornoNachrichten() {
        Privatperson p = new Privatperson("Martha", "Mayer");
        tui1.stornoAblehnen(p, Reiseanbieter.BAHN);
        tui1.stornoBestaetigen(p, Reiseanbieter.BUS);
        tui1.stornoBestaetigen(p, Reiseanbieter.EGAL);
        assertEquals(3, p.getAnzahlNachrichten());
    }

    // testet, ob bei Buchungen und Stonierungen Nachrichten an den Kunden
    // versandt werden
    @Test
    public void testStornoBuchungNachrichten() {
        Privatperson p = new Privatperson("Martha", "Mayer");
        tui1.buchungAblehnen(p, Reiseanbieter.BUS);
        tui1.stornoBestaetigen(p, Reiseanbieter.BAHN);
        tui1.buchungBestaetigen(p, Reiseanbieter.EGAL);
        tui1.stornoAblehnen(p, Reiseanbieter.EGAL);
        assertEquals(4, p.getAnzahlNachrichten());
    }

    // die nachfolgenden Tests testen, ob beim Aufruf der Methode
    // preisErfragen() der korrekte Preis f�r ein Transportmittel ausgegeben
    // wird und ob eine Nachricht an den Kunden verschickt wird

    @Test
    public void testPreisErfragenBus() {
        Privatperson p = new Privatperson("Martha", "Mayer");
        assertEquals(25, tui1.preisErfragen(p, Reiseanbieter.BUS), 0);
        assertEquals(1, p.getAnzahlNachrichten());
    }

    @Test
    public void testPreisErfragenBahn() {
        Student s = new Student("Martha", "Mayer", "HTW");
        assertEquals(40, tui1.preisErfragen(s, Reiseanbieter.BAHN), 0);
        assertEquals(1, s.getAnzahlNachrichten());
    }

    @Test
    public void testPreisErfragenEgal() {
        Privatperson p = new Privatperson("Martha", "Mayer");
        assertEquals(25, tui1.preisErfragen(p, Reiseanbieter.EGAL), 0);
        assertEquals(1, p.getAnzahlNachrichten());
    }

    // die nachfolgenden Tests testen, ob beim Aufruf der Methode
    // dauerErfragen() die korrekte Dauer f�r ein Transportmittel ausgegeben
    // wird und ob eine Nachricht an den Kunden verschickt wird

    @Test
    public void testDauerErfragenBus() {
        Privatperson p = new Privatperson("Martha", "Mayer");
        assertEquals(3.58, tui1.dauerErfragen(p, Reiseanbieter.BUS), 0);
        assertEquals(1, p.getAnzahlNachrichten());
    }

    @Test
    public void testDauerErfragenBahn() {
        Student p = new Student("Martha", "Mayer", "HTW");
        assertEquals(2.58, tui1.dauerErfragen(p, Reiseanbieter.BAHN), 0);
        assertEquals(1, p.getAnzahlNachrichten());
    }

    @Test
    public void testDauerErfragenEgal() {
        Privatperson p = new Student("Martha", "Mayer", "HTW");
        assertEquals(2.58, tui1.dauerErfragen(p, Reiseanbieter.EGAL), 0);
        assertEquals(1, p.getAnzahlNachrichten());
    }

    // die nachfolgenden Tests testen, ob und wann Buchungs- und
    // Stornierungsvorg�nge erfolgreich sind und ob in jedem Fall Nachrichten
    // an Kunden verschickt werden

    // Einzelbuchung erfolgreich
    @Test
    public void testBuchenEinzelperson() {
        Privatperson p = new Privatperson("Martha", "Mayer");
        tui2 = new TuiReisen(bus1, bahn1);
        assertTrue(tui2.buchen(p, Reiseanbieter.BUS));
        assertEquals(1, p.getAnzahlNachrichten());
    }

    // Stornierung nicht erfolgreich, wenn vorher nichts gebucht wurde
    @Test
    public void testKeineStornierenEinzelperson() {
        Privatperson p = new Privatperson("Martha", "Mayer");
        tui2 = new TuiReisen(bus1, bahn1);
        assertFalse(tui2.stornieren(p, Reiseanbieter.BAHN));
        assertEquals(1, p.getAnzahlNachrichten());
    }

    // Stornierung erfolgreich, wenn vorher gebucht wurde
    @Test
    public void testStornierenEinzelperson() {
        Privatperson p = new Privatperson("Martha", "Mayer");
        tui2 = new TuiReisen(bus1, bahn1);

        assertTrue(tui2.buchen(p, Reiseanbieter.BAHN));
        assertEquals(1, p.getAnzahlNachrichten());

        assertTrue(tui2.stornieren(p, Reiseanbieter.BAHN));
        assertEquals(2, p.getAnzahlNachrichten());
    }

    // Gruppenbuchung erfolgreich
    @Test
    public void testBuchenGruppe() {
        Student s1 = new Student("Hans", "Maier", "HTW-Berlin");
        Student s2 = new Student("Angela", "Elbig", "HTW-Berlin");
        tui2 = new TuiReisen(bus1, bahn1);
        assertTrue(tui2.buchen(new Student[] { s1, s2 }, Reiseanbieter.BUS));
        assertEquals(1, s1.getAnzahlNachrichten());
        assertEquals(1, s2.getAnzahlNachrichten());
    }

    // Gruppenbuchung erfolgreich, alle Pl�tze belegt
    @Test
    public void testBuchenGruppeGrenzfall() {
        Student s1 = new Student("Hans", "Maier", "HTW-Berlin");
        Student s2 = new Student("Angela", "Elbig", "HTW-Berlin");
        Student s3 = new Student("Maria", "Hellmann", "HU-Berlin");
        tui2 = new TuiReisen(bus1, bahn1);
        assertTrue(tui2.buchen(new Student[] { s1, s2, s3 }, Reiseanbieter.BUS));
        assertEquals(1, s1.getAnzahlNachrichten());
        assertEquals(1, s2.getAnzahlNachrichten());
        assertEquals(1, s3.getAnzahlNachrichten());
    }

    // gesamte Gruppenbuchung nicht erfolgreich,
    // da nicht f�r alle Platz vorhanden
    @Test
    public void testBusUeberbucht() {
        Privatperson p1 = new Privatperson("Robert", "Neumann");
        Student s1 = new Student("Hans", "Maier", "HTW-Berlin");
        Student s2 = new Student("Angela", "Elbig", "HTW-Berlin");
        Student s3 = new Student("Maria", "Hellmann", "HU-Berlin");
        tui2 = new TuiReisen(bus1, bahn1);

        // Buchung der Busreise f�r Einzelperson erfolgreich
        assertTrue(tui2.buchen(p1, Reiseanbieter.BUS));
        assertEquals(1, p1.getAnzahlNachrichten());

        // Buchung der Busreise f�r die Gruppe nicht erfolgreich
        assertFalse(tui2
                .buchen(new Student[] { s1, s2, s3 }, Reiseanbieter.BUS));
        assertEquals(1, s1.getAnzahlNachrichten());
        assertEquals(1, s2.getAnzahlNachrichten());
        assertEquals(1, s3.getAnzahlNachrichten());

        // Stornierung der Busreise f�r keine der Einzelpersonen aus der Gruppe
        // m�glich, da nichts gebucht
        assertFalse(tui2.stornieren(s1, Reiseanbieter.BUS));
        assertEquals(2, s1.getAnzahlNachrichten());

        assertFalse(tui2.stornieren(s2, Reiseanbieter.BUS));
        assertEquals(2, s2.getAnzahlNachrichten());

        assertFalse(tui2.stornieren(s3, Reiseanbieter.BUS));
        assertEquals(2, s3.getAnzahlNachrichten());
    }

    // Gruppenbuchung erfolgreich, danach Einzelstornierung m�glich
    @Test
    public void testBuchenGruppeBahn() {
        Student s1 = new Student("Hans", "Maier", "HTW-Berlin");
        Student s2 = new Student("Angela", "Elbig", "HTW-Berlin");
        Student s3 = new Student("Maria", "Hellmann", "HU-Berlin");
        tui2 = new TuiReisen(bus1, bahn1);

        // Gruppenbuchung der Bahnreise erfolreich
        assertTrue(tui2
                .buchen(new Student[] { s1, s2, s3 }, Reiseanbieter.BAHN));
        assertEquals(1, s1.getAnzahlNachrichten());
        assertEquals(1, s2.getAnzahlNachrichten());
        assertEquals(1, s3.getAnzahlNachrichten());

        // Einzelstornierung der Bahnreise erfolgreich
        assertTrue(tui2.stornieren(s2, Reiseanbieter.BAHN));
        assertEquals(2, s2.getAnzahlNachrichten());
    }

    // Gruppenbuchung erfolgreich, danach Gruppenstornierung m�glich
    @Test
    public void testStornierenGruppeBahn() {
        Student s1 = new Student("Hans", "Maier", "HTW-Berlin");
        Student s2 = new Student("Angela", "Elbig", "HTW-Berlin");
        Student s3 = new Student("Maria", "Hellmann", "HU-Berlin");
        tui2 = new TuiReisen(bus1, bahn1);
        Student[] gruppe = { s1, s2, s3 };

        // Gruppenbuchung der Bahnreise erfolreich
        assertTrue(tui2.buchen(gruppe, Reiseanbieter.BAHN));
        assertEquals(1, s1.getAnzahlNachrichten());
        assertEquals(1, s2.getAnzahlNachrichten());
        assertEquals(1, s3.getAnzahlNachrichten());

        // Gruppenstornierung der Bahnreise erfolgreich
        assertTrue(tui2.stornieren(gruppe, Reiseanbieter.BAHN));
        assertEquals(2, s1.getAnzahlNachrichten());
        assertEquals(2, s2.getAnzahlNachrichten());
        assertEquals(2, s3.getAnzahlNachrichten());
    }

    // Einzelbuchung erfolgreich, danach Gruppenstornierung m�glich,
    // wenn alle Gruppenmitglieder gebucht haben
    @Test
    public void testBuchenEinzelnStornierenGruppe() {
        Student s1 = new Student("Hans", "Maier", "HTW-Berlin");
        Student s2 = new Student("Angela", "Elbig", "HTW-Berlin");
        Student s3 = new Student("Maria", "Hellmann", "HU-Berlin");
        tui2 = new TuiReisen(bus1, bahn1);
        Student[] gruppe = { s1, s2, s3 };

        // Einzelbuchung der Bahnreise erfolreich
        assertTrue(tui2.buchen(s1, Reiseanbieter.BAHN));
        assertEquals(1, s1.getAnzahlNachrichten());
        assertTrue(tui2.buchen(s2, Reiseanbieter.BAHN));
        assertEquals(1, s2.getAnzahlNachrichten());
        assertTrue(tui2.buchen(s3, Reiseanbieter.BAHN));
        assertEquals(1, s3.getAnzahlNachrichten());

        // Gruppenstornierung der Bahnreise erfolgreich
        assertTrue(tui2.stornieren(gruppe, Reiseanbieter.BAHN));
        assertEquals(2, s1.getAnzahlNachrichten());
        assertEquals(2, s2.getAnzahlNachrichten());
        assertEquals(2, s3.getAnzahlNachrichten());
    }

    // Einzelbuchung erfolgreich, danach Gruppenstornierung nicht m�glich,
    // wenn nicht alle Gruppenmitglieder gebucht haben
    @Test
    public void testBuchenEinzelnStornierenGruppeFehler() {
        Student s1 = new Student("Hans", "Maier", "HTW-Berlin");
        Student s2 = new Student("Angela", "Elbig", "HTW-Berlin");
        Student s3 = new Student("Maria", "Hellmann", "HU-Berlin");
        tui2 = new TuiReisen(bus1, bahn1);
        Student[] gruppe = { s1, s2, s3 };

        // Einzelbuchung der Busreise erfolreich
        assertTrue(tui2.buchen(s1, Reiseanbieter.BUS));
        assertEquals(1, s1.getAnzahlNachrichten());
        assertTrue(tui2.buchen(s2, Reiseanbieter.BUS));
        assertEquals(1, s2.getAnzahlNachrichten());

        // Gruppenstornierung der Busreise nicht erfolgreich
        assertFalse(tui2.stornieren(gruppe, Reiseanbieter.BUS));
        assertEquals(2, s1.getAnzahlNachrichten());
        assertEquals(2, s2.getAnzahlNachrichten());
        assertEquals(1, s3.getAnzahlNachrichten());
    }

    // angefragte Stornierung mit einem falschen Transportmittel nicht
    // erfolgreich, da f�r die Stornierung das korrekte Transportmittel
    // angegeben werden muss
    @Test
    public void testStornierenGruppeFehler() {
        Student s1 = new Student("Hans", "Maier", "HTW-Berlin");
        Student s2 = new Student("Angela", "Elbig", "HTW-Berlin");
        Student s3 = new Student("Maria", "Hellmann", "HU-Berlin");
        tui2 = new TuiReisen(bus1, bahn1);
        Student[] gruppe = { s1, s2, s3 };

        // Gruppenbuchung der Bahnreise erfolreich
        assertTrue(tui2.buchen(gruppe, Reiseanbieter.BAHN));
        assertEquals(1, s1.getAnzahlNachrichten());
        assertEquals(1, s2.getAnzahlNachrichten());
        assertEquals(1, s3.getAnzahlNachrichten());

        // Gruppenstornierung eines Busreise nicht erfolgreich
        assertFalse(tui2.stornieren(gruppe, Reiseanbieter.BUS));
        assertEquals(2, s1.getAnzahlNachrichten());
        assertEquals(2, s2.getAnzahlNachrichten());
        assertEquals(2, s3.getAnzahlNachrichten());
    }

    // angefragte Stornierung mit einem beliebigen Transportmittel nicht
    // erfolgreich, da f�r die Stornierung das korrekte Transportmittel
    // angegeben werden muss
    @Test
    public void testStornierenGruppeEgal() {
        Student s1 = new Student("Hans", "Maier", "HTW-Berlin");
        Student s2 = new Student("Angela", "Elbig", "HTW-Berlin");
        Student s3 = new Student("Maria", "Hellmann", "HU-Berlin");
        tui2 = new TuiReisen(bus1, bahn1);
        Student[] gruppe = { s1, s2, s3 };

        // Gruppenbuchung der Bahnreise erfolreich
        assertTrue(tui2.buchen(gruppe, Reiseanbieter.BAHN));
        assertEquals(1, s1.getAnzahlNachrichten());
        assertEquals(1, s2.getAnzahlNachrichten());
        assertEquals(1, s3.getAnzahlNachrichten());

        // Gruppenstornierung mit beliebigem Transportmittel nicht erfolgreich
        assertFalse(tui2.stornieren(gruppe, Reiseanbieter.EGAL));
        assertEquals(2, s1.getAnzahlNachrichten());
        assertEquals(2, s2.getAnzahlNachrichten());
        assertEquals(2, s3.getAnzahlNachrichten());
    }

    // angefragte Gruppenbuchung mit einem beliebigen Transportmittel wird mit
    // dem Transportmittel vorgenommen, in dem noch ausreichend viele Pl�tze f�r
    // alle Gruppenmitglieder vorhanden sind
    @Test
    public void testGruppenBuchungEgal() {
        Privatperson p1 = new Privatperson("Robert", "Neumann");
        Student s1 = new Student("Hans", "Maier", "HTW-Berlin");
        Student s2 = new Student("Angela", "Elbig", "HTW-Berlin");
        Student s3 = new Student("Maria", "Hellmann", "HU-Berlin");
        tui2 = new TuiReisen(bus1, bahn1);

        // Buchung der Busreise f�r Einzelperson erfolgreich
        assertTrue(tui2.buchen(p1, Reiseanbieter.BUS));
        assertEquals(1, p1.getAnzahlNachrichten());

        // Buchung der Reise f�r die Gruppe erfolgreich
        Student[] gruppe = { s1, s2, s3 };
        assertTrue(tui2.buchen(gruppe, Reiseanbieter.EGAL));
        assertEquals(1, s1.getAnzahlNachrichten());
        assertEquals(1, s2.getAnzahlNachrichten());
        assertEquals(1, s3.getAnzahlNachrichten());

        // Stornierung der Busreise f�r Einzelpersonen aus der Gruppe nicht
        // m�glich,
        // da keine Busreise gebucht
        assertFalse(tui2.stornieren(s2, Reiseanbieter.BUS));
        assertEquals(2, s2.getAnzahlNachrichten());

        // Stornierung der Bahnreise f�r Einzelpersonen aus der Gruppe m�glich
        // -> Bahnreise wurde gebucht
        assertTrue(tui2.stornieren(s2, Reiseanbieter.BAHN));
        assertEquals(3, s2.getAnzahlNachrichten());
    }

    // angefragte Gruppenbuchung mit einem beliebigen Transportmittel wird
    // abgelehnt, wenn in keinem Transportmittel ausreichend viele Pl�tze f�r
    // alle Gruppenmitglieder vorhanden sind
    @Test
    public void testKeineGruppenBuchungEgal() {
        Privatperson p1 = new Privatperson("Robert", "Neumann");
        Privatperson p2 = new Privatperson("Sabine", "Neumann");
        Privatperson[] gruppe1 = { p1, p2 };

        Student s1 = new Student("Hans", "Maier", "HTW-Berlin");
        Student s2 = new Student("Angela", "Elbig", "HTW-Berlin");
        Student s3 = new Student("Maria", "Hellmann", "HU-Berlin");
        Student s4 = new Student("Jan", "Schulz", "HU-Berlin");
        Student[] gruppe2 = { s1, s2, s3, s4 };

        tui2 = new TuiReisen(bus1, bahn1);

        // Buchung der Bahnreise f�r gruppe1 erfolgreich
        assertTrue(tui2.buchen(gruppe1, Reiseanbieter.BAHN));
        assertEquals(1, p1.getAnzahlNachrichten());
        assertEquals(1, p2.getAnzahlNachrichten());

        // Buchung der Reise f�r gruppe2 nicht erfolgreich
        assertFalse(tui2.buchen(gruppe2, Reiseanbieter.EGAL));
        assertEquals(1, s1.getAnzahlNachrichten());
        assertEquals(1, s2.getAnzahlNachrichten());
        assertEquals(1, s3.getAnzahlNachrichten());
        assertEquals(1, s4.getAnzahlNachrichten());
    }
}
