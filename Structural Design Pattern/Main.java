import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Computer cmp=new Computer();
        int flag=0;

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String Line = sc.nextLine();
            String[] Command = Line.split(" ");

            //Case starts from here
            if (Command[0].equalsIgnoreCase("mkdrive")) {
                    cmp.MakeDrive(Command[1]);
            }
            else if(Command[0].equalsIgnoreCase("mkdir")){
                    cmp.MakeDir(Command[1]);

            }
            else if(Command[0].equalsIgnoreCase("touch")){
                    int a=Integer.parseInt(Command[2]);
                    cmp.Touch(Command[1],a);
            }
            else if(Command[0].equalsIgnoreCase("cd") && Command[1].equals("~")){
                    cmp.Jump();
            }
            else if(Command[0].equalsIgnoreCase("cd")){
                cmp.ChangeDirectory(Command[1]);
            }

            else if(Command[0].equalsIgnoreCase("Is")){
                cmp.Details(Command[1]);
            }
            else if(Command[0].equalsIgnoreCase("list")){
                cmp.List();
            }
            else if(Command[0].equalsIgnoreCase("delete") && Command[1].equals("-r")){
                cmp.RecursiveDelete(Command[2]);
            }
            else if(Command[0].equalsIgnoreCase("delete")){
                cmp.Delete(Command[1]);
            }

            else {
                System.out.println("invalid command");
            }
        }

    }
}
