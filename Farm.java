import java.util.ArrayList;

public class Farm extends Location {
    private ArrayList<Animal> inventory;
    private ArrayList<Fodder> fodderInventory;

    public Farm(String name) {
        super(name);
        this.inventory = new ArrayList<>();
        this.fodderInventory = new ArrayList<>();
    }

    public Farm(String name, ArrayList<Animal> inventory) {
        super(name);
        this.inventory = null;
        this.fodderInventory = null;
    }

    public String getAnimalInventory() {
        if (inventory.size() == 0) {
            return "Your inventory in the farm is empty.";
        }
        StringBuilder inventoryString = new StringBuilder("Farm Inventory:\n");
        for (Animal animal : inventory) {
         inventoryString.append("- ").append(animal.getName()).append("\n");
        }
        return inventoryString.toString();
        }

    public String getName() {
        return "Farm";
    }

    public ArrayList<Animal> getInventory() {
        return this.inventory;
    }

    public ArrayList<Fodder> getFodderInventory() {
        return this.fodderInventory;
    }

    public void addToInventory(Animal animal) {
        inventory.add(animal);
    }

    public void removeFromInventory(Animal animal) {
        inventory.remove(animal);
    }

    public void addTofodderInventory(Fodder fodder) {
        fodderInventory.add(fodder);
    }

    public void removeFromfodderInventory(Fodder fodder) {
        fodderInventory.remove(fodder);
    }

    

}

