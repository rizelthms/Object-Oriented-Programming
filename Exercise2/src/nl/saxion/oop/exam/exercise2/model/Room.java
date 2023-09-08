package nl.saxion.oop.exam.exercise2.model;

public abstract class Room implements Comparable<Room>{

    protected final int surface;

    public Room(int surface) {
        this.surface = surface;
    }

    protected abstract int getPricePerM2();

    public int getPrice() {
        return getPricePerM2() * surface;
    }

    protected abstract String getRoomInfoAsString();

    @Override
    public String toString() {
        return getRoomInfoAsString() + " --- " + surface + " m2, price: €" + getPrice() + ".00";
    }

    @Override
    public int compareTo(Room o) {
        return surface - o.surface;
    }
}
