package Tarea3;

public  class Interface {
    public static void main(String[] args){
        Polygon firstRect = new Rectangle(2.5f,5);
        System.out.println("El area del rectangulo es: "+firstRect.getArea());
        System.out.println("Lados del rectangulo: "+firstRect.getSides());
        Polygon firstTriangle = new Triangle(25,12.4f);
        System.out.println("El area del triangulo es: "+firstTriangle.getArea());
        System.out.println("Lados del triangulo: "+firstTriangle.getSides());
        Polygon firstCircle = new Circle(18.7f);
        System.out.println("El area del circulo es: "+firstCircle.getArea());
        System.out.println("Lados del circulo: "+firstCircle.getSides());
    }
}