import java.util.*;

public class HostelElectricity {
    interface Room {
        double bill();
        String getType();
    }

    static class SingleRoom implements Room {
        private final int units;
        SingleRoom(int units) { this.units = units; }
        public double bill() { return units * 8.0; }
        public String getType() { return "SINGLE"; }
    }

    static class SharedRoom implements Room {
        private final int units;
        private final int occupants;
        SharedRoom(int units, int occupants) {
            this.units = units;
            this.occupants = occupants;
        }
        public double bill() { return (units * 6.0) / occupants; }
        public String getType() { return "SHARED"; }
    }

    static class ACRoom implements Room {
        private final int units;
        ACRoom(int units) { this.units = units; }
        public double bill() { return units * 10.0 + 200.0; }
        public String getType() { return "AC"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Room> rooms = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            if (type.equals("SINGLE")) rooms.add(new SingleRoom(units));
            else if (type.equals("SHARED")) rooms.add(new SharedRoom(units, sc.nextInt()));
            else rooms.add(new ACRoom(units));
        }

        for (Room room : rooms) {
            double bill = room.bill();
            System.out.printf("%s: %.2f%n", room.getType(), bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
