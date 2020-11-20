package reiseanbieter;

import kunden.Kunde;
import transportmittel.Bahn;
import transportmittel.Bus;


public class TuiReisen implements Reiseanbieter {

    private final int BUSPREIS = 25;
    private final int BAHNPREIS = 40;
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
        if(transport==BUS) {
            if(this.getBus().getAnzahlPlaetze()>=1) {
                k.empfangeNachricht("gebucht!!!\n");
                this.getBus().setAnzahlPlaetze(this.getBus().getAnzahlPlaetze() - 1);
                return true;
            }
        }else if(transport==BAHN) {
            if(this.getBahn().getAnzahlPlaetze()>=1) {
                k.empfangeNachricht("gebucht!!!\n");
                this.getBahn().setAnzahlPlaetze(this.getBahn().getAnzahlPlaetze() - 1);
                return true;
            }
        }else if(transport==EGAL) {
            //wenn das ausgewaehlte Transportmittel egal ist
            // wird der erste Prioritaet Bahn sein sonst wird es den Bus.
            if(this.getBahn().getAnzahlPlaetze()>=1){
                this.getBahn().setAnzahlPlaetze(this.getBahn().getAnzahlPlaetze() - 1);
            }else if(this.getBus().getAnzahlPlaetze()>=1) {
                this.getBus().setAnzahlPlaetze(this.getBus().getAnzahlPlaetze() - 1);
            }
            k.empfangeNachricht("gebucht!!!\n");
            return true;
        }else {
            throw new IllegalArgumentException("Falsch eingegeben!!!! Transportmittel fuer die eingegebene Zahl existiert nicht.");
        }
        return false;

    }



    @Override
    public boolean buchen(Kunde[] gruppe, int transport) {
        if(transport==BUS) {
            if(this.getBus().getAnzahlPlaetze()>=1) {
                for (int i = 0; i < gruppe.length; i++) {
                    gruppe[i].empfangeNachricht("gebucht!!!\n");
                    this.getBus().setAnzahlPlaetze(this.getBus().getAnzahlPlaetze() - 1);
                }
                return true;
            }
        }else if(transport==BAHN) {
            if(this.getBahn().getAnzahlPlaetze()>=1) {
                for (int i = 0; i < gruppe.length; i++) {
                    gruppe[i].empfangeNachricht("gebucht!!!\n");
                    this.getBahn().setAnzahlPlaetze(this.getBahn().getAnzahlPlaetze() - 1);
                }
                return true;
            }
        }else if(transport==EGAL) {
            //wenn das ausgewaehlte Transportmittel egal ist
            // wird der erste Prioritaet Bahn sein sonst wird es den Bus.
            if(this.getBahn().getAnzahlPlaetze()>=1){
                for (int i = 0; i < gruppe.length; i++) {
                    gruppe[i].empfangeNachricht("gebucht!!!\n");
                    this.getBahn().setAnzahlPlaetze(this.getBahn().getAnzahlPlaetze() - 1);
                }
                return true;
            }else if(this.getBus().getAnzahlPlaetze()>=1) {
                for (int i = 0; i < gruppe.length; i++) {
                    gruppe[i].empfangeNachricht("gebucht!!!\n");
                    this.getBus().setAnzahlPlaetze(this.getBus().getAnzahlPlaetze() - 1);
                }
                return true;
            }
        }else {
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
        boolean res = false;
        if(buchen(k,transport)==true) {
            if (transport == BAHN) {
                this.getBahn().setAnzahlPlaetze(this.getBahn().getAnzahlPlaetze() + 1);
                res = true;
            } else if (transport == BUS) {
                 this.getBus().setAnzahlPlaetze(this.getBus().getAnzahlPlaetze() + 1);
                res = true;
            } else if (transport == EGAL) {
                k.empfangeNachricht("Transportmittel muss festgelegt werden");
            }
        }
        return res;
    }



    @Override
    public boolean stornieren(Kunde[] k, int transport) {
        if(buchen(k, transport)) {
            if(transport == BAHN) {
                for (int i = 0; i > k.length; i++) {
                    k[i].empfangeNachricht("storniert!!!!\n");
                    this.getBahn().setAnzahlPlaetze(this.getBahn().getAnzahlPlaetze() + 1);
                }
                return true;
            }else if(transport == BUS){
                for (int i = 0; i > k.length; i++) {
                    k[i].empfangeNachricht("storniert!!!!\n");
                    this.getBus().setAnzahlPlaetze(this.getBus().getAnzahlPlaetze() + 1);
                }
                return true;
            }else if( transport == 0){
                for(int i= 0; i> k.length; i++) {
                    k[i].empfangeNachricht("Die Buchung kann nicht storniert werden");
                }
            }else {
                return false;
            }
        }else {
            return false;
        }
        return false;
    }



    @Override
    public void stornoBestaetigen(Kunde k, int transport) {
        stornieren(k, transport);
    }



    @Override
    public void stornoAblehnen(Kunde k, int transport) {
        stornieren(k, transport);
    }



    @Override
    public double preisErfragen(Kunde k, int transport) {
        int res=0;
            if (transport == BUS) {
                res = BUSPREIS;
            } else if (transport == BAHN) {
                res = BAHNPREIS;
            } else if (transport == EGAL) {
                res = BUSPREIS; // guenstigere Transportmittel
            }else{
                throw new IllegalArgumentException("Falsch eingegeben!!!! Transportmittel fuer die eingegebene Zahl existiert nicht.");
            }
        k.empfangeNachricht("Der Preis ist" + res);
        return res;
    }



    @Override
    public double dauerErfragen(Kunde k, int transport) {
        double dauerzeitBus =  entfernungBus/this.getBus().getGeschwindigkeit();
        double dauerzeitBahn =  entfernungBahn/this.getBahn().getGeschwindigkeit();
        double res = 0;
        if(transport == BUS) {
            res = Math.round(entfernungBus / bus.getGeschwindigkeit() * 100.0) / 100.0;
            return res;
        } else if(transport == BAHN) {
            res = Math.round(entfernungBahn / bahn.getGeschwindigkeit() * 100.0) / 100.0;
            return res;
        } else if(transport == EGAL) {
                if(dauerzeitBahn<dauerzeitBus){
                    res = Math.round(entfernungBahn / bahn.getGeschwindigkeit() * 100.0) / 100.0;
                }else{
                    res = Math.round(entfernungBus / bus.getGeschwindigkeit() * 100.0) / 100.0;
                }
        }else{
            throw new IllegalArgumentException("Falsch eingegeben!!!! Transportmittel fuer die eingegebene Zahl existiert nicht");
        }
        k.empfangeNachricht("es daurt " + res + "Stunden.");
        return res;
    }


}
