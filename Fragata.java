import java.util.ArrayList;

/**
 * Write a description of class Fragata here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fragata extends Barcos
{
    // instance variables - replace the example below with your own
    public static final int INITIAL_STATE = 8;

    /**
     * Constructor for objects of class Fragata
     */
    public Fragata(Bando bando, int soldierNumber, int cannonNumber)
    {
        // initialise instance variables
        super(bando, INITIAL_STATE, soldierNumber, cannonNumber);
    }

    /**
     * Obtener la fuerza de combate
     */
    @Override
    public int getCombatForce()
    {
        int combatForce = cannonNumber + soldiers.size();
        return combatForce;
    }

    /**
     * Obtener el bando al que pertenece el barco
     */
    public String getBando()
    {
        return bando.getBando();
    }

    /**
     * Devuelve el nombre del barco
     */
    public String getShipName()
    {
        String shipName = "F" + super.getShipName();
        return shipName;
    }
       
    public void mover()
    {
        super.mover();       
    }
}
