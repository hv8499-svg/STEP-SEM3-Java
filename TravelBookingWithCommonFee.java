import java.util.*;

// Problem 5: Travel Booking with a Common Fee
abstract class Booking {
    // The booking fee lives in exactly ONE place.
    static final double BOOKING_FEE = 50;

    protected final double distanceKm;

    Booking(double distanceKm) { this.distanceKm = distanceKm; }

    abstract String modeName();

    abstract double baseFare();

    // Template method: shared fee added once; subclasses cannot override it.
    final double totalFare() { return baseFare() + BOOKING_FEE; }
}

class BusBooking extends Booking {
    BusBooking(double d) { super(d); }

    String modeName() { return "BUS"; }

    double baseFare() { return 2 * distanceKm; }
}

class TrainBooking extends Booking {
    TrainBooking(double d) { super(d); }

    String modeName() { return "TRAIN"; }

    double baseFare() { return 1.5 * distanceKm; }
}

class FlightBooking extends Booking {
    FlightBooking(double d) { super(d); }

    String modeName() { return "FLIGHT"; }

    double baseFare() { return 2500 + 4 * distanceKm; }
}

public class TravelBookingWithCommonFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double km = sc.nextDouble();
            Booking b;
            switch (mode) {
                case "BUS":    b = new BusBooking(km); break;
                case "TRAIN":  b = new TrainBooking(km); break;
                case "FLIGHT": b = new FlightBooking(km); break;
                default: throw new IllegalArgumentException("Unknown mode: " + mode);
            }
            System.out.println(String.format(Locale.US, "%s: %.2f", b.modeName(), b.totalFare()));
        }
    }
}
