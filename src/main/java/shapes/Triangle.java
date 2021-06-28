package shapes;

import java.awt.*;

public class Triangle extends Figure{
    private Line[] lines = new Line[3];

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3, Color color, boolean isFilled) {
        super(x1, y1, x2, y2, color, isFilled);
        lines[0] = new Line(x1, y2, x2, y2, color, isFilled);
        lines[1] = new Line(x2, y2, x3, y3, color, isFilled);
        lines[2] = new Line(x3, y3, x1, y1, color, isFilled);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        for (Line l: lines) {
            l.draw(g);
        }
    }
}
