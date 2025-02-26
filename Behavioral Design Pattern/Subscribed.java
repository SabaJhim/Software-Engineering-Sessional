public class Subscribed {
    Subscriber subscriber;
    String stock;

    Subscribed(){
        this.subscriber=new Subscriber(" ");
        this.stock=" ";
    }

    Subscribed(Subscriber s,String stock){
        this.subscriber=s;
        this.stock=stock;
    }
}
