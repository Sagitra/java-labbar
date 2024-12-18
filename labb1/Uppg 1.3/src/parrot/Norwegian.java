package parrot;

public record Norwegian(boolean isNailed, double voltage) implements Parrot {
    public String getHome(){
        return (isNailed) ? "I en bur" : "Ingenstans";
    }

    public double getSpeed(){
        return (isNailed) ? 0 : getBaseSpeed(voltage);
    }

    private double getBaseSpeed(double voltage){
        return Math.min(24.0, voltage*getBaseSpeed());
    }

    private double getBaseSpeed(){
        return 12.0;
    }
}