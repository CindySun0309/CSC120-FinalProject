import java.util.ArrayList;

public class Main {
Player player = new Player("User");

Farm farm = new Farm("User's farm", "This is your farm", new ArrayList<Animal>());

Nature forest = new Nature("Forest", "This is the forest", new ArrayList<Animal>());
Nature river = new Nature("River", "This is the river", new ArrayList<Animal>());
Nature grassland = new Nature("Grassland", "This is the grassland", new ArrayList<Animal>());

Animal rabbit = new Animal("rabbit", "This is a rabbit", true, 4, false, 0, 2, AnimalMouthType.mouth, 4, "Grass");
Animal tiger = new Animal("tiger", "This is a tiger", true, 4, false, 0, 3, AnimalMouthType.mouth, 10,"Meat");
Animal fish = new Animal("fish", "This is a fish", false, 0, false, 0, 1, AnimalMouthType.mouth, 2,"plankton");
Animal starfish = new Animal("starfish", "This is a starfish", false, 0, false, 0, 1, AnimalMouthType.mouth, 2, "plankton");
Animal zebra = new Animal("zebra", "This is a zebra", true, 4, false, 0, 2, AnimalMouthType.mouth, 5,"grass");
Animal bird = new Animal("bird", "This is a bird", true, 2, true, 2, 2, AnimalMouthType.mouth, 3,"insect");

Animal rabbitfish = new Animal("rabbitfish", "This is a rabbitfish", true, 4, false, 0, 5, AnimalMouthType.mouth, 4, "Grass");
Animal tigerbird = new Animal("tigerbird", "This is a tigerbird", true, 4, true, 2, 10, AnimalMouthType.mouth, 4, "Meat");
Animal zebrabird = new Animal("zebrabird", "This is a zebrabird", true, 4, false, 2, 8, AnimalMouthType.mouth, 4, "Insect");
Animal rabbitzebra = new Animal("rabbitzebra", "This is a rabbitzebra", true, 4, false, 0, 8, AnimalMouthType.mouth, 4, "grass");

Fodder grass = new Fodder("grass", 1);
Fodder meat = new Fodder("meat", 3);
Fodder insect = new Fodder("insect", 1);
Fodder plankton = new Fodder("plankton", 1);
}
