package parrot;

public class Norwegian extends Parrot{
    public Norwegian(boolean isNailed, double voltage ) {
        super(ParrotTypeEnum.NORWEGIAN_BLUE, voltage, 0, isNailed);
        this.isNailed = isNailed;
        this.voltage = voltage;
    } 

    @Override
    public String getHome(){
        return (isNailed) ? "I en bur" : "Ingenstans";
    }

    @Override
    public double getSpeed(){
        return (isNailed) ? 0 : super.getBaseSpeed(voltage);
    }
}
