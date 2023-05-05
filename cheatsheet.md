We are creating an interactive farm, and the player is a farmer. 

The player can:
Explore the map, move to different locations (ie. river, forest, and grassland).
Catch animals in specific locations, such as catch fish only in the river, catch birds only in the forest, and catch tigers only on the grassland. 
Sell animals you caught in the shop to get money.
Use two different animals to create a new creature!
Put animals in the farm.
Throw away the animals in your inventory. Reminder: Your inventory can contain maximum 5 animals. Otherwise, you can throw away or put animals into the farm inventory which don't have the size limit.
Get animals from the farm. 
Show your inventory.
Redo actions: move, catch, sell, throw away, put in farm, get from farm, combine. 

The animals are preset by the game, including traits like leg numbers, wing numbers, price, pop-up locations etc. 

Once you sell animals and have 20 dollars, the game ends! Congratulations! 


methods for the Location class:
getName()
getLivingAnimals()
addAnimal()

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
getInventory()
getLocation()
addMoney()
subtractMoney()
printAnimalInInventory()
move()
combine()
throwaway()
putInFarm()
getFromFarm()
catchAnimal()

methods for the Shop class:
getName()

methods for the Location class:
getName()
addAnimal()
getLivingAnimals()