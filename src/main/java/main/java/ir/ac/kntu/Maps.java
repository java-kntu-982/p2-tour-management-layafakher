package main.java.ir.ac.kntu;
import main.java.ir.ac.kntu.maputil.MapUtil;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
public class Maps {
    public static void map(ArrayList<InlandTour> inlandTours, ArrayList<ForeignTour> foreignTours){
        System.out.println("Enter 1 to see the home position of a tour:");
        System.out.println("Enter 2 to see the destination of a tour:");
        System.out.println("Enter 3 to see the home position & destination of a tour:");
        System.out.println("Enter 4 to see the location of  the tour on a specific day:");
        System.out.println("Enter 5 to see all of the visited cities of a foreign tour:");
        System.out.println("Enter 6 to see a specific city or country:");
        System.out.println("Enter 7 to see two city in map:");
        Scanner scanner=new Scanner(System.in);
        int result=scanner.nextInt();
        switch (result){
            case 1:
                System.out.println("Enter the tour id:");
                String id=scanner.nextLine();
                for (ForeignTour foreignTour:foreignTours){
                    if (foreignTour.getId().equals(id)){
                        MapUtil.showMap(foreignTour.getHome().getCityName());
                    }
                }
                for (InlandTour inlandTour:inlandTours){
                    if (inlandTour.getId().equals(id)){
                        MapUtil.showMap(inlandTour.getHome().getCityName());
                    }
                }
                break;
            case 2:
                System.out.println("Enter the tour id:");
                String id1=scanner.nextLine();
                for (ForeignTour foreignTour:foreignTours){
                    if (foreignTour.getId().equals(id1)){
                        MapUtil.showMap(foreignTour.getDestination().getCountryName());

                    }

                }
                for (InlandTour inlandTour:inlandTours){
                    if (inlandTour.getId().equals(id1)){
                        MapUtil.showMap(inlandTour.getDestination().getCityName());
                    }
                }
                break;
            case 3:
                System.out.println("Enter the tour id:");
                String id2=scanner.nextLine();
                for (ForeignTour foreignTour:foreignTours){
                    if (foreignTour.getId().equals(id2)){
                        MapUtil.showMap(foreignTour.getHome().getCityName(),foreignTour.getDestination().getCountryName());

                    }

                }
                for (InlandTour inlandTour:inlandTours){
                    if (inlandTour.getId().equals(id2)){
                        MapUtil.showMap(inlandTour.getHome().getCityName(),inlandTour.getDestination().getCityName());

                    }

                }
                break;
            case 4:
                System.out.println("Enter the tour id:");
                String id3=scanner.nextLine();
                System.out.println("Enter the date(year,month,day):");
                int year=scanner.nextInt();
                int month=scanner.nextInt();
                int day=scanner.nextInt();
                Date date=new Date(year,month,day);
                for (ForeignTour foreignTour:foreignTours){
                    if (foreignTour.getId().equals(id3)){
                        for (Date date1:foreignTour.getNowLocation().keySet()) {
                            if (date.equals(date1))
                                MapUtil.showMap(foreignTour.getNowLocation().get(date1).getCityName());
                        }
                    }

                }
                break;
            case 5:
                System.out.println("Enter the tour id:");
                String id4=scanner.nextLine();
                for (ForeignTour foreignTour:foreignTours){
                    if (foreignTour.getId().equals(id4)){
                        for (Place place:foreignTour.getVisitedCities())
                        System.out.println(place);
                    }

                }
                break;
            case 6:
                System.out.println("Enter the city or country name:");
                String place=scanner.nextLine();
                MapUtil.showMap(place);
                break;
            case 7:
                System.out.println("Enter the first city name:");
                String city1=scanner.nextLine();
                System.out.println("Enter the second city name:");
                String city2=scanner.nextLine();
                MapUtil.showMap(city1,city2);
                break;
        }



    }



}
