import java.util.ArrayList;

/**
The Location class represents a location where animals can live.
*/
public class Location {
    
    /** The list of living animals in the location. */
    private ArrayList<Animal> livingAnimals;
    /** The name of the location */
    private String name;

    /**
     * Constructs a Location object with the specified name and an empty ArrayList of living animals.
     * @param name the name of the location.
     */
    public Location(String name){
        this.name = name;
        this.livingAnimals = new ArrayList<Animal> ();
    } 

    /**
     * Get the name of the location.
     * @return the name of the location.
     */
    public String getName() {
        return name;
    }

    /**
     * Adds an animal to the list of living animals in the location.
     * @param a the animal to be added.
     */
    public void addAnimal(Animal a) {
        this.livingAnimals.add(a);
    }
    
    /**
     * Returns the list of living animals in the location.
     * @return the list of living animals.
     */
    public ArrayList<Animal> getLivingAnimals() {
        return this.livingAnimals;
    }
}

