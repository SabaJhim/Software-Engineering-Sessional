import java.util.Date;
public abstract class Base implements CommonInterface {
    protected String name;
    protected int size;
    protected String type;
    protected String directory;
    protected int component_count;
    protected Date creation_time;

    //getter-setter


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }
    public int getSize(){
        return this.size;
    }

    public Date getCreation_time() {
        return creation_time;
    }

    public int getComponent_count() {
        return component_count;
    }

    @Override
    public String getDirectory() {
        return directory;
    }



    public void DetailsPrint(){
        System.out.println("Name: "+this.name);
        System.out.println("Type: "+this.type);
        System.out.println("Size: "+this.size);
        System.out.println("Directory: "+this.directory);
        System.out.println("Component Count: "+this.component_count);
        System.out.println("Creation time: "+this.creation_time);
    }



}

