package Tarea3;

public class Circle implements Polygon{
    public int sides=1;
    public float radio=0;
    public float area=0;

    public Circle(float radio){
        this.radio=radio;
    }

    @Override
    public float getArea() {
        area=(radio*radio)*(float)Math.PI;
        return area;
    }

    @Override
    public int getSides() {
        return sides;
    }
}
