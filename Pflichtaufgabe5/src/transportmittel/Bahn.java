package transportmittel;

public class Bahn implements Transportmittel {
    private double geschwindigkeit;
    private int anzahlPlaetze;

    public Bahn() {
    }

    public Bahn(double geschwindigkeit, int anzahlPlaetze){
        this.anzahlPlaetze = anzahlPlaetze;
        this.geschwindigkeit = geschwindigkeit;
    }


    @Override
    public double getGeschwindigkeit() {
        return geschwindigkeit;
    }

    public void setGeschwindigkeit(double geschwindigkeit) {
        this.geschwindigkeit = geschwindigkeit;
    }

    @Override
    public int getAnzahlPlaetze() {
        return anzahlPlaetze;
    }

    public void setAnzahlPlaetze(int anzahlPlaetze) {
        this.anzahlPlaetze = anzahlPlaetze;
    }

    @Override
    public String toString() {
        return "Bahn{" +
                "geschwindigkeit=" + geschwindigkeit +
                ", anzahlPlaetze=" + anzahlPlaetze +
                '}';
    }
}
