package RaumschiffService;

import utilities.Printer;

/**
 * The type M offer.
 */
public class MOffer {
    /**
     * The Name.
     */
    public String name;
    /**
     * The Change schildstaerke.
     */
    public int changeSchildstaerke;
    /**
     * The Change angriffskraft.
     */
    public int changeAngriffskraft;
    /**
     * The Preis.
     */
    public int preis;

    /**
     * Instantiates a new M offer.
     *
     * @param name                the name
     * @param changeSchildstaerke the change schildstaerke
     * @param changeAngriffskraft the change angriffskraft
     * @param preis               the preis
     */
    public MOffer(String name, int changeSchildstaerke, int changeAngriffskraft, int preis) {
        this.name = name;
        this.changeSchildstaerke = changeSchildstaerke;
        this.changeAngriffskraft = changeAngriffskraft;
        this.preis = preis;

    }
    public String toString() {
        if (changeSchildstaerke == 0){
            return"Name: " + name  + " | Angriffskraft verbesserung: " + changeAngriffskraft + " | Preis: " + preis + " |";
        }
        else if (changeAngriffskraft == 0){
            return "Name: " + name + " | Schildstärken verbesserung: " + changeSchildstaerke + " | Preis: " + preis + " |";
        }
        else{
            return "Name: " + name + " | Schildstärken verbesserung: " + changeSchildstaerke + " | Angriffskraft verbesserung: " + changeAngriffskraft + " | Preis: " + preis + " |";
        }

    }

}
