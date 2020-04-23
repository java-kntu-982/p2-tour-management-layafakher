package main.java.ir.ac.kntu;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class TourLeader extends Person{
    private String firstName;
    private String lastName;
    private String nationalCode;
    private long idNumber;
    private Integer age;
    private Date birthday;
    private Date employmentDate;
    private boolean isMarried;
    private ArrayList<Place> knownPlaces=new ArrayList<>();

    public TourLeader(String userName, String password) {
        super(userName, password);
    }

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
    @Override
    public void getAccess(ArrayList<InlandTour> inlandTours, ArrayList<ForeignTour> foreignTours,ArrayList<TourLeader> tourLeaders){
        System.out.println("1-See tour menu,2-See tour leader menu,3-See regions menu,4-See map,5-Edit information,6-Add a client to list:");
        Scanner scanner=new Scanner(System.in);
        int answer=scanner.nextInt();
        switch (answer){
            case 1:
                System.out.println("If you want to see all of The foreign and inland tours press 1:  ");
                System.out.println("If you want to see all kind of a tour press 2:  ");
                System.out.println("If you want to search for a tour press 3:  ");
                System.out.println("If you want to search for a region tour press 4:  ");
                int result=scanner.nextInt();
                if (result==1){
                    TourMenu.printTours(inlandTours,foreignTours);
                }else if (result==2){
                    TourMenu.printAllKindOfATour(inlandTours,foreignTours);
                }else if (result==3){
                    TourMenu.tourSearch(inlandTours,foreignTours);
                }else if (result==4){
                    TourMenu.regionTourSearch(inlandTours,foreignTours,tourLeaders);
                }
                break;
            case 2:
                TourLeaderMenu.printTourLeaders(tourLeaders);
                break;
            case 3:
                Regions.region(inlandTours,foreignTours);
                break;
            case 4:
                Maps.map(inlandTours,foreignTours);
                break;
            case 5:
                System.out.println("1-Edit basic information,2-Edit total information:");
                int answer2=scanner.nextInt();
                if (answer2==1){
                    editInformation();
                }else if (answer2==2){
                    TourLeaderMenu.editTourLeader(tourLeaders);
                }
                break;
            case 6:
                System.out.println("Enter client user name");
                String userName=scanner.nextLine();
                System.out.println("Enter client password");
                String password=scanner.nextLine();
                Client client=new Client(userName,password);
                Main.clients.add(client);
                break;
        }
    }
    public void editInformation(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("First enter your password:");
        String oldPass=scanner.nextLine();
        if (oldPass.equals(this.password)){
            System.out.println("1-Edit user name,2-Edit password,3-Edit email address,4-Edit phone number: ");
            int result=scanner.nextInt();
            switch (result){
                case 1:
                    System.out.println("Enter new user name:");
                    String userName=scanner.nextLine();
                    this.userName=userName;
                    break;
                case 2:
                    System.out.println("First enter your password:");
                    String oldPass1=scanner.nextLine();
                    if (oldPass1.equals(this.password)){
                        this.password=oldPass1;
                    }else {
                        System.out.println("Wrong password!");
                    }
                    break;
                case 3:
                    System.out.println("Enter new email address:");
                    String email=scanner.nextLine();
                    this.email=email;
                    break;
                case 4:
                    System.out.println("Enter new phone number:");
                    String phone=scanner.nextLine();
                    this.phone=phone;
                    break;
            }
        }else {
            System.out.println("Wrong password!");
        }
    }
}
