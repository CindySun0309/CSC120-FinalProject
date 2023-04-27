This file will contain documentation for all commands available in your game.

Note:  It's a good idea to also make this list available inside the game, in response to a `HELP` command.

We are creating an interactive farm, and the player is a farmer. The player can explore the map to catch different animals and sell them to get money, buy fodder to feed animals, and also combine animals to create new creatures (sometimes will not be successful— if successful, the new creature will be sold at higher prices, and if failed, then the farmer will lose animals). The goal of the game is to collect all creatures in this world.
Sorry but currently all of our classes are disconnected, so it can't be played for now:(

methods for the Location class:
getName()
getdescription()

methods for the Farm class:
addToInventory()
removeFromInventory()
addToFodderInventory()
removeFromFodderInventory()

methods for the Nature class:
getAnimals() — not yet done
getName() — not yet done
getDescription() — not yet done

methods for the Animal class:
getName()
getdescription()
getPrice()
gethungryvalue()
getfodderType()

methods for the Player class:
getName()
getmoney()
addmoney()
subtractMoney()
getInventory()
sell()
buy()
move()
feed()
combine()
throwaway()
putInFarm()

methods for the Shop class:
restock()  — not yet done

methods for the Fodder class:
getName()
getPrice()

# SPOILER ALERT

If your game includes challenges that must be overcome to win, also list them below.
