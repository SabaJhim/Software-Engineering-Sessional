import java.util.Vector;

public class Product {
    private Vector<String> baseIngredient=new Vector<>();
    private Vector<String> addedIngredient=new Vector<>();

    private Vector<customElement> CustomIngredient=new Vector<>();
    private int price=0;
    private String name;

    private int addedPrice=0;

    //getter-setter

    public Vector<String> getAddedIngredient() {
        return addedIngredient;
    }

    public Vector<String> getBaseIngredient() {
        return baseIngredient;
    }

    public Vector<customElement> getCustomIngredient() {
        return CustomIngredient;
    }


    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAddedPrice() {
        return addedPrice;
    }

    public void setAddedPrice(int addedPrice) {
        this.addedPrice = addedPrice;
    }
}
