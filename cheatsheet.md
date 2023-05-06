We created an interactive farm, and the player is the farmer. The goal is to earn 50 dollars.

The player can:
- Explore the map, move to different locations (ie. river, forest, and grassland).
- Catch animals in specific locations, such as catch fish only in the river, catch birds only in the forest, and catch tigers only on the grassland. 
- Sell animals you caught in the shop to get money.
- Combine two different animals to create a new creature!
- Put animals in the farm.
- Throw away the animals in your bag. Reminder: Your bag can contain maximum 5 animals. Otherwise, you can throw away or put animals into the farm inventory which doesn't have a size limit.
- Get animals from the farm. 
- Show your bag, witch will tell you how many animals you currently have in your bag and how much money you have in your pocket.
- Redo actions: move, catch, sell, throw away, put in farm, get from farm, combine. 

The animals are preset by the game, including traits like leg numbers, wing numbers, price, pop-up locations etc. 

Once you sell animals and have 50 dollars, the game ends! Congratulations! 

___________________________________________________________________________________________________
Below are code related information --- players do not need to know these when playing:

methods for the Location class:
getName()
addAnimal()
getLivingAnimals()

methods for the Farm class:
getAnimalInventory()
getName()
getInventory()
addToInventory()
removeFromInventory()

methods for the Animal class:
getHaslegs()
hasWings()
getLegNum()
getWingNum()
getName()
getdescription()
getPrice()
getLivingLocation()

methods for the Player class:
getName()
getMoney()
addMoney()
printAnimalInInventory()
getInventory()
getLocation()
combine()
throwaway()
putInFarm()
getFromFarm()
catchAnimal()
getLastLocation()
move()
unmove()
getActions()
getLastAnimalCaught()

methods for the Location class:
getName()
addAnimal()
getLivingAnimals()