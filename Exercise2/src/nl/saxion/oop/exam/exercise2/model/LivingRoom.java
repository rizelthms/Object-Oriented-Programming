package nl.saxion.oop.exam.exercise2.model;

public class LivingRoom extends Room {

    private final int numWindows;

    public LivingRoom(int surface, int numWindows) {
        super(surface);
        this.numWindows = numWindows;
    }

    @Override
    protected int getPricePerM2() {
        return 1000 + numWindows * 250;
    }

    @Override
    protected String getRoomInfoAsString() {
        return "Living room (number of windows: " + numWindows + ")";
    }

}
