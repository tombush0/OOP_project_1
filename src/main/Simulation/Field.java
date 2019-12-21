package Simulation;

import AnimalMech.Animal;
import Interfaces.IMapElement;
import Interfaces.IPositionChangeObserver;
import Interfaces.IWorldMap;
import MapMech.Grass;
import MapMech.Vector2d;
import Visualisation.OldVisualiser;

import java.util.*;


public class Field implements IWorldMap, IPositionChangeObserver {
    public int grassCount=0;
    public int growingGrassCount;
    public final int width;
    public final int height;
    public final Vector2d jungleLowLeft;
    public final Vector2d jungleUpRight;

    private List<Animal> animals = new ArrayList<>();
//    List<Grass> grassList = new ArrayList<>();
    private Map<Vector2d, LinkedList<IMapElement> > mapElements = new HashMap<>();


    public Field(int height, int width,  double jungleRatio, int grassGrownPerDay){
        this.height = height;
        this.width = width;
        this.growingGrassCount = grassGrownPerDay;
        this.jungleLowLeft = new Vector2d((int) Math.round(this.width*(1-jungleRatio)/2.0), (int) Math.round(this.height*(1-jungleRatio)/2.0));
        this.jungleUpRight = new Vector2d((int) Math.round(this.width*(1+jungleRatio)/2.0), (int) Math.round(this.height*(1+jungleRatio)/2.0));

    }


    // placing created animals
    public void placeAnimal(Animal animal){
        LinkedList<IMapElement> localElements = new LinkedList<>();
        Vector2d animalPosition = animal.getPosition();
        animal.inMap(this);
        if(!isOccupied(animalPosition)){
            localElements = new LinkedList<>();
        }
        else{
            localElements = this.mapElements.get(animalPosition);
            if(localElements.getFirst() instanceof Grass){
                localElements.clear();
            }
        }
        localElements.add(animal);
        this.mapElements.put(animalPosition, localElements);
        this.animals.add(animal);
        animal.addObserver(this);
    }

    // placing grass elements
    public boolean placeGrass(Grass grass){
        if( isOccupied(grass.getPosition())){
            return false;
        }
        LinkedList<IMapElement> localElements = new LinkedList<>();
        localElements.add(grass);
        this.mapElements.put(grass.getPosition(), localElements);
        this.grassCount ++;
        return true;
    }


    public void day(){
        Simulation.day(animals, mapElements,this);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null && this.objectAt(position).size() != 0;
    }

    @Override
    public LinkedList<IMapElement> objectAt(Vector2d position) {
        return this.mapElements.get(position);
    }


    @Override
    public String toString(){
        Vector2d lowerLeft = new Vector2d(0,0);
        Vector2d upperRight = new Vector2d(width,height);
        return new OldVisualiser(this).draw(lowerLeft, upperRight);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition, Animal animal) {
        this.mapElements.get(oldPosition).remove(animal);
        if(newPosition.equals(new Vector2d(-5,-5))) {
            this.animals.remove(animal);
            this.animals.remove(animal);
        }
        else {
            if (mapElements.get(newPosition) == null) {
                LinkedList<IMapElement> tmp = new LinkedList<>();
                this.mapElements.put(newPosition, tmp);
            }
            this.mapElements.get(newPosition).add(animal);
        }
    }

}


