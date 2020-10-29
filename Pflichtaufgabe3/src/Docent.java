public class Docent extends Person {

    private int fachbereichNummer;

    public Docent(){
        System.out.println("Warning, Constructor without parameter is called!!!");
    }

    public Docent (String vorname, String nachname, char geschlecht, int fachbereichNummer){
        super(vorname, nachname, geschlecht);
        this.fachbereichNummer = fachbereichNummer;
    }

    public int getFachbereichNummer() {
        return fachbereichNummer;
    }

    public void setFachbereichNummer(int fachbereichNummer) {
        this.fachbereichNummer = fachbereichNummer;
    }

    @Override
    public String toString() {
        return super.toString() + ", fachbereichNummer: " + fachbereichNummer;
    }

}
