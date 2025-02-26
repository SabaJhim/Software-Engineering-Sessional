import java.util.ArrayList;
import java.util.HashMap;

public class Manager {
    ArrayList<Subscribed> SubscriberList=new ArrayList<>();

    public void subscribe(String name,StockData stock){
        int flag=0;
        for(Subscribed e:SubscriberList){
            if(e.subscriber.name.equalsIgnoreCase(name)){
                if(!(e.stock.equalsIgnoreCase(stock.name))) {
                    Subscribed temp = new Subscribed(e.subscriber, stock.name);
                    SubscriberList.add(temp);
                    e.subscriber.sub(stock);
                    flag = 1;
                    break;
                }

            }
        }

    if(flag==0){
        Subscriber newSub=new Subscriber(name);
        Subscribed temp=new Subscribed(newSub,stock.name);
        SubscriberList.add(temp);
        newSub.sub(stock);
    }

    }
    public void unsubscribe(String name,StockData stock) {
        Subscribed temp=new Subscribed();
        for(Subscribed e:SubscriberList){
            if(e.subscriber.name.equalsIgnoreCase(name) && e.stock.equalsIgnoreCase(stock.name)){
                e.subscriber.unsub(stock);
                temp=e;
                break;

            }
        }
        SubscriberList.remove(temp);

    }
    public ArrayList<Subscriber> Notify(String event,StockData stock){
        ArrayList<Subscriber> SubscriberFound=new ArrayList<>();
        for(Subscribed e:SubscriberList){
            if(e.stock.equalsIgnoreCase(stock.name)){
                SubscriberFound.add(e.subscriber);
            }
        }
            return SubscriberFound;
    }
    public ArrayList<StockData> View(String name){
        ArrayList<StockData> fileData=new ArrayList<>();
        for(Subscribed e: SubscriberList){
           if(e.subscriber.name.equalsIgnoreCase(name)) {
               fileData=e.subscriber.View();
               break;
           }
        }
      return fileData;
    }
}
