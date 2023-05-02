import java.util.ArrayList;

import javax.sound.midi.Soundbank;

public class Player {
    private String name;
    private int money;
    private ArrayList<Animal> inventory;
    private Location location;
    private Farm myfarm;

    public Player(String name) {
        this.name = name;
        this.money = 0;
        this.inventory = new ArrayList<>();  
        this.myfarm = new Farm("your farm");
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

    public ArrayList<Animal> getInventory() {
        return inventory;
    }

    public Location getLocation() {
        return location;
    }    


    public void sell(Animal animal) {
        if (location instanceof Shop) {
            this.inventory.remove(animal);
            this.money += animal.getPrice();
        } else {
            System.out.println("You should move to the shop to sell animals!");
        }
    }

    public void buy(Fodder fodder) {
        if (location instanceof Shop && money >= fodder.getPrice()) {
            myfarm.getFodderInventory().add(fodder);
            this.money -= fodder.getPrice();
        } else {
            System.out.println("You should move to the shop to buy fodder and have enough money!");
        }        
    }

    public void move(Location newLocation) {
        if (newLocation != null) {
            this.location = newLocation;
            System.out.println("You are now at " + this.location.getName() + "!");
        } else {
            System.out.println("Invalid location. Please enter a valid location.");
        }
    }

    public void feed(Animal animal, Fodder fodder) {
        if (location instanceof Farm) {
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

    public void combine(Animal animal1, Animal animal2, Animal animal3) {
        if (this.inventory.contains(animal1) && this.inventory.contains(animal2)) {
            this.inventory.remove(animal1);
            this.inventory.remove(animal2);
            this.inventory.add(animal3);
            //if (animal1.getName().equals("rabbit") || animal2.getName().equals("rabbit")) {
                //if (animal1.getName().equals("fish") || animal2.getName().equals("fish")) {
                    //this.inventory.add();
                //} 
            //}
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

    public void catchAnimal(Animal animal) {
        if (this.inventory.size() > 0 && this.inventory.size() <=5) {
            this.inventory.add(animal);
        }
        else {
            System.out.println("Sorry! Your inventory is full! Maximum capacity is 5. The " + animal.getName() + "has been thrown away :(");
            throwaway(animal);
        }
    }
}
