public class Azubi extends Mitarbeiter {

    private int alter;
    private String bezeichnung;

    public Azubi(){
    }

    public Azubi(String name, String vorname, int betriebsZugehoerigkeit, boolean fuehrungsRolle, double gehalt, int alter, String bezeichnung ) {
        super(name, vorname, betriebsZugehoerigkeit, fuehrungsRolle, gehalt);
        this.alter = alter;
        this.bezeichnung = bezeichnung;
        this.setFuehrungsRolle(false); // azubis can never get the leading role, so that it will always be false.
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }


    /**
     * Christmas bonus for trainees
     * @return the amount of bonus
     */
    public double weihnachtenPraemie() {
        double summe = 10*alter;
        return summe;
    }


    public String toString() {
        return super.toString() + "  alter:" + alter + "  bezeichnung:" + bezeichnung;
    }
}
