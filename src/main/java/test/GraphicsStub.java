package test;

public class GraphicsStub extends ConcreteGraphics{
    int numbOfFillCalls;
    int numbOfDrawCalls;
    int x1;
    int y1;
    int x2;
    int y2;

    @Override
    public void fillRect(int x, int y, int width, int height) {
        numbOfFillCalls++;
    }

    @Override
    public void drawRect(int x1, int y1, int x2, int y2) {
        numbOfDrawCalls++;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void fillOval(int x1, int y1, int x2, int y2) {
        numbOfFillCalls++;
    }

    @Override
    public void drawOval(int x1, int y1, int x2, int y2) {
        numbOfDrawCalls++;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}
