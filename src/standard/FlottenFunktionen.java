package standard;

import Raumschiffe.Raumschiff;

import java.util.Vector;

/**
 * The interface Flotten funktionen.
 */
public interface FlottenFunktionen {

    /**
     * Gets schiffe.
     *
     * @return the schiffe
     */
    public Vector<Raumschiff> getSchiffe ();

    /**
     * Show flotte.
     */
    public void showFlotte();
}
