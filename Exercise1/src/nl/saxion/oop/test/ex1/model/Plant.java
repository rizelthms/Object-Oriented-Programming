package nl.saxion.oop.test.ex1.model;

public class Plant {

    private static int current_id = 1;
    private final int id;
    private final String type;
    private int possibleDaysWithoutWater;
    private int daysSinceLastWater = 0;

    public Plant(String type, int possibleDaysWithoutWater) {
        id = current_id;
        current_id++;
        this.type = type;
        this.possibleDaysWithoutWater = possibleDaysWithoutWater;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getPossibleDaysWithoutWater() {
        return possibleDaysWithoutWater;
    }

    public int getDaysSinceLastWater() {
        return daysSinceLastWater;
    }

    public void waterPlant() {
        daysSinceLastWater = 0;
    }

    public int getDaysUntilWaterNeeded() {
        return possibleDaysWithoutWater - daysSinceLastWater;
    }

    public void nextDay() {
        daysSinceLastWater++;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", possibleDaysWithoutWater=" + possibleDaysWithoutWater +
                ", daysSinceLastWater=" + daysSinceLastWater +
                '}';
    }
}
