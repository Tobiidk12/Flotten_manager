package standard;

import RaumschiffService.RWorkshop;
import Raumschiffe.Jaeger;
import Raumschiffe.Kreuzer;
import Raumschiffe.Raumschiff;
import Raumschiffe.Schlachtschiff;
import UI.Test;
import javafx.stage.Stage;
import utilities.OtherUtilities;
import utilities.Printer;

import java.util.Scanner;

/**
 * The type Game master.
 */
public class GameMaster {
private static Scanner scanner = new Scanner(System.in);
private static Gegner gegner = new Gegner();

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        UI.Test.main(args);
    Printer.print("Welcome to the Game Master!");
    Printer.print("Enter name:");
    String name = scanner.nextLine();

    Spieler.create().setName(name);
    menu();





}

    /**
     * Buy ship.
     */
    public static void buyShip() {
    Printer.print("Enter 1 to buy a Jaeger");
    Printer.print("| Schildstaerke: 250| Angriffskraft: 1000| Preis: 150 |");
    Printer.print("Enter 2 to buy a Kreuzer");
    Printer.print("| Schildstaerke: 1000 | Angriffskraft: 500| Preis: 150 |");
    Printer.print("Enter 3 to buy a Schlachtschiff");
    Printer.print("| Schildstaerke: 1000| Angriffskraft: 1000| Preis: 300 |");
    int choice = scanner.nextInt();
    switch (choice) {
        case 1: if(Spieler.create().credits > 150){
            Spieler.create().credits = Spieler.create().credits -150;
            Flotte.getInstance().addSchiff(new Jaeger("Jaeger"));
        }
        else{
            Printer.print("you have not enough credits");
        }
        break;
        case 2: if(Spieler.create().credits > 150){
            Spieler.create().credits = Spieler.create().credits -150;
            Flotte.getInstance().addSchiff(new Kreuzer("Kreuzer"));
        }
        else{
            Printer.print("you have not enough credits");
        }
        break;
        case 3: if(Spieler.create().credits > 300){
            Spieler.create().credits = Spieler.create().credits -300;
            Flotte.getInstance().addSchiff(new Schlachtschiff("Schlachtschiff"));
        }
        else{
            Printer.print("you have not enough credits");
        }
        break;
    }
}

    /**
     * Remove ship.
     */
    public static void removeShip(){
    int choice = OtherUtilities.chooseShip(Flotte.getInstance(),"remove");
    if (choice == -2 || choice ==-1) {return;}
    Raumschiff toDelete = Flotte.getInstance().getSchiffe().get(choice);
    Spieler.create().credits = Spieler.create().credits + toDelete.price;
    Flotte.getInstance().removeSchiff(toDelete);
}

    /**
     * Repair ship.
     */
    public static void checkup(){
        int choice = OtherUtilities.chooseShip(Flotte.getInstance(),"Repair");
        if (choice == -2 || choice ==-1) {return;}
        Raumschiff ziel = Flotte.getInstance().getSchiffe().get(choice);
        RWorkshop.build().durchführenWartung(ziel);


    }

    /**
     * Menu.
     */
    public static void menu() {
    while (true) {
        Printer.printSeperator();
        Printer.print("you have " + Spieler.create().credits + " credits");
        Printer.print("Menu");
        Printer.print("Enter 1 to buy a new ship");
        Printer.print("Enter 2 to remove a ship");
        Printer.print("Enter 3 to show all current ships");
        Printer.print("Enter 4 to do a checkup on a ship");
        Printer.print("Enter 5 to modify a ship");
        Printer.print("Enter 6 to show available enemies");
        Printer.print("Enter 7 simulate attack");


        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                buyShip();
                break;
            case 2:
                removeShip();
                break;
            case 3:
                Flotte.getInstance().showFlotte();
                break;
            case 4:
                checkup();
                break;

                case 5:
                    modify();
                    break;

            case 6:
                attackEnemy();
                //utilities.Printer.print("coming soon");
                break;
                case 7:
                    simulate_attack();
                    //utilities.Printer.print("coming soon");

                    break;
            default:
                Printer.print("Not a valid choice");
                break;
        }


    }
}

    /**
     * Service.
     */
    public static void modify(){
    int choice = OtherUtilities.chooseShip(Flotte.getInstance(),"modify");
    if (choice == -2 || choice ==-1) {return;}
    Raumschiff ziel = Flotte.getInstance().getSchiffe().get(choice);
    RWorkshop.build().modify(ziel);
}


    /**
     * Simulate attack.
     */
    public static void simulate_attack (){
    gegner.angriff();
}


    /**
     * Attack enemy.
     */
    public static void attackEnemy(){
       int ziel = OtherUtilities.chooseShip(gegner,"attack");
       if (ziel == -2) {return;}
       int ausgang = OtherUtilities.chooseShip(Flotte.getInstance(),"attack with");
       if (ausgang == -2 || ausgang == -1) {return;}

        Raumschiff zielSchiff = gegner.getSchiffe().get(ziel);
        Raumschiff ausgangsSchiff = Flotte.getInstance().getSchiffe().get(ausgang);
        ausgangsSchiff.attack(zielSchiff);
    }


}
