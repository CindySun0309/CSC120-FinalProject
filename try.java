public class try {
    Scanner input = new Scanner(System.in);
        while (player.getMoney() <= 20){
            String action = null;
            if (player.getLocation() == "Farm"){
                System.out.println("You are in Farm, What things to you want to do: 'move', 'stay'");
                action = input.nextLine();
                if (action == "move"){
                    System.out.println("Where do you want to move: 'shop', 'grassland', 'river', 'forest'");
                    String nextLocation = input.nextLine();
                    player.move(nextLocation);
                }
                else if (action == "stay"){
                    System.out.println("What do you want to do: 'putintofarm', 'remove'. 'combine'");
                    action = input.nextLine();
                    if (action == "putintofarm"){
                        System.out.println("What animals do you want to put:");
                        String AnimalName = input.nextLine();
                        if (AnimalName == "rabbit"){
                            player.putInFarm(rabbit);
                        }
                        if (AnimalName == "tiger"){
                            player.putInFarm(tiger);
                        }
                        if (AnimalName == "fish"){
                            player.putInFarm(fish);
                        }
                        if (AnimalName == "starfish"){
                            player.putInFarm(crab);
                        }
                        if (AnimalName == "zebra"){
                            player.putInFarm(zebra);
                        }
                        if (AnimalName == "bird"){
                            player.putInFarm(bird);
                        }
                        if (AnimalName == "rabbitfish"){
                            player.putInFarm(rabbitfish);
                        }
                        if (AnimalName == "tigerbird"){
                            player.putInFarm(tigerbird);
                        }
                        if (AnimalName == "zebrabird"){
                            player.putInFarm(zebrabird);
                        }
                        if (AnimalName == "rabbitzebra"){
                            player.putInFarm(rabbitzebra);
                        }
                    }
                    if (action == "remove"){
                        System.out.println("What animals do you want to remove:");
                        String AnimalName = input.nextLine();
                        if (AnimalName == "rabbit"){
                            player.getFarm().removeFromInventory(rabbit);;
                        }
                        if (AnimalName == "tiger"){
                            player.getFarm().removeFromInventory(tiger);
                        }
                        if (AnimalName == "fish"){
                            player.getFarm().removeFromInventory(fish);
                        }
                        if (AnimalName == "starfish"){
                            player.getFarm().removeFromInventory(starfish);
                        }
                        if (AnimalName == "zebra"){
                            player.getFarm().removeFromInventory(zebra);
                        }
                        if (AnimalName == "bird"){
                            player.getFarm().removeFromInventory(bird);
                        }
                        if (AnimalName == "rabbitfish"){
                            player.getFarm().removeFromInventory(rabbitfish);
                        }
                        if (AnimalName == "tigerbird"){
                            player.getFarm().removeFromInventory(tigerbird);
                        }
                        if (AnimalName == "zebrabird"){
                            player.getFarm().removeFromInventory(zebrabird);
                        }
                        if (AnimalName == "rabbitzebra"){
                            player.getFarm().removeFromInventory(rabbitzebra);
                        }
                    }
                    if (action == "combine"){
                        System.out.println("What animals do you want to combine first:");
                        String animalName1 = input.nextLine();
                        System.out.println("What animals do you want to combine then:");
                        String animalName2 = input.nextLine();
                        if (animalName1.equals("rabbit") && animalName2.equals("fish")) {
                            player.combine(animalName1, animalName2);
                        }
                        if (animalName1.equals("tiger") && animalName2.equals("bird")){
                            player.combine(animalName1, animalName2);
                        }
                        if (animalName1.equals("zebra") && animalName2.equals("bird")){
                            player.combine(animalName1, animalName2);
                        }
                        if (animalName1.equals("zebra") && animalName2.equals("rabbit")){
                            player.combine(animalName1, animalName2);
                        }
                    }
                }
                else{
                    System.out.print("Invalid Input, please restart the game");
                }
            }
            if (player.getLocation().getName() == "Shop"){
                //implement the action in shop
            }
            if (player.getLocation().getName() == "grassland"){
                //implement the action in grassland
            }
            if (player.getLocation().getName() == "river"){
                //implement the action in river
            }
            if (player.getLocation().getName() == "forest"){
                //implement the action in forest
            }
        }
}








