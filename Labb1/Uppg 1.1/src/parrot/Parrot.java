package parrot;


public class Parrot {

    private ParrotTypeEnum type;
    private int numberOfCoconuts;
    private double voltage;
    private boolean isNailed;


    public Parrot(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
        this.type = type;
        this.numberOfCoconuts = numberOfCoconuts;
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    public double getSpeed() {
        return switch (type) {
            case EUROPEAN -> getBaseSpeed();
            case AFRICAN -> Math.max(0, getBaseSpeed() - getLoadFactor() * numberOfCoconuts);
            case NORWEGIAN_BLUE -> (isNailed) ? 0 : getBaseSpeed(voltage);
            default -> throw new RuntimeException("Should be unreachable");
        };
    }

    private double getBaseSpeed(double voltage) {
        return Math.min(24.0, voltage * getBaseSpeed());
    }

    private double getLoadFactor() {
        return 9.0;
    }

    private double getBaseSpeed() {
        return 12.0;
    }

    public String getHome(){
        return switch(type){
            case EUROPEAN -> "Bo byggt av pinnar";
            case AFRICAN -> "Hål i träd";
            case NORWEGIAN_BLUE -> (isNailed) ? "I en bur" : "Ingenstans";
            default -> throw new RuntimeException("Should be unreachable");
        };
    }

}
