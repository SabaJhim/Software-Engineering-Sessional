public class StockData {
    String name;
    int count;
    float price;

    StockData(){
        this.name=" ";
        this.price=0;
        this.count=0;
    }

    StockData(String name,int count,float price){
        this.name=name;
        this.count=count;
        this.price=price;

    }
}
