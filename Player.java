import java.util.ArrayList;

public class Player {
    private String name;
    private int money;
    private ArrayList<Animal> inventory;
    private String location;
    private Farm myfarm;

    public Player(String name) {
        this.name = name;
        this.money = 0;
        this.inventory = null;
        this.location = "Farm";
        this.myfarm = new Farm("my farm", "This is my farm", new ArrayList<Animal>());
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int amount) {
        this.money += amount;
    }

    public void subtractMoney(int amount) {
        this.money -= amount;
    }

    public ArrayList<Animal> getInventory() {
        return inventory;
    }


    public void sell(Animal animal) {
        if (location == "Shop") {
            this.inventory.remove(animal);
            this.money += animal.getPrice();
        } else {
            System.out.println("You should move to the shop to sell animals!");
        }
    }

    public void buy(Fodder fodder, Farm myfarm) {
        if (location == "Shop" && money >= fodder.getPrice()) {
            myfarm.addTofodderInventory(fodder);
            this.money -= fodder.getPrice();
        } else {
            System.out.println("You should move to the shop to buy fodder and have enough money!");
        }
    }

    public void move(String newLocation) {
        if (newLocation == "farm" || newLocation =="river" || newLocation =="forest" ||newLocation =="grassland"||newLocation =="shop") {
            this.location = newLocation;
            System.out.println("You are now in " + this.location + "!");
        } else {
            System.out.println(newLocation + " is not valid! Please enter a valid location. (possible options: farm, river, forest, grassland, shop)");
        }
    }

    public void feed(Animal animal, Fodder fodder) {
        if (location == "Farm") {
            if (myfarm.getFodderInventory().contains(fodder)) {
                if (animal.getfodderType().equals(fodder.getName())&& animal.gethungryValue()<=0) {
                    myfarm.removeFromfodderInventory(fodder);
                    System.out.println("You fed the " + animal.getName() + " with " + fodder.getName() + ".");
                } 
            } else {
                System.out.println("You do not have any " + fodder.getName() + " in your inventory.");
            }
        } else {
            System.out.println("You should move to the farm to feed animals.");
        }
    }

    public void combine(Animal animal) {
        if (inventory.contains("rabbit") && inventory.contains("fish")) {
            this.inventory.remove("rabbit");
            this.inventory.remove("fish");
            this.inventory.add(animal);
            System.out.println("Combined " + animal.getName() + " and " + animal.getName() + " into " + animal.getName());
        } else {
            System.out.println("You don't have both " + animal.getName() + " and " + animal.getName() + " in your inventory.");
        }
    }
    
    public void throwaway(Animal animal) {
        if (inventory.contains(animal)){
            this.inventory.remove(animal);
        } else {
            System.out.println("You don't have  " + animal.getName() + " in your inventory.");
        }
    }

    public void putInFarm(Animal animal) {
        if (inventory.contains(animal)){
            this.inventory.remove(animal);
            myfarm.addToInventory(animal);
        } else {
            System.out.println("You don't have  " + animal.getName() + " in your inventory.");
        }
    }
}
