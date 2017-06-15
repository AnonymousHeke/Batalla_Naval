import java.util.ArrayList;

/**
 * Write a description of class Navio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Navio extends Barcos
{
    // instance variables - replace the example below with your own
    public static final int INITIAL_STATE = 8;

    /**
     * Constructor for objects of class Navio
     */
    public Navio(Bando bando, int soldierNumber, int cannonNumber)
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
        int combatForce = (cannonNumber + soldiers.size()) * shipState;
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
        String shipName = "N" + super.getShipName();
        return shipName;
    }    

    public void mover()
    {
        super.mover();     
    }
}
