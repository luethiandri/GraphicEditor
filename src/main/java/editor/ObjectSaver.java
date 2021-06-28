package editor;

import com.sun.corba.se.spi.ior.IdentifiableFactory;
import shapes.Figure;

import java.io.*;

public class ObjectSaver {
    public void saveFigures(Figure[] figures) {
        try {
            String name = "Test" + System.currentTimeMillis();
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
    }
}
