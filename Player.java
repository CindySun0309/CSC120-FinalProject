import java.util.ArrayList;

/**
The Player class create the player and its associated movements & functions.
*/
public class Player {

    /** The name of the player */
    private String name;
    /** the amount of money the player owns */
    private int money;
    /** the player's bag */
    private ArrayList<Animal> inventory;
    /** the current location of the player */
    private Location location;
    /** the farm that the player owns */
    private Farm myfarm;
    /** the arraylist that stores all actions of the player */
    private ArrayList<String> actions = new ArrayList<String>();
    /** the last location that the player moved from */
    private Location lastLocation;
    /** the last animal the player caught */
    private Animal lastAnimalCaught;

    /**
     * Constructs a Player object with the specified name and a farm.
     * @param name the name of the location.
     * @param money the amount of money the player owns, which starts at 0
     * @param inventory the inventory ArrayList for the player, AKA the player's bag
     * @param myfarm the farm of the player
     * @param location the current location for the player, which is initialized at the farm
     */
    public Player(String name, Farm myFarm) {
        this.name = name;
        this.money = 0;
        this.inventory = new ArrayList<>();  
        this.myfarm = myFarm;
        this.location = myfarm;
    }

    /**
     * Get the name of the player.
     * @return the name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the amount of money of the player.
     * @return the amount of money of the player.
     */
    public int getMoney() {
        return money;
    }
    
    /**
     * Add money to the player.
     */
    public void addMoney(int amount) {
        this.money += amount;
    }

    /**
     * Prints the money and the animals in the player's bag
     * @return String that prints the money and the animals in the player's bag
     */
    public String printAnimalInInventory() {
        if (inventory.size() == 0) {
            System.out.println("You currently have " + this.getMoney() + " dollar(s) in your pocket.");
            return "Your bag is empty.";
        }
        StringBuilder inventoryString = new StringBuilder("Your bag has:\n");
        for (Animal animal : inventory) {
            inventoryString.append("- ").append(animal.getName()).append("\n");
        }
        System.out.println("You currently have " + this.getMoney() + " dollar(s) in your pocket.");
        return inventoryString.toString();
    }

    /**
     * Get the arraylist of the player's bag
     * @return the arraylist of the player's bag
     */
    public ArrayList<Animal> getInventory() {
        return inventory;
    }

    /**
     * Get the current location of the player
     * @return the current location of the player
     */
    public Location getLocation() {
        return location;
    }    

    /**
     * combine two animals to create a new creature
     * @param animal1 the first animal used to combine
     * @param animal2 the second animal used to combine
     */
    public void combine(Animal animal1, Animal animal2) {
        if (this.inventory.contains(animal1) && this.inventory.contains(animal2)) {
            String combinedName = animal1.getName() + animal2.getName();
            String combinedDescription = animal1.getDescription() + " " + animal2.getDescription();
            boolean combinedHasLegs = animal1.getHasLegs() && animal2.getHasLegs();
            int combinedLegNum = animal1.getLegNum() + animal2.getLegNum();
            boolean combinedHasWings = animal1.getHasWings() && animal2.getHasWings();
            int combinedWingNum = animal1.getWingNum() + animal2.getWingNum();
            int combinedPrice = animal1.getPrice() + animal2.getPrice() +2;
            Location combinedLivingLocation = null; // Set to null by default

            Animal combinedAnimal = new Animal(combinedName, combinedDescription, combinedHasLegs, combinedLegNum, combinedHasWings, combinedWingNum, combinedPrice, combinedLivingLocation);

            this.inventory.remove(animal1);
            this.inventory.remove(animal2);
            this.inventory.add(combinedAnimal);
            System.out.println("Congratulations! You have successfully combined " + animal1.getName() + " and " + animal2.getName() + " to create " + combinedName + ".");
            System.out.println("Here is the detail of your creature: it has " + combinedAnimal.getLegNum() + " legs, " + combinedAnimal.getWingNum() + " wings, and worth " + combinedAnimal.getPrice()+ " dollars!");
            this.actions.add("COMBINE");
            } 
        else {
            System.out.println("You do not have both of these animals in your bag.");
        }
        }

    /**
     * throw an animal away from the player's bag
     * @param animal the animal to throw away
     */
    public void throwaway(Animal animal) {
        if (inventory.contains(animal)){
            this.inventory.remove(animal);
            System.out.println("You threw away a " + animal.getName() + ".");
            this.actions.add("THROW AWAY");
        } 
        else {
            System.out.println("You don't have " + animal.getName() + " in your bag to throw away.");
        }
    }

    /**
     * put an animal into the farm inventory
     * @param animal the animal to put into the farm inventory
     */
    public void putInFarm(Animal animal) {
        if (inventory.contains(animal)){
            this.inventory.remove(animal);
            myfarm.addToInventory(animal);
            System.out.println("You put a " + animal.getName() + " in the farm inventory.");
        } 
        else {
            System.out.println("You don't have " + animal.getName() + " in your bag currently to put in the farm inventory.");
        }
    }

    /**
     * take an animal from the farm inventory and put it into the player's bag
     */
    public void getFromFarm(Animal animal) {
        if (myfarm.getInventory().contains(animal)) {
            myfarm.removeFromInventory(animal);
            inventory.add(animal);
            System.out.println("You took a " + animal.getName() + " from the farm inventory and put it into your bag.");
        } 
        else {
            System.out.println("The " + animal.getName() + " is not in the farm inventory.");
        }
    }
    
    /**
     * catch an animal and put it into the player's bag, if the bag is not full
     * @param animal the animal to catch
     */
    public void catchAnimal(Animal animal) {
        if (this.inventory.size() < 5) {
            this.inventory.add(animal);
            this.actions.add("CATCH");
            this.lastAnimalCaught = animal;
            System.out.println("You caught a " + animal.getName() + "! It worth " + animal.getPrice() + " dollars.");
        } 
        else {
            System.out.println("Sorry! Your bag is full! Maximum capacity is 5.");
            throwaway(animal);
        }
    }

    /**
     * get the last location the player moved from, used in the UNDO commant
     * @return the last location the player moved from
     */
    public Location getLastLocation() {
        return this.lastLocation;
    }
    
    /**
     * move to a location
     * @param newLocation the location for move
     */
    public void move(Location newLocation) {
        if (newLocation != null) {
            this.lastLocation = this.location;
            this.location = newLocation;
            System.out.println("You are now at " + this.location.getName() + "!");
            this.actions.add("MOVE");
        } 
        else {
            System.out.println("Invalid location. Please enter a valid location.");
        }
    }

    /**
     * return to the last location
     * @param backToLocation the last location
     */
    public void unmove(Location backToLocation) {
        this.move(this.lastLocation);
        this.actions.remove(this.actions.size()-1);
    }

    /**
     * get the arraylist of the player's actions
     * @return the arraylist of the player's actions
     */
    public ArrayList<String> getActions() {
        return this.actions;
    }

    /**
     * get the last animal the player caught
     * @return the last animal the player caught
     */
    public Animal getLastAnimalCaught() {
        return this.lastAnimalCaught;
    }
}
