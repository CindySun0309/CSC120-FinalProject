import java.lang.invoke.StringConcatFactory;

public class Fodder {
    private int price;
    private String name;

    public Fodder(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
