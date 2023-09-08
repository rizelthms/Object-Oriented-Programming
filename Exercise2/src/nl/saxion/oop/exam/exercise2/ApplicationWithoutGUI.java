package nl.saxion.oop.exam.exercise2;

import nl.saxion.oop.exam.exercise2.model.RealEstateManagement;

import java.util.Scanner;

public class ApplicationWithoutGUI {

    public static void main(String[] args) {
        RealEstateManagement administration = new RealEstateManagement("Exercise2/houses.csv");

        Scanner s = new Scanner(System.in);
        System.out.println("How many bathrooms do you need?");
        int numBathrooms = s.nextInt();
        System.out.println("How many bedrooms do you need?");
        int numBedrooms = s.nextInt();
        System.out.println("Find houses with at least " + numBathrooms + " bathrooms and at least of " + numBedrooms + "bedrooms:");

        administration.findHouses(numBathrooms, numBedrooms);
    }
}
