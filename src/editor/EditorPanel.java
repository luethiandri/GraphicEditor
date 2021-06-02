package editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public final class EditorPanel extends JPanel
                               implements ActionListener {
    private final EditorController editorController;
    private JButton saveBtn, loadFileBtn, colorSelectorBtn, clearDrawingsBtn, backgroundColorBtn, newFileBtn;
    private JCheckBox isFilledCB;
    private JRadioButton redRB, greenRB, blueRB, yellowRB, blackRB, whiteRB;
    private JColorChooser colorSelector;
    private JFileChooser fileSelector;

    EditorPanel(EditorController controller, JFrame frame) {
        this.setFocusable(true);
        this.requestFocus();
        editorController = controller;
        this.addMouseListener(new EditorMouseAdapter(this, editorController));
        this.addKeyListener(new EditorKeyAdapter(editorController));

        initialiseComponents();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        editorController.drawEverythingNew(g);
    }

    public void updateDrawings() {
        this.repaint();
        this.grabFocus();
    }

    public void initialiseComponents() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);

        saveBtn = new JButton("Save"); loadFileBtn = new JButton("Load file");
        clearDrawingsBtn = new JButton("Clear panel"); colorSelectorBtn = new JButton("Choose color");
        isFilledCB = new JCheckBox("Filled drawing"); redRB = new JRadioButton("Red");
        greenRB = new JRadioButton("Green"); blueRB = new JRadioButton("Blue");
        yellowRB = new JRadioButton("Yellow"); blackRB = new JRadioButton("Black");
        whiteRB = new JRadioButton("White");backgroundColorBtn = new JButton("Set bg color");
        colorSelector = new JColorChooser();
        ButtonGroup btnGroup = new ButtonGroup();

        blackRB.doClick();
        this.setBackground(Color.white);

        List<AbstractButton> components = new ArrayList<AbstractButton>() {{
            add(saveBtn);
            add(loadFileBtn);
            add(clearDrawingsBtn);
            add(isFilledCB);
            add(colorSelectorBtn);
            add(blackRB);
            add(whiteRB);
            add(redRB);
            add(greenRB);
            add(blueRB);
            add(yellowRB);
            add(backgroundColorBtn);
        }};

        for (AbstractButton comp : components) {
            if (comp.getClass() == JRadioButton.class) {
                btnGroup.add(comp);
            }
            comp.addActionListener(this);
            buttonPanel.add(comp);
            comp.setBackground(Color.WHITE);
        }

        fileSelector = new JFileChooser();
        fileSelector.addActionListener(this);
        //colorSelector = new JColorChooser();
        //colorSelector.addActionListener(this);

        add(buttonPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == saveBtn) {
            editorController.saveDrawing();
        } else if (src == loadFileBtn) {
            int result = fileSelector.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                try {
                    editorController.loadDrawing(fileSelector.getSelectedFile());
                    updateDrawings();
                } catch (Exception e2) {
                    System.out.println("Sömsing went wröng while loading the file");
                }
            }
//        } else if (src == colorSelectorBtn) {
//            int result = colorSelector.
//            if (result == JFileChooser.APPROVE_OPTION) {
//                try {
//                    editorController.loadDrawing(fileSelector.getSelectedFile());
//                    updateDrawings();
//                } catch (Exception e2) {
//                    System.out.println("Sömsing went wröng while loading the file");
//                }
//            }
        } else if (src == clearDrawingsBtn) {
            editorController.clearDrawing();
            updateDrawings();
        } else if (src == isFilledCB) {
            editorController.activeFillState = isFilledCB.isSelected();
        } else if (src.getClass() == JRadioButton.class) {
            Color color = null;
            if (src == redRB) {
                editorController.activeDrawingColor = Color.red;
            } else if (src == greenRB) {
                editorController.activeDrawingColor = Color.green;
            } else if (src == blueRB) {
                editorController.activeDrawingColor = Color.blue;
            } else if (src == yellowRB) {
                editorController.activeDrawingColor = Color.yellow;
            } else if (src == blackRB) {
                editorController.activeDrawingColor = Color.black;
            } else if (src == whiteRB) {
                editorController.activeDrawingColor = Color.white;
            }
        } else if (src == backgroundColorBtn) {
            this.setBackground(editorController.activeDrawingColor);
        }
        this.grabFocus();
    }
}