package parrot;

public class Parrot {
    protected ParrotTypeEnum type;
    protected double voltage;
    protected int numberOfCoconuts;
    protected boolean isNailed;

    public Parrot(ParrotTypeEnum type, double voltage, int numberOfCoconuts, boolean isNailed) {
        this.type = type;
        this.voltage = voltage;
        this.numberOfCoconuts = numberOfCoconuts;
        this.isNailed = isNailed;
    }

    public double getSpeed(){
        return 0;
    }

    public String getHome(){
        return "";
    }

    protected double getBaseSpeed(double voltage) {
        return Math.min(24.0, voltage * getBaseSpeed());
    }

    protected double getLoadFactor() {
        return 9.0;
    }

    protected double getBaseSpeed() {
        return 12.0;
    }


}
