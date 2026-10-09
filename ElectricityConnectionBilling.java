import java.util.*;

// Problem 4: Electricity Connection Billing
abstract class Connection {
    protected final double units;

    Connection(double units) { this.units = units; }

    abstract String typeName();

    abstract double calculateBill();
}

class HomeConnection extends Connection {
    HomeConnection(double units) { super(units); }

    String typeName() { return "HOME"; }

    double calculateBill() {
        if (units <= 100) return units * 5;
        return 100 * 5 + (units - 100) * 7;
    }
}

class ShopConnection extends Connection {
    ShopConnection(double units) { super(units); }

    String typeName() { return "SHOP"; }

    double calculateBill() { return units * 8 + 100; }
}

class FactoryConnection extends Connection {
    FactoryConnection(double units) { super(units); }

    String typeName() { return "FACTORY"; }

    double calculateBill() { return Math.max(units * 6, 1000); }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();
            Connection c;
            switch (type) {
                case "HOME":    c = new HomeConnection(units); break;
                case "SHOP":    c = new ShopConnection(units); break;
                case "FACTORY": c = new FactoryConnection(units); break;
                default: throw new IllegalArgumentException("Unknown connection type: " + type);
            }
            double bill = c.calculateBill();
            System.out.println(String.format(Locale.US, "%s: %.2f", c.typeName(), bill));
            total += bill;
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
