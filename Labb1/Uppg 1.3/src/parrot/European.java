package parrot;
public record European() implements Parrot {
    public String getHome(){
        return "Bo byggt av pinnar";
    }

    public double getSpeed(){
        return getBaseSpeed();
    }

    private double getBaseSpeed(){
        return 12;
    }
}
