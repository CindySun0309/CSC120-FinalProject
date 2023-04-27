import java.util.ArrayList;

public class Location {
    private ArrayList<Animal> animals;
    private String description;
    private String name;

public Location(String name, String description){
    this.name = name;
    this.description = description;
}

public Location(String name, String description, ArrayList<Animal> animals) {
    this.name = name;
    this.description = description;
    this.animals = animals;
 }    

public String getName() {
    return name;
}

public String getdescription() {
    return description;
}

}