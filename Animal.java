/**
The Animal class represents an animal with a name, description, physical attributes, price, and living location.
*/
public class Animal {

    /** The name of the animal. */
    private String name; 
    /** A description of the animal. */
    private String description; 
    /**  Whether the animal has legs or not. */
    private boolean haslegs; 
    /** The number of legs the animal has. */
    private int legnum; 
    /** Whether the animal has wings or not. */
    private boolean haswings; 
    /** The number of wings the animal has. */
    private int wingnum; 
    /** The price of the animal. */
    private int price;
    /** The location where the animal lives. */
    private Location livingLocation; 
    

    /**
    Constructs an Animal object with the specified name, description, physical attributes, price, and living location.
    @param name the name of the animal.
    @param description a description of the animal.
    @param haslegs whether the animal has legs or not.
    @param legnum the number of legs the animal has.
    @param haswings whether the animal has wings or not.
    @param wingnum the number of wings the animal has.
    @param price the price of the animal.
    @param livingLocation the location where the animal lives.
    */
    public Animal(String name, String description, boolean haslegs, int legnum, boolean haswings, int wingnum,int price, Location livingLocation) {
        this.name = name;
        this.description = description;
        this.haslegs = haslegs;
        this.legnum = legnum;
        this.haswings = haswings;
        this.wingnum = wingnum;
        this.price = price;
        this.livingLocation = livingLocation;
    }

    /**
    Returns whether the animal has legs or not.
    @return true if the animal has legs, false otherwise.
    */
    public boolean getHasLegs() {
        return haslegs;
    }

    /**
    Returns whether the animal has wings or not.
    @return true if the animal has wings, false otherwise.
    */
    public boolean getHasWings() {
        return haswings;
    }

    /**
    Returns the number of legs the animal has.
    @return the number of legs.
    */
    public int getLegNum() {
        return legnum;
    }

    /**
    Returns the number of wings the animal has.
    @return the number of wings.
    */
    public int getWingNum() {
        return wingnum;
    }

    /**
    Returns the name of the animal.
    @return the name.
    */
    public String getName() {
        return name;
    }

    /**
    Returns the description of the animal.
    @return the description.
    */
    public String getDescription() {
        return description;
    }

    /**
    Returns the price of the animal.
    @return the price.
    */
    public int getPrice() {
        return price;
    }

    /**
    Returns the location where the animal lives.
    @return the living location.
    */
    public Location getLivingLocation() {
        return livingLocation;
    }
}
