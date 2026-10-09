import java.util.*;

// Problem 1: Garden Plot Area Report
abstract class Plot {
    private final String owner;

    Plot(String owner) { this.owner = owner; }

    String getOwner() { return owner; }

    abstract String shapeName();

    abstract double area();
}

class CirclePlot extends Plot {
    private final double radius;

    CirclePlot(String owner, double radius) { super(owner); this.radius = radius; }

    String shapeName() { return "CIRCLE"; }

    double area() { return Math.PI * radius * radius; }
}

class RectanglePlot extends Plot {
    private final double length, width;

    RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    String shapeName() { return "RECTANGLE"; }

    double area() { return length * width; }
}

class TrianglePlot extends Plot {
    private final double base, height;

    TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    String shapeName() { return "TRIANGLE"; }

    double area() { return 0.5 * base * height; }
}

public class Main {
    // Only place that knows about concrete shapes (input parsing).
    static Plot parse(Scanner sc) {
        String shape = sc.next();
        String owner = sc.next();
        switch (shape) {
            case "CIRCLE":    return new CirclePlot(owner, sc.nextDouble());
            case "RECTANGLE": return new RectanglePlot(owner, sc.nextDouble(), sc.nextDouble());
            case "TRIANGLE":  return new TrianglePlot(owner, sc.nextDouble(), sc.nextDouble());
            default: throw new IllegalArgumentException("Unknown shape: " + shape);
        }
    }

    // Report code depends only on Plot -> new shapes need no change here.
    static void report(List<Plot> plots) {
        double total = 0;
        for (Plot p : plots) {
            System.out.println(String.format(Locale.US, "%s (%s): %.2f", p.getOwner(), p.shapeName(), p.area()));
            total += p.area();
        }
        System.out.println(String.format(Locale.US, "Total Area: %.2f", total));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Plot> plots = new ArrayList<>();
        for (int i = 0; i < n; i++) plots.add(parse(sc));
        report(plots);
    }
}
