package transportmittel;

public class Bus implements Transportmittel {
    private double geschwindigkeit;
    private int anzahlPlaetze;

    public Bus() {
    }

    public Bus(double geschwindigkeit, int anzahlPlaetze) throws IllegalArgumentException {
        this.anzahlPlaetze = anzahlPlaetze;
        this.setGeschwindigkeit(geschwindigkeit);
        if(anzahlPlaetze < 1){
            throw new IllegalArgumentException("Anazahl pläze kann nicht 0 oder Negativ beim Erzuegen eines neues Bus sein.");
        }
    }


    @Override
    public double getGeschwindigkeit() {
        return geschwindigkeit;
    }

    public void setGeschwindigkeit(double geschwindigkeit) throws IllegalArgumentException {
       if(geschwindigkeit<0){
           throw new IllegalArgumentException("Geschwindigkeit kann nicht negative sein.");
       }
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
        return "Bus{" +
                "geschwindigkeit=" + geschwindigkeit +
                ", anzahlPlaetze=" + anzahlPlaetze +
                '}';
    }
}
