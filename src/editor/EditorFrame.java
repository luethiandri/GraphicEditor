package editor;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public final class EditorFrame extends JFrame {
    private EditorController editorController;
    private Graphics g;

    public EditorFrame(int width, int height) {
        createAndSetEditorPanel();
        centerWindow(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createAndSetEditorPanel() {
        editorController = new EditorController(this);
        JPanel panel = new EditorPanel(editorController, this);
        setContentPane(panel);
        g = getGraphics();
    }

    private void centerWindow(int width, int height) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle window = new Rectangle();
        window.width = width;
        window.height = height;
        window.x = (screenSize.width - window.width) / 2;
        window.y = (screenSize.height - window.height) / 2;
        setBounds(window);
    }
}
