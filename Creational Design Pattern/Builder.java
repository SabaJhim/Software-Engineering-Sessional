public interface Builder {
    void addMilk();
    void addSweetener();
    void addflavoring();
    void setPrice();
    void setName();
    Product getShake();



}


class ChocolateShake implements Builder{
    private Product shake= new Product();

   public void addMilk(){
        shake.getBaseIngredient().add("Milk");
    }
    public void addSweetener(){
       shake.getBaseIngredient().add("Sugar");
    }
    public void addflavoring(){
       shake.getAddedIngredient().add("Chocolate Syrup");
       shake.getAddedIngredient().add("Chocolate Ice cream");
    }
    public void setPrice(){
       shake.setPrice(230);
    }

    public void setName(){
       shake.setName("Chocolate Shake");
    }
    public Product getShake(){
       return shake;
    }


}


class CoffeeShake implements Builder{
    private Product shake= new Product();

    public void addMilk(){
        shake.getBaseIngredient().add("Milk");
    }
    public void addSweetener(){
        shake.getBaseIngredient().add("Sugar");
    }
    public void addflavoring(){
        shake.getAddedIngredient().add("Coffee");
        shake.getAddedIngredient().add("Jello");
    }
    public void setPrice(){
        shake.setPrice(250);
    }

    public void setName(){
        shake.setName("Coffee Shake");
    }
    public Product getShake(){
        return shake;
    }


}


class StrawberryShake implements Builder{
    private Product shake= new Product();

    public void addMilk(){
        shake.getBaseIngredient().add("Milk");
    }
    public void addSweetener(){
        shake.getBaseIngredient().add("Sugar");
    }
    public void addflavoring(){
        shake.getAddedIngredient().add("Strawberry Syrup");
        shake.getAddedIngredient().add("Strawberry Ice cream");
    }
    public void setPrice(){
        shake.setPrice(200);
    }

    public void setName(){
        shake.setName("Strawberry Shake");
    }
    public Product getShake(){
        return shake;
    }

}


class VanillaShake implements Builder{
    private Product shake= new Product();

    public void addMilk(){
        shake.getBaseIngredient().add("Milk");
    }
    public void addSweetener(){
        shake.getBaseIngredient().add("Sugar");
    }
    public void addflavoring(){
        shake.getAddedIngredient().add("Vanilla flavoring");
        shake.getAddedIngredient().add("Jello");
    }
    public void setPrice(){
        shake.setPrice(190);
    }

    public void setName(){
        shake.setName("Vanilla Shake");
    }
    public Product getShake(){
        return shake;
    }

}


class ZeroShake implements Builder{
    private Product shake= new Product();

    public void addMilk(){
        shake.getBaseIngredient().add("Milk");
    }
    public void addSweetener(){
        shake.getBaseIngredient().add("Sweetener");
    }
    public void addflavoring(){
        shake.getAddedIngredient().add("Vanilla flavoring");
        shake.getAddedIngredient().add("SugarFree Jello");
    }
    public void setPrice(){
        shake.setPrice(240);
    }

    public void setName(){
        shake.setName("Zero Shake");
    }
    public Product getShake(){
        return shake;
    }


}
