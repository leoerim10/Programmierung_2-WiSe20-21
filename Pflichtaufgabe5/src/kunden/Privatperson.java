package kunden;

public class Privatperson implements Kunde {
    private String vorname;
    private String nachname;
    private int AnzahlNachrichten;

    public Privatperson() {
    }


    public Privatperson(String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.AnzahlNachrichten = 0;
    }


    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public int getAnzahlNachrichten() {
        return AnzahlNachrichten;
    }

    public void setAnzahlNachrichten(int anzahlNachrichten) {
        this.AnzahlNachrichten = anzahlNachrichten;
    }

    @Override
    public String toString() {
        return "Privatperson{" +
                "vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                '}';
    }

    @Override
    public int empfangeNachricht(String nachricht) {
        this.setAnzahlNachrichten(this.AnzahlNachrichten +1);
        return this.getAnzahlNachrichten();
    }
}
