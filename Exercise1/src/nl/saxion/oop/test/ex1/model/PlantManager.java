package nl.saxion.oop.test.ex1.model;

import java.util.ArrayList;

/**
 * Class for keeping track of all plants in a house.
 */
public class PlantManager {

    private ArrayList<Plant> plants = new ArrayList<>();

    /**
     * Add a plant to the system.
     *
     * This method should throw a custom exception when: type is empty, location is empty or when the interval is < 1.
     *
     * @param type Name of the plants type.
     * @param interval After how many days does the plant need to be watered? (e.g. interval=5 means, every 5 days).
     * @return The unique id of the plant.
     */
    public int addPlant(String type, int interval) throws PlantArgumentException{
        if(type.isBlank()) {
            throw new PlantArgumentException("The type cannot be empty");
        }
        if(interval <= 0) {
            throw new PlantArgumentException("The interval must be at least 1");
        }
        Plant p = new Plant(type, interval);
        plants.add(p);
        return p.getId();
    }

    /**
     * Give an overview of all plants in the system. Clearly indicate which plants need water today!
     * @return All plants in String format.
     */
    public String toString() {
        String str = "All plants in the system:\n";
        for(Plant p : plants) {
            int waterDays = p.getDaysUntilWaterNeeded();
            String waterString = waterDays >= 1 ? "in " + waterDays + " days." : "TODAY!";
            str += "\tPlant " + p.getType() + " (id: " + p.getId() + ") needs water " + waterString + "\n";
        }
        return str;
    }

    /**
     * Try to water a plant. If the plant was not found or the plant does not need water today, throw an exception.
     * @param id Unique id of the plant we want to water.
     */
    public void waterPlant(int id) throws PlantArgumentException{
        for(Plant p : plants) {
            if(p.getId() == id) {
                if(p.getDaysUntilWaterNeeded() > 0) {
                    throw new PlantArgumentException("This plant does not need watering yet");
                }
                p.waterPlant();
                return;
            }
        }
        throw new PlantArgumentException("There is no plant with this id in the system");
    }

    /**
     * Go to the next day in the system.
     * Should throw an exception when there are plants that needed water today, but haven't been watered yet.
     */
    public void increaseDay() throws PlantRuntumeException{
        for(Plant p : plants) {
            if(p.getDaysUntilWaterNeeded() <= 0) {
                throw new PlantRuntumeException("There are plants left that need watering");
            }
            p.nextDay();
        }
    }
}
