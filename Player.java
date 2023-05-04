import java.util.ArrayList;

public class Player {
    private String name;
    private int money;
    private ArrayList<Animal> inventory;
    private Location location;
    private Farm myfarm;

    public Player(String name, Farm myFarm) {
        this.name = name;
        this.money = 0;
        this.inventory = new ArrayList<>();  
        this.myfarm = myFarm;
        this.location = myfarm;
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


    public String printAnimalInInventory() {
        if (inventory.size() == 0) {
            System.out.println("You currently have " + this.getMoney() + " dollar(s) in your pocket.");
            return "Your inventory is empty.";
        }
        StringBuilder inventoryString = new StringBuilder("Inventory:\n");
        for (Animal animal : inventory) {
         inventoryString.append("- ").append(animal.getName()).append("\n");
        }
        System.out.println("You currently have " + this.getMoney() + " dollar(s) in your pocket.");
        return inventoryString.toString();
    }

    public ArrayList<Animal> getInventory() {
        return inventory;
    }    

    public Location getLocation() {
        return location;
    }    

    public void move(Location newLocation) {
        if (newLocation != null) {
            this.location = newLocation;
            System.out.println("You are now at " + this.location.getName() + "!");
        } else {
            System.out.println("Invalid location. Please enter a valid location.");
        }
    }


    public void combine(Animal animal1, Animal animal2) {
    if (this.inventory.contains(animal1) && this.inventory.contains(animal2)) {
        String combinedName = animal1.getName() + animal2.getName();
        String combinedDescription = animal1.getdescription() + " " + animal2.getdescription();
        boolean combinedHasLegs = animal1.getHaslegs() && animal2.getHaslegs();
        int combinedLegNum = animal1.getLegNum() + animal2.getLegNum();
        boolean combinedHasWings = animal1.hasWings() && animal2.hasWings();
        int combinedWingNum = animal1.getWingNum() + animal2.getWingNum();
        int combinedPrice = animal1.getPrice() + animal2.getPrice();
        Location combinedLivingLocation = null; // Set to null by default

        Animal combinedAnimal = new Animal(combinedName, combinedDescription, combinedHasLegs, combinedLegNum, combinedHasWings, combinedWingNum, combinedPrice, combinedLivingLocation);

        this.inventory.remove(animal1);
        this.inventory.remove(animal2);
        this.inventory.add(combinedAnimal);
        System.out.println("Congratulations! You have successfully combined " + animal1.getName() + " and " + animal2.getName() + " to create " + combinedName + ".");
        System.out.println("Here is the detail of your creature: it has " + combinedAnimal.getLegNum() + " legs, " + combinedAnimal.getWingNum() + " wings, and worth " + combinedAnimal.getPrice()+ " usd!");
        } else {
        System.out.println("You do not have both of these animals in your inventory.");}
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

    public void getFromFarm(Animal animal) {
        if (myfarm.getInventory().contains(animal)) {
            myfarm.removeFromInventory(animal);
            inventory.add(animal);
            System.out.println("You took the " + animal.getName() + " from the farm.");
        } else {
            System.out.println("The " + animal.getName() + " is not in the farm.");
        }
    }
    

    public void catchAnimal(Animal animal) {
        if (this.inventory.size() < 5) {
            this.inventory.add(animal);
        } else {
            System.out.println("Sorry! Your inventory is full! Maximum capacity is 5. The " + animal.getName() + " has been thrown away :(");
            throwaway(animal);
        }
    }

    
}
