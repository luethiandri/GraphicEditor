package test;

import org.junit.Test;
import shapes.*;
import static org.junit.Assert.assertEquals;

public class FigureTest {
    private final GraphicsStub graphics = new GraphicsStub();
    @Test
    public void rectangleValuesShouldBeEqual() {
        Rectangle rectangle = new Rectangle(300, 350, 150, 300);
        rectangle.draw(graphics);
        assertEquals(0, graphics.numbOfFillRectCalls);
        assertEquals(1,graphics.numbOfDrawRectCalls);
        assertEquals(300, graphics.x1);
        assertEquals(350, graphics.y1);
        assertEquals(300-150, graphics.x2);
        assertEquals(350-300, graphics.y2);
    }
}
