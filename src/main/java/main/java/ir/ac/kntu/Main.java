package main.java.ir.ac.kntu;

import main.java.ir.ac.kntu.maputil.MapUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Client> clients=new ArrayList<>();
    public static ArrayList<Employee> employees=new ArrayList<>();
    public static ArrayList<Admin> admins=new ArrayList<>();

    public static void main(String[] args) {
        Place place=new Place("Moscow","Russia");
        Place place1=new Place("Canberra","Australia");
        Place place2=new Place("Beijing","China");
        Place place3=new Place("Paris","France");
        Place place4=new Place("Rome","Italy");
        Place place5=new Place("Madrid","Spain");
        Place place6=new Place("Istanbul","Turkey");
        Place place7=new Place("Shiraz","Iran");
        Place place8=new Place("Isfahan","Iran");
        Place place9=new Place("Mashhad","Iran");
        Place place10=new Place("Tabriz","Iran");
        Place place11=new Place("Tehran","Iran");
        ArrayList<Place>places=new ArrayList<>();
        places.add(place);places.add(place1);places.add(place2);places.add(place3);places.add(place4);places.add(place5);places.add(place6);places.add(place7);places.add(place8);places.add(place9);places.add(place10);places.add(place11);
        ArrayList<String>visitedPlaces=new ArrayList<>();
        visitedPlaces.add("Persepolis");visitedPlaces.add("Eram garden");visitedPlaces.add("Tomb of Hafez");visitedPlaces.add("Pasargadae");
        ArrayList<String>strings=new ArrayList<>();
        strings.add("Siosepol");strings.add("Naqsh-e-Jahan Square");strings.add("Grand Bazaar");strings.add("Jameh Mosque");
        ArrayList<String>strings1=new ArrayList<>();
        strings1.add("Imam reza holy shrine");strings1.add("kooh sangi park");strings1.add("Mellat park");strings1.add("Kang village");strings1.add("Miniature Park");
        ArrayList<String>strings2=new ArrayList<>();
        strings2.add("Tabriz Bazaar");strings2.add("Blue Mosque");strings2.add("Tabriz citadel");
        ArrayList<Place>places1=new ArrayList<>();
        places1.add(new Place("Kazan","Russia"));places1.add(new Place("saint petersburg","Russia"));places1.add(new Place("Moscow","Russia"));
        ArrayList<Place>places2=new ArrayList<>();
        places2.add(new Place("Nice","France"));places2.add(new Place("Marseille","France"));places2.add(new Place("Paris","France"));
        TourLeader tourLeader=new TourLeader("Sam","Emit","4477",1234,19,new Date(1379,10,3),new Date(1399,1,20),false,places);
        TourLeader tourLeader1=new TourLeader("john","bert","4586",1235,25,new Date(1373,10,3),new Date(1399,1,19),true,places);
        TourLeader tourLeader2=new TourLeader("lia","herd","8574",1236,25,new Date(1373,10,3),new Date(1399,1,17),false,places);
        TourLeader tourLeader3=new TourLeader("Mary","bell","4456",1237,25,new Date(1373,10,3),new Date(1399,1,18),true,places);
        TourLeader tourLeader4=new TourLeader("Jack","watson","4346",1568,26,new Date(1374,2,5),new Date(1399,1,10),false,places);
        ArrayList<TourLeader> tourLeaders=new ArrayList<>();
        tourLeaders.add(tourLeader);tourLeaders.add(tourLeader1);tourLeaders.add(tourLeader2);tourLeaders.add(tourLeader3);tourLeaders.add(tourLeader4);
        InlandTour inlandTour=new InlandTour("1",200,4,new Date(1399,5,4),place11,place7,20,100,visitedPlaces);
        InlandTour inlandTour1=new InlandTour("2",180,4,new Date(1399,2,3),place11,place8,30,100,strings);
        InlandTour inlandTour2=new InlandTour("3",250,5,new Date(1399,6,8),place11,place9,50,200,strings1);
        InlandTour inlandTour3=new InlandTour("4",250,5,new Date(1399,6,8),place11,place10,20,100,strings2);
        ArrayList<InlandTour>inlandTours=new ArrayList<>();
        inlandTours.add(inlandTour);inlandTours.add(inlandTour1);inlandTours.add(inlandTour2);inlandTours.add(inlandTour3);
        ForeignTour foreignTour=new ForeignTour("11",500,new Date(1399,2,15),7,place11,place,places1,30,150);
        ForeignTour foreignTour1=new ForeignTour("12",400,new Date(1399,3,11),6,place11,place3,places2,25,170);
        ArrayList<ForeignTour>foreignTours=new ArrayList<>();
        foreignTours.add(foreignTour);foreignTours.add(foreignTour1);
        Admin admin2=new Admin("laya","1234");
        Admin admin1=new Admin("ali","1235");
        admins.add(admin2);admins.add(admin1);
        Client client2=new Client("leila","1236");
        Client client1=new Client("parsa","1237");
        clients.add(client2);clients.add(client1);
        Employee employee1=new Employee("sara","1238",new Date(1380,10,3),1200);
        Employee employee2=new Employee("sina","1239",new Date(1380,10,3),1200);
        employees.add(employee1);employees.add(employee2);
        Scanner scanner1=new Scanner(System.in);
        while (true){
            System.out.println("Press 1 to log in as an Admin:");
            System.out.println("Press 2 to log in as an employee:");
            System.out.println("Press 3 to log in as a client:");
            System.out.println("Press 4 to log in as a tour leader:");
            System.out.println("Press 5 to back to menu:");
            System.out.println("Press 6 to exit:");


            int result1=scanner1.nextInt();
            switch (result1){
                case 1:
                    System.out.println("1-Sign in,2-Sign up");
                    int adminResult=scanner1.nextInt();
                    if (adminResult==1){
                        System.out.println("Enter the user name:");
                        String userName=scanner1.nextLine();
                        System.out.println("Enter the password:");
                        String password=scanner1.nextLine();
                        for (Admin admin:admins){
                            if (admin.password.equals(password)&&admin.userName.equals(userName)){
                                admin.getAccess(inlandTours,foreignTours,tourLeaders);
                            }else {
                                System.out.println("Admin not found");
                            }

                        }
                    }else if (adminResult==2){
                        System.out.println("Enter admin user name");
                        String userName=scanner1.nextLine();
                        System.out.println("Enter admin password");
                        String password=scanner1.nextLine();
                        System.out.println("Enter admin phone number");
                        String phone=scanner1.nextLine();
                        System.out.println("Enter admin email");
                        String email=scanner1.nextLine();
                        Admin admin=new Admin(userName,password);
                        admin.email=email;
                        admin.phone=phone;
                        admins.add(admin);
                    }
                    break;
                case 2:
                    System.out.println("1-Sign in,2-Sign up");
                    int employeeResult=scanner1.nextInt();
                    if (employeeResult==1){
                        System.out.println("Enter the user name:");
                        String userName=scanner1.nextLine();
                        System.out.println("Enter the password:");
                        String password=scanner1.nextLine();
                        for (Employee employee:employees){
                            if (employee.password.equals(password)&&employee.userName.equals(userName)){
                                employee.getAccess(inlandTours,foreignTours,tourLeaders);
                            }else {
                                System.out.println("Employee not found");
                            }

                        }
                    }else if (employeeResult==2){
                        System.out.println("Enter employee user name");
                        String userName=scanner1.nextLine();
                        System.out.println("Enter employee password");
                        String password=scanner1.nextLine();
                        System.out.println("Enter employee phone number");
                        String phone=scanner1.nextLine();
                        System.out.println("Enter employee email");
                        String email=scanner1.nextLine();
                        System.out.println("Enter employment date(year,month,day):");
                        int year=scanner1.nextInt();
                        int month=scanner1.nextInt();
                        int day=scanner1.nextInt();
                        Date date=new Date(year,month,day);
                        System.out.println("Enter the base salary:");
                        int salary=scanner1.nextInt();
                        Employee employee=new Employee(userName,password,date,salary);
                        employee.email=email;
                        employee.phone=phone;
                    }
                    break;
                case 3:
                    System.out.println("1-Sign in,2-Sign up");
                    int clientResult=scanner1.nextInt();
                    if (clientResult==1){
                        System.out.println("Enter the user name:");
                        String userName=scanner1.nextLine();
                        System.out.println("Enter the password:");
                        String password=scanner1.nextLine();
                        for (Client client:clients){
                            if (client.password.equals(password)&&client.userName.equals(userName)){
                                client.getAccess(inlandTours,foreignTours,tourLeaders);
                            }else {
                                System.out.println("Admin not found");
                            }

                        }
                    }else if (clientResult==2){
                        System.out.println("Enter client user name");
                        String userName=scanner1.nextLine();
                        System.out.println("Enter client password");
                        String password=scanner1.nextLine();
                        System.out.println("Enter client phone number");
                        String phone=scanner1.nextLine();
                        System.out.println("Enter client email");
                        String email=scanner1.nextLine();
                        Client client=new Client(userName,password);
                        client.email=email;
                        client.phone=phone;
                    }
                    break;
                case 4:
                    System.out.println("1-Sign in,2-Sign up");
                    int tourleaderResult=scanner1.nextInt();
                    if (tourleaderResult==1){
                        System.out.println("Enter the user name:");
                        String userName=scanner1.nextLine();
                        System.out.println("Enter the password:");
                        String password=scanner1.nextLine();
                        for (TourLeader tourLeader6:tourLeaders){
                            if (tourLeader6.password.equals(password)&&tourLeader6.userName.equals(userName)){
                                tourLeader6.getAccess(inlandTours,foreignTours,tourLeaders);
                            }else {
                                System.out.println("Admin not found");
                            }

                        }
                    }else if (tourleaderResult==2){
                        System.out.println("Enter client user name");
                        String userName=scanner1.nextLine();
                        System.out.println("Enter client password");
                        String password=scanner1.nextLine();
                        System.out.println("Enter client phone number");
                        String phone=scanner1.nextLine();
                        System.out.println("Enter client email");
                        String email=scanner1.nextLine();
                        TourLeader tourLeader7=new TourLeader(userName,password);
                        tourLeader7.email=email;
                        tourLeader7.phone=phone;
                        tourLeaders.add(tourLeader7);
                    }
                    break;
                case 5:
                    continue;
            }
            if (result1==6)
                break;
        }
    }
}
