package display;

import shapes.Figure;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Drawing{
    private List<Figure> figures;
    private Figure tempShowcaseFigure = null;

    public Drawing() {
        this.figures = new ArrayList<>();
    }

    public Drawing(List<Figure> figures) {
        this.figures = figures;
    }

    public void drawFigures(Graphics g) {
        for (Figure f : figures) {
            f.draw(g);
        }

        if (tempShowcaseFigure != null) {
            tempShowcaseFigure.draw(g);
        }
    }

    public Figure findFigure(Point point) {
        Figure figure = null;
        for (Figure f: figures) {
            if ((point.x >= f.getX1() && point.x <= f.getX2()) && (point.y >= f.getY1() && point.y <= f.getY2())) {
                figure = f;
            }
        }
        return figure;
    }

    public void addFigure(Figure figure) {
        figures.add(figure);
    }

    public void clearDrawing() {
        figures.clear();
    }

    public void removeFigureFromDrawing(Figure figure) {
        figures.remove(figure);
    }

    public void setTempShowcaseFigure(Figure figure) {
        tempShowcaseFigure = figure;
    }

    public List<Figure> getFigures() {
        return figures;
    }

    public void replaceFigures(List<Figure> figuresFromFile) { figures = figuresFromFile; }


}
