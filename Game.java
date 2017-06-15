import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.scene.control.Label;
import javafx.animation.Animation;
import java.util.Random;
import java.util.ArrayList;
import javafx.scene.shape.Shape;

import javafx.scene.text.Text;
import javafx.scene.paint.*;

import java.util.Random;

public class Game extends Application 
{ 

    public static final int C_SOLDIER_NUMBER = 8600;
    public static final int T_SOLDIER_NUMBER = 7700;
    public static final int C_NAVIO_NUMBER = 20;
    public static final int T_NAVIO_NUMBER = 18;
    public static final int C_FRAGATA_NUMBER = 6;
    public static final int T_FRAGATA_NUMBER = 38;
    public static final int C_GALERA_NUMBER = 17;
    public static final int T_GALERA_NUMBER = 21;
    public static final int C_CANNON_NUMBER = 430;
    public static final int T_CANNON_NUMBER = 308;

    private static final int ANCHO_ESCENA = 1600;
    private static final int ALTO_ESCENA = 800;
    private static final int ALTO_BARRA_SUPERIOR = 20;

    private static double shipXSpeed;
    private static double shipYSpeed; 

    private static int shipsNumber;
    private static int cristianShipsNumber;
    private static int turkishShipsNumber;
    private static int cristianSoldiersPerShip;
    private static int turkishSoldiersPerShip;
    private static int cristianCannonsPerShip;
    private static int turkishCannonsPerShip;

    public ArrayList<Barcos> ships;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage escenario)
    {
        //Obtenemos el numero total de barcos
        shipsNumber = C_NAVIO_NUMBER + T_NAVIO_NUMBER + C_FRAGATA_NUMBER + T_FRAGATA_NUMBER + C_GALERA_NUMBER + T_GALERA_NUMBER;
        //Barcos del bando cristiano
        cristianShipsNumber = C_NAVIO_NUMBER + C_FRAGATA_NUMBER + C_GALERA_NUMBER;
        //Barcos del bando turco
        turkishShipsNumber = T_NAVIO_NUMBER + T_FRAGATA_NUMBER + T_GALERA_NUMBER;
        //Soldados por barco cristiano
        cristianSoldiersPerShip = C_SOLDIER_NUMBER/cristianShipsNumber;
        //Soldados por barco turco
        turkishSoldiersPerShip = T_SOLDIER_NUMBER/turkishShipsNumber;
        //Cañones por barco cristiano
        cristianCannonsPerShip = C_CANNON_NUMBER/cristianShipsNumber;
        //Cañones por barco turco
        turkishCannonsPerShip = T_CANNON_NUMBER/turkishShipsNumber;

        Group contenedor = new Group();
        Scene escena = new Scene(contenedor, ANCHO_ESCENA, ALTO_ESCENA); 

        //Creamos los barcos
        ships = new ArrayList<>();
        Random randomPosition = new Random();
        int numberOfShipsAdded = 0;
        for(int i = 0; i < shipsNumber; i++)
        {

            for(int galeraCristiana = 0; galeraCristiana < C_GALERA_NUMBER; galeraCristiana++)
            {
                Galera galera = new Galera(Bando.CRISTIANO, cristianSoldiersPerShip, cristianCannonsPerShip);
                ships.add(galera);
            }

            for(int fragataCristiana = 0; fragataCristiana < C_FRAGATA_NUMBER; fragataCristiana++)
            {
                Fragata fragata = new Fragata(Bando.CRISTIANO, cristianSoldiersPerShip, cristianCannonsPerShip);
                ships.add(fragata);                
            }

            for(int navioCristiano = 0; navioCristiano < C_NAVIO_NUMBER; navioCristiano++)
            {
                Navio navio = new Navio(Bando.CRISTIANO, cristianSoldiersPerShip, cristianCannonsPerShip);
                ships.add(navio);                
            }

            for(int galeraTurca = 0; galeraTurca < T_GALERA_NUMBER; galeraTurca++)
            {
                Galera galera = new Galera(Bando.TURCO, turkishSoldiersPerShip, turkishCannonsPerShip);
                ships.add(galera);
            }

            for(int fragataTurca = 0; fragataTurca < T_FRAGATA_NUMBER; fragataTurca++)
            {
                Fragata fragata = new Fragata(Bando.CRISTIANO, turkishSoldiersPerShip, turkishCannonsPerShip);
                ships.add(fragata);   
            }

            for(int navioTurco = 0; navioTurco < T_NAVIO_NUMBER; navioTurco++)
            {
                Navio navio = new Navio(Bando.CRISTIANO, turkishSoldiersPerShip, turkishCannonsPerShip);
                ships.add(navio);
            }            

            boolean shipAdded = false;

            while(!shipAdded)
            {
                int shipXPosition = randomPosition.nextInt(ANCHO_ESCENA - 50);
                int shipYPosition = randomPosition.nextInt(ALTO_ESCENA - 20 - ALTO_BARRA_SUPERIOR);

                Text ship = new Text();
                ship.setX(shipXPosition);
                ship.setY(shipYPosition);
                ship.setText(ships.get(numberOfShipsAdded).getShipName());
                if (ships.get(i).getBando().equals("Cristiano"))
                {
                    ship.setFill(Color.BLUE);
                }
                if (ships.get(i).getBando().equals("Turco"))
                {
                    ship.setFill(Color.RED);
                }
                contenedor.getChildren().add(ship);
                numberOfShipsAdded++;
                shipAdded = true;


            }

        }
        escenario.setScene(escena);
        escenario.show();
        Timeline timeline = new Timeline();
        KeyFrame keyframe = new KeyFrame(Duration.seconds(0.01), event -> 
                {

                    //Desplazamos los barcos
                    for(int i = 0; i < shipsNumber; i++)
                    {
                        ships.get(i).mover();
                    }
                }
            );
        timeline.getKeyFrames().add(keyframe);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();    
    }
}

