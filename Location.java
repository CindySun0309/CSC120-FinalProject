import java.util.ArrayList;

public class Location {
    private ArrayList<Animal> livingAnimals;
    private String name;

    public Location(String name){
        this.name = name;
        this.livingAnimals = new ArrayList<Animal> ();
    }

    public Location(String name, ArrayList<Animal> animals) {
        this.name = name;
        this.livingAnimals = animals;
    }    

    public String getName() {
        return name;
    }

    public void addAnimal(Animal a) {
        this.livingAnimals.add(a);
    }
    
    public ArrayList<Animal> getLivingAnimals() {
        return this.livingAnimals;
    }
}

