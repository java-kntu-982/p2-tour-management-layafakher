package main.java.ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class Client extends Person{
    public Client(String userName, String password) {
        super(userName, password);
    }
    @Override
    public void getAccess(ArrayList<InlandTour> inlandTours, ArrayList<ForeignTour> foreignTours, ArrayList<TourLeader> tourLeaders){
        System.out.println("1-See tour menu,2-See tour leader menu,3-See regions menu,4-See map,5-Edit information:");
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
                editInformation();
                break;
        }
    }
    public void editInformation(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("First enter your password:");
        String oldPass=scanner.next();
        if (oldPass.equals(this.password)){
            System.out.println("1-Edit user name,2-Edit password,3-Edit email address,4-Edit phone number: ");
            int result=scanner.nextInt();
            switch (result){
                case 1:
                    System.out.println("Enter new user name:");
                    this.userName= scanner.next();
                    break;
                case 2:
                    System.out.println("First enter your password:");
                    String oldPass1=scanner.next();
                    if (oldPass1.equals(this.password)){
                        this.password=oldPass1;
                    }else {
                        System.out.println("Wrong password!");
                    }
                    break;
                case 3:
                    System.out.println("Enter new email address:");
                    this.email= scanner.next();
                    break;
                case 4:
                    System.out.println("Enter new phone number:");
                    this.phone= scanner.next();
                    break;
            }
        }else {
            System.out.println("Wrong password!");
        }
    }
}
