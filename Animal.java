public class Animal {
    private String name;
    private String description;
    private boolean haslegs;
    private int legnum;
    private boolean haswings;
    private int wingnum;
    private AnimalMouthType mouthtype;
    private int price;
    private int hungryValue;
    private String fodderType;
    

    public Animal(String name, String description, boolean haslegs, int legnum, boolean haswings, int wingnum,int price, AnimalMouthType mouthtype, int hungryValue, String fodderType) {
        this.name = name;
        this.description = description;
        this.haslegs = haslegs;
        this.legnum = legnum;
        this.haswings = haswings;
        this.wingnum = wingnum;
        this.mouthtype = mouthtype;
        this.hungryValue = hungryValue;
        this.price = price;
        this.fodderType = fodderType;
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

    public int gethungryValue() {
        return hungryValue;
    }

    public String getfodderType() {
        return fodderType;
    }
}
