package test;

public class GraphicsStub extends ConcreteGraphics{
    int numbOfFillRectCalls;
    int numbOfDrawRectCalls;
    int x1;
    int y1;
    int x2;
    int y2;

    @Override
    public void fillRect(int x, int y, int width, int height) {
        numbOfFillRectCalls++;
    }

    @Override
    public void drawRect(int x1, int y1, int x2, int y2) {
        numbOfDrawRectCalls++;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}
