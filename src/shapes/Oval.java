package shapes;


import java.awt.*;

public class Oval extends Rectangle {

    public Oval(int x1,int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
    }

    public Oval(int x1,int y1, int x2, int y2, Color color, boolean isFilled) {
        super(x1, y1, x2, y2, color, isFilled);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        if (isFilled) {
            g.fillOval(x1, y1, width, height);
        } else {
            g.drawOval(x1, y1, width, height);
        }
    }
}