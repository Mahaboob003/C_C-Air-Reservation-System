import java.util.*;

public class AirlineReservationSystem {
    private static final int NUMBER_OF_SEATS = 10;
    private static boolean[] seats = new boolean[NUMBER_OF_SEATS];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("1. Show number of available seats");
            System.out.println("2. Book a seat");
            System.out.println("3. Cancel a booking");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    showAvailableSeats();
                    break;
                case 2:
                    bookSeat();
                    break;
                case 3:
                    cancelBooking();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    private static void showAvailableSeats() {
        int availableSeats = 0;
        for (boolean seat : seats) {
            if (!seat) {
                availableSeats++;
            }
        }
        System.out.println("Number of available seats: " + availableSeats);
    }

    private static void bookSeat() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the seat number you want to book (1-10): ");
        int seatNumber = input.nextInt();

        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number");
            return;
        }

        if (seats[seatNumber - 1]) {
            System.out.println("Seat already booked");
        } else {
            seats[seatNumber - 1] = true;
            System.out.println("Seat booked successfully");
        }
    }

    private static void cancelBooking() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the seat number you want to cancel (1-10): ");
        int seatNumber = input.nextInt();

        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number");
            return;
        }

        if (!seats[seatNumber - 1]) {
            System.out.println("Seat not booked");
        } else {
            seats[seatNumber - 1] = false;
            System.out.println("Booking cancelled successfully");
        }
    }
}
