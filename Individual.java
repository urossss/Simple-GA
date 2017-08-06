package ga;

public class Individual {
    
    private int defaultGeneLength;
    private byte[] genes;
    private int fitness;

    //Constructor
    public Individual() {
        defaultGeneLength = 64;
        genes = new byte[defaultGeneLength];
        fitness = 0;
    }

    //Create a random individual
    public void generateIndividual() {
        for (int i = 0; i < defaultGeneLength; i++) {
            byte gene = (byte) Math.round(Math.random());
            genes[i] = gene;
        }
    }

    /*Getters and setters*/
    public void setDefaultGeneLength(int length) {
        defaultGeneLength = length;
    }
    
    public void setGene(int index, byte value) {
        genes[index] = value;
        fitness = 0;
    }
    
    public byte getGene(int index) {
        return genes[index];
    }
    
    public int size() {
        return defaultGeneLength;
    }
    
    public int getFitness() {
        if (fitness == 0) {
            fitness = FitnessCalculator.getFitness(this);
        }
        return fitness;
    }
    
    @Override
    public String toString() {
        String geneString = "";
        for (int i = 0; i < size(); i++) {
            geneString += getGene(i);
        }
        return geneString;
    }
}
