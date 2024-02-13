import java.sql.ClientInfoStatus;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Vechile{
     String make;
    String model;
    int year;
    double rental_price;

    public Vechile(String make, String model, int year, double rental_price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.rental_price = rental_price;
    }


}
class Car extends Vechile{
    private int num_seats;
    private String fuel_type;

    public Car(String make, String model, int year, double rental_price, int num_seats, String fuel_type) {
        super(make, model, year, rental_price);
        this.num_seats = num_seats;
        this.fuel_type = fuel_type;
    }


}
class Customer{
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;

    }

    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }

}

public class carrent_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Vechile> vechiles = new ArrayList<>();
        List<Customer> coustomers = new ArrayList<>();
        List<Vechile> rented = new ArrayList<>();
        while (true) {
            System.out.println("OPTIONS");
            System.out.println("1.Enter Vechiles");
            System.out.println("2. Vehicle Available for Rent:");
            System.out.println("3. Add customer:");
            System.out.println("4. View Registered customers");
            System.out.println("5. Rent Vehicle");
            System.out.println("6. Return Vehicle");
            System.out.println("7. Exist the system");
            System.out.println("8. Enter Your choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Car vechile = addvechile(sc);
                    if (vechile != null)
                        vechiles.add(vechile);
                    System.out.println("Vehicle added successfully");
                    break;
                case 2: {
                    if (!vechiles.isEmpty()) {
                        System.out.println("Vehicles available for rent:");
                        int i=1;
                        for (Vechile present : vechiles) {
                            System.out.println((i++)+" : "+"COMPANY : "+present.make + "\n\tCAR NAME : " + present.model + "\n\tRENT(PER DAY) : " + present.rental_price);
                        }
                    } else
                        System.out.println("No Vehicles are available for Rent");
                    break;
                }
                case 3:
                    Customer customer = addcustomer(sc);
                    if (customer != null)
                        coustomers.add(customer);
                    System.out.println("Customer added successfully");
                    break;
                case 4: {
                    if (!coustomers.isEmpty()) {
                        System.out.println("Registered customers are :");
                        int i=1;
                        for (Customer present : coustomers) {
                            System.out.println((i++)+" : "+"Name : " + present.getName() + "\n\tEmail : " + present.getEmail());
                        }
                    } else
                        System.out.println("No Registered Customer");
                    break;
                }
                case 5:
                    boolean userr = false;
                    System.out.println("Enter your registerd email:");
                    String email = sc.next();
                    for (Customer rcustomer : coustomers) {
                        if (rcustomer.getEmail().equalsIgnoreCase(email)) {
                            userr = true;
                            System.out.println("Enter the vehicle model(name of Vehicle)");
                            String vechilemodel = sc.next();
                            boolean flag = false;
                            for (Vechile entry : vechiles) {
                                if (entry.model.equalsIgnoreCase(vechilemodel)) {
                                    System.out.println("Vechile Rented to " + rcustomer.getName() + " " + entry.make + " : " + entry.model);
                                    System.out.print("Enter the number of day you want to rent the Vechile:");
                                    int days = sc.nextInt();
                                    System.out.println("Total rent=" + entry.rental_price * days);
                                    flag = true;
                                    rented.add(entry);
                                    vechiles.remove(entry);
                                    break;

                                } else
                                    System.out.println("Vehicle not found");
                                if (flag == false)
                                    System.out.println("No vehicle found ");


                            }
                        }
                    }
                    if (userr == false)
                        System.out.println("you are not registered user register first to rent a vechile");

                    break;
                case 6:
                    boolean returnv = false;
                    System.out.println("Enter your registerd email:");
                    String email1 = sc.next();
                    for (Customer r1customer : coustomers) {
                        if (r1customer.getEmail().equalsIgnoreCase(email1)) {
                            System.out.println("Enter the vehicle model you want to return:");
                            String vehiclemodel2 = sc.next();
                            boolean flag2 = false;
                            for (Vechile check : rented) {
                                if (check.model.equalsIgnoreCase(vehiclemodel2)) {
                                    System.out.println("vehcile " + check.make + " " + check.model + " is  returned");
                                    rented.remove(check);
                                    vechiles.add(check);
                                    returnv = true;
                                    break;


                                } else
                                    System.out.println("Vehicle is not rented ");
                            }
                        }
                    }
                    if (!returnv)
                        System.out.println("Your are not a registerd customer");
                    break;
                case 7:
                    System.out.println("Exiting");
                    System.exit(0);



            }
        }
    }
    public  static Car addvechile(Scanner sc)
    {
        System.out.println("Enter the Make ( COMPANY ) :");
        String model= sc.next();
        sc.nextLine();
        System.out.println("Enter the model (NAME OF CAR ) :");
        String make= sc.next();
        sc.nextLine();
        System.out.println("Enter the year of manufacturing :");
        int year= sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Rent price per day:");
        double price= sc.nextDouble();
        System.out.println("Enter number of Seats:");
        int seats= sc.nextByte();
        sc.nextLine();
        System.out.println("Enter type of fuel: Diesel(D) Petrol(P) (CNG) :");
        String fuel= sc.next();
        sc.nextLine();
        return new Car(model,make,year,price,seats,fuel);
    }
    public static Customer addcustomer(Scanner sc)
    {
        System.out.println("Enter the customer Name:");
        String name= sc.next();
        sc.nextLine();
        System.out.println("Enter the email id of the customer:");
        String emailid= sc.next();
        sc.nextLine();
        return new Customer(name,emailid);
    }
}
