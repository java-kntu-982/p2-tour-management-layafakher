package main.java.ir.ac.kntu;

import java.util.ArrayList;

public class RegionForeignTour extends ForeignTour{

    private int number;

    public RegionForeignTour(String id, long price, Date startDate, int period, Place home, Place destination, ArrayList<Place> visitedCities, int minimPeople, int maximumPeople,int number) {
        super(id, price, startDate, period, home, destination, visitedCities, minimPeople, maximumPeople);
        this.number=number;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
