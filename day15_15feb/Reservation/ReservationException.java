package Reservation;

public class ReservationException extends Exception{
        int seats;

    public ReservationException(int seats) {
        this.seats = seats;
    }

    String error(Flight flight)
    {
            if(seats>flight.availSeats)

            {
                return "Seats  you wanted are Not Available for this Flight";
            }
            if(seats<=0)
            {
                return "Invalid Input for Seats (Seats cannot be zero or Negative";
            }
            else
                return null;
    }


}
