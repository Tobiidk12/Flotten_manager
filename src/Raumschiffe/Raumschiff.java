package Raumschiffe;
import RaumschiffService.AlarmZentrale;
import RaumschiffService.ÜberwachungsObjekte;
import utilities.Printer;

/**
 * The type Raumschiff.
 */
public abstract class Raumschiff implements ÜberwachungsObjekte {
    /**
     * The Name.
     */
    public String name;
    /**
     * The Shield power.
     */
    public int ShieldPower;
    /**
     * The O shield power, O means original.
     */
    public int oShieldPower;
    /**
     * The Attack power.
     */
    public int attackPower;
    /**
     * The Price.
     */
    public int price;



    private AlarmZentrale alarm;


    /**
     * Instantiates a new Raumschiff.
     *
     * @param name        the name
     * @param ShieldPower the schildstaerke
     * @param attackPower the angriffskraft
     * @param price       the preis
     */
    public Raumschiff(String name, int ShieldPower, int attackPower, int price) {

        this.name = name;
    this.ShieldPower = ShieldPower;
    this.attackPower = attackPower;
    this.price = price;
    this.oShieldPower = ShieldPower;
    alarm = new AlarmZentrale();
    alarm.Schaden_registrieren(this);
}

    /**
     * Angriff.
     *
     * @param ziel the ziel
     */
    public void attack(Raumschiff ziel){
    if (this.ShieldPower == 0){
        Printer.print("The selected ship is broken and needs to be repaired");
        return;
    }

    if (ziel.ShieldPower > 0){
        alarm.Schaden_alarmieren(ziel);
        ziel.schaden(this.attackPower);

        if (ziel.ShieldPower <= 0){
            Printer.print( ziel.name + " has been destroyed");

        }

    }
    else{
        Printer.print( ziel.name + " is already destroyed");
    }

}

    /**
     * Schaden.
     *
     * @param angriffskraft the angriffskraft
     */
    public void schaden(int angriffskraft){
    if (ShieldPower > 0 && angriffskraft < ShieldPower){
        this.ShieldPower = ShieldPower - angriffskraft;
    }
    else{
        this.ShieldPower =0;
    }

}


    /**
     * Reparieren.
     */
    public void reparieren(){
    ShieldPower = oShieldPower;
    Printer.print("Ship " + this.name + " has been repaired");
}



public String toString(){
    return "Name: " + name + " | Schildstaerke: " + ShieldPower +" (max "+ oShieldPower + ")" + " | Angriffskraft: "
            + attackPower + " | Preis: " + price + " |";
}



public void werdeAngegriffen(Raumschiff ziel){
    Printer.printRed("Alarm " + ziel.name + " wird angegriffen ⚠" );
}

    /**
     * Wurde zerstört.
     *
     * @param ziel the ziel
     */
    public void wurdeZerstört(Raumschiff ziel){
    Printer.printRed("Alarm "+ ziel.name + " würde zerstört ⚠");


}




}
