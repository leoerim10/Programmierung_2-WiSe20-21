public class Mitarbeiter {

    private String name;
    private String vorname;
    private int betriebsZugehoerigkeit;
    private boolean fuehrungsRolle;
    private double gehalt;

    public Mitarbeiter(){
    }

    public Mitarbeiter(String name, String vorname, int betriebsZugehoerigkeit, boolean fuehrungsRolle, double gehalt){
        this.name = name;
        this.vorname = vorname;
        this.betriebsZugehoerigkeit = betriebsZugehoerigkeit;
        this.fuehrungsRolle = fuehrungsRolle;
        this.gehalt = gehalt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public int getBetriebsZugehoerigkeit() {
        return betriebsZugehoerigkeit;
    }

    public void setBetriebsZugehoerigkeit(int betriebsZugehoerigkeit) {
        this.betriebsZugehoerigkeit = betriebsZugehoerigkeit;
    }

    public boolean isFuehrungsRolle() {
        return fuehrungsRolle;
    }

    public void setFuehrungsRolle(boolean fuehrungsRolle) {
        this.fuehrungsRolle = fuehrungsRolle;
    }

    public double getGehalt() {
        return gehalt;
    }

    public void setGehalt(double gehalt) {
        this.gehalt = gehalt;
    }


    /**
     * increase the salary by given amount
     * @param betrag amount to be incresed
     */
    public void gehaltErhoehung(double betrag) {
        if(betrag<=0){ // increasement cannot be zero or negative
            throw new IllegalArgumentException("the amount cannot be less than zero");
        }else {
            this.setGehalt(this.getGehalt() + betrag);
            System.out.println(this.getGehalt());
        }
    }


    /**
     * Christmas bonus for the employee
     * @return amount of bonus
     */
    public double weihnachtenPraemie() {
        double summe;
        if(this.fuehrungsRolle == true) {   //employee with leading role
            summe = 50*betriebsZugehoerigkeit+200;

        }else {                             //employee without leading role
            summe = 50*betriebsZugehoerigkeit;

        }
        return summe;
    }




    public String toString() {
        return "name:" + name + "  vorname:" + vorname + "  betriebsZugehoerigkeit:" + betriebsZugehoerigkeit + "  fuehrungsRolle:" + fuehrungsRolle + "  gehalt:" + gehalt ;
    }


}
