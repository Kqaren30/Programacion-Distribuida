package Tarea3;

import Tarea3.Polygon;

public class Rectangle implements Polygon {
    public int sides=4;
    public float width=0;
    public float height=0;
    public float area=0;

    public Rectangle(float width, float height){

        this.width=width;
        this.height=height;
    }

    @Override
    public float getArea(){
        area=height*width;
        return area;
    };

    @Override
    public int getSides(){
        return sides;
    };


}
