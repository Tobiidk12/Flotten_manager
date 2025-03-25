package main.RaumschiffService;

import main.Raumschiffe.Raumschiff;
import main.standard.Spieler;
import main.utilities.Printer;

import java.util.Scanner;
import java.util.Vector;

/**
 * The type R workshop.
 */
public class RWorkshop {

    /**
     * The Instance.
     */
    static RWorkshop instance;
    /**
     * The M offer.
     */
    Vector<MOffer> mOffer = new Vector<>();

    private RWorkshop(){
        mOffer.add(new MOffer("Waffenupgrade",0,50,10));
        mOffer.add(new MOffer("Schildupgrade",50,0,10));
    }

    /**
     * Build r workshop.
     *
     * @return the r workshop
     */
    public static RWorkshop build (){
        if (instance == null){
            instance = new RWorkshop();
        }
        return instance;
    }


    /**
     * Modify.
     *
     * @param schiff the schiff
     */
    public void modify(Raumschiff schiff) {
        int choice = chooseOffer(mOffer);
        if (choice == -2 ) {return;}
        MOffer selectedOffer = mOffer.get(choice);
        schiff.attackPower = schiff.attackPower + selectedOffer.changeAngriffskraft;
        schiff.ShieldPower = schiff.ShieldPower + selectedOffer.changeSchildstaerke;
        schiff.oShieldPower = schiff.oShieldPower + selectedOffer.changeSchildstaerke;
        Spieler.create().credits = Spieler.create().credits - selectedOffer.preis;
        Printer.print(schiff.name + " was successfully modified.");
    }

    /**
     * List offer.
     */
    public void listOffer(){
        MOffer Offer;
        for (int i = 1; i <= mOffer.size(); i++){
            Offer = mOffer.get(i-1);
            Printer.print(i + ". " + Offer.toString());
        }
    }

    /**
     * Choose offer int.
     *
     * @param mOffer the m offer
     * @return the int
     */
// -2 wird ausgegeben um zu verlassen.
    public int chooseOffer (Vector<MOffer> mOffer){
        listOffer();
        Scanner scanner = new Scanner(System.in);
        while (true) {
                Printer.print("choose Offer number ");
                int exitNumber = mOffer.size() + 1;
                Printer.printGreen("Enter " + exitNumber + " to exit");
                int choice = scanner.nextInt();
                if (choice <= mOffer.size() && choice > 0) {
                    return choice - 1;
                } else if (choice == exitNumber) {
                    return -2;
                } else {
                    Printer.print("Not valid input");
                }


        }

    }

    /**
     * Durchführen wartung.
     *
     * @param schiff the schiff
     */
    public final void durchführenWartung(Raumschiff schiff){
        diagnose(schiff);
        hauptWartung(schiff);
        abschlussCheck(schiff);
        System.out.println("Wartung abgeschlossen für " + schiff.name);

    }



    private void diagnose(Raumschiff schiff){
        System.out.println("Diagnose: " + schiff.name);
        System.out.println("Schildstaerke: " + schiff.ShieldPower);
        System.out.println("Angriffskraft: " + schiff.attackPower);
    }

    /**
     * Haupt wartung.
     *
     * @param schiff the schiff
     */
//hauptWartung wird von den unterklassen spezifiziert.
    protected  void hauptWartung(Raumschiff schiff){
        System.out.println("Wartung für main.Raumschiffe: " + schiff.name + " Waffen und Schilde");
        schiff.reparieren();
    }

    //Stellt sicher das das schiff bereit ist.
    private void abschlussCheck(Raumschiff schiff) {
        System.out.println("Abschlusscheck erfolgreich");
        System.out.println("das Schiff ist bereit");
    }


}
