package mountain;

public class Side {
    private final Point a, b;

    public Side(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public Point getStart() {
        return a;
    }

    public Point getEnd() {
        return b;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Side s = (Side) obj;

        return (a.equals(s.getStart()) && b.equals(s.getEnd())) ||
                (a.equals(s.getEnd()) && b.equals(s.getStart()));
    }
    @Override
    public int hashCode() {
        return a.hashCode() + b.hashCode();
    }
}