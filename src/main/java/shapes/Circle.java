package shapes;

import java.awt.*;

public class Circle extends Figure {
    private int diameter;

    public Circle(int x1,int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
        calculateCircle();
    }

    public Circle(int x1,int y1, int x2, int y2, Color color, boolean isFilled) {
        super(x1, y1, x2, y2, color, isFilled);
        calculateCircle();
    }

    public void calculateCircle() {
        if (x2 < x1) {
            diameter = (x1 - x2) * 2;
        } else if (y2 < y1) {
            diameter = (y1-y2) * 2;
        } else if (y2 > y1) {
            diameter = (y2 - y1) * 2;
        } else {
            diameter = (x2- x1) * 2;
        }
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        int radius = diameter/2;
        if (isFilled) {
            g.fillOval(x1 -radius, y1 -radius, diameter, diameter);
        } else {
            g.drawOval(x1 -radius, y1 -radius, diameter, diameter);
        }
    }
}