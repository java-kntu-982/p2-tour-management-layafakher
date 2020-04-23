package main.java.ir.ac.kntu;
import java.util.ArrayList;
import java.util.Scanner;

public class TourLeaderMenu {
    public static void tourMenu(ArrayList<TourLeader> tourLeaders){
        Scanner sc=new Scanner(System.in);
        System.out.println("If you want to see all the tour leaders press 1:");
        System.out.println("If you want to add a tour leader press 2:");
        System.out.println("If you want to delete a tour leader press 3:");
        System.out.println("If you want to edit a tour leader press 4:");
        System.out.println("If you want to search for a tour leader press 5:");
        int res=sc.nextInt();
        switch (res){
            case 1:
                printTourLeaders(tourLeaders);
                break;
            case 2:
                addTourLeader(tourLeaders);
                break;
            case 3:
                deleteTourLeader(tourLeaders);
                break;
            case 4:
                editTourLeader(tourLeaders);
                break;
            case 5:
                searchForTourLeader(tourLeaders);
                break;
        }
    }
    public static void printTourLeaders(ArrayList<TourLeader> tourLeaders){
        for (TourLeader tourLeader:tourLeaders){
            System.out.println(tourLeader.getFirstName()+" "+tourLeader.getLastName()+" id: " +tourLeader.getIdNumber());
        }
    }
    public static void addTourLeader(ArrayList<TourLeader> tourLeaders){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter your first name:");
        String firstName=in.nextLine();
        System.out.println("Enter your last name:");
        String lastName=in.nextLine();
        System.out.println("Enter your national code:");
        String nationalCode=in.next();
        System.out.println("Enter your certificate number:");
        long id=in.nextLong();
        System.out.println("Enter your age:");
        int age=in.nextInt();
        System.out.println("Enter your birthday date(year,month,day):");
        int year=in.nextInt();
        int month=in.nextInt();
        int day=in.nextInt();
        Date date=new Date(year,month,day);
        System.out.println("Enter today date(year,month,day):");
        int year2=in.nextInt();
        int month2=in.nextInt();
        int day2=in.nextInt();
        Date date1=new Date(year2,month2,day2);
        System.out.println("Are you married?(true,false):");
        boolean b= Boolean.parseBoolean(in.next());
        ArrayList<Place> places=new ArrayList<>();
        String []input=new String[100];
        System.out.println("Enter cities you know:(if you finished press 0)");
        for (int i=0;i<100;i++){
            input[i]=in.next();
            if (input[i].endsWith("0")){
                break;
            }
        }
        Place []arr=new Place[100];
        for (int i=0;i<100;i++){
            arr[i].setCityName(input[i]);
        }
        for (int i=0;i<input.length;i++){
            places.add(arr[i]);
        }
        TourLeader tourLeader=new TourLeader(firstName,lastName,nationalCode,id,age,date,date1,b,places);
        tourLeader.setKnownPlaces(places);
        tourLeaders.add(tourLeader);
    }
    public static void deleteTourLeader(ArrayList<TourLeader> tourLeaders){
        Scanner inp=new Scanner(System.in);
        System.out.println("Enter your first name:");
        String firstName=inp.nextLine();
        System.out.println("Enter your last name:");
        String lastName=inp.nextLine();
        System.out.println("Enter your national code:");
        String nationalCode=inp.next();
        System.out.println("Enter your certificate number:");
        long id=inp.nextLong();
        System.out.println("Enter your age:");
        int age=inp.nextInt();
        System.out.println("Enter your birthday date(year,month,day):");
        int year=inp.nextInt();
        int month=inp.nextInt();
        int day=inp.nextInt();
        Date date=new Date(year,month,day);
        System.out.println("Enter today date(year,month,day):");
        int year2=inp.nextInt();
        int month2=inp.nextInt();
        int day2=inp.nextInt();
        Date date1=new Date(year2,month2,day2);
        System.out.println("Are you married?(true,false):");
        boolean b= Boolean.parseBoolean(inp.next());
        TourLeader tourLeader=new TourLeader(firstName,lastName,nationalCode,id,age,date,date1,b);
        for (TourLeader tourLeader1:tourLeaders){
            if (tourLeader.equals(tourLeader1)){
                tourLeaders.remove(tourLeader1);
            }
        }
    }
    public static void editTourLeader(ArrayList<TourLeader> tourLeaders){
    System.out.println("If you want to edit your name press 1,your ");
    }
    public static void searchForTourLeader(ArrayList<TourLeader> tourLeaders){
        System.out.println("for searching based on first name press 1,last name press 2,age press 3 and places he knows press 4:");
        Scanner scanner=new Scanner(System.in);
        int ans=scanner.nextInt();
        switch (ans){
            case 1:
                System.out.println("Enter the first name:");
                String f=scanner.nextLine();
                for (TourLeader tourLeader:tourLeaders){
                    if (tourLeader.getFirstName().equals(f))
                        System.out.println(tourLeader);
                }
                break;
            case 2:
                System.out.println("Enter the last name:");
                String l=scanner.nextLine();
                for (TourLeader tourLeader:tourLeaders){
                    if (tourLeader.getLastName().equals(l))
                        System.out.println(tourLeader);
                }
                break;
            case 3:
                System.out.println("If you want to see tour leaders with the same age press 1,or more than a number press 2,less than a number press 3,between two number press 4:");
                int result=scanner.nextInt();
                switch (result){
                    case 1:
                        System.out.println("Enter the age:");
                        int age=scanner.nextInt();
                        for (TourLeader tourLeader:tourLeaders){
                            if (tourLeader.getAge().equals(age))
                                System.out.println(tourLeader);
                        }
                        break;
                    case 2:
                        System.out.println("Enter the number:");
                        int num=scanner.nextInt();
                        for (TourLeader tourLeader:tourLeaders){
                            if (tourLeader.getAge()>=num)
                                System.out.println(tourLeader);
                        }
                        break;
                    case 3:
                        System.out.println("Enter the number:");
                        int numb=scanner.nextInt();
                        for (TourLeader tourLeader:tourLeaders){
                            if (tourLeader.getAge()<numb)
                                System.out.println(tourLeader);
                        }
                        break;
                    case 4:
                        System.out.println("Enter the minim number:");
                        int minim=scanner.nextInt();
                        System.out.println("Enter the max number:");
                        int max=scanner.nextInt();
                        for (TourLeader tourLeader:tourLeaders){
                            if (tourLeader.getAge()<=max&&tourLeader.getAge()>=minim)
                                System.out.println(tourLeader);
                        }
                        break;
                }
            case 4:
                System.out.println("Enter the city or country want him to know:");
                String location=scanner.nextLine();
                for (TourLeader tourLeader:tourLeaders){
                  for (Place place:tourLeader.getKnownPlaces()){
                      if (place.getCityName().equals(location)||place.getCountryName().equals(location))
                          System.out.println(tourLeader);
                  }
                }
                break;
        }
    }

}
