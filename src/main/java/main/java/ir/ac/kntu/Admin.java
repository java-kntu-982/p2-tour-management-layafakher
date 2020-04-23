package main.java.ir.ac.kntu;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Person{
    public void getAccess(ArrayList<InlandTour> inlandTours, ArrayList<ForeignTour> foreignTours, ArrayList<TourLeader>tourLeaders){
        System.out.println("1-See tour menu,2-See tour leaders menu,3-See maps,4-See regions,5-Information part");
        Scanner scanner=new Scanner(System.in);
        int result=scanner.nextInt();
        switch(result){
            case 1:
                TourMenu.tourMenu(inlandTours,foreignTours,tourLeaders);
                break;
            case 2:
                TourLeaderMenu.tourMenu(tourLeaders);
                break;
            case 3:
                Maps.map(inlandTours,foreignTours);
                break;
            case 4:
                Regions.region(inlandTours,foreignTours);
                break;
            case 5:

                break;
        }

    }
    public void editInformation(){
        System.out.println("1-Employee part,2-Client part,3-Tour leader part: ");
        Scanner scanner=new Scanner(System.in);
        int answer=scanner.nextInt();
        if (answer==1){
            System.out.println("1-Add an employee,2-Delete an employee,3-Edit an employee:");
            int result=scanner.nextInt();
            if (result==1){
                System.out.println("Enter the user name:");
                String userName=scanner.nextLine();
                System.out.println("Enter the password:");
                String password=scanner.nextLine();
                System.out.println("Enter employment date(year,month,day):");
                int year=scanner.nextInt();
                int month=scanner.nextInt();
                int day=scanner.nextInt();
                Date date=new Date(year,month,day);
                System.out.println("Enter the base salary:");
                int salary=scanner.nextInt();
                System.out.println("Enter the phone number:");
                String phone=scanner.nextLine();
                System.out.println("Enter an email:");
                String email=scanner.nextLine();
                Employee employee=new Employee(userName,password,date,salary);
                employee.phone=phone;
                employee.email=email;
                Main.employees.add(employee);
            }else if (result==2){
                System.out.println("Enter the user name:");
                String userName=scanner.nextLine();
                System.out.println("Enter the password:");
                String password=scanner.nextLine();
                for (Employee employee:Main.employees){
                    if (employee.userName.equals(userName)&&employee.password.equals(password)){
                        Main.employees.remove(employee);
                    }else {
                        System.out.println("Employee not found:");
                    }
                }
            }else if (result==3){
                System.out.println("Enter the user name:");
                String userName=scanner.nextLine();
                System.out.println("Enter the password:");
                String password=scanner.nextLine();
                for (Employee employee:Main.employees){
                    if (employee.userName.equals(userName)&&employee.password.equals(password)){
                        System.out.println("1-Edit user name,2-Edit password,3-Edit employment date,4-Edit base salary,5-Edit email address,6-Edit phone number: ");
                        int result1=scanner.nextInt();
                        switch (result1){
                            case 1:
                                System.out.println("Enter new user name:");
                                employee.userName= scanner.nextLine();
                                break;
                            case 2:
                                System.out.println("Enter your password:");
                                String oldPass1=scanner.nextLine();
                                if (oldPass1.equals(employee.password)){
                                    employee.password=oldPass1;
                                }else {
                                    System.out.println("Wrong password!");
                                }
                                break;
                            case 3:
                                System.out.println("Enter new date(year,month,day):");
                                int year=scanner.nextInt();
                                int month=scanner.nextInt();
                                int day=scanner.nextInt();
                                Date date1=new Date(year,month,day);
                                employee.setEmploymentDate(date1);
                                break;
                            case 4:
                                System.out.println("Enter new salary:");
                                int salary1=scanner.nextInt();
                                employee.setBaseSalary(salary1);
                                break;
                            case 5:
                                System.out.println("Enter new email address:");
                                employee.email= scanner.nextLine();
                                break;
                            case 6:
                                System.out.println("Enter new phone number:");
                                employee.phone= scanner.nextLine();
                                break;
                        }
                    }else {
                        System.out.println("Employee not found:");
                    }
            }

        }
    }
        else if (answer==2){
            System.out.println("1-Add a client,2-Delete a client,3-Edit a client:");
            int result=scanner.nextInt();
            if (result==1){
            System.out.println("Enter client user name");
            String userName=scanner.nextLine();
            System.out.println("Enter client password");
            String password=scanner.nextLine();
            System.out.println("Enter client phone number");
            String phone=scanner.nextLine();
            System.out.println("Enter client email");
            String email=scanner.nextLine();
            Client client=new Client(userName,password);
            client.email=email;
            client.phone=phone;
            Main.clients.add(client);}
            else if (result==2){

            }
        }
}
}
