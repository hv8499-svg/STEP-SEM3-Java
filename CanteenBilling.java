import java.util.*;

public class CanteenBilling {
    interface Bill {
        double finalAmount();
        String getType();
    }

    static class StudentBill implements Bill {
        private final double amount;
        StudentBill(double amount) { this.amount = amount; }
        public double finalAmount() { return amount * 0.90; }
        public String getType() { return "STUDENT"; }
    }

    static class StaffBill implements Bill {
        private final double amount;
        StaffBill(double amount) { this.amount = amount; }
        public double finalAmount() { return amount * 0.95; }
        public String getType() { return "STAFF"; }
    }

    static class GuestBill implements Bill {
        private final double amount;
        GuestBill(double amount) { this.amount = amount; }
        public double finalAmount() { return amount + 10; }
        public String getType() { return "GUEST"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Bill> bills = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            if (type.equals("STUDENT")) bills.add(new StudentBill(amount));
            else if (type.equals("STAFF")) bills.add(new StaffBill(amount));
            else bills.add(new GuestBill(amount));
        }

        for (Bill bill : bills) {
            double amount = bill.finalAmount();
            System.out.printf("%s: %.2f%n", bill.getType(), amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
