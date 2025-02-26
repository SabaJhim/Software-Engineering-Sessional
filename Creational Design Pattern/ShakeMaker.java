public class ShakeMaker {
    private Builder ShakeBuilder;

    public void MakeShake(Builder Shake){
        ShakeBuilder=Shake;
        ShakeBuilder.addMilk();
        ShakeBuilder.addSweetener();
        ShakeBuilder.addflavoring();
        ShakeBuilder.setPrice();
        ShakeBuilder.setName();
    }

}
