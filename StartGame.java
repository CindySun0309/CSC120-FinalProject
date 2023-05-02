import java.util.ArrayList;
import java.util.Scanner;
public class StartGame {
    public static void main(String[]args){
        
        Location forest = new Location("Forest");
        Location river = new Location("River");
        Location grassland = new Location("Grassland");
        Farm farm = new Farm("Farm");
        Shop shop = new Shop("Shop");

        Animal rabbit = new Animal("rabbit", "This is a rabbit", true, 4, false, 0, 2, AnimalMouthType.mouth, 4, "Grass", grassland);
        Animal tiger = new Animal("tiger", "This is a tiger", true, 4, false, 0, 3, AnimalMouthType.mouth, 10,"Meat", grassland);
        Animal fish = new Animal("fish", "This is a fish", false, 0, false, 0, 1, AnimalMouthType.mouth, 2,"plankton",river);
        Animal crab = new Animal("crab", "This is a crab", true, 10, false, 0, 2, AnimalMouthType.mouth, 2, "plankton",river);
        Animal zebra = new Animal("zebra", "This is a zebra", true, 4, false, 0, 2, AnimalMouthType.mouth, 5,"grass",grassland);
        Animal bird = new Animal("bird", "This is a bird", true, 2, true, 2, 2, AnimalMouthType.mouth, 3,"insect", forest);
        Animal frog = new Animal("frog", "This is a frog", true, 4, false, 0, 1, AnimalMouthType.mouth, 3,"insect", forest);

        Animal rabbitfish = new Animal("rabbitfish", "This is a rabbitfish", true, 4, false, 0, 5, AnimalMouthType.mouth, 4, "Grass", null);
        Animal tigerbird = new Animal("tigerbird", "This is a tigerbird", true, 4, true, 2, 10, AnimalMouthType.mouth, 4, "Meat", null);
        Animal zebrabird = new Animal("zebrabird", "This is a zebrabird", true, 4, false, 2, 8, AnimalMouthType.mouth, 4, "Insect", null);
        Animal rabbitzebra = new Animal("rabbitzebra", "This is a rabbitzebra", true, 4, false, 0, 8, AnimalMouthType.mouth, 4, "grass", null);

        Fodder grass = new Fodder("grass", 1);
        Fodder meat = new Fodder("meat", 3);
        Fodder insect = new Fodder("insect", 1);
        Fodder plankton = new Fodder("plankton", 1);
        

        forest.addAnimal(bird);
        forest.addAnimal(frog);

        river.addAnimal(fish);
        river.addAnimal(crab);

        grassland.addAnimal(tiger);
        grassland.addAnimal(zebra);
        grassland.addAnimal(rabbit);





        //Start game
        Scanner input = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter username:");

        String userName = input.nextLine();  // Read user input
        System.out.println("Your name is: " + userName); 

        Player player = new Player(userName);


        Location currentLocation = player.getLocation();

        

        

        while (player.getMoney() <= 20){
            System.out.println("What do you want to do next? \nAvailable options: Move, Catch, Sell, Buy, Feed, Combine, Throw away, Put in farm");
            String userMovement = input.nextLine();

            if (userMovement.equals("Move")) {
                System.out.println("Where do you want to move to? Available options: Forest, River, Grassland, Farm, Shop");
                String userNewLocation = input.nextLine();
                System.out.println("Moving...");
    
                if (currentLocation.getName().equals(userNewLocation)) {
                    System.out.println("Oops! You are already at " + userNewLocation + "!");
                }
                else if (userNewLocation.equals("Farm")) {
                    player.move(farm);
                    currentLocation = player.getLocation();
                }
                else if (userNewLocation.equals("Forest")) {
                    player.move(forest);
                    currentLocation = player.getLocation();
                }
                else if (userNewLocation.equals("River")) {
                    player.move(river);
                    currentLocation = player.getLocation();
                }
                else if (userNewLocation.equals("Grassland")) {
                    player.move(grassland);
                    currentLocation = player.getLocation();
                }
                else if (userNewLocation.equals("Shop")) {
                    player.move(shop);
                    currentLocation = player.getLocation();
                }
                else {
                    System.out.println("Oops! Please enter a valid location.");
                }
            }

            if (userMovement.equals("Catch")) {
                System.out.println("What animal do you want to catch?");
                String animalToCatch = input.nextLine();
    
                Animal targetAnimal = null;
                for (Animal animal : currentLocation.getLivingAnimals()) {
                    if (animal.getName().equals(animalToCatch)) {
                        targetAnimal = animal;
                    }
                }
                
                if (targetAnimal != null) {
                    if (currentLocation.equals(targetAnimal.getLivingLocation())) {
                        player.catchAnimal(targetAnimal);
                        System.out.println("You caught a " + targetAnimal.getName() + "!");
                    } else {
                        System.out.println("The " + targetAnimal.getName() + " is not in this location.");
                    }
                } else {
                    System.out.println("There is no animal with the name " + animalToCatch + " in this location.");
                }
    
                
                
            }
        }
        
        
    }
}

