public class Crewmate {
    private String name;

    //getter setter


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void login(){
        System.out.println("Welcome Crewmate");
    }
     void repair(){
        System.out.println("Repairing Spaceship");
    }
     void work(){
        System.out.println("Doing Research");
    }
     void logout(){
        System.out.println("Bye Bye Crewmate");
    }
}
