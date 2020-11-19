package transportmittel;

/**
 * Schnittstelle transportmittel.Transportmittel <br>
 * Klassen, die diese Schnittstelle implementieren sind konkrete
 * transportmittel.Transportmittel, wie Bus, Bahn, Minibus, Sammeltaxi usw.
 *
 * @author Adrianna Alexander
 * @version 1.2
 */
public interface Transportmittel {

    /**
     * liefert die Durchschnittsgeschwindigkeit des transportmittels zurueck
     *
     * @return Durchschnittsgeschwindigkeit des Transportmittels
     */
    public abstract double getGeschwindigkeit();

    /**
     * liefert die maximale Anzahl der Plaetze fuer die Fahrgaeste in dem
     * transportmittel.Transportmittel zurueck
     *
     * @return Anzahl der Plaetze
     */
    public abstract int getAnzahlPlaetze();
}
