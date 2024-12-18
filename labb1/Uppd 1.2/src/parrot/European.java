package parrot;

public class European extends Parrot {
    public European(double voltage) {
        super(ParrotTypeEnum.EUROPEAN, voltage, 0, false);
    }
    
    @Override
    public String getHome(){
        return "Bo byggt av pinnar";
    }

    @Override
    public double getSpeed(){
        return super.getBaseSpeed();
    }
}
