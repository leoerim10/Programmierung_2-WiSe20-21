package reiseanbieter;

import kunden.Kunde;
import transportmittel.Bahn;
import transportmittel.Bus;

public class TuiReisen implements Reiseanbieter {

    private final int BUSKOSTEN = 25;
    private final int BAHNKOSTEN = 40;
    private Bus bus;
    private Bahn bahn;

    public TuiReisen(){

    }

    public TuiReisen(Bus bus, Bahn bahn){
        this.bahn = bahn;
        this.bus = bus;
    }

    public Bahn getBahn() {
        return bahn;
    }

    public void setBahn(Bahn bahn) {
        this.bahn = bahn;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }



    @Override
    public boolean buchen(Kunde k, int transport) {
        if(transport <0 || transport > 2){
            throw new IllegalArgumentException("Falsch eingegeben!!!! Transportmittel fuer die eingegebene Zahl existiert nicht.");
        }else {
            //wenn das ausgewaehlte Transportmittel egal ausgewaehlt ist
            // wird der erste Prioritaet Bahn sein sonst wird es Bus.
            if ((transport == 0 || transport == 2) && (this.getBahn().getAnzahlPlaetze() >= 1)) {
                k.empfangeNachricht("gebucht!!\n");
                this.getBahn().setAnzahlPlaetze(this.getBahn().getAnzahlPlaetze() - 1);
                return true;
            } else if ((transport == 0 || transport == 1) && this.getBus().getAnzahlPlaetze() >= 1) {
                k.empfangeNachricht("gebucht!!\n");
                this.getBus().setAnzahlPlaetze(this.getBus().getAnzahlPlaetze() - 1);
                return true;
            } else {
                return false;
            }
        }
    }



    @Override
    public boolean buchen(Kunde[] gruppe, int transport) {
        if(transport==0) {
            if (this.getBahn().getAnzahlPlaetze() >= gruppe.length || this.getBus().getAnzahlPlaetze() >= gruppe.length) {
                for (int i = 0; i < gruppe.length; i++) {
                    gruppe[i].empfangeNachricht("gebucht!!\n");
                }
                if(this.getBahn().getAnzahlPlaetze()>this.getBus().getAnzahlPlaetze()){// Erste Prioritaet wird Bahn sein
                    this.getBahn().setAnzahlPlaetze(this.getBahn().getAnzahlPlaetze()- gruppe.length);
                }else{
                    this.getBus().setAnzahlPlaetze(this.getBus().getAnzahlPlaetze()- gruppe.length); // sonst wird der Bus ausgewaehlt
                }
                return true;
            }

        }else if (transport==1) {
            if(this.getBus().getAnzahlPlaetze()>=gruppe.length)  {
                for(int i = 0; i< gruppe.length; i++) {
                    gruppe[i].empfangeNachricht("gebucht!!\n");
                }
                this.getBus().setAnzahlPlaetze(this.getBus().getAnzahlPlaetze()- gruppe.length);
                return true;
            }
        }else if(transport==2) {
            if(this.getBahn().getAnzahlPlaetze()>=gruppe.length) {
                for(int i = 0; i< gruppe.length; i++) {
                    gruppe[i].empfangeNachricht("gebucht!!\n");
                }
                this.getBahn().setAnzahlPlaetze(this.getBahn().getAnzahlPlaetze()- gruppe.length);
                return true;
            }
        }else{
            throw new IllegalArgumentException("Falsch eingegeben!!!! Transportmittel fuer die eingegebene Zahl existiert nicht.");
        }
        return false;
    }



    @Override
    public void buchungBestaetigen(Kunde k, int transport) {
       buchen(k, transport);
    }


    @Override
    public void buchungAblehnen(Kunde k, int transport) {
        buchen(k, transport);
    }



    @Override
    public boolean stornieren(Kunde k, int transport) {
        if(buchen(k, transport)){
            if(transport == 1  || transport == 2){
                k.empfangeNachricht("storniert!!\n");
                return true;
            }else if(transport == 0){
                k.empfangeNachricht("Transportmittel muss festgelegt werden!!!");
            }
        }
        return false;
    }



    @Override
    public boolean stornieren(Kunde[] k, int transport) {
        if(buchen(k, transport)){
            if(transport == 1  || transport == 2){
                for(int i= 0; i> k.length; i++) {
                    k[i].empfangeNachricht("storniert!!\n");
                }
                return true;
            }else if(transport == 0){
                for(int i= 0; i> k.length; i++) {
                    k[i].empfangeNachricht("Transportmittel muss festgelegt werden!!!");
                }
            }
        }
        return false;
    }



    @Override
    public void stornoBestaetigen(Kunde k, int transport) {
        if(stornieren(k, transport)){
            k.empfangeNachricht("Die Buchung ist erfolgreich storniert.");
        }
    }



    @Override
    public void stornoAblehnen(Kunde k, int transport) {
        if(!stornieren(k, transport)){
            k.empfangeNachricht("Die Buchung kann nicht storniert werden.");
        }
    }



    @Override
    public double preisErfragen(Kunde k, int transport) {

        return 0;
    }



    @Override
    public double dauerErfragen(Kunde k, int transport) {
        return 0;
    }
}
