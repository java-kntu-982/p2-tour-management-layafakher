package main.java.ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class Employee extends Person{
    private Date employmentDate;
    private int baseSalary;

    public Employee(String userName, String password, Date employmentDate, int baseSalary) {
        super(userName, password);
        this.employmentDate = employmentDate;
        this.baseSalary = baseSalary;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void getAccess(ArrayList<InlandTour> inlandTours, ArrayList<ForeignTour> foreignTours){
        System.out.println("1-See regions menu,2-See region tour menu,3-Edit your information,4-Add & delete client: ");
        Scanner scanner=new Scanner(System.in);
        int answer=scanner.nextInt();
        switch (answer){
            case 1:
                Regions.region(inlandTours,foreignTours);
                break;
            case 2:
                TourMenu.printAllKindOfATour(inlandTours,foreignTours);
                break;
            case 3:
                editInformation();
                break;
            case 4:
                System.out.println("1-Add a client,2-delete a client:");
                int answer1=scanner.nextInt();
                if (answer1==1){
                    System.out.println("Enter client user name");
                    String userName=scanner.next();
                    System.out.println("Enter client password");
                    String password=scanner.next();
                    Client client=new Client(userName,password);
                    Main.clients.add(client);
                }else if (answer1==2){
                    System.out.println("Enter client user name");
                    String userName=scanner.next();
                    System.out.println("Enter client password");
                    String password=scanner.next();
                    Client client=new Client(userName,password);
                    Main.clients.remove(client);
                }
                break;
        }
    }
    public void editInformation(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter your password:");
        String oldPass=scanner.next();
        if (oldPass.equals(this.password)){
            System.out.println("1-Edit user name,2-Edit password,3-Edit employment date,4-Edit base salary,5-Edit email address,6-Edit phone number: ");
            int result=scanner.nextInt();
            switch (result){
                case 1:
                    System.out.println("Enter new user name:");
                    this.userName= scanner.next();
                    break;
                case 2:
                    System.out.println("Enter your password:");
                    String oldPass1=scanner.next();
                    if (oldPass1.equals(this.password)){
                        this.password=oldPass1;
                    }else {
                        System.out.println("Wrong password!");
                    }
                    break;
                case 3:
                    System.out.println("Enter new date(year,month,day):");
                    int year=scanner.nextInt();
                    int month=scanner.nextInt();
                    int day=scanner.nextInt();
                    this.employmentDate= new Date(year,month,day);
                    break;
                case 4:
                    System.out.println("Enter new salary:");
                    this.baseSalary= scanner.nextInt();
                    break;
                case 5:
                    System.out.println("Enter new email address:");
                    this.email= scanner.next();
                    break;
                case 6:
                    System.out.println("Enter new phone number:");
                    this.phone= scanner.next();
                    break;
            }
        }else {
            System.out.println("Wrong password!");
        }
    }
}
