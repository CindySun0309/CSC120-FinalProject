import java.util.Scanner;

/**
The StartGame class is the main class for the game to run.
*/
public class StartGame {

    /** This is the main we used to run our codes */
    public static void main(String[]args){
        
        /** Create the forest */
        Location forest = new Location("forest");
        /** Create the river */
        Location river = new Location("river");
        /** Create the grassland */
        Location grassland = new Location("grassland");
        /** Create the farm */
        Farm farm = new Farm("farm");
        /** Create the shop */
        Location shop = new Location("shop");

        /** Create rabbit */
        Animal rabbit = new Animal("rabbit", "This is a rabbit", true, 4, false, 0, 4, grassland);
        /** Create tiger */
        Animal tiger = new Animal("tiger", "This is a tiger", true, 4, false, 0, 6,  grassland);
        /** Create fish */
        Animal fish = new Animal("fish", "This is a fish", false, 0, false, 0, 2, river);
        /** Create crab */
        Animal crab = new Animal("crab", "This is a crab", true, 10, false, 0, 4, river);
        /** Create shrimp */
        Animal shrimp = new Animal("shrimp", "This is a shrimp", true, 10, false, 0, 4, river);
        /** Create zebra */
        Animal zebra = new Animal("zebra", "This is a zebra", true, 4, false, 0, 4, grassland);
        /** Create bird */
        Animal bird = new Animal("bird", "This is a bird", true, 2, true, 2, 4,forest);
        /** Create frog */
        Animal frog = new Animal("frog", "This is a frog", true, 4, false, 0, 2, forest);
        /** Create butterfly */
        Animal butterfly = new Animal("butterfly", "This is a butterfly", true, 4, true, 2, 4, forest);

        /** Add bird to the forest */
        forest.addAnimal(bird);
        /** Add frog to the forest */
        forest.addAnimal(frog);
        /** Add butterfly to the forest */
        forest.addAnimal(butterfly);

        /** Add fish to the river */
        river.addAnimal(fish);
        /** Add crab to the river */
        river.addAnimal(crab);
        /** Add shrimp to the river */
        river.addAnimal(shrimp);

        /** Add tiger to the grassland */
        grassland.addAnimal(tiger);
        /** Add zebra to the grassland */
        grassland.addAnimal(zebra);
        /** Add rabbit to the grassland */
        grassland.addAnimal(rabbit);

        /** Open the scanner for the player to input commmands */
        Scanner input = new Scanner(System.in);  

        /** Ask the player to enter their name */
        System.out.println("Enter username:");
        String userName = input.nextLine(); 
        System.out.println("Your name is: " + userName + ". You are a farmer and own a big farm! \nYour goal is to earn 50 dollars. Now start your exploration!"); 

        /** Create the player */
        Player player = new Player(userName, farm);

        /** Set the player's current location to currentlocation */
        Location currentLocation = player.getLocation();

        /** Open the while loop to offically start the game, once the player earned 50 dollars, the while loop closed*/
        while (player.getMoney() < 50){
            /** Ask player commands */
            System.out.println("\nWhat do you want to do next? \nAvailable options: move, catch, sell, combine, throw away, put in farm, \nget from farm, show my bag, show farm inventory, show location, and undo.");
            String userMovement = input.nextLine().toUpperCase();

            /** Enter the if-statement if the player wants to move to a location*/
            if (userMovement.contains("MOVE")) {
                System.out.println("Where do you want to move to? Available options: forest, river, grassland, farm, shop");
                String userNewLocation = input.nextLine().toUpperCase();
                System.out.println("Moving...");
    
                /** Check if the player is already at the location they want to go */
                if (userNewLocation.contains(player.getLocation().getName().toUpperCase())) {
                    System.out.println("Oops! You are already at " + userNewLocation + "!");
                }
                else if (userNewLocation.contains("FARM")) {
                    player.move(farm);
                    currentLocation = player.getLocation();
                }
                else if (userNewLocation.contains("FOREST")) {
                    player.move(forest);
                    currentLocation = player.getLocation();
                    System.out.println("You are surrounded by tall trees. The fresh air makes you feel relaxed. \nYou hear the frogs croaking, the birds singing. Some colorful butterflies \nare flying around you.");
                }
                else if (userNewLocation.contains("RIVER")) {
                    player.move(river);
                    currentLocation = player.getLocation();
                    System.out.println("The river in front of you is very clear. You can't help but take off \nyour shoes and socks and run into the water. There are fish and shrimps \nswimming, as well as some crabs lying by the river.");
                }
                else if (userNewLocation.contains("GRASSLAND")) {
                    player.move(grassland);
                    currentLocation = player.getLocation();
                    System.out.println("A group of leisurely zebras was suddenly frightened by running rabbits, \nand it turned out that there was a group of tigers staring at the group \nof zebras intently nearby! You can't help but wonder, does something \nlike this happen everyday?");
                }
                else if (userNewLocation.contains("SHOP")) {
                    player.move(shop);
                    System.out.println("Welcome! Welcome! You can sell your animal(s) in your bag here!");
                    currentLocation = player.getLocation();
                }
                else {
                    System.out.println("Oops! Please enter a valid location.");
                }
            }

            /** Enter the if-statement if the player wants to catch an animal */
            else if (userMovement.contains("CATCH")) {
                System.out.println("What animal do you want to catch?");
                String animalToCatch = input.nextLine().toUpperCase();
    
                Animal targetAnimal = null;
                for (Animal animal : player.getLocation().getLivingAnimals()) {
                    if (animalToCatch.contains(animal.getName().toUpperCase())) {
                        targetAnimal = animal;
                    }
                }
                
                if (targetAnimal != null) {
                    if (player.getLocation().equals(targetAnimal.getLivingLocation())) {
                        player.catchAnimal(targetAnimal);
                    } 
                    else {
                        System.out.println("The " + targetAnimal.getName() + " is not in this location.");
                    }
                } 
                else {
                    System.out.println("There is no animal called " + animalToCatch + " in this location.");
                }  
            }

            /** Enter the if-statement if the player wants to throw away an animal from their bag */
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

                } 
                else {
                    System.out.println("There is no animal with the name " + animalToThrow + " in your bag.");
                }  
            }

            /** Enter the if-statement if the player wants to show things in their bag */
            else if (userMovement.equals("SHOW MY BAG")) {
                System.out.println(player.printAnimalInInventory());
            }

            /** Enter the if-statement if the player wants to show their farm inventory */
            else if (userMovement.equals("SHOW FARM INVENTORY")) {
                System.out.println(farm.getAnimalInventory());
            }

            /** Enter the if-statement if the player wants to put an animal into their farm inventory */
            else if (userMovement.equals("PUT IN FARM")) {
                if (currentLocation != farm) {
                    System.out.println("Please move back to your farm first!");
                }
                else {
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
                        System.out.println("You put a " + putAnimal.getName() + " in to the farm inventory!");
                        System.out.println(farm.getAnimalInventory());
                        player.getActions().add("PUT IN FARM");
                    } 
                    else {
                        System.out.println("Sorry, you do not have this animal in your bag currently.");
                    }
                }
                
            }

            /** Enter the if-statement if the player wants to take an animal out from their farm inventory */
            else if (userMovement.equals("GET FROM FARM")) {
                if (currentLocation != farm) {
                    System.out.println("Please move back to your farm first!");
                }
                else {
                    System.out.println("What animal do you want to get from the farm inventory?");
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
                        player.getActions().add("GET FROM FARM");
                    } 
                    else {
                    System.out.println("Sorry, you do not have this animal in your farm inventory currently.");
                    }
                } 
            }
            
            /** Enter the if-statement if the player wants to sell animal(s) */
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
                    
                    // Check if the user has the specified animal in their bag
                    if (player.getInventory().contains(targetAnimal)) {

                        

                        // Get the current quantity of the animal in the bag
                        int currentQuantity = 0;
                        for (Animal animal : player.getInventory()) {
                            if (animal.getName().toUpperCase().equals(animalToSell)) {
                                currentQuantity ++;
                            }
                        }
                        System.out.println("You currently have " + currentQuantity + " " + animalToSell + " in your bag.");

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
                                
                                // Remove the sold animal(s) from the bag and add the money to the user's balance
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
                                player.getActions().add("SELL");
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
                        System.out.println("You do not have any " + animalToSell + " in your bag! Try to catch one first!");
                    }
                }
                else {
                    System.out.println("Please go to the shop for selling your animal(s)!");
                }
            }

            else if (userMovement.contains("SHOW LOCATION")){
                System.out.println("You are currently at the " + player.getLocation().getName() + ".");
            }

            /** Enter the if-statement if the player wants to combine two animals */
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
                    System.out.println("Sorry, one or more of the animals you have entered cannot be found in your bag.");
                } 
                else if (targetCombine1 == targetCombine2) {
                    System.out.println("You use the same animal to combine! Please use two different animals to combine!\nYou don't want to waste 2 " + targetCombine1.getName() + "(s) to create 1 new " + targetCombine1.getName() + ", right? :)");
                } 
                else {
                    player.combine(targetCombine1,targetCombine2);
                    System.out.println();
                }
            }

            /** Enter the if-statement if the player wants to undo the previous command */
            else if (userMovement.contains("UNDO")) {
                try {
                    if (player.getActions().get(player.getActions().size()-1) == "MOVE") {
                        System.out.println("You thought: Maybe I should not come to the " + player.getLocation().getName() + " now...\nSo you moved back...");
                        player.unmove(player.getLocation());
                        player.getActions().remove(player.getActions().size()-1);
                    }
                    else if (player.getActions().get(player.getActions().size()-1) == "CATCH") {
                        System.out.println("You thought: Maybe I should not catch the " + player.getLastAnimalCaught().getName() + " now...\nSO");
                        player.throwaway(player.getLastAnimalCaught());
                        player.getActions().remove(player.getActions().size()-1);
                        player.getActions().remove(player.getActions().size()-1);
                    }
                    else if (player.getActions().get(player.getActions().size()-1) == "COMBINE") {
                        System.out.println("Oops! Once you tried to combine two animals, those two animals no longer exist, \nno matter you failed to create a new animal or not :(");
                        player.getActions().remove(player.getActions().size()-1);
                    }
                    else if (player.getActions().get(player.getActions().size()-1) == "THROW AWAY") {
                        System.out.println("You realized you threw a " + player.getLastAnimalCaught().getName() + " by accident.\nHowever, when you want to re-catch it, it already ran away.");
                        player.getActions().remove(player.getActions().size()-1);
                    }
                    else if (player.getActions().get(player.getActions().size()-1) == "SELL") {
                        System.out.println("Sorry, once an animal is sold, you can no longer buy it back.");
                        player.getActions().remove(player.getActions().size()-1);
                    }
                    else if (player.getActions().get(player.getActions().size()-1) == "PUT IN FARM") {
                        System.out.println("You realized: Actually I don't want to put it in my farm...");
                        player.getFromFarm(farm.getInventory().get(farm.getInventory().size()-1));
                        player.getActions().remove(player.getActions().size()-1);
                    }
                    else if (player.getActions().get(player.getActions().size()-1) == "GET FROM FARM") {
                        System.out.println("You realized: Actually I don't want to get it from my farm...");
                        player.putInFarm(player.getInventory().get(player.getInventory().size()-1));
                        player.getActions().remove(player.getActions().size()-1);
                    }
                } 
                catch(Exception e) {
                    System.out.println("Oops! No more undo available!");
                }
            }
            else {
                System.out.println("Please enter a valid command.");
            }
        }
        /** Once the while loop is closed, the player win the game */
        System.out.println("-------------------------------------------------------");
        System.out.println("Congratulation! You earned 50 dollars and won the game!");
        System.out.println("-------------------------------------------------------");
        input.close();
    }
}

