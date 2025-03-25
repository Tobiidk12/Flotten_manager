package main.standard;

import main.Raumschiffe.Jaeger;
import main.Raumschiffe.Raumschiff;
import main.Raumschiffe.Schlachtschiff;
import main.utilities.Printer;

/**
 * The type Main.
 */
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
Printer.print("test");


Raumschiff raumschiff1 = new Jaeger("Jaeger1");
        Raumschiff raumschiff2 = new Schlachtschiff("Schlachtschiff1");
Flotte.getInstance().addSchiff(raumschiff1);
        Flotte.getInstance().addSchiff(raumschiff2);
Flotte.getInstance().showFlotte();


        }
    }