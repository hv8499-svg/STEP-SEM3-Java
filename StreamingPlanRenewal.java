import java.time.LocalDate;
import java.util.*;

public class StreamingPlanRenewal {
    interface Plan {
        LocalDate renewalDate();
        String getName();
    }

    static class BasicPlan implements Plan {
        private final String name;
        private final LocalDate startDate;
        BasicPlan(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }
        public LocalDate renewalDate() { return startDate.plusDays(30); }
        public String getName() { return name; }
    }

    static class StandardPlan implements Plan {
        private final String name;
        private final LocalDate startDate;
        StandardPlan(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }
        public LocalDate renewalDate() { return startDate.plusDays(90); }
        public String getName() { return name; }
    }

    static class PremiumPlan implements Plan {
        private final String name;
        private final LocalDate startDate;
        PremiumPlan(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }
        public LocalDate renewalDate() { return startDate.plusDays(365); }
        public String getName() { return name; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Plan> plans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            if (type.equals("BASIC")) plans.add(new BasicPlan(name, startDate));
            else if (type.equals("STANDARD")) plans.add(new StandardPlan(name, startDate));
            else plans.add(new PremiumPlan(name, startDate));
        }

        for (Plan plan : plans) {
            System.out.println(plan.getName() + ": " + plan.renewalDate());
        }

        sc.close();
    }
}
