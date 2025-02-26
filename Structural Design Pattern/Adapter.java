public class Adapter extends Crewmate{
    private Imposter imposter;

    public Adapter(Imposter imposter){
        this.imposter=imposter;
    }
    public void login(){
        System.out.println("Welcome Crewmate");
        imposter.login();
    }
    public void work(){
        System.out.println("Doing Research");
        imposter.work();
    }
    public void repair(){
        System.out.println("Repairing Spaceship");
        imposter.repair();
    }
    public void logout(){
        System.out.println("Bye Bye Crewmate");
        imposter.logout();
    }


}
