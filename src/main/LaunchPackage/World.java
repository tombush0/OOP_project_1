package LaunchPackage;

import AnimalMech.Animal;
import MapMech.Grass;
import Simulation.Field;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class World {
    public static void main(String[] args) {
        try {

            Json.readJSON();

            Field map = new Field(Json.height, Json.width, Json.jungleRatio, Json.grassPerDay);
            Grass.energy = Json.grassEnergy;
            Animal.startEnergy = Json.startEnergy;
            Animal.moveEnergy = Json.moveEnergy;
            int animalsNumber = Json.animalsStartingNumber;


            for(int i=0; i<animalsNumber; i++){
                Animal.makeAnimal(map);
            }

            Runnable animateDay = new Runnable() {
                @Override
                public void run() {
                    map.day();
                    System.out.println(map);
                    System.out.println(map.statistics.toString());
                }
            };

            ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
            executor.scheduleAtFixedRate(animateDay, 0, 500, TimeUnit.MILLISECONDS);
        }
        catch(IllegalArgumentException a) {
            System.out.println(a); }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
//
//
//}
//
//import javatutorial.net.JFrmaeGraphics;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class World{
//    public static void main(String[] args) {
//
//
//
//        JFrame frame= new JFrame("JavaTutorial.net");
//        frame.getContentPane().add(new JFrmaeGraphics());
//        frame.setSize(400, 400);
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setResizable(false);
//    }
}