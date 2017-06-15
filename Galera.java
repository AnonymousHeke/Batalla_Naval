import java.util.ArrayList;

/**
 * Write a description of class Galera here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Galera extends Barcos
{
    // instance variables - replace the example below with your own 
    public static final int INITIAL_STATE = 10;

    /**
     * Constructor for objects of class Galera
     */
    public Galera(Bando bando, int soldierNumber, int cannonNumber)
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
        int combatForce = shipState * cannonNumber;
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
        String shipName = "G" + super.getShipName();
        return shipName;
    }    

    public void mover()
    {
        super.mover();
    }
}
