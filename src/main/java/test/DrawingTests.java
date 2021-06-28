package test;

import display.Drawing;
import org.junit.Test;

import org.mockito.InOrder;
import org.mockito.Mockito;
import shapes.*;
import shapes.Rectangle;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class DrawingTests {
    private final Graphics graphics = mock(Graphics.class);
    private final Rectangle r1 = new Rectangle(20,14,43,54);
    private final Line l1 = new Line(159, 100, 298, 245);
    private final Oval o1 = new Oval(59, 30, 128, 145);

    @Test
    public void drawingValuesShouldBeEqual() {
        final List<Figure> figures = new ArrayList(){{add(r1); add(l1); add(o1);}};
        final Drawing drawing = new Drawing(figures);
        drawing.drawFigures(graphics);

        //InOrder inOrder = Mockito.inOrder(graphics);
        verify(graphics, times(1)).drawRect(20,14,23,40);
        verify(graphics, times(1)).drawLine(159, 100, 298, 245);
        verify(graphics, times(1)).drawOval(59, 30, o1.getX2()-o1.getX1(), o1.getY2()-o1.getY1());
    }
}
