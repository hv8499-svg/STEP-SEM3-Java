import java.util.*;

// Problem 3: Library Late Fine Counter
abstract class LibraryItem {
    private final String title;
    protected final int daysLate;

    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    String getTitle() { return title; }

    abstract double calculateFine();
}

class Book extends LibraryItem {
    Book(String title, int daysLate) { super(title, daysLate); }

    double calculateFine() { return 2.0 * daysLate; }
}

class Dvd extends LibraryItem {
    Dvd(String title, int daysLate) { super(title, daysLate); }

    double calculateFine() { return Math.min(5.0 * daysLate, 50.0); }
}

class Magazine extends LibraryItem {
    Magazine(String title, int daysLate) { super(title, daysLate); }

    double calculateFine() { return 1.0 * daysLate; }
}

public class LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int days = sc.nextInt();
            LibraryItem item;
            switch (type) {
                case "BOOK":     item = new Book(title, days); break;
                case "DVD":      item = new Dvd(title, days); break;
                case "MAGAZINE": item = new Magazine(title, days); break;
                default: throw new IllegalArgumentException("Unknown item type: " + type);
            }
            double fine = item.calculateFine();
            System.out.println(String.format(Locale.US, "%s: %.2f", item.getTitle(), fine));
            total += fine;
        }
        System.out.println(String.format(Locale.US, "Total Fines: %.2f", total));
    }
}
