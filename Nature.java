import java.util.ArrayList;

public class Nature extends Location {

    public Nature(String name, ArrayList<Animal> inventory) {
        super(name, inventory);
    }

    public String getName() {
        return "Nature";
    }

}