import java.util.*;

public class CampusParking {
    interface Vehicle {
        double charge();
        String getType();
    }

    static class Bike implements Vehicle {
        private final int hours;
        Bike(int hours) { this.hours = hours; }
        public double charge() { return hours * 10.0; }
        public String getType() { return "BIKE"; }
    }

    static class Car implements Vehicle {
        private final int hours;
        Car(int hours) { this.hours = hours; }
        public double charge() { return 30.0 + (hours - 1) * 20.0; }
        public String getType() { return "CAR"; }
    }

    static class Truck implements Vehicle {
        private final int hours;
        Truck(int hours) { this.hours = hours; }
        public double charge() { return Math.max(100.0, hours * 50.0); }
        public String getType() { return "TRUCK"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Vehicle> vehicles = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();

            if (type.equals("BIKE")) vehicles.add(new Bike(hours));
            else if (type.equals("CAR")) vehicles.add(new Car(hours));
            else vehicles.add(new Truck(hours));
        }

        for (Vehicle vehicle : vehicles) {
            double charge = vehicle.charge();
            System.out.printf("%s: %.2f%n", vehicle.getType(), charge);
            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
