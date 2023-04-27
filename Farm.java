import java.util.ArrayList;

public class Farm extends Location {
    private ArrayList<Animal> inventory;
    private ArrayList<Fodder> fodderInventory;

    public Farm(String name, String description, ArrayList<Animal> inventory) {
        super(name, description);
        this.inventory = null;
        this.fodderInventory = null;
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

