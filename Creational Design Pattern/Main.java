import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Shop S=new Shop();
        System.out.println("Welcome to the shop.");
        System.out.println("1.Press 'o' to open an order.");
        System.out.println("2.Write 'add' then write the desired flavour (Chocolate/Coffee/Vanilla/Strawberry/Zero)");
        System.out.println("3.Write 'Customize' then write the desired customization (Almond/candy/cookie)");
        System.out.println("4.Press 'c' to close and place the order.");
        System.out.println("Reminder:Once you have placed the order,you can not cancel it");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String Line = sc.nextLine();
            String[] Command = Line.split(" ");

            //Case starts from here
            if (Command[0].equalsIgnoreCase("o")) {
                S.openOrder();
            }
            else if(Command[0].equalsIgnoreCase("c")){
                S.closeOrder();

            }
            else if(Command[0].equalsIgnoreCase("add")){
                S.addOrder(Command);
            }
            else if(Command[0].equalsIgnoreCase("Customize")){
                S.customizeOrder(Command);
            }
            else {
                System.out.println("invalid command");
            }
        }

    }
}