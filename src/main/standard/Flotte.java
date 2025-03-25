package main.standard;

import main.Raumschiffe.Raumschiff;
import main.utilities.Printer;

import java.util.Vector;

/**
 * The type Flotte.
 */
public class Flotte implements FlottenFunktionen{
    private static Flotte instance;
    private Vector <Raumschiff> schiffe;

    private Flotte() {
        schiffe = new Vector<Raumschiff>();

    }

    /**
     * Get instance flotte.
     *
     * @return the flotte
     */
    public static Flotte getInstance(){
        if(instance == null){
           instance = new Flotte();
        }
        return instance;
    }

    public Vector <Raumschiff> getSchiffe (){
        return this.schiffe;
    }

    /**
     * Sets schiffe.
     *
     * @param schiffe the schiffe
     */
    public void setSchiffe (Vector <Raumschiff> schiffe) {
        this.schiffe = schiffe;
    }

    /**
     * Remove schiff.
     *
     * @param schiff the schiff
     */
    public void removeSchiff (Raumschiff schiff) {
        schiffe.remove(schiff);
    }

    /**
     * Add schiff.
     *
     * @param schiff the schiff
     */
    public void addSchiff (Raumschiff schiff) {
        schiffe.add(schiff);


    }

    public void showFlotte(){
        Printer.printSeperator();
        if (schiffe.size() > 0) {
            Printer.print("Aktuelle Flotte:");
            for (int i = 1; i < schiffe.size() + 1; i++) {
                Printer.print(i + ". " + schiffe.get(i - 1).toString());
            }
        }
        else{
            Printer.print("Keine Schiffe in der Flotte ⚠");
        }
    }


}
