package main.java.ir.ac.kntu;

import main.java.ir.ac.kntu.maputil.MapUtil;

import java.util.ArrayList;

public class InlandTour {
    private String id;
    //private int number;
    private long price;
    private ArrayList<RegionInlandTour> regionInlandTours=new ArrayList<>();
    private int period;
    private Date startDate=new Date();
    private Place home=new Place();
    private Place destination=new Place();
    private String region;
    private int minimPeople;
    private int maximumPeople;
   private ArrayList<String> visitedPlaces=new ArrayList<>();

    public InlandTour(String id, long price, ArrayList<RegionInlandTour> regionInlandTours, int period, Date startDate, Place home, Place destination, String region, int minimPeople, int maximumPeople, ArrayList<String> visitedPlaces) {
        this.id = id;
        this.price = price;
        this.regionInlandTours = regionInlandTours;
        this.period = period;
        this.startDate = startDate;
        this.home = home;
        this.destination = destination;
        this.region = region;
        this.minimPeople = minimPeople;
        this.maximumPeople = maximumPeople;
        this.visitedPlaces = visitedPlaces;
    }

    public InlandTour(String id, long price, int period, Date startDate, Place home, Place destination, int minimPeople, int maximumPeople, ArrayList<String> visitedPlaces) {
        this.id = id;
        this.price = price;
        this.period = period;
        this.startDate = startDate;
        this.home = home;
        this.destination = destination;
        this.minimPeople = minimPeople;
        this.maximumPeople = maximumPeople;
        this.visitedPlaces = visitedPlaces;
    }
    public InlandTour(String id, long price, int period, Date startDate, Place home, Place destination, int minimPeople, int maximumPeople) {
        this.id = id;
        this.price = price;
        this.period = period;
        this.startDate = startDate;
        this.home = home;
        this.destination = destination;
        this.minimPeople = minimPeople;
        this.maximumPeople = maximumPeople;
    }

    public InlandTour(String id, long price, ArrayList<RegionInlandTour> regionInlandTours, int period, Date date, Place home, Place city, int minim, int max, ArrayList<String> visited) {
    }

    public ArrayList<String> getVisitedPlaces() {
        return visitedPlaces;
    }

    public void setVisitedPlaces(ArrayList<String> visitedPlaces) {
        this.visitedPlaces = visitedPlaces;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getRegion() {
        return destination.getCityName();
    }

    public void setRegion(String region) {
        this.region = destination.getCityName();
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



    public ArrayList<RegionInlandTour> getRegionInlandTours() {
        return regionInlandTours;
    }

    public void setRegionInlandTours(ArrayList<RegionInlandTour> regionInlandTours) {
        this.regionInlandTours = regionInlandTours;
    }

    @Override
    public String toString() {
        return "InlandTour{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", regionInlandTours=" + regionInlandTours +
                ", period=" + period +
                ", startDate=" + startDate +
                ", home=" + home +
                ", destination=" + destination +
                ", region='" + region + '\'' +
                ", minimPeople=" + minimPeople +
                ", maximumPeople=" + maximumPeople +
                ", visitedPlaces=" + visitedPlaces +
                '}';
    }
}
