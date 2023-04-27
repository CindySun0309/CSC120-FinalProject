import java.util.ArrayList;

public class Shop extends Location {
    private ArrayList<Animal> inventory;

    public Shop(String name, String description, ArrayList<Animal> inventory) {
        super(name, description);
        this.inventory = null;
    }

}
