import java.util.*;

public class FestivalBonus {
    interface Employee {
        double bonus();
        String getName();
    }

    static class FullTimeEmployee implements Employee {
        private final String name;
        private final double salary;
        FullTimeEmployee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }
        public double bonus() { return salary * 0.10; }
        public String getName() { return name; }
    }

    static class PartTimeEmployee implements Employee {
        private final String name;
        private final double salary;
        PartTimeEmployee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }
        public double bonus() { return salary * 0.05; }
        public String getName() { return name; }
    }

    static class Intern implements Employee {
        private final String name;
        Intern(String name, double salary) { this.name = name; }
        public double bonus() { return 2000.0; }
        public String getName() { return name; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Employee> employees = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            if (type.equals("FULLTIME")) employees.add(new FullTimeEmployee(name, salary));
            else if (type.equals("PARTTIME")) employees.add(new PartTimeEmployee(name, salary));
            else employees.add(new Intern(name, salary));
        }

        for (Employee employee : employees) {
            double bonus = employee.bonus();
            System.out.printf("%s: %.2f%n", employee.getName(), bonus);
            total += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", total);
        sc.close();
    }
}
