package main.java.ir.ac.kntu;
import java.util.ArrayList;
import java.util.Scanner;

public class Regions {
public static void region(ArrayList<InlandTour> inlandTours,ArrayList<ForeignTour> foreignTours){
    Scanner scanner=new Scanner(System.in);
    System.out.println("To see all of the declared places press 1:");
    System.out.println("To add a region press 2:");
    System.out.println("To edit a region press 3:");
    System.out.println("To delete a region press 4:");
    int answer=scanner.nextInt();
    switch (answer){
        case 1:
            for (ForeignTour foreignTour:foreignTours){
                System.out.println(foreignTour.getDestination().getCountryName());
            }
            for (InlandTour inlandTour:inlandTours){
                System.out.println(inlandTour.getDestination().getCityName());
            }
            break;
        case 2:
            System.out.println("1-Add a region to a Foreign tour,2-Add a region to an Inland tour:");
            int choice=scanner.nextInt();
            if (choice==1){
                System.out.println("Enter the tour id:");
                String id=scanner.nextLine();
                for (ForeignTour foreignTour:foreignTours){
                    if (foreignTour.getId().equals(id)){
                        System.out.println("Enter the city name:");
                        String city=scanner.nextLine();
                        Place visit=new Place(city,foreignTour.getCountry());
                        foreignTour.getVisitedCities().add(visit);
                        foreignTour.setVisitedCities(foreignTour.getVisitedCities());
                    }
                }
            }else if (choice==2){
                System.out.println("Enter the tour id:");
                String id=scanner.nextLine();
                for (InlandTour inlandTour:inlandTours){
                    if (inlandTour.getId().equals(id)){
                        System.out.println("Enter the place name:");
                        String place=scanner.nextLine();
                        inlandTour.getVisitedPlaces().add(place);
                        inlandTour.setVisitedPlaces(inlandTour.getVisitedPlaces());
                    }
                }
            }
            break;
        case 3:
            System.out.println("1-Edit a region of a Foreign tour,2-Edit a region of an Inland tour:");
            int result=scanner.nextInt();
            if (result==1){
                System.out.println("Enter the tour id:");
                String id=scanner.nextLine();
                System.out.println("Enter the city name:");
                String oldName=scanner.nextLine();
                for (ForeignTour foreignTour:foreignTours){
                    if (foreignTour.getId().equals(id)){
                        Place old=new Place(oldName,foreignTour.getDestination().getCountryName());
                        System.out.println("Enter the new city name:");
                        String newName=scanner.nextLine();
                        int index=foreignTour.getVisitedCities().indexOf(old);
                        Place place1=new Place(newName,foreignTour.getDestination().getCountryName());
                        foreignTour.getVisitedCities().remove(old);
                        foreignTour.getVisitedCities().add(index,place1);
                        foreignTour.setVisitedCities(foreignTour.getVisitedCities());
                    }
                }
            }else if (result==2){
                System.out.println("Enter the tour id:");
                String id=scanner.nextLine();
                System.out.println("Enter the old place:");
                String oldName=scanner.nextLine();
                for (InlandTour inlandTour:inlandTours){
                    if (inlandTour.getId().equals(id)){
                        int index=inlandTour.getVisitedPlaces().indexOf(oldName);
                        System.out.println("Enter the new place:");
                        String newName=scanner.nextLine();
                        inlandTour.getVisitedPlaces().remove(index);
                        inlandTour.getVisitedPlaces().add(index,newName);
                        inlandTour.setVisitedPlaces(inlandTour.getVisitedPlaces());
                    }
                }
            }
            break;
        case 4:
            System.out.println("1-Delete a region of a Foreign tour,2-Edit a region of an Inland tour:");
            int ans=scanner.nextInt();
            if (ans==1){
                System.out.println("Enter the tour id:");
                String id=scanner.nextLine();
                for (ForeignTour foreignTour:foreignTours){
                    if (foreignTour.getId().equals(id)){
                        System.out.println("Enter the city name:");
                        String city=scanner.nextLine();
                        Place place=new Place(city,foreignTour.getHome().getCountryName());
                        if (foreignTour.getVisitedCities().contains(place)){
                            foreignTour.getVisitedCities().remove(place);
                            foreignTour.setVisitedCities(foreignTour.getVisitedCities());
                        }
                    }
                }
            }
            if (ans==2){
                System.out.println("Enter the tour id:");
                String id=scanner.nextLine();
                for (InlandTour inlandTour:inlandTours){
                    if (inlandTour.getId().equals(id)){
                        System.out.println("Enter the place name:");
                        String place=scanner.nextLine();
                        if (inlandTour.getVisitedPlaces().contains(place)){
                            inlandTour.getVisitedPlaces().remove(place);
                            inlandTour.setVisitedPlaces(inlandTour.getVisitedPlaces());
                        }
                    }
                }
            }
            break;
    }

}
}
