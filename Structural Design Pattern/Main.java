import java.util.Scanner;
import java.util.Vector;


public class Main {
    public static void main(String[] args) {
        Spaceship sp=new Spaceship();
        Crewmate current=new Crewmate();
        int flag=0;

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String Line = sc.nextLine();
            String[] Command = Line.split(" ");

            //Case starts from here
            if (Command[0].equalsIgnoreCase("login")) {
                if(flag==0) {
                    String temp = Command[1].substring(0, 3);
                    if (temp.equalsIgnoreCase("cre")) {
                        current = new Crewmate();
                        current.setName(Command[1]);
                        sp.login(current);
                        flag=1;
                    }
                    else if (temp.equalsIgnoreCase("imp")) {
                        Imposter imposter = new Imposter();
                        imposter.setName(Command[1]);
                        current = new Adapter(imposter);
                        sp.login(current);
                        flag=1;
                    }
                    else {
                        System.out.println("Invalid Crew name");
                    }
                }
                else{
                    System.out.println("Someone is already logged in.");
                }
            }
            else if(Command[0].equalsIgnoreCase("work")){
                if(flag==1) {
                    sp.work(current);
                }
                else{
                    System.out.println("Please login first");
                }

            }
            else if(Command[0].equalsIgnoreCase("repair")){
                if(flag==1) {
                    sp.repair(current);
                }
                else{
                    System.out.println("Please login first");
                }
            }
            else if(Command[0].equalsIgnoreCase("logout")){
                if(flag==1) {
                    sp.logout(current);
                    flag=0;
                }
                else{
                    System.out.println("Please login first");
                }
            }
            else {
                System.out.println("invalid command");
            }
        }

    }
}