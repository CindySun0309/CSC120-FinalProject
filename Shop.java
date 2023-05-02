import java.util.ArrayList;

public class Shop extends Location {
    private ArrayList<Animal> inventory;

    public Shop(String name) {
        super(name);
        this.inventory = null;
    }

    public Shop(String name, ArrayList<Animal> inventory) {
        super(name);
        this.inventory = null;
    }

    public String getName() {
        return "Shop";
    }

}
