package dao;

import shapes.*;

import java.util.ArrayList;
import java.util.List;

public class FigureParser {
  private final FigureDAO dao;

  public FigureParser(FigureDAO dao) {
    this.dao = dao;
  }

  public List<Figure> parse() {
    List<Figure> figures = new ArrayList<Figure>();
    String[] figureData = dao.readNextFigureData();
    while (figureData != null) {
      String figureType = figureData[0];
      int x = Integer.parseInt(figureData[1]);
      int y = Integer.parseInt(figureData[2]);
      int x2 = Integer.parseInt(figureData[3]);
      int y2 = Integer.parseInt(figureData[4]);
      switch (figureType) {
      case "Line":
        figures.add(new Line(x, y, x2, y2));
        break;
      case "Rectangle":
        figures.add(new Rectangle(x, y, x2, y2));
        break;
      case "Circle":
        figures.add(new Circle(x, y, x2, y2));
        break;
      }
      figureData = dao.readNextFigureData();
    }
    return figures;
  }
}
