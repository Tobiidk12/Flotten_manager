package RaumschiffService;

import Raumschiffe.Raumschiff;

import java.util.Vector;

/**
 * The type Alarm zentrale.
 */
public class AlarmZentrale {
private Vector<ÜberwachungsObjekte> überwachung = new Vector<ÜberwachungsObjekte>();


    /**
     * Schaden registrieren.
     *
     * @param schiff the schiff
     */
    public void Schaden_registrieren(ÜberwachungsObjekte schiff){
    überwachung.add(schiff);
}

    /**
     * Schaden alarmieren.
     *
     * @param ziel the ziel
     */
    public void Schaden_alarmieren(Raumschiff ziel){
    for (ÜberwachungsObjekte schiff: überwachung){
        schiff.werdeAngegriffen(ziel);
    }
}






}
