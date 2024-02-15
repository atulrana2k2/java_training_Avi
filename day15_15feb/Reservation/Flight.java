package Reservation;

public class Flight {
    int FlightNumber;
    String DepartureC;
    String DestinationC;
    int availSeats;

    public Flight(int flightNumber, String departureC, String destinationC, int availSeats) {
        FlightNumber = flightNumber;
        DepartureC = departureC;
        DestinationC = destinationC;
        this.availSeats = availSeats;
    }
}
