import java.util.Date;

public interface CommonInterface {

    //getter-setter methods
    String getName();
    String getType();
    int getSize();
     Date getCreation_time();
     String getDirectory();
     int getComponent_count();

    void setSize();
    void setComponent_count();



    CommonInterface ChangeDirectory(String name);
    void Details(String name);
    void DetailsPrint();
    void List();
    void DeleteAll();
    void Delete(String name);
    void RecursiveDelete(String name);
    void addComponent(CommonInterface c);

}
