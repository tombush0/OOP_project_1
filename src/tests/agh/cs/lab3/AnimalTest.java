package agh.cs.lab3;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionsParser;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {
/*
    @Test
    public void testOrientation() {
        Animal animal = new Animal();
        assertEquals(animal.toString(), "Position: (2,2), direction: Północ");
        animal.move(MoveDirection.RIGHT);
        assertEquals(animal.toString(), "Position: (2,2), direction: Wschód");
        animal.move(MoveDirection.RIGHT);
        assertEquals(animal.toString(), "Position: (2,2), direction: Południe");
        animal.move(MoveDirection.RIGHT);
        assertEquals(animal.toString(), "Position: (2,2), direction: Zachód");
        animal.move(MoveDirection.RIGHT);
        assertEquals(animal.toString(), "Position: (2,2), direction: Północ");
        animal.move(MoveDirection.LEFT);
        assertEquals(animal.toString(), "Position: (2,2), direction: Zachód");
        animal.move(MoveDirection.LEFT);
        assertEquals(animal.toString(), "Position: (2,2), direction: Południe");
        animal.move(MoveDirection.LEFT);
        assertEquals(animal.toString(), "Position: (2,2), direction: Wschód");
        animal.move(MoveDirection.LEFT);
        assertEquals(animal.toString(), "Position: (2,2), direction: Północ");
        assertNotEquals(animal.toString(), "Position: (2,2), direction: Południe");
    }

    @Test
    public void testMovement() {
        Animal animal = new Animal();

        for (int i = 0; i < 10; i++) {
            animal.move(MoveDirection.FORWARD);
        }
        assertEquals(animal.toString(), "Position: (2,4), direction: Północ");

        animal.move(MoveDirection.LEFT);
        for (int i = 0; i < 10; i++) {
            animal.move(MoveDirection.FORWARD);
        }
        assertEquals(animal.toString(), "Position: (0,4), direction: Zachód");

        for (int i = 0; i < 10; i++) {
            animal.move(MoveDirection.BACKWARD);
        }
        assertEquals(animal.toString(), "Position: (4,4), direction: Zachód");

        animal.move(MoveDirection.LEFT);
        for (int i = 0; i < 10; i++) {
            animal.move(MoveDirection.FORWARD);
        }
        assertEquals(animal.toString(), "Position: (4,0), direction: Południe");

        assertNotEquals(animal.toString(), "Position: (-5,0), direction: Południe");
    }

    public void run(Animal animal, MoveDirection[] moves){
        for(MoveDirection i: moves){
            animal.move(i);
        }
    }

    @Test
    public void testPosition(){
        Animal animal = new Animal();
        MoveDirection[] testing = {MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.RIGHT};
        run(animal,testing);
        assertEquals(animal.toString(), "Position: (1,1), direction: Północ");
    }

    @Test
    public void testIntegration(){
        Animal animal = new Animal();
        String[] moves = {"f","forward",";","left","backward"};
        run(animal,OptionsParser.parse(moves));
        assertEquals(animal.toString(), "Position: (3,4), direction: Zachód");
    }

 */
}