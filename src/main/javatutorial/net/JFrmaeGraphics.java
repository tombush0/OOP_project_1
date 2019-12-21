package javatutorial.net;

import java.awt.Graphics;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JPanel;


public class JFrmaeGraphics extends JPanel{

//    Field map = new Field(10,10, 0.2, 4);
//    Grass.energy = 5;
//    Animal.startEnergy = 10;
//    Animal.dayEnergy = 2;

    public void paint(Graphics g) {
        Runnable animateDay = new Runnable() {
            @Override
                public void run() {
                g.drawString("Hello to JavaTutorial.net",10,10);
                ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
                }
        };
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(animateDay, 0, 500, TimeUnit.MILLISECONDS);
    }

//    JFrmaeGraphics(String toBePrinted, Graphics g){
//        g.drawString(toBePrinted, 10, 10);
//    }

//    public static void main(String[] args){
//        JFrame frame= new JFrame("JavaTutorial.net");
//        frame.getContentPane().add(new JFrmaeGraphics());
//        frame.setSize(300, 300);
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setResizable(false);
//    }
}
