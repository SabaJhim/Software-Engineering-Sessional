public class Spaceship {
    private String current="";


    //getter setter
    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }


    public void login(Crewmate crew){
        setCurrent(crew.getName());
        crew.login();

    }
    public void work(Crewmate crew){
        crew.work();
    }
    public void repair(Crewmate crew){
        crew.repair();
    }
    public void logout(Crewmate crew){
        crew.logout();
        setCurrent("");
    }

}
