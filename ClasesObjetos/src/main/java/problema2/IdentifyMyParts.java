package problema2;

public class IdentifyMyParts {
    public static int x= 7;
    public int y= 3;

    public static void main(String[] args) {
        IdentifyMyParts a = new IdentifyMyParts();
        IdentifyMyParts b = new IdentifyMyParts();
        a.y = 5;
        b.y = 6;
        a.x = 1;
        b.x = 2;
        System.out.println("a.y = " + a.y);
        System.out.println("b.y = " + b.y);
        System.out.println("a.x = " + a.x);
        System.out.println("b.x = " + b.x);
        System.out.println("IdentifyMyParts.x = " + IdentifyMyParts.x);
    }
}

/*
Resultado a imprimirse es:
a.y = 5
b.y = 6
a.x = 2
b.x = 2
IdentifyMyParts.x = 2
Razón:
La variable x esta definido como estatico por lo que ocasiona que x siempre tenga el ultimo valor
que se le asigna, a diferencia de la variable Y, que es como si creara una variable Y para cada objeto,
y en x es como si se compartieran la misma variable.
* */