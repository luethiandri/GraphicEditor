package editor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditorMouseAdapter extends MouseAdapter {
    private EditorController controller;
    private EditorPanel panel;

    public EditorMouseAdapter(EditorPanel panel, EditorController controller) {
        this.panel = panel;
        this.controller = controller;
        panel.addMouseMotionListener(this);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        controller.setFirstPoint(e.getPoint());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (controller.getEditMode() == 'm') {
            controller.moveFigure(e.getPoint());
        } else if (controller.getEditMode() == 'd') {
            controller.deleteFigure();
        } else {
            controller.createFigureWithSecondPoint(e.getPoint());
        }
        panel.updateDrawings();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        controller.updateFigure(e.getPoint());
        panel.updateDrawings();
    }
}
