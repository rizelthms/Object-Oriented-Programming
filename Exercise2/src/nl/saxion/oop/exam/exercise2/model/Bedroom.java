package nl.saxion.oop.exam.exercise2.model;

public class Bedroom extends Room {

    private final boolean fitsDoubleBed;

    public Bedroom(int surface, boolean fitsDoubleBed) {
        super(surface);
        this.fitsDoubleBed = fitsDoubleBed;
    }

    @Override
    protected int getPricePerM2() {
        return fitsDoubleBed ? 975 : 800;
    }

    @Override
    protected String getRoomInfoAsString() {
        return "Bedroom (double bed: " + fitsDoubleBed + ")";
    }
}
