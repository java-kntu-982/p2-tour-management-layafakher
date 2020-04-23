package main.java.ir.ac.kntu;

import java.util.ArrayList;

public class RegionInlandTour extends InlandTour{
    private int number;

    public RegionInlandTour(String id, long price, int period, Date startDate, Place home, Place destination, int minimPeople, int maximumPeople, ArrayList<String> visitedPlaces,int number) {
        super(id, price, period, startDate, home, destination, minimPeople, maximumPeople, visitedPlaces);
        this.number=number;
    }



    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
