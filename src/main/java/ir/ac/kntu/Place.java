package main.java.ir.ac.kntu;

import java.util.Objects;

public class Place {
    private String cityName;
    private String countryName;

    public Place(String cityName, String countryName) {
        this.cityName = cityName;
        this.countryName = countryName;
    }

    public Place(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return Objects.equals(cityName, place.cityName) &&
                Objects.equals(countryName, place.countryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityName, countryName);
    }

    public Place() {
    }
}
