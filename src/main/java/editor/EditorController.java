package editor;

import display.Drawing;
import shapes.*;
import shapes.Rectangle;

import java.awt.*;
import java.io.File;

final class EditorController {
    private final Drawing drawing = new Drawing();
    private char editMode = 'r';
    private Point firstPoint;
    private final EditorFrame frame;
    private ObjectSaver saver = new ObjectSaver();
    private ObjectLoader loader = new ObjectLoader();
    private File currentFile = new File("C:\\Users\\vmadmin\\Desktop\\hello.txt");
    private String currentFileName;
    public Color activeDrawingColor = Color.BLACK;
    public boolean activeFillState;

    public EditorController(EditorFrame frame) {
        this.frame = frame;
    }

    public void drawEverythingNew(Graphics g) {
        drawing.drawFigures(g);
    }

    public void setEditMode(char editMode) {
        this.editMode = editMode;
    }

    public void setFirstPoint(Point firstPoint) {
        this.firstPoint = firstPoint;
    }

    public void createFigureWithSecondPoint(Point secondPoint) {
        System.out.println(firstPoint.x + "--" + firstPoint.y + "--" + secondPoint.x + "--" + secondPoint.y);
        drawing.addFigure(createFigureBasedOnEditType(secondPoint));
    }

    public Figure createFigureBasedOnEditType(Point secondPoint) {
        Figure f = null;
        switch (editMode) {
            case 'c':
                f = new Circle(firstPoint.x, firstPoint.y,  secondPoint.x, secondPoint.y, activeDrawingColor, activeFillState);
            break;
//            case 'p':
//                f = new Triangle(firstPoint.x, firstPoint.y, secondPoint.x, secondPoint.y, activeDrawingColor, activeFillState);
//                break;
            case 'r':
                f = new Rectangle(Math.min(firstPoint.x, secondPoint.x), Math.min(firstPoint.y, secondPoint.y), Math.max(firstPoint.x, secondPoint.x),Math.max(firstPoint.y, secondPoint.y), activeDrawingColor, activeFillState);
            break;
            case 'o':
                f = new Oval(Math.min(firstPoint.x, secondPoint.x), Math.min(firstPoint.y, secondPoint.y), Math.max(firstPoint.x, secondPoint.x),Math.max(firstPoint.y, secondPoint.y), activeDrawingColor, activeFillState);
            break;
            case 'l':
                f = new Line(firstPoint.x, firstPoint.y,  secondPoint.x, secondPoint.y, activeDrawingColor, activeFillState);
            break;
        }
        return f;
    }

    public void updateFigure(Point point) {
        drawing.setTempShowcaseFigure(createFigureBasedOnEditType(point));
    }

    public char getEditMode() {
        return editMode;
    }

    public void moveFigure(Point secondPoint) {
        System.out.println(firstPoint.x + "--" + firstPoint.y + "--" + secondPoint.x + "--" + secondPoint.y);
        Figure figure = drawing.findFigure(firstPoint);
        if (figure != null) {
            figure.move(firstPoint, secondPoint);
        }
    }

    public void deleteFigure() {
        Figure figure = drawing.findFigure(firstPoint);
        if (figure != null) {
            drawing.removeFigureFromDrawing(figure);
            drawing.drawFigures(frame.getGraphics());
        }
        drawing.drawFigures(frame.getGraphics());
    }

    public void saveDrawing() {
        Figure[] figures = new Figure[drawing.getFigures().size()];
        figures = drawing.getFigures().toArray(figures);

        saver.saveFigures(figures);
    }

    public void loadDrawing(File f) {
        currentFile = f;
        drawing.replaceFigures(loader.deserializeObjectsFromFile(f));
        drawEverythingNew(frame.getGraphics());
    }

    public void clearDrawing() {
        drawing.setTempShowcaseFigure(null);
        drawing.clearDrawing();
        drawEverythingNew(frame.getGraphics());
    }
}
