package editor;

import shapes.Figure;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectLoader {
    public List<Figure> deserializeObjectsFromFile(File incomingFile) {
        List<Figure> figures = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(incomingFile);
            ObjectInputStream in = new ObjectInputStream(file);
            boolean cont = true;
            try {
                while(cont) {
                    Figure obj = (Figure)in.readObject();
                    if (obj != null) {
                        figures.add(obj);
                    } else {
                        cont = false;
                    }
                }
            } catch (Exception e) {

            }
            file.close();
            in.close();
        } catch (Exception e) {
        }
        return figures;
    }
}
