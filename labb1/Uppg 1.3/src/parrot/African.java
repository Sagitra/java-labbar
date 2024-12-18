package parrot;

public record African(int numberOfCoconuts) implements Parrot {
    public String getHome(){
        return "Hål i träd";
    }

    public double getSpeed(){
        return Math.max(0, getBaseSpeed()- getLoadFactor()*numberOfCoconuts);
    }

    private double getBaseSpeed(){
        return 12.0;
    }

    private double getLoadFactor(){
        return 9.0;
    }
}
