import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class publisher {
    private Manager eventManager=new Manager();
    private ArrayList<StockData> FileData = new ArrayList<>();
    private String filePath = "C:\\Users\\LENOVO\\IdeaProjects\\offline4\\src\\input.txt";

    publisher(){
        try {
            List<String> lines = readFile(filePath);

            for (String line : lines) {
                String words[]=line.split(" ");
                StockData s = new StockData(words[0], Integer.parseInt(words[1]), Float.parseFloat(words[2]));
                FileData.add(s);
            }

        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }


    }

    private static List<String> readFile(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }

        return lines;
    }

    ArrayList<Subscriber> IncreasePrice(String name,float amount){
        ArrayList<Subscriber> SubscriberFound=new ArrayList<>();
        for(StockData s : FileData){
           if(s.name.equalsIgnoreCase(name)) {
               s.price=s.price+amount;
              SubscriberFound= eventManager.Notify("I"+" "+name+" "+amount,s);
           }
        }
        return SubscriberFound;
    }

    ArrayList<Subscriber> DecreasePrice(String name,float amount){
        ArrayList<Subscriber> SubscriberFound=new ArrayList<>();
        for(StockData s : FileData){
            if(s.name.equalsIgnoreCase(name)) {
                if(s.price-amount>=0) {
                    s.price = s.price - amount;
                    SubscriberFound=eventManager.Notify("D"+" "+name+" "+amount,s);
                }
                else{
                    s.price=0;
                    SubscriberFound=eventManager.Notify("D"+" "+name+" "+amount,s);
                }
            }
        }
        return SubscriberFound;
    }
    ArrayList<Subscriber> ChangeCount(String name, int count){
        ArrayList<Subscriber> SubscriberFound=new ArrayList<>();
        for(StockData s: FileData){
            if(s.name.equalsIgnoreCase(name)){
                s.count=count;
                SubscriberFound=eventManager.Notify("C"+" "+name+" "+count,s);
            }
        }
        return SubscriberFound;
    }
    void Subscribe(String name,String Stock){

        for(StockData s:FileData){
            if(s.name.equalsIgnoreCase(Stock)){
                eventManager.subscribe(name,s);
                eventManager.Notify("S"+" "+Stock,s);
            }
        }

    }
    void Unsubscribe(String name,String Stock){

        for(StockData s:FileData){
            if(s.name.equalsIgnoreCase(Stock)){
                eventManager.unsubscribe(name,s);
                System.out.println("publisher");
            }
        }
    }
    ArrayList<StockData> View(String name){
        ArrayList<StockData> dataList=new ArrayList<>();
        dataList=eventManager.View(name);
        return dataList;
    }
    ArrayList<StockData> showAll(){
        return FileData;
    }

}

