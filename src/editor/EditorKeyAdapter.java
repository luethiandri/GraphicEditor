package editor;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EditorKeyAdapter extends KeyAdapter {
    private EditorController controller;

    public EditorKeyAdapter(EditorController controller) {
        this.controller = controller;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        controller.setEditMode(e.getKeyChar());
        System.out.println(e.getKeyChar());
    }
}
