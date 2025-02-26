import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class server {
    public static void main(String args[]) throws IOException {
        ServerSocket serverSocket=new ServerSocket(3000);
        publisher Publisher=new publisher();
        HashMap<String,NetworkUtil> clientTracker=new HashMap<>();
        System.out.println("Server started");


        while(true){
            Socket clientSocket=serverSocket.accept();
            NetworkUtil client=new NetworkUtil(clientSocket);
            System.out.println("Someone just joined");




            new Thread(()->{
                try {
                    String name=(String)client.read();
                    clientTracker.put(name,client);
                    int flag=0;
                    if(name.equalsIgnoreCase("admin")){
                        flag=1;
                    }
                    if(flag==0) {
                        ArrayList<StockData> allInfo = Publisher.showAll();
                        client.write("All stock Information:");
                        for (StockData s : allInfo) {
                            client.write(s.name + " " + s.count + " " + s.price);
                        }
                    }

                    while (true) {
                        Object data = client.read();
                        String str = (String) data;
                        String words[]=str.split(" ");
                        NetworkUtil admin=clientTracker.get("admin");
                        NetworkUtil subscriber=clientTracker.get(name);

                        if(client==admin) {

                            if (words[0].equalsIgnoreCase("I")) {
                                ArrayList<Subscriber> SubscriberFound=new ArrayList<>();
                               SubscriberFound= Publisher.IncreasePrice(words[1],Float.parseFloat(words[2]));
                               for(Subscriber e:SubscriberFound){
                                   NetworkUtil Foundsubscriber=clientTracker.get(e.name);
                                   if(Foundsubscriber!=null){

                                       Foundsubscriber.write("Increased price of "+words[1]+" by "+words[2]);

                                   }
                               }
                                admin.write("Increased price of "+words[1]+" by "+words[2]);
                                System.out.println("Increased price");

                            }
                            else if (words[0].equalsIgnoreCase("D")) {
                                ArrayList<Subscriber> SubscriberFound=new ArrayList<>();
                               SubscriberFound= Publisher.DecreasePrice(words[1],Float.parseFloat(words[2]));
                                for(Subscriber e:SubscriberFound){
                                    NetworkUtil Foundsubscriber=clientTracker.get(e.name);
                                    if(Foundsubscriber!=null){
                                        Foundsubscriber.write("Decreased price of "+words[1]+" by"+words[2]);
                                    }
                                }
                                admin.write("Decreased price of "+words[1]+" by "+words[2]);
                                System.out.println("Decreased price");

                            } else if (words[0].equalsIgnoreCase("C")) {
                                ArrayList<Subscriber> SubscriberFound=new ArrayList<>();
                                SubscriberFound=Publisher.ChangeCount(words[1],Integer.parseInt(words[2]));
                                for(Subscriber e:SubscriberFound){
                                    NetworkUtil Foundsubscriber=clientTracker.get(e.name);
                                    if(Foundsubscriber!=null){
                                        Foundsubscriber.write("Changed stock count of "+words[1]+" to "+words[2]);
                                    }
                                }
                                admin.write("Changed stock count of "+words[1]+" to "+words[2]);
                                System.out.println("Changed Count");
                            }
                            else{
                                admin.write("Not a valid command for admin");
                                System.out.println("Not a valid command for admin");
                            }
                        }
                        else if(subscriber==client){
                            if(words[0].equalsIgnoreCase("S")){
                                Publisher.Subscribe(name,words[1]);
                                client.write("Subscribed to "+words[1]);
                                System.out.println("Subscribed");
                            }
                            else if(words[0].equalsIgnoreCase("U")){
                                Publisher.Unsubscribe(name,words[1]);
                                client.write("Unsubscribed to "+words[1]);
                                System.out.println("UnSubscribed");

                            }
                            else if(words[0].equalsIgnoreCase("V")){
                               ArrayList<StockData> DataList= Publisher.View(name);
                               for(StockData s:DataList){
                                   client.write(s.name+" "+s.count+" "+s.price);
                               }
                                System.out.println("Printed");

                            }
                        }

                    }












                } catch (IOException e) {
                    System.out.println("Client disconnected.");

                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } finally {
                    try {
                        client.closeConnection();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }


            }).start();
        }
    }
}
