package main.java.ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class TourMenu {

    public static void tourMenu(ArrayList<InlandTour> inlandTours,ArrayList<ForeignTour> foreignTours,ArrayList<TourLeader> tourLeaders){
        System.out.println("If you want to see all of The foreign and inland tours press 1:  ");
        System.out.println("If you want to see all kind of a tour press 2:  ");
        System.out.println("If you want to add a tour to list press 3:  ");
        System.out.println("If you want to add a tour to a region press 4:  ");
        System.out.println("If you want to edit a tour press 5:  ");
        System.out.println("If you want to edit a tour of a region tour press 6:  ");
        System.out.println("If you want to delete a tour press 7:  ");
        System.out.println("If you want to search for a tour press 8:  ");
        System.out.println("If you want to search for a region tour press 9:  ");
        Scanner scanner=new Scanner(System.in);
        int ans=scanner.nextInt();
        switch (ans){
            case 1:
                printTours(inlandTours,foreignTours);
                break;
            case 2:
                printAllKindOfATour(inlandTours,foreignTours);
                break;
            case 3:
                addTour(inlandTours,foreignTours);
                break;
            case 4:
                addTourToARegion(inlandTours,foreignTours);
                break;
            case 5:
                editTour(inlandTours,foreignTours);
                break;
            case 6:
                editARegionTour(inlandTours,foreignTours);
                break;
            case 7:
                deleteTour(inlandTours,foreignTours);
                break;
            case 8:
                tourSearch(inlandTours,foreignTours);
                break;
            case 9:
                regionTourSearch(inlandTours,foreignTours,tourLeaders);
                break;
        }
    }
    public static void printTours(ArrayList<InlandTour> inlandTours,ArrayList<ForeignTour> foreignTours){
        System.out.println("Inland Tours :");
        for (InlandTour inlandTour:inlandTours)
            System.out.println(inlandTour.getRegion());
        System.out.println("Foreign Tours :");
        for (ForeignTour foreignTour:foreignTours)
            System.out.println(foreignTour.getCountry());
    }
    public static void printAllKindOfATour(ArrayList<InlandTour> inlandTours,ArrayList<ForeignTour> foreignTours){
        Scanner scanner=new Scanner(System.in);
        System.out.println("for searching for an inland tour press 1,foreign tour press 2:");
        int res=scanner.nextInt();
        if (res==1){
            System.out.println("Enter the region you are looking for :");
            String region=scanner.nextLine();
            for (InlandTour inlandTour:inlandTours){
                if (inlandTour.getRegion().equals(region)&&inlandTour.getRegionInlandTours()!=null)
                    System.out.println(inlandTour.getRegion()+"in: "+inlandTour.getStartDate());
            }
        }else if (res==2){
            System.out.println("Enter the region you are looking for :");
            String country=scanner.nextLine();
            for (ForeignTour foreignTour:foreignTours){
                if (foreignTour.getCountry().equals(country)&&foreignTour.getRegionForeignTours()!=null)
                    System.out.println(foreignTour.getCountry()+"in: "+foreignTour.getStartDate());
            }
    }
    }
    public static void addTour(ArrayList<InlandTour>inlandTours,ArrayList<ForeignTour>foreignTours){
        System.out.println("If you want to add a tour to inland tours press 1,to foreign tours press 2:");
        Scanner scanner=new Scanner(System.in);
        int res=scanner.nextInt();
        if (res==1){
            System.out.println("Enter the destination city :");
            String destinationCity=scanner.nextLine();
            Place city=new Place(destinationCity,"Iran");
            Place home=new Place("Tehran","Iran");
            System.out.println("Enter the tour id:");
            String id=scanner.nextLine();
            System.out.println("Enter the price :");
            long price=scanner.nextLong();
            System.out.println("How long does it take? :");
            int period=scanner.nextInt();
            System.out.println("When does it start? :(year,month,day)");
            int year=scanner.nextInt();
            int month=scanner.nextInt();
            int day=scanner.nextInt();
            Date date=new Date(year,month,day);
            System.out.println("How many people can attend in the tour(minim)? :");
            int minim=scanner.nextInt();
            System.out.println("How many people can attend in the tour(maximum)? :");
            int max=scanner.nextInt();
            System.out.println("Where are we going to visit there? (Enter 0 to finish):");
            String []visitedPlaces=new String[20];
            for (int i=0;i<20;i++){
                visitedPlaces[i]=scanner.next();
                if (visitedPlaces[i].endsWith("0"))
                    break;
            }
            ArrayList<String> visited=new ArrayList<>();
            for (int i=0;i<visitedPlaces.length;i++){
                visited.add(visitedPlaces[i]);
            }
            InlandTour inlandTour=new InlandTour(id,price,period,date,home,city,minim,max,visited);
            inlandTours.add(inlandTour);
        }else if (res==2){
            System.out.println("Enter the destination country :");
            String destinationCountry=scanner.nextLine();
            Place country=new Place("capital",destinationCountry);
            System.out.println("Enter the tour id:");
            Place start=new Place("Tehran","Iran");
            String id=scanner.nextLine();
            System.out.println("Enter the price :");
            long price=scanner.nextLong();
            System.out.println("How long does it take? :");
            int period=scanner.nextInt();
            System.out.println("When does it start? :(year,month,day)");
            int year=scanner.nextInt();
            int month=scanner.nextInt();
            int day=scanner.nextInt();
            Date date=new Date(year,month,day);
            System.out.println("How many people can attend in the tour(minim)? :");
            int minim=scanner.nextInt();
            System.out.println("How many people can attend in the tour(maximum)? :");
            int max=scanner.nextInt();
            System.out.println("Which cities are we going to visit there? (Enter 0 to finish):");
            Place[] visitedCities=new Place[20];
            for (int i=0;i<20;i++){
                visitedCities[i].setCityName(scanner.next());
                if (visitedCities[i].getCityName().endsWith("0"))
                    break;}
            ArrayList<Place> visited=new ArrayList<>();
            for (int i=0;i<visitedCities.length;i++){
                visited.add(visitedCities[i]);
            }
            ForeignTour foreignTour=new ForeignTour(id,price,date,period,start,country,visited,minim,max);
            foreignTours.add(foreignTour);
        }
    }
    public static void addTourToARegion(ArrayList<InlandTour> inlandTours,ArrayList<ForeignTour> foreignTours){
        System.out.println("If you want to add a tour to inland tours press 1,to foreign tours press 2:");
        Scanner scanner=new Scanner(System.in);
        int res=scanner.nextInt();
        if (res==1){
            System.out.println("Enter the destination city :");
            String destinationCity=scanner.nextLine();
            Place city=new Place(destinationCity,"Iran");
            Place home=new Place("Tehran","Iran");
            System.out.println("Enter the region tour number:");
            int number=scanner.nextInt();
            System.out.println("Enter the  region tour id:");
            String id=scanner.nextLine();
            System.out.println("Enter the price :");
            long price=scanner.nextLong();
            System.out.println("How long does it take? :");
            int period=scanner.nextInt();
            System.out.println("When does it start? :(year,month,day)");
            int year=scanner.nextInt();
            int month=scanner.nextInt();
            int day=scanner.nextInt();
            Date date=new Date(year,month,day);
            System.out.println("How many people can attend in the tour(minim)? :");
            int minim=scanner.nextInt();
            System.out.println("How many people can attend in the tour(maximum)? :");
            int max=scanner.nextInt();
            System.out.println("Where are we going to visit there? (Enter 0 to finish):");
            String []visitedPlaces=new String[20];
            for (int i=0;i<20;i++){
                visitedPlaces[i]=scanner.next();
                if (visitedPlaces[i].endsWith("0"))
                    break;
            }
            ArrayList<String> visited=new ArrayList<>();
            for (int i=0;i<visitedPlaces.length;i++){
                visited.add(visitedPlaces[i]);
            }
            ArrayList<RegionInlandTour> regionInlandTours=new ArrayList<>();
            RegionInlandTour regionInlandTour;
            regionInlandTour = new RegionInlandTour(id,price,period,date,home,city,minim,max,visited,number);
            regionInlandTours.add(regionInlandTour);
            InlandTour inlandTour=new InlandTour(id,price,regionInlandTours,period,date,home,city,minim,max,visited);
            inlandTours.add(inlandTour);
        }else if (res==2){
            System.out.println("Enter the destination country :");
            String destinationCountry=scanner.nextLine();
            Place country=new Place("capital",destinationCountry);
            System.out.println("Enter the region tour number:");
            int number=scanner.nextInt();
            System.out.println("Enter the tour id:");
            Place start=new Place("Tehran","Iran");
            String id=scanner.nextLine();
            System.out.println("Enter the price :");
            long price=scanner.nextLong();
            System.out.println("How long does it take? :");
            int period=scanner.nextInt();
            System.out.println("When does it start? :(year,month,day)");
            int year=scanner.nextInt();
            int month=scanner.nextInt();
            int day=scanner.nextInt();
            Date date=new Date(year,month,day);
            System.out.println("How many people can attend in the tour(minim)? :");
            int minim=scanner.nextInt();
            System.out.println("How many people can attend in the tour(maximum)? :");
            int max=scanner.nextInt();
            System.out.println("Which cities are we going to visit there? (Enter 0 to finish):");
            Place[] visitedCities=new Place[20];
            for (int i=0;i<20;i++){
                visitedCities[i].setCityName(scanner.next());
                if (visitedCities[i].getCityName().endsWith("0"));
                    break;}
            ArrayList<Place> visited=new ArrayList<>();
            for (int i=0;i<visitedCities.length;i++){
                visited.add(visitedCities[i]);
            }
            ArrayList<RegionForeignTour> regionForeignTours=new ArrayList<>();
            RegionForeignTour regionForeignTour=new RegionForeignTour(id,price,date,period,start,country,visited,minim,max,number);
            regionForeignTours.add(regionForeignTour);
            ForeignTour foreignTour=new ForeignTour(id,price,date,period,start,country,visited,minim,max,regionForeignTours);
            foreignTours.add(foreignTour);
        }
    }
    public static void editTour(ArrayList<InlandTour> inlandTours,ArrayList<ForeignTour> foreignTours){
        System.out.println("please enter the id of the tour you want to edit:");
        Scanner scanner=new Scanner(System.in);
        String id=scanner.nextLine();
        for (InlandTour inlandTour:inlandTours){
            if (inlandTour.getId().equals(id)){
                System.out.println("Which part you want to edit?1-destination city,2-price,3-start date,4-period,5-minim people,6-maximum people,7-visited places:");
                int ans=scanner.nextInt();
                switch (ans){
                    case 1:
                        System.out.println("please enter the new place:");
                        String newC=scanner.nextLine();
                        Place city=new Place(newC,"Iran");
                        inlandTour.setDestination(city);
                        break;
                    case 2:
                        System.out.println("please enter the new price:");
                        long price=scanner.nextLong();
                        inlandTour.setPrice(price);
                        break;
                    case 3:
                        System.out.println("please enter the new date:(year,month,day)");
                        int year=scanner.nextInt();
                        int month=scanner.nextInt();
                        int day=scanner.nextInt();
                        Date date=new Date(year,month,day);
                        inlandTour.setStartDate(date);
                        break;
                    case 4:
                        System.out.println("please enter the new period:");
                        int period=scanner.nextInt();
                        inlandTour.setPeriod(period);
                        break;
                    case 5:
                        System.out.println("please enter the new minim people:");
                        int minim=scanner.nextInt();
                        inlandTour.setMinimPeople(minim);
                        break;
                    case 6:
                        System.out.println("please enter the new maximum people:");
                        int max=scanner.nextInt();
                        inlandTour.setMaximumPeople(max);
                        break;
                    case 7:
                        System.out.println("Enter the old place");
                        String old=scanner.nextLine();
                        for (String place:inlandTour.getVisitedPlaces()){
                            if (place.equals(old)){
                                System.out.println("Enter the new place");
                                String newP=scanner.nextLine();
                                int index=inlandTour.getVisitedPlaces().indexOf(old);
                                inlandTour.getVisitedPlaces().remove(index);
                                inlandTour.getVisitedPlaces().add(index,newP);
                                inlandTour.setVisitedPlaces(inlandTour.getVisitedPlaces());
                            }
                        }break;
                }
            }
        }
        for (ForeignTour foreignTour:foreignTours){
            if (foreignTour.getId().equals(id)){
                System.out.println("Which part you want to edit?1-destination country,2-price,3-start date,4-period,5-minim people,6-maximum people,7-visited places:");
                int ans=scanner.nextInt();
                switch (ans){
                    case 1:
                        System.out.println("please enter the new country:");
                        String newC=scanner.nextLine();
                        Place country=new Place("capital",newC);
                        foreignTour.setDestination(country);
                        break;
                    case 2:
                        System.out.println("please enter the new price:");
                        long price=scanner.nextLong();
                        foreignTour.setPrice(price);
                        break;
                    case 3:
                        System.out.println("please enter the new date:(year,month,day)");
                        int year=scanner.nextInt();
                        int month=scanner.nextInt();
                        int day=scanner.nextInt();
                        Date date=new Date(year,month,day);
                        foreignTour.setStartDate(date);
                        break;
                    case 4:
                        System.out.println("please enter the new period:");
                        int period=scanner.nextInt();
                        foreignTour.setPeriod(period);
                        break;
                    case 5:
                        System.out.println("please enter the new minim people:");
                        int minim=scanner.nextInt();
                        foreignTour.setMinimPeople(minim);
                        break;
                    case 6:
                        System.out.println("please enter the new maximum people:");
                        int max=scanner.nextInt();
                        foreignTour.setMaximumPeople(max);
                        break;
                    case 7:
                        System.out.println("Enter the old city:");
                        String old=scanner.nextLine();
                        for (Place place:foreignTour.getVisitedCities()){
                            if (place.getCityName().equals(old)){
                                System.out.println("Enter the new city:");
                                Place oldC=new Place(old,place.getCountryName());
                                String newP=scanner.nextLine();
                                Place newCity=new Place(newP,place.getCountryName());
                                int index=foreignTour.getVisitedCities().indexOf(oldC);
                                foreignTour.getVisitedCities().remove(index);
                                foreignTour.getVisitedCities().add(index,newCity);
                                foreignTour.setVisitedCities(foreignTour.getVisitedCities());
                            }
                        }
                        break;
                }
            }
        }
    }
    public static void editARegionTour(ArrayList<InlandTour> inlandTours,ArrayList<ForeignTour> foreignTours){
        System.out.println("please enter the id of the region tour you want to edit:");
        Scanner scanner=new Scanner(System.in);
        String id=scanner.nextLine();
        for (InlandTour inlandTour:inlandTours){
            if (inlandTour.getId().equals(id)&&inlandTour.getRegionInlandTours()!=null){
                System.out.println("Which part you want to edit?1-destination city,2-price,3-start date,4-period,5-minim people,6-maximum people,7-visited places,8-number:");
                int ans=scanner.nextInt();
                switch (ans){
                    case 1:
                        System.out.println("please enter the new place:");
                        String newC=scanner.nextLine();
                        Place city=new Place(newC,"Iran");
                        inlandTour.setDestination(city);
                        break;
                    case 2:
                        System.out.println("please enter the new price:");
                        long price=scanner.nextLong();
                        inlandTour.setPrice(price);
                        break;
                    case 3:
                        System.out.println("please enter the new date:(year,month,day)");
                        int year=scanner.nextInt();
                        int month=scanner.nextInt();
                        int day=scanner.nextInt();
                        Date date=new Date(year,month,day);
                        inlandTour.setStartDate(date);
                        break;
                    case 4:
                        System.out.println("please enter the new period:");
                        int period=scanner.nextInt();
                        inlandTour.setPeriod(period);
                        break;
                    case 5:
                        System.out.println("please enter the new minim people:");
                        int minim=scanner.nextInt();
                        inlandTour.setMinimPeople(minim);
                        break;
                    case 6:
                        System.out.println("please enter the new maximum people:");
                        int max=scanner.nextInt();
                        inlandTour.setMaximumPeople(max);
                        break;
                    case 7:
                        System.out.println("Enter the old place");
                        String old=scanner.nextLine();
                        for (String place:inlandTour.getVisitedPlaces()){
                            if (place.equals(old)){
                                System.out.println("Enter the new place");
                                String newP=scanner.nextLine();
                                int index=inlandTour.getVisitedPlaces().indexOf(old);
                                inlandTour.getVisitedPlaces().remove(index);
                                inlandTour.getVisitedPlaces().add(index,newP);
                                inlandTour.setVisitedPlaces(inlandTour.getVisitedPlaces());
                            }
                        }break;
//                    case 8:
//                        System.out.println("please enter the new tour number:");
//                        int num=scanner.nextInt();
//                        ArrayList<RegionInlandTour> regionInlandTours=new ArrayList<>();
//                        RegionInlandTour regionInlandTour=new RegionInlandTour(id,inlandTour.getRegionInlandTours().);
//                        regionInlandTours.add(regionInlandTour);
//                        inlandTour.setRegionInlandTours(regionInlandTours);
//                        break;

                }
            }
        }
        for (ForeignTour foreignTour:foreignTours){
            if (foreignTour.getId().equals(id)&&foreignTour.getRegionForeignTours()!=null){
                System.out.println("Which part you want to edit?1-destination country,2-price,3-start date,4-period,5-minim people,6-maximum people,7-visited places,8-tour number:");
                int ans=scanner.nextInt();
                switch (ans){
                    case 1:
                        System.out.println("please enter the new country:");
                        String newC=scanner.nextLine();
                        Place country=new Place("capital",newC);
                        foreignTour.setDestination(country);
                        break;
                    case 2:
                        System.out.println("please enter the new price:");
                        long price=scanner.nextLong();
                        foreignTour.setPrice(price);
                        break;
                    case 3:
                        System.out.println("please enter the new date:(year,month,day)");
                        int year=scanner.nextInt();
                        int month=scanner.nextInt();
                        int day=scanner.nextInt();
                        Date date=new Date(year,month,day);
                        foreignTour.setStartDate(date);
                        break;
                    case 4:
                        System.out.println("please enter the new period:");
                        int period=scanner.nextInt();
                        foreignTour.setPeriod(period);
                        break;
                    case 5:
                        System.out.println("please enter the new minim people:");
                        int minim=scanner.nextInt();
                        foreignTour.setMinimPeople(minim);
                        break;
                    case 6:
                        System.out.println("please enter the new maximum people:");
                        int max=scanner.nextInt();
                        foreignTour.setMaximumPeople(max);
                        break;
                    case 7:
                        System.out.println("Enter the old city:");
                        String old=scanner.nextLine();
                        for (Place place:foreignTour.getVisitedCities()){
                            if (place.getCityName().equals(old)){
                                Place oldC=new Place(old,place.getCountryName());
                                System.out.println("Enter the new city:");
                                String newP=scanner.nextLine();
                                Place newCity=new Place(old,place.getCountryName());
                                int index=foreignTour.getVisitedCities().indexOf(oldC);
                                foreignTour.getVisitedCities().remove(index);
                                foreignTour.getVisitedCities().add(index,newCity);
                                foreignTour.setVisitedCities(foreignTour.getVisitedCities());
                            }
                        }
                        break;
//                    case 8:
//                        System.out.println("please enter the new tour number:");
//                        int num=scanner.nextInt();
//                        ArrayList<RegionInlandTour>regionInlandTours=new ArrayList<>();
//                        RegionInlandTour regionInlandTour=new RegionInlandTour(id,pr);
//                        RegionInlandTour regionInlandTour1=new RegionInlandTour(num);
//                        regionInlandTours.add(regionInlandTour1);
//                        foreignTour.setRegionInlandTours(regionInlandTours);
//                        break;
                }
            }
        }
    }
    public static void deleteTour(ArrayList<InlandTour> inlandTours,ArrayList<ForeignTour> foreignTours){
        System.out.println("please enter the id of the tour you want to edit:");
        Scanner scanner=new Scanner(System.in);
        String id=scanner.nextLine();
        for (InlandTour inlandTour:inlandTours){
            if (inlandTour.getId().equals(id)){
                inlandTours.remove(inlandTour);
                break;
            }
        }
        for (ForeignTour foreignTour:foreignTours){
            if (foreignTour.getId().equals(id)){
                inlandTours.remove(foreignTour);
                break;
            }
        }
    }
    public static void tourSearch(ArrayList<InlandTour> inlandTours,ArrayList<ForeignTour> foreignTours){

        System.out.println("Search tours based on:1-taking time,2-visited places,3-Region,4-content,5-price,");
        Scanner scanner=new Scanner(System.in);
        int result=scanner.nextInt();
        switch (result){
            case 1:
                System.out.println("How many days you want it takes?");
                int period=scanner.nextInt();
                for (InlandTour inlandTour:inlandTours){
                    if (inlandTour.getPeriod()==period)
                        System.out.println(inlandTour.getDestination()+" "+inlandTour.getPeriod());
                }
                for (ForeignTour foreignTour:foreignTours){
                    if (foreignTour.getPeriod()==period)
                        System.out.println(foreignTour.getDestination()+" "+foreignTour.getPeriod());
                }
                break;
            case 2:
                System.out.println("Where do you want to visit?");
                String place=scanner.nextLine();
                for (InlandTour inlandTour:inlandTours){
                    if (inlandTour.getVisitedPlaces().contains(place)){
                        System.out.println(inlandTour.getDestination()+" "+place);
                    }
                }
                for (ForeignTour foreignTour:foreignTours){
                    if (foreignTour.getVisitedCities().contains(place)){
                        System.out.println(foreignTour.getDestination()+" "+place);
                    }
                }
                break;
            case 3:
                System.out.println("Enter the region you are looking for:");
                String region=scanner.nextLine();
                for (InlandTour inlandTour:inlandTours){
                    if (inlandTour.getDestination().getCityName().equals(region))
                    {
                        inlandTour.toString();
                    }
                }
                for (ForeignTour foreignTour:foreignTours){
                    if (foreignTour.getDestination().getCountryName().equals(region))
                    {
                        foreignTour.toString();
                    }
                }
                break;
            case 4:
                System.out.println("1-minim people,2-maximum people:");
                int ans=scanner.nextInt();
                if (ans==1){
                    System.out.println("1-Enter the minim number:");
                    int minim=scanner.nextInt();
                    System.out.println("1-Foreign tour,2-Inland tour:");
                    int res=scanner.nextInt();
                    if (res==1){
                        for (ForeignTour foreignTour:foreignTours)
                        {
                            if (foreignTour.getMinimPeople()==minim)
                                foreignTour.toString();
                        }

                    }
                    else if (res==2){
                        for (InlandTour inlandTour:inlandTours){
                            if (inlandTour.getMinimPeople()==minim)
                                inlandTour.toString();
                        }
                    }
                }else if (ans==2){
                    System.out.println("1-Enter the maximum number:");
                    int max=scanner.nextInt();
                    System.out.println("1-Foreign tour,2-Inland tour:");
                    int res=scanner.nextInt();
                    if (res==1){
                        for (ForeignTour foreignTour:foreignTours)
                        {
                            if (foreignTour.getMaximumPeople()==max)
                                foreignTour.toString();
                        }
                    }
                    else if (res==2){
                        for (InlandTour inlandTour:inlandTours){
                            if (inlandTour.getMaximumPeople()==max)
                                inlandTour.toString();
                        }
                    }
                }
                break;
            case 5:
                System.out.println("1-above a number,2-less than a number,3-between twe number,4-specific number");
                int choice=scanner.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("Enter the price:");
                        long price=scanner.nextLong();
                        for (InlandTour inlandTour:inlandTours){
                            if (inlandTour.getPrice()>price)
                                inlandTour.toString();
                        }
                        for (ForeignTour foreignTour:foreignTours){
                            if (foreignTour.getPrice()>price)
                                foreignTour.toString();
                        }
                        break;
                    case 2:
                        System.out.println("Enter the price:");
                        long price1=scanner.nextLong();
                        for (InlandTour inlandTour:inlandTours){
                            if (inlandTour.getPrice()<price1)
                                inlandTour.toString();
                        }
                        for (ForeignTour foreignTour:foreignTours){
                            if (foreignTour.getPrice()<price1)
                                foreignTour.toString();
                        }
                        break;
                    case 3:
                        System.out.println("Enter the minim price:");
                        long minim=scanner.nextLong();
                        System.out.println("Enter the maximum price:");
                        long max=scanner.nextLong();

                        for (InlandTour inlandTour:inlandTours){
                            if (inlandTour.getPrice()<max&&inlandTour.getPrice()>minim)
                                inlandTour.toString();
                        }
                        for (ForeignTour foreignTour:foreignTours){
                            if (foreignTour.getPrice()<max && foreignTour.getPrice()>minim)
                                foreignTour.toString();
                        }
                        break;
                    case 4:
                        System.out.println("Enter the price:");
                        long price3=scanner.nextLong();
                        for (InlandTour inlandTour:inlandTours){
                            if (inlandTour.getPrice()==price3)
                                inlandTour.toString();
                        }
                        for (ForeignTour foreignTour:foreignTours){
                            if (foreignTour.getPrice()==price3)
                                foreignTour.toString();
                        }
                        break;
                }
               break;
        }
    }
    public static void regionTourSearch(ArrayList<InlandTour> inlandTours,ArrayList<ForeignTour> foreignTours,ArrayList<TourLeader> tourLeaders){
        System.out.println("search based on:1-Specific tour leader,2-Start date&End date,3-taking time,4-visited places,5-region,6-content,7-price");
        Scanner scanner=new Scanner(System.in);
        int answer=scanner.nextInt();
        switch (answer){
            case 1:
                System.out.println("Enter the tour leader first name:");
                String firstName=scanner.nextLine();
                System.out.println("Enter the tour leader last name:");
                String lastName=scanner.nextLine();
                for (TourLeader tourLeader:tourLeaders){
                    if (tourLeader.getFirstName().equals(firstName)&&tourLeader.getLastName().equals(lastName))
                        tourLeader.toString();
                }
                break;
            case 2:
                System.out.println("1-After a specific date,2-Before  a specific date,3-Between two date:");
                int ans=scanner.nextInt();
                if (ans==1){
                    System.out.println("Enter the date(year,month,day):");
                    int year=scanner.nextInt();
                    int month=scanner.nextInt();
                    int day=scanner.nextInt();
                    for (InlandTour inlandTour:inlandTours){
                        if ((inlandTour.getStartDate().getMonth()>month&&inlandTour.getStartDate().getYear()>=year)||(inlandTour.getStartDate().getYear()>year)||(inlandTour.getStartDate().getYear()>=year&&inlandTour.getStartDate().getMonth()>=month&&inlandTour.getStartDate().getDay()>day)&&inlandTour.getRegionInlandTours()!=null)
                            inlandTour.toString();
                    }
                    for (ForeignTour foreignTour:foreignTours){
                        if ((foreignTour.getStartDate().getMonth()>month&&foreignTour.getStartDate().getYear()>=year)||(foreignTour.getStartDate().getYear()>year)||(foreignTour.getStartDate().getYear()>=year&&foreignTour.getStartDate().getMonth()>=month&&foreignTour.getStartDate().getDay()>day)&&foreignTour.getRegionForeignTours()!=null)
                           foreignTour.toString();
                    }
                }else  if (ans==2){
                    System.out.println("Enter the date(year,month,day):");
                    int year=scanner.nextInt();
                    int month=scanner.nextInt();
                    int day=scanner.nextInt();
                    for (InlandTour inlandTour:inlandTours){
                        if ((inlandTour.getStartDate().getMonth()<month&&inlandTour.getStartDate().getYear()<=year)||(inlandTour.getStartDate().getYear()<year)||(inlandTour.getStartDate().getYear()<=year&&inlandTour.getStartDate().getMonth()<=month&&inlandTour.getStartDate().getDay()<day)&&inlandTour.getRegionInlandTours()!=null)
                            inlandTour.toString();
                    }
                    for (ForeignTour foreignTour:foreignTours){
                        if ((foreignTour.getStartDate().getMonth()<month&&foreignTour.getStartDate().getYear()<=year)||(foreignTour.getStartDate().getYear()<year)||(foreignTour.getStartDate().getYear()<=year&&foreignTour.getStartDate().getMonth()<=month&&foreignTour.getStartDate().getDay()<day)&&foreignTour.getRegionForeignTours()!=null)
                            foreignTour.toString();
                    }
                }else if (ans==3){
                    System.out.println("Enter the first date(year,month,day):");
                    int year1=scanner.nextInt();
                    int month1=scanner.nextInt();
                    int day1=scanner.nextInt();
                    System.out.println("Enter the last date(year,month,day):");
                    int year2=scanner.nextInt();
                    int month2=scanner.nextInt();
                    int day2=scanner.nextInt();
                    for (InlandTour inlandTour:inlandTours){
                        if (((inlandTour.getStartDate().getMonth()>month1&&inlandTour.getStartDate().getYear()>=year1)||(inlandTour.getStartDate().getYear()>year1)||(inlandTour.getStartDate().getYear()>=year1&&inlandTour.getStartDate().getMonth()>=month1&&inlandTour.getStartDate().getDay()>day1))&&
                                (inlandTour.getStartDate().getMonth()<month2&&inlandTour.getStartDate().getYear()<=year2)||(inlandTour.getStartDate().getYear()<year2)||(inlandTour.getStartDate().getYear()<=year2&&inlandTour.getStartDate().getMonth()<=month2&&inlandTour.getStartDate().getDay()<day2)&&inlandTour.getRegionInlandTours()!=null)
                            inlandTour.toString();
                    }
                    for (ForeignTour foreignTour:foreignTours){
                        if (((foreignTour.getStartDate().getMonth()>month1&&foreignTour.getStartDate().getYear()>=year1)||(foreignTour.getStartDate().getYear()>year1)||(foreignTour.getStartDate().getYear()>=year1&&foreignTour.getStartDate().getMonth()>=month1&&foreignTour.getStartDate().getDay()>day1))&&
                                (foreignTour.getStartDate().getMonth()<month2&&foreignTour.getStartDate().getYear()<=year2)||(foreignTour.getStartDate().getYear()<year2)||(foreignTour.getStartDate().getYear()<=year2&&foreignTour.getStartDate().getMonth()<=month2&&foreignTour.getStartDate().getDay()<day2)&&foreignTour.getRegionForeignTours()!=null)
                            foreignTour.toString();
                    }
                }
                break;
            case 3:
                System.out.println("How long do you want it take?");
                int period=scanner.nextInt();
                for (InlandTour inlandTour:inlandTours){
                    if (inlandTour.getPeriod()==period&&inlandTour.getRegionInlandTours()!=null)
                        inlandTour.toString();
                }
                for (ForeignTour foreignTour:foreignTours){
                    if (foreignTour.getPeriod()==period&&foreignTour.getRegionForeignTours()!=null)
                        foreignTour.toString();
                }
                break;
            case 4:
                System.out.println("Where do you want to visit?");
                String place=scanner.nextLine();
                for (InlandTour inlandTour:inlandTours){
                    if (inlandTour.getVisitedPlaces().contains(place)&&inlandTour.getRegionInlandTours()!=null){
                        System.out.println(inlandTour.getDestination()+" "+place);
                    }
                }
                for (ForeignTour foreignTour:foreignTours){
                    if (foreignTour.getVisitedCities().contains(place)&&foreignTour.getRegionForeignTours()!=null){
                        System.out.println(foreignTour.getDestination()+" "+place);
                    }
                }
                break;
            case 5:
                System.out.println("Enter the region you are looking for:");
                String region=scanner.nextLine();
                for (InlandTour inlandTour:inlandTours){
                    if (inlandTour.getDestination().getCityName().equals(region)&&inlandTour.getRegionInlandTours()!=null)
                    {
                        inlandTour.toString();
                    }
                }
                for (ForeignTour foreignTour:foreignTours){
                    if (foreignTour.getDestination().getCountryName().equals(region)&&foreignTour.getRegionForeignTours()!=null)
                    {
                        foreignTour.toString();
                    }
                }
                break;
            case 6:
                System.out.println("1-minim people,2-maximum people:");
                int answ=scanner.nextInt();
                if (answ==1){
                    System.out.println("1-Enter the minim number:");
                    int minim=scanner.nextInt();
                    System.out.println("1-Foreign tour,2-Inland tour:");
                    int res=scanner.nextInt();
                    if (res==1){
                        for (ForeignTour foreignTour:foreignTours)
                        {
                            if (foreignTour.getMinimPeople()==minim&&foreignTour.getRegionForeignTours()!=null)
                                foreignTour.toString();
                        }

                    }
                    else if (res==2){
                        for (InlandTour inlandTour:inlandTours){
                            if (inlandTour.getMinimPeople()==minim&&inlandTour.getRegionInlandTours()!=null)
                                inlandTour.toString();
                        }
                    }
                }else if (answ==2){
                    System.out.println("1-Enter the maximum number:");
                    int max=scanner.nextInt();
                    System.out.println("1-Foreign tour,2-Inland tour:");
                    int res=scanner.nextInt();
                    if (res==1){
                        for (ForeignTour foreignTour:foreignTours)
                        {
                            if (foreignTour.getMaximumPeople()==max&&foreignTour.getRegionForeignTours()!=null)
                                foreignTour.toString();
                        }
                    }
                    else if (res==2){
                        for (InlandTour inlandTour:inlandTours){
                            if (inlandTour.getMaximumPeople()==max&&inlandTour.getRegionInlandTours()!=null)
                                inlandTour.toString();
                        }
                    }
                }
                break;
            case 7:
                System.out.println("1-above a number,2-less than a number,3-between twe number,4-specific number");
                int choice=scanner.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("Enter the price:");
                        long price=scanner.nextLong();
                        for (InlandTour inlandTour:inlandTours){
                            if (inlandTour.getPrice()>price)
                                inlandTour.toString();
                        }
                        for (ForeignTour foreignTour:foreignTours){
                            if (foreignTour.getPrice()>price)
                                foreignTour.toString();
                        }
                        break;
                    case 2:
                        System.out.println("Enter the price:");
                        long price1=scanner.nextLong();
                        for (InlandTour inlandTour:inlandTours){
                            if (inlandTour.getPrice()<price1&&inlandTour.getRegionInlandTours()!=null)
                                inlandTour.toString();
                        }
                        for (ForeignTour foreignTour:foreignTours){
                            if (foreignTour.getPrice()<price1&&foreignTour.getRegionForeignTours()!=null)
                                foreignTour.toString();
                        }
                        break;
                    case 3:
                        System.out.println("Enter the minim price:");
                        long minim=scanner.nextLong();
                        System.out.println("Enter the maximum price:");
                        long max=scanner.nextLong();

                        for (InlandTour inlandTour:inlandTours){
                            if (inlandTour.getPrice()<max&&inlandTour.getPrice()>minim&&inlandTour.getRegionInlandTours()!=null)
                                inlandTour.toString();
                        }
                        for (ForeignTour foreignTour:foreignTours){
                            if (foreignTour.getPrice()<max && foreignTour.getPrice()>minim&&foreignTour.getRegionForeignTours()!=null)
                                foreignTour.toString();
                        }
                        break;
                    case 4:
                        System.out.println("Enter the price:");
                        long price3=scanner.nextLong();
                        for (InlandTour inlandTour:inlandTours){
                            if (inlandTour.getPrice()==price3&&inlandTour.getRegionInlandTours()!=null)
                                inlandTour.toString();
                        }
                        for (ForeignTour foreignTour:foreignTours){
                            if (foreignTour.getPrice()==price3&&foreignTour.getRegionForeignTours()!=null)
                                foreignTour.toString();
                        }

                        break;
                }
                break;
        }

    }
}
