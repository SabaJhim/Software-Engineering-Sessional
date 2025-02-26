import java.util.ArrayList;
import java.util.Date;

public class Folder extends Base{

    protected ArrayList<CommonInterface> Components=new ArrayList<CommonInterface>();

    Folder(String name){
        this.name=name;
        setSize();
        this.type="Folder";
        this.directory="";
        this.component_count=Components.size();
        this.creation_time=new Date();
    }

    public void setSize(){
        this.size=0;
        for(CommonInterface component: Components){
            component.setSize();
            this.size=this.size+component.getSize();
        }
    }
    public void setDirectory(String directory){
        this.directory=directory;
    }

    public void setComponent_count() {
        this.component_count = Components.size();
    }
    public void addComponent(CommonInterface c){
        Components.add(c);
    }


    public CommonInterface ChangeDirectory(String name){
        if(this.name.equals(name)){
            return this;
        }
        else {
            for (CommonInterface components : Components) {
                if (components.getName().equals(name)) {
                    return components;
                }
            }
            return null;
        }
    }

    public void Details(String name){
        if(this.name.equals(name)){
            this.DetailsPrint();
        }
        for(CommonInterface components: Components){
            components.Details(name);
        }
    }

    public void List(){
        for(CommonInterface component: Components){
            System.out.println(component.getName()+"  "+component.getSize()+"  "+component.getCreation_time());
        }
    }


    public void Delete(String name){
        for(CommonInterface c:Components){
            if(c.getName().equals(name)){
                if(c.getComponent_count()==0){
                    System.out.println(c.getName()+" is deleted");
                    Components.remove(c);
                    return;

                }
                else{
                    System.out.println("Error!There are files in this directory");
                    return;
                }
            }

        }
        System.out.println("Error! No such file or directory");

    }
    public void DeleteAll(){
        for(CommonInterface c: Components){
            if(c.getType().equals("File")){
                Components.remove(c);
                System.out.println("Warning! "+c.getName()+" is deleted permanently");
            }
            else if(c.getComponent_count()==0){
                System.out.println("Warning! "+c.getName()+" is deleted permanently");
                Components.remove(c);
            }
            else{
                c.DeleteAll();
            }
        }
    }
    public void RecursiveDelete(String name){
        for(CommonInterface c:Components){
            if(c.getName().equals(name)){
                c.DeleteAll();
                System.out.println(c.getName()+" is deleted");
                Components.remove(c);
                return;
            }
        }
        System.out.println("Error! No such file or directory");

    }


}
