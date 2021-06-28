package shapes;

import java.awt.*;

public class Rectangle extends Figure {
    protected int width;
    protected int height;

    public Rectangle(int x1,int y1, int x2, int y2) {
        super(x1,y1,x2,y2);
        this.width = Math.abs(x2-x1);
        this.height = Math.abs(y2-y1);
    }

    public Rectangle(int x1,int y1, int x2, int y2, Color color, boolean isFilled) {
        super(x1,y1,x2,y2, color, isFilled);
        this.width = Math.abs(x2-x1);
        this.height = Math.abs(y2-y1);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        if (isFilled) {
            g.fillRect(x1, y1, width, height);
        } else {
            g.drawRect(x1, y1, width, height);
        }
    }
}