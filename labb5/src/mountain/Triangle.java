package mountain;

import fractal.*;

import java.util.HashMap;

public class Triangle extends Fractal {
    private final Point a;
    private final Point b;
    private final Point c;
    private double rand;
    private HashMap<Side, Point> map;

    public Triangle(Point a, Point b, Point c, double rand) {
        super();
        this.a = a;
        this.b = b;
        this.c = c;
        this.rand = rand;
        map = new HashMap<>();
    }

    @Override
    public String getTitle() {
        return "Triangle fractal";
    }

    @Override
    public void draw(TurtleGraphics turtle) {
        fractalLine(turtle, super.getOrder(), a, b, c);
    }

    private void fractalLine(TurtleGraphics turtle, int order, Point A, Point B, Point C) {
        turtle.penDown();
        if (order == 0) {
            turtle.moveTo(A.getX(), A.getY());
            turtle.forwardTo(B.getX(), B.getY());
            turtle.forwardTo(C.getX(), C.getY());
            turtle.forwardTo(A.getX(), A.getY());
        } else {
            Side a_b = new Side(A, B);
            Side b_c = new Side(B, C);
            Side c_a = new Side(C, A);
            Point AB = middlePoint(a_b);
            Point BC = middlePoint(b_c);
            Point CA = middlePoint(c_a);
            map.put(a_b, AB);
            map.put(b_c, BC);
            map.put(c_a, CA);

            fractalLine(turtle, order - 1, AB, CA, A);
            fractalLine(turtle, order - 1, BC, AB, B);
            fractalLine(turtle, order - 1, CA, BC, C);
            fractalLine(turtle, order - 1, AB, BC, CA);
        }
    }

    private Point middlePoint(Side s) {
        for (Side side : map.keySet()) {
            if (side.equals(s)) {
                return map.get(side);
            }
        }
        return new Point(
                (s.getStart().getX() + s.getEnd().getX()) / 2,
                (s.getStart().getY() + s.getEnd().getY()) / 2 + (int) RandomUtilities.randFunc(rand / (2 * super.getOrder())));
    }
}
