import java.util.Scanner;
public class StartGame {
    public static void main(String[]args){
        
        Location forest = new Location("forest");
        Location river = new Location("river");
        Location grassland = new Location("grassland");
        Farm farm = new Farm("farm");
        Shop shop = new Shop("shop");

        Animal rabbit = new Animal("rabbit", "This is a rabbit", true, 4, false, 0, 2, grassland);
        Animal tiger = new Animal("tiger", "This is a tiger", true, 4, false, 0, 3,  grassland);
        Animal fish = new Animal("fish", "This is a fish", false, 0, false, 0, 1, river);
        Animal crab = new Animal("crab", "This is a crab", true, 10, false, 0, 2, river);
        Animal zebra = new Animal("zebra", "This is a zebra", true, 4, false, 0, 2, grassland);
        Animal bird = new Animal("bird", "This is a bird", true, 2, true, 2, 2,forest);
        Animal frog = new Animal("frog", "This is a frog", true, 4, false, 0, 1, forest);

        forest.addAnimal(bird);
        forest.addAnimal(frog);

        river.addAnimal(fish);
        river.addAnimal(crab);

        grassland.addAnimal(tiger);
        grassland.addAnimal(zebra);
        grassland.addAnimal(rabbit);


        Scanner input = new Scanner(System.in);  
        System.out.println("Enter username:");

        String userName = input.nextLine(); 
        System.out.println("Your name is: " + userName + ". You are a farmer and has a big farm! \nNow start your exploration!"); 

        Player player = new Player(userName, farm);


        Location currentLocation = player.getLocation();


        while (player.getMoney() < 20){
            System.out.println("\nWhat do you want to do next? \nAvailable options: move, catch, sell, combine, throw away, put in farm, get from farm, show inventory, and redo.");
            String userMovement = input.nextLine().toUpperCase();

            if (userMovement.contains("MOVE")) {
                System.out.println("Where do you want to move to? Available options: forest, river, grassland, farm, shop");
                String userNewLocation = input.nextLine().toUpperCase();
                System.out.println("Moving...");
    
                if (userNewLocation.contains(currentLocation.getName())) {
                    System.out.println("Oops! You are already at " + userNewLocation + "!");
                }
                else if (userNewLocation.contains("FARM")) {
                    player.move(farm);
                    currentLocation = player.getLocation();
                }
                else if (userNewLocation.contains("FOREST")) {
                    player.move(forest);
                    currentLocation = player.getLocation();
                }
                else if (userNewLocation.contains("RIVER")) {
                    player.move(river);
                    currentLocation = player.getLocation();
                }
                else if (userNewLocation.contains("GRASSLAND")) {
                    player.move(grassland);
                    currentLocation = player.getLocation();
                }
                else if (userNewLocation.contains("SHOP")) {
                    player.move(shop);
                    System.out.println("Welcome! Welcome! You can sell your animal(s) in your inventory here!");
                    currentLocation = player.getLocation();
                }
                else {
                    System.out.println("Oops! Please enter a valid location.");
                }
            }

            else if (userMovement.contains("CATCH")) {
                System.out.println("What animal do you want to catch?");
                String animalToCatch = input.nextLine().toUpperCase();
    
                Animal targetAnimal = null;
                for (Animal animal : currentLocation.getLivingAnimals()) {
                    if (animalToCatch.contains(animal.getName().toUpperCase())) {
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
                    System.out.println("There is no animal called " + animalToCatch + " in this location.");
                }  
            }

            else if (userMovement.equals("THROW AWAY")) {
                System.out.println("What animal do you want to throw?");
                String animalToThrow = input.nextLine().toUpperCase();
            
                Animal avoidAnimal = null;
                for (Animal animal : player.getInventory()) {
                    if (animalToThrow.contains(animal.getName().toUpperCase())) {
                        avoidAnimal = animal;
                        break;
                    }
                }
            
                if (avoidAnimal != null) {
                    player.throwaway(avoidAnimal);
                    System.out.println("You throw a " + avoidAnimal.getName() + "!");
                } else {
                    System.out.println("There is no animal with the name " + animalToThrow + " in your inventory.");
                }  
            }

            else if (userMovement.equals("SHOW INVENTORY")) {
                System.out.println(player.printAnimalInInventory());
            }

            else if (userMovement.equals("PUT IN FARM")) {
                System.out.println("What animal do you want to put in to the farm?");
                String animalToPut = input.nextLine().toUpperCase();
    
                Animal putAnimal = null;

                for (Animal animal : player.getInventory()) {
                    if (animalToPut.equals(animal.getName().toUpperCase())) {
                        putAnimal = animal;
                        break;
                    }
                }
                
                if (putAnimal != null) {
                    player.putInFarm(putAnimal);
                    System.out.println("You put the " + putAnimal.getName() + " in to the farm!");
                } else {
                System.out.println("It is not your bag.");
                }
            System.out.println(farm.getAnimalInventory());    
            }

            else if (userMovement.equals("GET FROM FARM")) {
                System.out.println("What animal do you want to put in to the farm?");
                String animalToGet = input.nextLine().toUpperCase();
    
                Animal getAnimal = null;

                for (Animal animal : farm.getInventory()) {
                    if (animalToGet.equals(animal.getName().toUpperCase())) {
                        getAnimal = animal;
                        break;
                    }
                }
                
                if (getAnimal != null) {
                    player.getFromFarm(getAnimal);
                    System.out.println("You get the " + getAnimal.getName() + " in to the bag!");
                } else {
                System.out.println("It is not your bag.");
                }
            }
            
            else if (userMovement.contains("SELL")) {
                if (currentLocation == shop) {
                    System.out.println("Which animal do you want to sell?");
                    String animalToSell = input.nextLine().toUpperCase();

                    Animal targetAnimal = null;
                                for (Animal animal : player.getInventory()) {
                                    if (animalToSell.contains(animal.getName().toUpperCase())) {
                                        targetAnimal = animal;
                                    }
                                }
                    
                    // Check if the user has the specified animal in their inventory
                    if (player.getInventory().contains(targetAnimal)) {

                        

                        // Get the current quantity of the animal in the inventory
                        int currentQuantity = 0;
                        for (Animal animal : player.getInventory()) {
                            if (animal.getName().toUpperCase().equals(animalToSell)) {
                                currentQuantity ++;
                            }
                        }
                        System.out.println("You currently have " + currentQuantity + " " + animalToSell + " in your inventory.");

                        if (currentQuantity > 0) {
                            // Ask the user how many of the animal they want to sell
                            System.out.println("How many " + animalToSell + "(s) do you want to sell?");
                            
                            while (!input.hasNextInt()) {
                                System.out.println("Please enter a valid number. How many " + animalToSell + "s do you want to sell?");
                                input.next();
                            }

                            int quantityToSell = input.nextInt();
                            input.nextLine();
                            
                            // Check if the user has enough of the specified animal to sell
                            if (quantityToSell >= 0 && quantityToSell <= currentQuantity) {
                                
                                // Calculate the total value of the animal(s) being sold
                                int totalValue = quantityToSell * targetAnimal.getPrice();
                                System.out.println("You will receive $" + totalValue + " for selling " + quantityToSell + " " + animalToSell + "(s).");
                                
                                // Remove the sold animal(s) from the inventory and add the money to the user's balance
                                int numberOfAnimal = quantityToSell;
                                int[] removingIndex = new int[numberOfAnimal];
                                int i = 0;
                                for (Animal a : player.getInventory()) {
                                    if (numberOfAnimal == 0) {
                                        break;
                                    }
                                    else if (animalToSell.contains(a.getName().toUpperCase())) {
                                        removingIndex[i] = player.getInventory().indexOf(a);
                                        numberOfAnimal --;
                                        i++;
                                    }
                                }
                                for (int index : removingIndex) {
                                    player.getInventory().remove(index);
                                }
                                System.out.println("You have sold " + quantityToSell + " " + animalToSell + "(s)!");
                                player.addMoney(totalValue);
                            } 
                            else {
                                System.out.println("Invalid quantity specified.");
                            }
                        } 
                        else {
                            System.out.println("You don't have any " + animalToSell + " to sell.");
                        }
                    } 
                    else {
                        System.out.println("You do not have any " + animalToSell + " in your inventory!");
                    }
                }
                else {
                    System.out.println("Please go to the shop for selling your animal(s)!");
                }
            }
            
            else if (userMovement.contains("COMBINE")) {
                System.out.println("What is the name of the first animal you want to use?");
                String animalCombine1 = input.nextLine().toUpperCase();
                
                System.out.println("What is the name of the second animal you want to use?");
                String animalCombine2 = input.nextLine().toUpperCase();
            
                Animal targetCombine1 = null;
                Animal targetCombine2 = null;
                for (Animal animal : player.getInventory()) {
                    if (animalCombine1.contains(animal.getName().toUpperCase())) {
                        targetCombine1 = animal;
                    }
                    if (animalCombine2.contains(animal.getName().toUpperCase())) {
                        targetCombine2 = animal;
                    }
                }
                if (targetCombine1 == null || targetCombine2 == null) {
                    System.out.println("One or more of the animals you have entered cannot be found in your bag.");
                } else if (targetCombine1 == targetCombine2) {
                    System.out.println("You use the same animal to combine! Please use two different animals to combine!");
                } else {
                    player.combine(targetCombine1,targetCombine2);
                    System.out.println();
                }
            }

            else {
                System.out.println("Please enter a valid command.");
            }

            
        }
        
        
    }
}

