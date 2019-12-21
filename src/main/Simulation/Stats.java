package Simulation;

import AnimalMech.Genes;
import AnimalMech.Genom;

import java.util.Arrays;

public class Stats {
    private int animalNumber;
    private int grassNumber;
    private int[] genomOccurence = new int[8];

    Stats(){
        Arrays.fill(genomOccurence, 0);
    }


    public void addAnimal(){
        this.animalNumber++;
    }

    public void addGrass(){
        this.grassNumber++;
    }

    public void analizeGenom(Genom genom){
        Arrays.fill(this.genomOccurence, 0);
        int[] animalGenes = new int[8];
        Arrays.fill(animalGenes, 0);
        Genes[] genes = genom.getGenes();
        for(int i=0; i<32; i++){
            animalGenes[genes[i].getNumerical()]++;
        }
        int mostFrequent = Arrays.stream(animalGenes)
                .max()
                .getAsInt();
        this.genomOccurence[mostFrequent] ++;
    }

    public Genes getMostPopularGene() {
        int bestGene = Arrays.stream(this.genomOccurence)
                .max()
                .getAsInt();
        return Genes.fromNumerical(bestGene);
    }
}
