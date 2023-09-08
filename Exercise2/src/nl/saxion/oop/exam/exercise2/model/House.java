package nl.saxion.oop.exam.exercise2.model;

import java.util.ArrayList;
import java.util.Collections;

public class House {

    private final String address;
    private final String zipcode;
    private final String city;
    private final int basePrice;

    private final ArrayList<Room> rooms = new ArrayList<>();

    public House(String address, String zipcode, String city, int basePrice) {
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.basePrice = basePrice;
    }

    public String getAddress() {
        return address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public int getBedrooms() {
        int num = 0;
        for(Room r : rooms) {
            if(r instanceof Bedroom) {
                num++;
            }
        }
        return num;
    }

    public int getBathrooms() {
        int num = 0;
        for(Room r : rooms) {
            if(r instanceof Bathroom) {
                num++;
            }
        }
        return num;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    private int getTotalPrice() {
        int total = basePrice;
        for(Room r : rooms) {
            total += r.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        Collections.sort(rooms);
        String str = "House at " + address + ", " + zipcode + " " + city + " and total price: €" + getTotalPrice() + ".00 has rooms:\n";
        for(Room r : rooms) {
            str += "- " + r.toString() + "\n";
        }
        return str;
    }
}
