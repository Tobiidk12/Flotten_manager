package main.standard;

/**
 * The type Spieler.
 */
public class Spieler {
    /**
     * The Name.
     */
    public String name;
    /**
     * The Credits.
     */
    public int credits;
    /**
     * The Iniciliced.
     */
    static Spieler Iniciliced;
    private Spieler(String name) {
        this.name = name;
        this.credits = 500;
    }

    /**
     * Create spieler.
     *
     * @return the spieler
     */
    public static Spieler create(){
        if (Iniciliced == null){
            Iniciliced = new Spieler("max musterman");
        }
            return Iniciliced;
    }

    /**
     * Set name.
     *
     * @param name the name
     */
    public void setName(String name){
        this.name = name;
    }



}
