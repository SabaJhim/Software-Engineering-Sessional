import java.util.ArrayList;


public class Computer {
    public ArrayList<Drive> drives=new ArrayList<Drive>();
    public CommonInterface current;



    public void ChangeDirectory(String name){

        if(current==null){
            for(Drive drive:drives){
                if(drive.getName().equals(name)){
                    current=drive;
                    System.out.println("Changed the directory to " + current.getName());
                }
            }
            if(current==null){
                System.out.println("Such directory does not exist");
            }
        }
        else {
            CommonInterface c = current.ChangeDirectory(name);
            if (c == null) {
                System.out.println("Error! Such directory does not exist");
            }
            else {
                current = c;
                c.ChangeDirectory(name);
                System.out.println("Changed the directory to " + current.getName());
            }
        }


    }

    public void Details(String name){
        for(Drive drive: drives){
            drive.Details(name);
        }

    }

    public void List(){
        if(current==null){
            System.out.println("Please Enter into a directory first");
        }
        else {
            current.List();
        }

    }

    public void Delete(String name){
        if(current==null){
            for(Drive drive:drives){
                if(drive.getName().equals(name)){
                    if(drive.getComponent_count()==0){

                        System.out.println(drive.getName()+" deleted successfully.");
                        drives.remove(drive);
                        return;
                    }
                    else{
                        System.out.println("Error!Can not delete. There are folders in this directory.");
                        return;
                    }
                }
            }
            System.out.println("Error!No such file or directory");
        }
        else{
           current.Delete(name);

        }

    }

    public void RecursiveDelete(String name){

        if(current==null){
            for(Drive drive:drives){
                if(drive.getName().equals(name)){
                        drive.DeleteAll();
                        System.out.println(drive.getName()+" deleted successfully.");
                        drives.remove(drive);
                        return;
                }
            }

        }
        else{
            current.RecursiveDelete(name);

        }
    }
    public void Jump(){
        current=null;
        System.out.println("Jumped to root");

    }
    public void MakeDir(String name){
        if(current==null){
            System.out.println("Please Enter into a drive first");
        }
        else  {

            Folder folder = new Folder(name);
            folder.setDirectory(current.getDirectory());

            current.addComponent(folder);
            current.setSize();
            current.setComponent_count();

            System.out.println("A new folder "+folder.getName()+" Created.");
        }


    }
    public void Touch(String name,int size){
        if(current.getType().equalsIgnoreCase("Drive")||current.getType().equalsIgnoreCase("Folder")) {
            File file = new File(name, size);
            file.setDirectory(current.getDirectory());

            current.addComponent(file);
            current.setSize();
            current.setComponent_count();

            System.out.println("A new file "+file.getName()+" Created");

        }
        else{
            System.out.println("Error!Please Create a drive or folder first");
        }
    }

    public void MakeDrive(String name){
        Drive dr=new Drive(name);
        drives.add(dr);
        System.out.println("New drive "+dr.getName()+" created.");

    }
}
