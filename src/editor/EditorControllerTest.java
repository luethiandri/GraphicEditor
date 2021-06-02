package editor;

import shapes.Circle;
import shapes.Line;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.*;

public class EditorControllerTest {
    private final EditorController ec = new EditorController(new EditorFrame(800, 650));
    private final Point p1 = new Point(12, 12);
    private final Point p2 = new Point(52, 52);

    @Test
    public void figureShouldBeALine() {
        char mode = 'l';
        Line line = new Line(p1.x, p1.y, p2.x, p2.y, Color.black, false);
        ec.setEditMode(mode);
        ec.setFirstPoint(p1);
        Object f = ec.createFigureBasedOnEditType(p2);

        assertEquals(f, line);
    }

    @Test
    public void figureShouldNotBeACircle() {
        char mode = 'r';
        Circle circle = new Circle(p1.x, p1.y, p2.x, p2.y, Color.BLACK, false);
        ec.setEditMode(mode);
        ec.setFirstPoint(p1);
        Object f = ec.createFigureBasedOnEditType(p2);

        assertNotEquals(f, circle);
    }
}
