import java.util.*;

// Problem 2: Weekly Staff Pay
abstract class Staff {
    private final String name;

    Staff(String name) { this.name = name; }

    String getName() { return name; }

    abstract double calculatePay();
}

class FullTimeStaff extends Staff {
    private final double weeklySalary;

    FullTimeStaff(String name, double weeklySalary) { super(name); this.weeklySalary = weeklySalary; }

    double calculatePay() { return weeklySalary; }
}

class HourlyStaff extends Staff {
    private final double hours, rate;

    HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    double calculatePay() {
        if (hours <= 40) return hours * rate;
        return 40 * rate + (hours - 40) * rate * 1.5;
    }
}

class Intern extends Staff {
    private final double stipend;

    Intern(String name, double stipend) { super(name); this.stipend = stipend; }

    double calculatePay() { return stipend; }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Staff s;
            switch (type) {
                case "FULLTIME": s = new FullTimeStaff(name, sc.nextDouble()); break;
                case "HOURLY":   s = new HourlyStaff(name, sc.nextDouble(), sc.nextDouble()); break;
                case "INTERN":   s = new Intern(name, sc.nextDouble()); break;
                default: throw new IllegalArgumentException("Unknown staff type: " + type);
            }
            double pay = s.calculatePay();
            System.out.println(String.format(Locale.US, "%s: %.2f", s.getName(), pay));
            total += pay;
        }
        System.out.println(String.format(Locale.US, "Total Payroll: %.2f", total));
    }
}
