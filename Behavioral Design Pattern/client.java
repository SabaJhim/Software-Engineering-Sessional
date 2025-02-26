import java.io.IOException;
import java.util.Scanner;

public class client {
    public static void main(String args[]) throws IOException {
        NetworkUtil server= new NetworkUtil("127.0.0.1",3000);
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name=sc.nextLine();
        server.write(name);

        new Thread(()->{
            while(true) {
                try {
                    Object data = server.read();
                    String str = (String) data;
                    System.out.println(str);



                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }

        }).start();

        while (true) {
            String message=sc.nextLine();
            server.write(message);
        }

    }
}
