package parrot;

public class African extends Parrot {
    public African(int numberOfCoconuts, double voltage) {
        super(ParrotTypeEnum.AFRICAN, voltage, numberOfCoconuts,false);
        this.numberOfCoconuts = numberOfCoconuts;
    }

    @Override
    public String getHome(){
        return "Hål i träd";
    }

    @Override
    public double getSpeed(){
        return Math.max(0, super.getBaseSpeed() - super.getLoadFactor() * numberOfCoconuts);
    }
    
}
