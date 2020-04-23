package main.java.ir.ac.kntu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ForeignTour {
    private String id;
    private long price;
    private Date startDate=new Date();
    private int period;
    private Place home=new Place();
    private Place destination=new Place();
    private ArrayList<Place> visitedCities=new ArrayList<>();
    private String country;
    private int minimPeople;
    private int maximumPeople;
    private ArrayList<RegionForeignTour> regionForeignTours=new ArrayList<>();
    Map<Date,Place> nowLocation=new HashMap<>();

    public Map<Date, Place> getNowLocation() {
        return nowLocation;
    }

    public void setNowLocation(Map<Date, Place> nowLocation) {
        this.nowLocation = nowLocation;
    }

    public ForeignTour(String id, long price, Date startDate, int period, Place home, Place destination, ArrayList<Place> visitedCities, int minimPeople, int maximumPeople, ArrayList<RegionForeignTour> regionForeignTours) {
        this.id = id;
        this.price = price;
        this.startDate = startDate;
        this.period = period;
        this.home = home;
        this.destination = destination;
        this.visitedCities = visitedCities;
        this.minimPeople = minimPeople;
        this.maximumPeople = maximumPeople;
        this.regionForeignTours = regionForeignTours;
    }

    public ForeignTour(String id, long price, Date startDate, int period, Place home, Place destination, ArrayList<Place> visitedCities, int minimPeople, int maximumPeople) {
        this.id = id;
        this.price = price;
        this.startDate = startDate;
        this.period = period;
        this.home = home;
        this.destination = destination;
        this.visitedCities = visitedCities;

        this.minimPeople = minimPeople;
        this.maximumPeople = maximumPeople;
    }

    public ArrayList<RegionForeignTour> getRegionForeignTours() {
        return regionForeignTours;
    }

    public void setRegionForeignTours(ArrayList<RegionForeignTour> regionForeignTours) {
        this.regionForeignTours = regionForeignTours;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public Place getHome() {
        return home;
    }

    public void setHome(Place home) {
        this.home = home;
    }

    public Place getDestination() {
        return destination;
    }

    public void setDestination(Place destination) {
        this.destination = destination;
    }

    public ArrayList<Place> getVisitedCities() {
        return visitedCities;
    }

    public void setVisitedCities(ArrayList<Place> visitedCities) {
        this.visitedCities = visitedCities;
    }

    public String getCountry() {
        return destination.getCountryName();
    }

    public void setCountry(String country) {
        this.country = destination.getCountryName();
    }

    public int getMinimPeople() {
        return minimPeople;
    }

    public void setMinimPeople(int minimPeople) {
        this.minimPeople = minimPeople;
    }

    public int getMaximumPeople() {
        return maximumPeople;
    }

    public void setMaximumPeople(int maximumPeople) {
        this.maximumPeople = maximumPeople;
    }


    @Override
    public String toString() {
        return "ForeignTour{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", startDate=" + startDate +
                ", period=" + period +
                ", home=" + home +
                ", destination=" + destination +
                ", visitedCities=" + visitedCities +
                ", country='" + country + '\'' +
                ", minimPeople=" + minimPeople +
                ", maximumPeople=" + maximumPeople +
                ", regionForeignTours=" + regionForeignTours +
                ", nowLocation=" + nowLocation +
                '}';
    }
}
