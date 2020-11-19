package reiseanbieter;

import kunden.Kunde;


/**
 * Schnittstelle reiseanbieter.Reiseanbieter <br>
 * Klassen, die diese Schnittstelle implementieren sind die Services fuer die Kunden
 *
 * @author Sameer Dhimal, Wojciech Maximilian Frackowski
 * @version 1.2
 */
public interface Reiseanbieter {

    public static final int EGAL = 0;
    public static final int BUS = 1;
    public static final int BAHN = 2;

    //Entfernung in Km auf Strassen (Busreise)
    public static final double entfernungBus = 288.2;
    //entfernung in Km auf Schienen (Bahnreise)
    public static final double entfernungBahn = 310;

    /**
     * bucht eine Reise mit dem ausgewaehltem Transportmittel fuer den Einzelkunde
     * @param k Kunde, der die Reise bucht
     * @param transport Art des Transportmittels
     * @return true, wenn die Buchung erfolgreich ist
     */
    public abstract boolean buchen(Kunde k, int transport);


    /**
     * bucht eine Reise mit dem ausgewaehltem Transportmittel fuer eine Reisegruppe
     * @param gruppe die Reisegruppe
     * @param transport Art des Transportmittels
     * @return true, wenn die Buchung erfolgreich ist
     */
    public abstract boolean buchen(Kunde[] gruppe, int transport);


    /**
     * sendet eine Buchungsbestaetigung an den Kunden, wenn die Buchung erfolgreich war
     * @param k der Kunde
     * @param transport Art des Transportmittels
     */
    public abstract void buchungBestaetigen(Kunde k, int transport);


    /**
     * sendet eine Buchungsbablehnung an den Kunden, wenn die Buchung nicht moeglich war
     * @param k der Kunde
     * @param transport Art des Transportmittels
     */
    public abstract void buchungAblehnen(Kunde k, int transport);


    /**
     * storniert eine Buchung von einem Kunde
     * @param k der Kunde
     * @param transport Art des Transportmittels
     * @return true, wenn die Stornierung erflogreich war
     */
    public abstract boolean stornieren(Kunde k, int transport);


    /**
     * storniert eine Buchung von einer Gruppe
     * @param k der Kunde
     * @param transport Art des Transportmittels
     * @return true, wenn die Stornierung erfolgreich war
     */
    public abstract boolean stornieren(Kunde[] k, int transport);


    /**
     * sendet eine Bestaetigung, wenn die Stornierung erfolgreich war
     * @param k der Kunde
     * @param transport Art des Transportmittels
     */
    public abstract void stornoBestaetigen(Kunde k, int transport);


    /**
     * sendet eine Ablehnung, wenn die Stornierung nicht erflogreich war.
     * @param k der Kunde
     * @param transport Art des Transportmittels
     */
    public abstract void stornoAblehnen(Kunde k, int transport);


    /**
     * liefert den Preis fuer das Transportmittel zurueck
     * @param k der Kunde
     * @param transport Art des Transportmittels
     * @return den Preis
     */
    public abstract double preisErfragen(Kunde k, int transport);


    /**
     *liefert die Dauerzeit fuer die Reise
     * @param k der Kunde
     * @param transport Art des Transportmittels
     * @return die Dauerzeit
     */
    public abstract double dauerErfragen(Kunde k, int transport);
}
