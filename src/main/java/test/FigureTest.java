package test;

import org.junit.Test;
import org.mockito.Mockito;
import shapes.Circle;
import shapes.Figure;
import shapes.Rectangle;
import static org.mockito.Mockito.*;
import org.mockito.InOrder;


import java.awt.*;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FigureTest {
    private final GraphicsStub graphics = new GraphicsStub();
    @Test
    public void circleMockitoTest() {
        Circle circle = Mockito.mock(Circle.class);

        circle.move(new Point(20, 43), new Point(322, 431));
        circle.move(new Point(312, 401), new Point(202, 143));
        Mockito.verify(circle, Mockito.times(2)).move(Mockito.any(), Mockito.any());
    }

    @Test
    public void circleShouldBeEqual() {
        Circle circle = new Circle(300, 350, 150, 300);
        circle.draw(graphics);
        assertEquals(0, graphics.numbOfFillCalls);
        assertEquals(1,graphics.numbOfDrawCalls);
        assertEquals(150, graphics.x1);
        assertEquals(200, graphics.y1);
        assertEquals(300, graphics.x2);
        assertEquals(300, graphics.y2);
    }
}
