package nl.saxion.oop.exam.exercise2.model;

public class Bathroom extends Room {

    private final boolean hasToilet;
    private final boolean hasShower;

    public Bathroom(int surface, boolean hasToilet, boolean hasShower) {
        super(surface);
        this.hasToilet = hasToilet;
        this.hasShower = hasShower;
    }

    @Override
    protected int getPricePerM2() {
        return 900;
    }

    @Override
    public int getPrice() {
        int price = surface * getPricePerM2();
        if(hasToilet) {
            price += 1000;
        }
        if(hasShower) {
            price += 2000;
        }
        return price;
    }

    @Override
    protected String getRoomInfoAsString() {
        return "Bathroom (toilet: " + hasToilet + ", shower: " + hasShower + ")";
    }
}
