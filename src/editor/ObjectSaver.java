package editor;

import com.sun.corba.se.spi.ior.IdentifiableFactory;
import shapes.Figure;

import java.io.*;

public class ObjectSaver {
    public File saveFigures(Figure[] figures, File currentFile) {
        try {
            String name = "Test" + System.currentTimeMillis();
            if (currentFile.exists()) {
                name = currentFile.getName();
            }

            String temp = currentFile.getName();

            FileOutputStream file = new FileOutputStream(name);

            ObjectOutputStream out = new ObjectOutputStream(file);

            for (Figure f : figures) {
                out.writeObject(f);
            }

            out.close();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("File could not been written");
        }
        return currentFile;
    }
}
