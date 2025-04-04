package main.standard;

import main.RaumschiffService.RWorkshop;
import main.Raumschiffe.Jaeger;
import main.Raumschiffe.Kreuzer;
import main.Raumschiffe.Raumschiff;
import main.Raumschiffe.Schlachtschiff;
import main.UI.Main;
import main.utilities.OtherUtilities;
import main.utilities.Printer;

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
        /*
        Flotte.getInstance().addSchiff(new Jaeger("test1"));
        Flotte.getInstance().addSchiff(new Jaeger("test2"));
        Flotte.getInstance().addSchiff(new Jaeger("test3"));
        Flotte.getInstance().addSchiff(new Jaeger("test4"));
        */
        Main.main(args);
        Printer.print("Welcome to the Game Master!");
        //Printer.print("Enter name:");
        //String name = scanner.nextLine();

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
            case 1:
                if (Spieler.create().credits > 150) {
                    Spieler.create().credits = Spieler.create().credits - 150;
                    Flotte.getInstance().addSchiff(new Jaeger("Jaeger"));
                } else {
                    Printer.print("you have not enough credits");
                }
                break;
            case 2:
                if (Spieler.create().credits > 150) {
                    Spieler.create().credits = Spieler.create().credits - 150;
                    Flotte.getInstance().addSchiff(new Kreuzer("Kreuzer"));
                } else {
                    Printer.print("you have not enough credits");
                }
                break;
            case 3:
                if (Spieler.create().credits > 300) {
                    Spieler.create().credits = Spieler.create().credits - 300;
                    Flotte.getInstance().addSchiff(new Schlachtschiff("Schlachtschiff"));
                } else {
                    Printer.print("you have not enough credits");
                }
                break;
        }
    }

    /**
     * Remove ship.
     */
    public static void removeShip(int choice) {
        if (choice == -2 || choice == -1) {
            return;
        }
        Raumschiff toDelete = Flotte.getInstance().getSchiffe().get(choice);
        Spieler.create().credits = Spieler.create().credits + toDelete.price;
        Flotte.getInstance().removeSchiff(toDelete);
    }

    /**
     * Repair ship.
     */
    public static void checkup(int choice) {
        //int choice = OtherUtilities.chooseShip(Flotte.getInstance(), "Repair");
        if (choice == -2 || choice == -1) {
            return;
        }
        Raumschiff ziel = Flotte.getInstance().getSchiffe().get(choice);
        RWorkshop.build().durchführenWartung(ziel);


    }

    /**
     * Menu.
     */
    public static void menu() {
        int i = 1;
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
            Printer.print("Enter 8 to Exit");


            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    buyShip();
                    break;
                case 2:
                    int choice2 = OtherUtilities.chooseShip(Flotte.getInstance(), "remove");
                    removeShip(choice2);
                    break;
                case 3:
                    Flotte.getInstance().showFlotte();
                    break;
                case 4:
                    int choice4 = OtherUtilities.chooseShip(Flotte.getInstance(), "Repair");
                    checkup(choice4);
                    break;
                case 5:
                    modify();
                    break;
                case 6:
                    attackEnemy();
                    break;
                case 7:
                    simulate_attack();
                    break;
                case 8:
                    System.exit(0);
                default:
                    Printer.print("Not a valid choice");
                    break;
            }


        }
    }

    /**
     * Service.
     */
    public static void modify() {
        int choice = OtherUtilities.chooseShip(Flotte.getInstance(), "modify");
        if (choice == -2 || choice == -1) {
            return;
        }
        Raumschiff ziel = Flotte.getInstance().getSchiffe().get(choice);
        RWorkshop.build().modify(ziel);
    }


    /**
     * Simulate attack.
     */
    public static void simulate_attack() {
        gegner.angriff();
    }


    /**
     * Attack enemy.
     */
    public static void attackEnemy() {
        int ziel = OtherUtilities.chooseShip(gegner, "attack");
        if (ziel == -2) {
            return;
        }
        int ausgang = OtherUtilities.chooseShip(Flotte.getInstance(), "attack with");
        if (ausgang == -2 || ausgang == -1) {
            return;
        }

        Raumschiff zielSchiff = gegner.getSchiffe().get(ziel);
        Raumschiff ausgangsSchiff = Flotte.getInstance().getSchiffe().get(ausgang);
        ausgangsSchiff.attack(zielSchiff);
    }


}
