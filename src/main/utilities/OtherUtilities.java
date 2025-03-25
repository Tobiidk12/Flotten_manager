package main.utilities;
import java.util.Scanner;
import main.standard.FlottenFunktionen;

/**
 * The type Other main.utilities.
 */
public class OtherUtilities {

    /**
     * Choose ship int.
     *
     * @param FlottenObjekt the flotten objekt
     * @param Aufgabe       the aufgabe
     * @return the int
     */
// -1 wird ausgegeben wenn die main.standard.Flotte des FlottenObjekts leer ist.
    // -2 wird ausgegeben um zu verlassen.
    public static int chooseShip(FlottenFunktionen FlottenObjekt, String Aufgabe){
        Scanner scanner = new Scanner(System.in);
        while (true){
            FlottenObjekt.showFlotte();
            if (FlottenObjekt.getSchiffe().size() != 0){
                Printer.print("choose Ship number to " + Aufgabe);
                int ausgangsNummer = FlottenObjekt.getSchiffe().size()+1;
                Printer.printGreen("Enter " + ausgangsNummer + " to exit");
                int choice = scanner.nextInt();
                if (choice <= FlottenObjekt.getSchiffe().size() && choice > 0){
                    return choice -1;
                }
                else if(choice == ausgangsNummer){
                    return -2;
                }
                else{
                    Printer.print("Not valid input");
                }
            }
            else{
                return -1;
            }

        }}
}
