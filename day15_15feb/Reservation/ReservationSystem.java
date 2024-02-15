package Reservation;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ReservationSystem {                                                            //Main class
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Flight> flights = new ArrayList<>();
        Flight f1 = new Flight(1001, "Delhi", "Mumbai", 75);            //adding some Flights in Class
        Flight f2 = new Flight(1002, "Delhi", "Chennai", 50);
        Flight f3 = new Flight(1003, "Delhi", "Kolkata", 25);
        flights.add(f1);
        flights.add(f2);
        flights.add(f3);
        List<Flight> booked = new ArrayList<>();                        //making a list of booked flight of type Flight
        while (true) {

            System.out.println("        OPTIONS          ");
            System.out.println("1: For Adding Flight");
            System.out.println("2: For viewing Existing Flight");
            System.out.println("3. For Reserving Flight");
            System.out.println("4. For cancelling a Flight");
            System.out.println("5. Exit The system");
            System.out.println("Enter Your Choice");
            try {                                                                           //using try catch for and Exception
                int choice = sc.nextByte();
                if (choice > 5) {
                    throw new InputMismatchException();
                }
                switch (choice) {
                    case 1:

                        Flight flight = addFlight(sc, flights);
                        if (flight != null) {
                            flights.add(flight);
                        }
                        break;
                    case 2:
                        display(flights);
                        break;
                    case 3:
                        reserve(sc, flights, booked);
                        break;
                    case 4:
                        cancel(sc, booked);
                        break;
                    case 5:
                        System.out.println("Existing System");
                        System.exit(0);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input (SELECT A VALID OPTION) ");
            }
            sc.nextLine();
        }
    }

    public static Flight addFlight(Scanner sc, List<Flight> flights) {                      //function to add a flight in the system
        try {
            System.out.println("Enter FlightNumber : ");
            int no = sc.nextInt();
            try {                                                                           //checking for already existing flight number
                for (Flight flight : flights) {
                    if (flight.FlightNumber == no) {
                        throw new InputMismatchException();
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Flight Number Already Exist in Flights");
                return null;
            }
            sc.nextLine();
            System.out.println("Entre Departure City : ");
            String dCity = sc.next();
            sc.nextLine();
            System.out.println("Enter Destination City : ");
            String desCity = sc.next();
            sc.nextLine();
            System.out.println("Enter Available Seats : ");
            int Seats = sc.nextInt();
            sc.nextLine();
            if (Seats < 1) {                                                                            //checking for exception no of seats less than 1
                throw new ReservationException(Seats);
            }
            sc.nextLine();
            return new Flight(no, dCity, desCity, Seats);
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input");
            return null;
        } catch (ReservationException e) {
            System.out.println("Invalid Input for seats");
            return null;


        }
    }


    public static void display( List<Flight> flights) {                  //function to display the available seats
        if (flights.isEmpty())
            System.out.println("No Flights Exist");
        else {
            System.out.println("Existing Flights :\n");
            for (Flight flight : flights) {
                System.out.println("Flight Number : " + flight.FlightNumber + "\nFlight Departure City : " + flight.DepartureC
                        + "\nFlight Destination : " + flight.DestinationC + "\nFlight Available Seats : " + flight.availSeats);
                System.out.println();
            }
        }

    }

    public static void reserve(Scanner sc, List<Flight> flights, List<Flight> booked) {     //function to reserve Seats in an existing flight
        try {
            System.out.println("Enter The Flight Number You want to reverse :");
            int no = sc.nextInt();
            for (Flight flight : flights) {
                if (flight.FlightNumber == no) {
                    System.out.println("Enter No. of Seats you want to reserve");
                    int seats = sc.nextInt();

                    try {                                                                   //checking exception for reserving seats
                        if (flight.availSeats <= 0) {
                            throw new ReservationException(seats);
                        } else if (seats > flight.availSeats) {
                            throw new ReservationException(seats);
                        } else if (seats <= 0) {
                            throw new ReservationException(seats);
                        }

                        System.out.println("You Reservation is successful for " + seats + "  seats in Flight Number  " +
                                flight.FlightNumber+" Going from "+flight.DepartureC+" to "+flight.DestinationC);
                        flight.availSeats -= seats;
                        Flight flightB = new Flight(flight.FlightNumber, flight.DepartureC, flight.DestinationC, seats);
                        booked.add(flightB);
                        return;
                    } catch (ReservationException e) {
                        System.out.println(e.error(flight));
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Flight ticket are not Reserved");
    }
    public static void cancel(Scanner sc,List<Flight>booked) {              //function to cancel reserved seats
    try{
        System.out.println("Enter the Flight Number whose ticket you  want to Cancel");
        int no = sc.nextInt();
        boolean flag = false;
        for (Flight flight : booked) {
            if (flight.FlightNumber == no) {                            //checking for flight no hava any booking or not
                flag = true;
                System.out.println("Enter No of Seats You want to cancel");
                int seats = sc.nextInt();

                try {                                                                       //checking for invalid seats exceptions
                    if (seats > flight.availSeats)
                        throw new ReservationException(seats);
                    else if (seats <= 0)
                        throw new ReservationException(seats);
                    System.out.println("You Canceled " + seats + " from " + flight.availSeats + " Booked seats");
                    flight.availSeats -= seats;
                } catch (ReservationException e) {
                    System.out.println(e.error(flight));
                }
            }
        }
        if(!flag)
        {
            System.out.println("Flight Number not have any bookings");
        }
    }
    catch (InputMismatchException e)
    {
        System.out.println(e.getMessage());
    }
    }

}