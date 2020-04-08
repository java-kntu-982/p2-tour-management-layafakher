package main.java.ir.ac.kntu;

import java.util.ArrayList;
import java.util.Objects;

public class TourLeader {
    private String firstName;
    private String lastName;
    private String nationalCode;
    private long idNumber;
    private Integer age;
    private Date birthday;
    private Date employmentDate;
    private boolean isMarried;
    private ArrayList<Place> knownPlaces=new ArrayList<>();

    public TourLeader() {
    }
    public TourLeader(String firstName, String lastName, String nationalCode, long idNumber, Integer age, Date birthday, Date employmentDate, boolean isMarried, ArrayList<Place> knownPlaces) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.idNumber = idNumber;
        this.age = age;
        this.birthday = birthday;
        this.employmentDate = employmentDate;
        this.isMarried = isMarried;
        this.knownPlaces = knownPlaces;
    }

    public TourLeader(String firstName, String lastName, String nationalCode, long idNumber, Integer age, Date birthday, Date employmentDate, boolean isMarried) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.idNumber = idNumber;
        this.age = age;
        this.birthday = birthday;
        this.employmentDate = employmentDate;
        this.isMarried = isMarried;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    public ArrayList<Place> getKnownPlaces() {
        return knownPlaces;
    }

    public void setKnownPlaces(ArrayList<Place> knownPlaces) {
        this.knownPlaces = knownPlaces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourLeader that = (TourLeader) o;
        return idNumber == that.idNumber &&
                isMarried == that.isMarried &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(nationalCode, that.nationalCode) &&
                Objects.equals(age, that.age) &&
                Objects.equals(birthday, that.birthday) &&
                Objects.equals(employmentDate, that.employmentDate) &&
                Objects.equals(knownPlaces, that.knownPlaces);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, nationalCode, idNumber, age, birthday, employmentDate, isMarried, knownPlaces);
    }
















}
