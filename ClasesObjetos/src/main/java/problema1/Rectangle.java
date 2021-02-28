package problema1;

public class Rectangle {
    static int width=0;
    static int height=0;
    static int area=0;

    public static void  getArea(){
        area=width*height;
    }

    public static void main(String[] args) {
      //  Rectangle myRect = new Rectangle();
        width = 40;
        height = 50;
        getArea();
        System.out.println("myRect's area is " + area);
    }
}

/*
* Errores:
* no se creo el metodo para sacar area
* no se instanciaron las variables de width,height
* como la clase no se llama rectangle no se puede crear el objeto, ademas de que no se hacia correctamente
*
* Soluciones:
*  Anteriormente habia hecho una version de este codigo para que se viera mejor, con constructor y el objeto myrect
* Pero despues note que tenia que ser sin advertencias y el crear el objeto de rect y el contructor me generaban
* advertencias asique termino de esta forma mi codigo.Ahora si explicare mi codigo:
* Primero declare las variables donde inclui la variable de area
* Lo siguiente fue crear el metodo de getArea el cual cambiaria el valor de area dependiendo del height y width
* En el main ingresó los valores de las variables de width y height y llamo a mi metodo getArea.
* Y finalmente se imprime la variable area
* */
