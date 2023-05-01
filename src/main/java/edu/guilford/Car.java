package edu.guilford;

import java.util.Random;

public class Car {

    Random rand = new Random();

    // attributes

    private String make;
    private String model;
    private int year;
    private int price;
    private int mileage;
    private double score;

    // constructors

    public Car() {
        // Choose a make from a list of 10 popular makes
        String[] makes = { "Honda", "Toyota", "Ford", "Chevrolet", "Nissan", "Hyundai", "Kia", "Dodge", "Jeep",
                "Subaru" };
        make = makes[rand.nextInt(makes.length)];
        // Choose a model from a list of 5 popular models for that make
        String[] hondaModels = { "Accord", "Civic", "CR-V", "Pilot", "Odyssey" };
        String[] toyotaModels = { "Camry", "Corolla", "RAV4", "Highlander", "Sienna" };
        String[] fordModels = { "F-150", "Escape", "Explorer", "Edge", "Fusion" };
        String[] chevroletModels = { "Silverado", "Equinox", "Malibu", "Traverse", "Cruze" };
        String[] nissanModels = { "Rogue", "Altima", "Sentra", "Pathfinder", "Versa" };
        String[] hyundaiModels = { "Elantra", "Sonata", "Santa Fe", "Tucson", "Accent" };
        String[] kiaModels = { "Soul", "Optima", "Sorento", "Sportage", "Forte" };
        String[] dodgeModels = { "Grand Caravan", "Journey", "Charger", "Durango", "Challenger" };
        String[] jeepModels = { "Grand Cherokee", "Cherokee", "Wrangler", "Compass", "Renegade" };
        String[] subaruModels = { "Outback", "Forester", "Crosstrek", "Impreza", "Legacy" };
        if (make.equals("Honda")) {
            model = hondaModels[rand.nextInt(5)];
        } else if (make.equals("Toyota")) {
            model = toyotaModels[rand.nextInt(5)];
        } else if (make.equals("Ford")) {
            model = fordModels[rand.nextInt(5)];
        } else if (make.equals("Chevrolet")) {
            model = chevroletModels[rand.nextInt(5)];
        } else if (make.equals("Nissan")) {
            model = nissanModels[rand.nextInt(5)];
        } else if (make.equals("Hyundai")) {
            model = hyundaiModels[rand.nextInt(5)];
        } else if (make.equals("Kia")) {
            model = kiaModels[rand.nextInt(5)];
        } else if (make.equals("Dodge")) {
            model = dodgeModels[rand.nextInt(5)];
        } else if (make.equals("Jeep")) {
            model = jeepModels[rand.nextInt(5)];
        } else {
            model = subaruModels[rand.nextInt(5)];
        }
        year = rand.nextInt(34) + 1990;
        price = rand.nextInt(25000) + 10000;
        mileage = rand.nextInt(200000) + 10000;
        score = this.analyze();
    }

    // methods

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    // toString method (all attributes annotated on one line)
    @Override
    public String toString() {
        return "Make: " + make + ", Model: " + model + ", Year: " + year + ", Price: " + price + ", Mileage: "
                + mileage + ", Score: " + String.format("%,.2f", score);
    }

    // Analyze method to rate each car on a score based on year, price, and mileage.
    // The higher the score, the better the car would be to buy. Lower price,
    // lower mileage, and newer year all give higher scores to the car.

    public double analyze() {
        double score = 0;
        if (year >= 2015) {
            score += .5;
        } else if (year >= 2010) {
            score += .4;
        } else if (year >= 2005) {
            score += .3;
        } else if (year >= 2000) {
            score += .2;
        } else if (year >= 1995) {
            score += .1;
        }
        if (price <= 12500) {
            score += .5;
        } else if (price <= 17500) {
            score += .4;
        } else if (price <= 22500) {
            score += .3;
        } else if (price <= 27500) {
            score += .2;
        } else if (price <= 32500) {
            score += .1;
        }
        if (mileage <= 10000) {
            score += .5;
        } else if (mileage <= 20000) {
            score += .4;
        } else if (mileage <= 30000) {
            score += .3;
        } else if (mileage <= 40000) {
            score += .2;
        } else if (mileage <= 50000) {
            score += .1;
        }
        return score * 66.6666666667;
    }

}
