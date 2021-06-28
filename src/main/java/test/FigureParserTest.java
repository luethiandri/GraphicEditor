package test;

import dal.FigureDAO;
import dal.FigureDAOStub;
import dal.FigureParser;
import org.junit.Test;
import shapes.Figure;
import org.mockito.Mockito;


import java.util.List;

import static org.junit.Assert.assertEquals;

public class FigureParserTest {
    private final FigureDAO dao = new FigureDAOStub();
    private final FigureParser pp = new FigureParser(dao);

    @Test
    public void detailStringsShouldBeEqual() {
        List<Figure> figures = pp.parse();
        assertEquals(4, figures.size());
        assertEquals("FigureType: Line, X1: 200, Y1: 200, X2: 100, Y2: 100", figures.get(0).getFigureDetailsAsString());
        assertEquals("FigureType: Rectangle, X1: 210, Y1: 210, X2: 400, Y2: 400", figures.get(1).getFigureDetailsAsString());
        assertEquals("FigureType: Circle, X1: 250, Y1: 250, X2: 300, Y2: 300", figures.get(2).getFigureDetailsAsString());
        assertEquals("FigureType: Line, X1: 123, Y1: 342, X2: 456, Y2: 233", figures.get(3).getFigureDetailsAsString());
    }
}
