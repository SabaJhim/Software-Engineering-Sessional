import java.util.Vector;

public class Shop {
    private Vector<Product> Order=new Vector<>();
    private String state="Active";

   //getter setter


    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    //Opening a order
    void openOrder(){
        if(state.equals("Active")) {
            System.out.println("Order is opened. Please place your orders.");
            setState("Engaged");
        }
        else{
            System.out.println("Sorry your current order is not placed yet. Do you want to add something in your current order? ");
        }
    }
    void closeOrder(){
        if(getState().equals("Engaged")) {
            if (Order.size() > 0) {
                System.out.println("Thank you for your orders.");
                printOrder();
                setState("Active");
                Order.clear();
            } else {
                System.out.println("Please order at least one item");
            }
        }
        else if(getState().equals("Active")){
            System.out.println("Error!! Please open an order first.");
        }
    }

    void addOrder(String[] command){
        if(getState().equals("Engaged")) {
            ShakeMaker Maker = new ShakeMaker();
            if(command.length==2) {

                    String type=command[1];
                if (type.equalsIgnoreCase("Chocolate")) {
                    Builder Chocolate = new ChocolateShake();
                    Maker.MakeShake(Chocolate);
                    Order.add(Chocolate.getShake());
                    System.out.println("Item added");
                } else if (type.equalsIgnoreCase("Coffee")) {
                    Builder Coffee = new CoffeeShake();
                    Maker.MakeShake(Coffee);
                    Order.add(Coffee.getShake());
                    System.out.println("Item added");
                } else if (type.equalsIgnoreCase("Strawberry")) {
                    Builder Strawberry = new StrawberryShake();
                    Maker.MakeShake(Strawberry);
                    Order.add(Strawberry.getShake());
                    System.out.println("Item added");
                } else if (type.equalsIgnoreCase("Vanilla")) {
                    Builder Vanilla = new VanillaShake();
                    Maker.MakeShake(Vanilla);
                    Order.add(Vanilla.getShake());
                    System.out.println("Item added");
                } else if (type.equalsIgnoreCase("Zero")) {
                    Builder Zero = new ZeroShake();
                    Maker.MakeShake(Zero);
                    Order.add(Zero.getShake());
                    System.out.println("Item added");
                } else {
                    System.out.println("Sorry this flavor is not available");
                }
            }
            else if(command.length==1){
                System.out.println("Please write the flavour you want");
            }
            else{
                System.out.println("Too many flavours.We cannot provide");
            }
        }
        else{
            System.out.println("Please Open an order first");
        }
    }

    private boolean findElementArray(String[] array, String targetContent) {
        // Iterate through the array
        for (int i = 0; i < array.length; i++) {
            if (targetContent.equalsIgnoreCase(array[i])) {
                return true;
            }
        }
        return false;
    }
    private boolean findElementVector(Vector<customElement> vector, String targetContent) {
        // Iterate through the array
        for (customElement e: vector) {
            if (targetContent.equalsIgnoreCase(e.name)) {
                return true;
            }
        }
        return false;
    }

    void customizeOrder(String[] Command){
        Customization custom=new Customization();
        int flag=0;

        if(Order.size()>0) {
            if (findElementArray(Command, "Almond")) {
                if(findElementVector(Order.lastElement().getCustomIngredient(),"Almond Milk")){
                    System.out.println("This Customization is already added");
                    flag=-1;
                }
                else {
                    custom.setAlmond_milk(Order.lastElement());
                    flag=1;
                    System.out.println("Almond milk is added.");
                }
            }
            if (findElementArray(Command, "Cookie")) {
                if(findElementVector(Order.lastElement().getCustomIngredient(),"Cookie")){
                    System.out.println("This Customization is already added");
                    flag=-1;
                }
                else {
                    custom.setCookie(Order.lastElement());
                    flag=1;
                    System.out.println("Cookie is added.");
                }
            }
            if (findElementArray(Command, "Candy")) {
                if(findElementVector(Order.lastElement().getCustomIngredient(),"Candy")){
                    System.out.println("This Customization is already added");
                    flag=-1;
                }
                else {
                    custom.setCandy(Order.lastElement());
                    flag=1;
                    System.out.println("Candy is added.");
                }

            }
            if(flag==0){
                System.out.println("Sorry this customization is not available");
            }
        }
        else{
            System.out.println("Please add an item first");
        }

    }

    void printOrder(){

        int i=1;
        int total_price=0;
        System.out.println("Your order is ");
        for (Product element : Order) {
            System.out.print(i);
            System.out.println(" "+element.getName()+" :");
            System.out.print("Base Ingredients: ");
            for (String ingredient: element.getBaseIngredient()){
                System.out.print(ingredient+",");
            }
            System.out.println(" ");
            System.out.print("Additional Ingredient: ");
            for (String ingredient: element.getAddedIngredient()){
                System.out.print(ingredient+",");
            }
            System.out.println(" ");
            System.out.print(" Base Price + Added Price: ");
            System.out.println((element.getPrice()+"tk"+"+"+ element.getAddedPrice()+"tk"));

            System.out.print("Added Price: ");
            System.out.println(element.getAddedPrice()+"tk");
            if(element.getAddedPrice()>0){
                for(customElement customIn: element.getCustomIngredient()){
                    System.out.println("    "+customIn.price+" tk added for "+customIn.name);
                }
            }
            i++;
            total_price=total_price+element.getAddedPrice()+element.getPrice();


        }
        System.out.println("Total price for the order is "+total_price+" tk");



    }



}
