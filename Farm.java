import java.util.ArrayList;

/**
The Farm class represents a farm location where animals can be stored in an inventory.
*/
public class Farm extends Location {

    /** The farm inventory */
    private ArrayList<Animal> inventory;


    /**
     * Constructs a Farm object with the specified name and an empty inventory.
     * @param name the name of the farm.
     */
    public Farm(String name) {
        super(name);
        this.inventory = new ArrayList<>();
    }

    /**
     * Returns a string representation of the animal inventory in the farm.
     * @return a string representing the animal inventory.
     */
    public String getAnimalInventory() {
        if (inventory.size() == 0) {
            return "Your farm inventory is empty.";
        }
        StringBuilder inventoryString = new StringBuilder("Farm Inventory:\n");
        for (Animal animal : inventory) {
         inventoryString.append("- ").append(animal.getName()).append("\n");
        }
        return inventoryString.toString();
        }

    /**
     * Get the name of the farm.
     * @return the name of the farm.
     */  
    public String getName() {
        return "farm";
    }

    /**
     * Get the inventory of the farm.
     * @return the inventory of the farm.
     */
    public ArrayList<Animal> getInventory() {
        return this.inventory;
    }

    /**
     * Adds an animal to the inventory of the farm.
     * @param animal the animal to be added to the inventory.
     */
    public void addToInventory(Animal animal) {
        inventory.add(animal);
    }

    /**
     * Removes an animal from the inventory of the farm.
     * @param animal the animal to be removed from the inventory.
     */
    public void removeFromInventory(Animal animal) {
        this.inventory.remove(animal);
    }
}

