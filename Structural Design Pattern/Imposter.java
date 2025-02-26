public class Imposter {

    private String name;

    //getter setter


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void login(){

        System.out.println("We won't tell anyone; you are an imposter");
    }
    public void repair(){

        System.out.println("Damaging the spaceship.");
    }

    public void work(){

        System.out.println("Trying to kill a crewmate");
        System.out.println("Successfully killed a crewmate");
    }
    public void logout(){

        System.out.println("See you again Comrade imposter");
    }
}
