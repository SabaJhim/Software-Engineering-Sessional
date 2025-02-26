import java.util.ArrayList;

public class Subscriber {
    String name;
    ArrayList<StockData> MyStock=new ArrayList<>();

    Subscriber(String name){
        this.name=name;
    }

    void sub(StockData stock){
        MyStock.add(stock);
    }
     void unsub(StockData stock){
        StockData temp=new StockData();
        for(StockData e:MyStock){
            if(e.name.equalsIgnoreCase(stock.name)){
                temp=e;

            }
        }
            MyStock.remove(temp);

    }
    ArrayList<StockData> View(){
        return MyStock;
    }


}
