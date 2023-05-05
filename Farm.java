import java.util.ArrayList;

public class Farm extends Location {
    private ArrayList<Animal> inventory;


    public Farm(String name) {
        super(name);
        this.inventory = new ArrayList<>();
    }

    public Farm(String name, ArrayList<Animal> inventory) {
        super(name);
        this.inventory = null;
    }

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

    public String getName() {
        return "farm";
    }

    public ArrayList<Animal> getInventory() {
        return this.inventory;
    }

    public void addToInventory(Animal animal) {
        inventory.add(animal);
    }

    public void removeFromInventory(Animal animal) {
        this.inventory.remove(animal);
    }
}

