

class customElement{
    public String name;
    public int price;

    customElement(String name,int price){
        this.name=name;
        this.price=price;
    }
}

public class Customization {
    void setAlmond_milk(Product shake){
        shake.getBaseIngredient().set(0,"Almond Milk");
        shake.getCustomIngredient().add(new customElement("Almond Milk",60));
        shake.setAddedPrice(shake.getAddedPrice()+60);
    }
    void setCandy(Product shake){
        shake.getAddedIngredient().add("Candy");
        shake.getCustomIngredient().add(new customElement("Candy",50));
        shake.setAddedPrice(shake.getAddedPrice()+50);
    }
    void setCookie(Product shake){
        shake.getAddedIngredient().add("Cookie");
        shake.getCustomIngredient().add(new customElement("Cookie",40));
        shake.setAddedPrice(shake.getAddedPrice()+40);
    }


}
