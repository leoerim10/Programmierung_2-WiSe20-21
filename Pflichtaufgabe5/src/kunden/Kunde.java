package kunden;

/**
 * Schnittstelle kunden.Kunde <br>
 * Klassen, die diese Schnittstelle implementieren sind Kunden eines
 * Reiseanbieters
 *
 * @author Adrianna Alexander
 * @version 1.2
 */
public interface Kunde {

    /**
     * empfaengt eine Text-Nachricht und zaehlt die Anzahl der insgesamt
     * empfangenen Nachrichten
     *
     * @param nachricht
     *            , die vom Kunden empfangen wird
     * @return Anzahl insgesamt empfangenen Nachrichten
     */
    public abstract int empfangeNachricht(String nachricht);
}
