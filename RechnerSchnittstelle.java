/**
 * Das Interface für eine Recheneinheit, die grundlegende mathematische Operationen durchführt
 * und Informationen über den Rechner bereitstellt.
 */
public interface RechnerSchnittstelle {

    /**
     * Gibt den aktuellen Anzeigewert zurück.
     *
     * @return der aktuelle Anzeigewert
     */
    public int gibAnzeigewert();

    /**
     * Verarbeitet eine getippte Ziffer.
     *
     * @param ziffer die getippte Ziffer
     */
    public void zifferGetippt(int ziffer);

    /**
     * Führt die Addition der bisher eingegebenen Zahlen durch.
     */
    public void plus();

    /**
     * Führt die Subtraktion der bisher eingegebenen Zahlen durch.
     */
    public void minus();

    /**
     * Führt die Berechnung aus oder meldet einen Fehler
     */
    public void gleich();

    /**
     * Setzt den Rechner in den Anfangszustand zurück.
     */
    public void clear();

    /**
     * Gibt den Titel dieser Recheneinheit zurück.
     *
     * @return der Titel dieser Recheneinheit
     */
    public String gibTitel();

    /**
     * Gibt den Autor dieser Recheneinheit zurück.
     *
     * @return der Autor dieser Recheneinheit
     */
    public String gibAutor();

    /**
     * Gibt die Versionsnummer dieser Recheneinheit zurück.
     *
     * @return die Versionsnummer dieser Recheneinheit
     */
    public String gibVersion();
}
