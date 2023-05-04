public class Animal {
    private String name;
    private String description;
    private boolean haslegs;
    private int legnum;
    private boolean haswings;
    private int wingnum;
    private int price;
    private Location livingLocation;
    

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

    public boolean getHaslegs() {
        return haslegs;
    }

    public boolean hasWings() {
        return haswings;
    }

    public int getLegNum() {
        return legnum;
    }

    public int getWingNum() {
        return wingnum;
    }

    public String getName() {
        return name;
    }

    public String getdescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public Location getLivingLocation() {
        return livingLocation;
    }
}
