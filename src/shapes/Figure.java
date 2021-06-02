package shapes;

import java.awt.*;
import java.io.Serializable;

public abstract class Figure implements Serializable {
    protected int x1, y1, x2, y2;
    protected Color color = Color.BLACK;
    protected boolean isFilled = false;

    public Figure(int x1,int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public Figure(int x1,int y1, int x2, int y2, Color color, boolean isFilled) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
        this.isFilled = isFilled;
    }
    public void draw(Graphics g) {
        g.setColor(color);
    }

    public void move(Point startP, Point delta) {
        int tmp1 = delta.x - startP.x;
        int tmp2 = delta.y - startP.y;
        x1 += tmp1;
        y1 += tmp2;
        x2 += tmp1;
        y2 += tmp2;
    }

    public String getFigureDetailsAsString() {
        return "FigureType: " + this.getClass().getSimpleName() + ", X1: " + x1 + ", Y1: " + y1 + ", X2: " + x2 + ", Y2: " + y2;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }
}
