package standard;

import Raumschiffe.Jaeger;
import Raumschiffe.Raumschiff;
import utilities.Printer;

import java.util.Random;
import java.util.Vector;


/**
 * The type Gegner.
 */
public class Gegner implements FlottenFunktionen{
    private Random rand = new Random();
    /**
     * The Gegner schiffe.
     */
    Vector<Raumschiff> gegnerSchiffe = new Vector<Raumschiff>();

    /**
     * Instantiates a new Gegner.
     */
    public Gegner(){
        for (int i = 1; i < 4 ; i++){
            Jaeger jaegertemp = new Jaeger("Jaeger" + i);
            gegnerSchiffe.add(jaegertemp);
        }

    }


    /**
     * Angriff.
     */
    public void angriff(){

        Vector<Raumschiff> spielerFlotte = Flotte.getInstance().getSchiffe();
        if (spielerFlotte.size() > 0){
            int ziel = rand.nextInt(spielerFlotte.size());
            Raumschiff zielSchiff = spielerFlotte.get(ziel);
            for (Raumschiff angreifer : gegnerSchiffe){
                if (zielSchiff.ShieldPower > 0){
                    angreifer.attack(zielSchiff);
                }
                else if(angreifer == gegnerSchiffe.get(0)){
                    Printer.print("Ship is already destroyed");
                }
            }
        }
        else{
            Printer.print("No ships to attack");
        }


    }
    public void showFlotte(){
        Printer.printSeperator();
            Printer.print("Aktuelle standard.Flotte:");
            for (int i = 1; i < gegnerSchiffe.size() + 1; i++) {
                Printer.print(i + ". " + gegnerSchiffe.get(i - 1).toString());
            }

    }

    public Vector<Raumschiff> getSchiffe (){
        return this.gegnerSchiffe;
    }



}
