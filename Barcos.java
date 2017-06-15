import java.util.ArrayList;
import javafx.scene.text.Text;

/**
 * Write a description of class Barcos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Barcos extends Text
{
    // instance variables - replace the example below with your own
    public Bando bando;
    public int cannonNumber;
    public int shipState;
    public ArrayList<Soldado> soldiers;  

    public double shipXSpeed;
    public double shipYSpeed; 

    /**
     * Constructor for objects of class Barcos
     */
    public Barcos(Bando bando, int shipState, int soldierNumber, int cannonNumber)
    {
        // Bando al que pertenece
        this.bando = bando;
        // Estado del barco
        this.shipState = shipState;
        //Numero de cañones
        this.cannonNumber = cannonNumber;
        //Inicializamos array soldados
        soldiers = new ArrayList<>();

        // Añadimos soldados al barco
        for(int i = 0; i < soldierNumber; i++)
        {
            Soldado soldier = new Soldado();
            soldiers.add(soldier);
        }

        //Velocidad del barco
        shipXSpeed = 3;
        shipYSpeed = 3;

    }

    /**
     * Obtener la fuerza de combate
     */
    public abstract int getCombatForce();

    /**
     * Devuelve el nombre del barco
     */
    public String getShipName()
    {
        String shipName = "-" + shipState + "-" + soldiers.size();
        return shipName;
    }

    /**
     * Disminuye la energia despues de un combate
     */
    public void decreaseShipState()
    {
        shipState = shipState - 2;
    }    

    /**
     * Obtener el bando al que pertenece el barco
     */
    public String getBando()
    {
        return bando.getBando();
    }

    public void mover()
    {
        //Desplazamos el barco
        setTranslateX(getTranslateX() + shipXSpeed);
        setTranslateY(getTranslateY() + shipYSpeed);    

        // Controlamos si el barco rebota a izquierda o derecha
        if (getBoundsInParent().getMinX() <= 0 || getBoundsInParent().getMaxX() >= 1600) 
        {
            shipXSpeed = -shipXSpeed;                              
        }

        // Controlamos si el barco rebota arriba o abajo
        if (getBoundsInParent().getMinY() <= 0 || getBoundsInParent().getMaxY() >= 800) 
        {
            shipYSpeed = -shipYSpeed;
        }        
    }
}
