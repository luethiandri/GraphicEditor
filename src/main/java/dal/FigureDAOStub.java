package dal;

public class FigureDAOStub implements FigureDAO{
    private final String[] testFigures = {
            "Line,200,200,100,100","Rectangle,210,210,400,400","Circle,250,250,300,300", "Line,123,342,456,233"
    };
    private int currentFigure;
    @Override
    public String[] readNextFigureData() {
        if (currentFigure < testFigures.length) {
            String[] figureData = testFigures[currentFigure].split(",");
            currentFigure++;
            return figureData;
        } else {
            return null;
        }
    }
}
