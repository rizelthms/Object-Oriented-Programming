package nl.saxion.oop.exam.exercise2.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class RealEstateManagement {

    private ArrayList<House> houses = new ArrayList<>();

    public RealEstateManagement(String fileName) {

        House currentHouse = null;

        int lineNo = 0;
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                ++lineNo;
                String[] fields = scanner.nextLine().split(",");
                switch (fields[0]) {
                    case "HOUSE": {
                        String address = fields[1];
                        String zipCode = fields[2];
                        String city = fields[3];
                        int basePrice = Integer.parseInt(fields[4]);

                        if(currentHouse != null) {
                            houses.add(currentHouse);
                        }
                        currentHouse = new House(address, zipCode, city, basePrice);

                        break;
                    }
                    case "LIVINGROOM": {
                        int sizeM2 = Integer.parseInt(fields[1]);
                        int numberOfWindows = Integer.parseInt(fields[2]);

                        currentHouse.addRoom(new LivingRoom(sizeM2, numberOfWindows));

                        break;
                    }
                    case "BEDROOM": {
                        int sizeM2 = Integer.parseInt(fields[1]);
                        boolean fitsDoubleBed = Boolean.parseBoolean(fields[2]);

                        currentHouse.addRoom(new Bedroom(sizeM2, fitsDoubleBed));

                        break;
                    }
                    case "BATHROOM": {
                        int sizeM2 = Integer.parseInt(fields[1]);
                        boolean hasToilet = Boolean.parseBoolean(fields[2]);
                        boolean hasShower = Boolean.parseBoolean(fields[3]);

                        currentHouse.addRoom(new Bathroom(sizeM2, hasToilet, hasShower));

                        break;
                    }
                }
            }
            houses.add(currentHouse);
        } catch (Exception e) {
            System.err.println("CSV read error in line " + lineNo + ": " + e.getMessage());
            System.exit(-1);
        }
    }

    public void findHouses(int numBathrooms, int numBedrooms) {
        for(House h : houses) {
            if(h.getBathrooms() >= numBathrooms && h.getBedrooms() >= numBedrooms) {
                System.out.println(h);
                System.out.println();
            }
        }
    }

}
