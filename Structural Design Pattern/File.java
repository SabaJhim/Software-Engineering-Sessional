import java.util.ArrayList;
import java.util.Date;

public class File extends Base{

    //Constructor
    File(String name,int size){
        this.name=name;
        this.size=size;
        this.type="File";
        this.directory="";
        this.component_count=0;
        this.creation_time=new Date();

    }
    //setter
    void setDirectory(String directory){
        this.directory=directory+this.name+'\\';

    }
   public void setSize(){

    }
    public void addComponent(CommonInterface c){

    }
    public void setComponent_count() {
        this.component_count = 0;
    }

    public CommonInterface ChangeDirectory(String name){
        System.out.println("Error! This is a file name.");
        return null;
    }

    public void Details(String name){
        if(this.name.equals(name)){
            this.DetailsPrint();
        }
    }

    public void List(){
        System.out.println("Error! This is a file");
    }

    public void Delete(String name){

    }
    public void RecursiveDelete(String name){

    }
    public void DeleteAll(){

    }


}
