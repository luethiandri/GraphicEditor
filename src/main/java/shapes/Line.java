package shapes;

import java.awt.*;

public class Line extends Figure{
    public Line(int x1,int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
    }

    public Line(int x1,int y1, int x2, int y2, Color color, boolean isFilled) {
        super(x1, y1, x2, y2, color, isFilled);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.drawLine(x1, y1, x2, y2);
    }

    @Override
    public void move(Point p1, Point p2) {
        int tmp = p2.x - p1.x;
        int tmp2 = p2.y - p1.y;
        super.move(p1, p2);
        p2.x = p1.x + tmp;
        p2.y = p1.y + tmp2;
    }
}