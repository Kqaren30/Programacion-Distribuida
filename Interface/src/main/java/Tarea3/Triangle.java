package Tarea3;

public class Triangle implements Polygon{
    public int sides=3;
    public float width=0;
    public float height=0;
    public float area=0;

    public Triangle(float width, float height){
        this.width=width;
        this.height=height;
    }

    @Override
    public float getArea() {
        area=(width*height)/2;
        return area;
    }

    @Override
    public int getSides() {
        return sides;
    }
}
