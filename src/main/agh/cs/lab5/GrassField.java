package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab6.MapBoundary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrassField extends AbstractWorldMap{

    private int inf=Integer.MAX_VALUE;
    private int grassCount;
    private List<Grass> grassList = new ArrayList<>();
    private MapBoundary bounds = new MapBoundary();

    private Vector2d randomGrassPosition(int n) {
        while (true) {
            Random gen1 = new Random();
            Random gen2 = new Random();
            int x = gen1.nextInt((int) Math.sqrt(n * 10));
            int y = gen2.nextInt((int) Math.sqrt(n * 10));
            if (super.objectAt(new Vector2d(x, y)) == null) {
                return new Vector2d(x, y);
            }
        }
    }

    public GrassField(Vector2d lowerLeft, Vector2d upperRight, int grassNumber){
        this.grassCount = grassNumber;
        for(int i=0; i<grassNumber; i++){
            Vector2d grassPos = randomGrassPosition(grassNumber);
            grassList.add(new Grass(grassPos));
            objects.put(grassPos, new Grass(grassPos));
            bounds.add(new Grass(grassPos));
        }
        Vector2d testPosition = new Vector2d(0,1);
        grassList.add(new Grass(testPosition));
        objects.put(testPosition, new Grass(testPosition));
        bounds.add(new Grass(testPosition));
    }

    public boolean place(Animal animal){
        bounds.add(animal);
        super.place(animal);
        return true;
    }

    @Override
    public void run(MoveDirection[] directions){
        int aSize = animals.size();
        int a = 0;
        for (MoveDirection x : directions) {
            Animal herbivorous = animals.get(a);
            Vector2d pos = herbivorous.getPosition();
            objects.remove(herbivorous.getPosition());

            if(objectAt(pos) != null &&  objectAt(pos).getClass() == Grass.class) {
                Object stepped = objectAt(pos);
                grassList.remove(stepped);
                Vector2d grassPos = randomGrassPosition(this.grassCount);
                grassList.add(new Grass(grassPos));
                objects.put(grassPos, new Grass(grassPos));
            }
            herbivorous.move(x);
            objects.put(herbivorous.getPosition(), herbivorous);
            a = (a + 1) % aSize;
        }
    }

    public Vector2d getUpperRight(){
        return bounds.upRight();
    }

    public Vector2d getLowerLeft(){
        return bounds.lowLeft();
    }
}
