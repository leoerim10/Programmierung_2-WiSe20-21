package reiseanbieter;

import kunden.Kunde;
import transportmittel.Bahn;
import transportmittel.Bus;
import java.text.DecimalFormat;

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
         /*   //wenn das ausgewaehlte Transportmittel egal ausgewaehlt ist
            // wird der erste Prioritaet Bahn sein sonst wird es Bus.
            if ((transport == EGAL || transport == BAHN) && (this.getBahn().getAnzahlPlaetze() >= 1)) {
                this.getBahn().setAnzahlPlaetze(this.getBahn().getAnzahlPlaetze() - 1);
                return true;
            } else if ((transport == EGAL || transport == BUS) && this.getBus().getAnzahlPlaetze() >= 1) {
                this.getBus().setAnzahlPlaetze(this.getBus().getAnzahlPlaetze() - 1);
                return true;
            } else {
                return false;
            }*/

        if(transport==BUS) {
            if(this.getBus().getAnzahlPlaetze()>=1) {
                k.empfangeNachricht("Buchung Erfolgreicht\n");
                this.getBus().setAnzahlPlaetze(this.getBus().getAnzahlPlaetze() - 1);
                return true;
            }
        }else if(transport==BAHN) {
            if(this.getBahn().getAnzahlPlaetze()>=1) {
                k.empfangeNachricht("Buchung Erfolgreicht\n");
                this.getBahn().setAnzahlPlaetze(this.getBahn().getAnzahlPlaetze() - 1);
                return true;
            }
        }else if(transport==EGAL) {
            if(this.getBahn().getAnzahlPlaetze()>=1 || this.getBus().getAnzahlPlaetze()>=1)  {
                k.empfangeNachricht("Buchung Erfolgreicht\n");
                return true;
            }

        }else {
            throw new IllegalArgumentException();
        }
        return false;

    }



    @Override
    public boolean buchen(Kunde[] gruppe, int transport) {
        if(transport != BAHN || transport != BUS || transport != EGAL){
            throw new IllegalArgumentException("Falsch eingegeben!!!! Transportmittel fuer die eingegebene Zahl existiert nicht.");
        }else {
            //wenn das ausgewaehlte Transportmittel egal ausgewaehlt ist
            // wird der erste Prioritaet Bahn sein sonst wird es Bus.
            if ((transport == EGAL || transport == BAHN) && (this.getBahn().getAnzahlPlaetze() >= 1)) {
                for ( int i = 0; i < gruppe.length; i++){
                    this.getBahn().setAnzahlPlaetze(this.getBahn().getAnzahlPlaetze() - 1);
                }
                return true;
            } else if ((transport == EGAL || transport == BAHN) && this.getBus().getAnzahlPlaetze() >= 1) {
                for ( int i = 0; i < gruppe.length; i++){
                    this.getBus().setAnzahlPlaetze(this.getBus().getAnzahlPlaetze() - 1);
                }
                return true;
            } else {
                return false;
            }
        }
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
        /*if(buchen(k, transport)){
            if(transport == BUS) {
                this.getBus().setAnzahlPlaetze(this.getBus().getAnzahlPlaetze() + 1);
                return true;
            }else if(transport == BAHN){
                this.getBahn().setAnzahlPlaetze(this.getBahn().getAnzahlPlaetze() + 1);
            }else if(transport == EGAL){
                k.empfangeNachricht("Transportmittel muss festgelegt werden!!!");
            }
        }
        return false; */
        boolean res = false;
        if(buchen(k,transport)==true) {
            if(transport==1 || transport==2 ) {

                res=true;
            }
        }else if(transport==0) {
            k.empfangeNachricht("Transportmittel muss festgelegt werden");
        }
        return res;
    }



    @Override
    public boolean stornieren(Kunde[] k, int transport) {
        if(buchen(k, transport)){
            if(transport == BUS) {
                for (int i = 0; i > k.length; i++) {
                    this.getBus().setAnzahlPlaetze(this.getBus().getAnzahlPlaetze() + 1);
                }
                return true;
            }else if (transport == BAHN){
                for (int i = 0; i > k.length; i++) {
                    this.getBahn().setAnzahlPlaetze(this.getBahn().getAnzahlPlaetze() + 1);
                }
                return true;
                }
            }else if(transport == EGAL){
                for(int i= 0; i> k.length; i++) {
                    k[i].empfangeNachricht("Transportmittel muss festgelegt werden!!!");
                }
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
        int res = 0;
        if(transport <0 || transport > 2){
            throw new IllegalArgumentException("Falsch eingegeben!!!! Transportmittel fuer die eingegebene Zahl existiert nicht.");
        }else {
            if (transport == BUS) {
                res = BUSPREIS;
            } else if (transport == BAHN) {
                res = BAHNPREIS;
            } else if (transport == EGAL) {
               if(BUSPREIS<BAHNPREIS){
                   res = BUSPREIS;
               }else{
                   res = BAHNPREIS;
               }
            }
        }
        k.empfangeNachricht("" + res);
        return res;
    }



    @Override
    public double dauerErfragen(Kunde k, int transport) {
        double dauerzeitBus =  entfernungBus/this.getBus().getGeschwindigkeit();
        double dauerzeitBahn =  entfernungBahn/this.getBahn().getGeschwindigkeit();
        DecimalFormat df = new DecimalFormat("#.##");
        double res=0;
        if(transport <0 || transport > 2){
            throw new IllegalArgumentException("Falsch eingegeben!!!! Transportmittel fuer die eingegebene Zahl existiert nicht.");
        }else {
            if (transport == BUS) {
                res = Double.valueOf(df.format(dauerzeitBus));

            } else if (transport == BAHN) {
                res = Double.valueOf(df.format(dauerzeitBahn));


            } else if (transport == EGAL) {
                if (dauerzeitBahn < dauerzeitBus) {
                    res = Double.valueOf(df.format(dauerzeitBahn));
                } else {
                    res = Double.valueOf(df.format(dauerzeitBus));
                }
            }
        }
        k.empfangeNachricht("es daurt " + res + "Stunden.");
        return res;
    }
}
