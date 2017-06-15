    import java.util.ArrayList;

/**
 * Write a description of class Soldado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Soldado
{
    // instance variables - replace the example below with your own
    private int soldierEnergy;

    /**
     * Constructor for objects of class Soldado
     */
    public Soldado()
    {
        // initialise instance variables
        soldierEnergy = 10;
    }

    /**
     * Devuelve la energia del soldado
     */
    public int getSoldierEnergy()
    {
        return soldierEnergy;
    }
    
    /**
     * Disminuye la energia despues de un combate
     */
    public void decreaseSoldierEnergy()
    {
        soldierEnergy = soldierEnergy - 3;
    }
}
