import figura.Circulo;
import figura.Retangulo;
import figura.Trapezio;
import figura.Triangulo;
import visitor.*;

public class Main {
    public static void main(String[] args) throws Exception {

        VisitorIF visitorArea = new VisitorCalcularArea();
        VisitorIF visitorPerimetro = new VisitorCalcularPerimetro();
        VisitorIF visitorDesenhar = new VisitorDesenhar();
        VisitorIF visitorMaximizar = new VisitorMaximizar();

        Circulo circulo1 = new Circulo(4); // Circulo
        Retangulo retangulo1 = new Retangulo(10, 2); // Retangulo
        Trapezio trapezio1 = new Trapezio(18, 7, 15); // Trapezio sem lado
        Trapezio trapezio2 = new Trapezio(18, 7, 15, 17); // Trapezio com lado
        Triangulo triangulo1 = new Triangulo(13, 7); // Triangulo sem lado
        Triangulo triangulo2 = new Triangulo(13, 7, 3); // Triangulo com lado

        System.out.println("Cálculo de area das figuras:");
        System.out.printf("Área círculo: %s cm%n", circulo1.aceitaVisita(visitorArea));
        System.out.printf("Área retângulo: %s cm%n", retangulo1.aceitaVisita(visitorArea));
        System.out.printf("Área trapézio: %s cm%n", trapezio1.aceitaVisita(visitorArea));
        System.out.printf("Área triângulo: %s cm%n", triangulo1.aceitaVisita(visitorArea));
        System.out.println("\nCálculo de perímetro das figuras:");
        System.out.printf("Perímetro círculo: %s cm%n", circulo1.aceitaVisita(visitorPerimetro));
        System.out.printf("Perímetro retângulo: %s cm%n", retangulo1.aceitaVisita(visitorPerimetro));
        System.out.printf("Perímetro trapézio: %s cm%n", trapezio2.aceitaVisita(visitorPerimetro));
        System.out.printf("Perímetro triângulo: %s cm%n", triangulo2.aceitaVisita(visitorPerimetro));
        System.out.println("\nDesenhado figuras:");
        System.out.println(circulo1.aceitaVisita((visitorDesenhar)));
        System.out.println(retangulo1.aceitaVisita((visitorDesenhar)));
        System.out.println(trapezio1.aceitaVisita((visitorDesenhar)));
        System.out.println(triangulo1.aceitaVisita((visitorDesenhar)));
        System.out.println("\nMaximizado figuras:");
        System.out.printf("Círculo maximizado em cm: %s %n", circulo1.aceitaVisita((visitorMaximizar)));
        System.out.printf("Retângulo maximizado em cm: %s %n", retangulo1.aceitaVisita((visitorMaximizar)));
        System.out.printf("Trapézio 1 maximizado em cm: %s %n", trapezio1.aceitaVisita((visitorMaximizar)));
        System.out.printf("Trapézio 2 maximizado em cm: %s %n", trapezio2.aceitaVisita((visitorMaximizar)));
        System.out.printf("Triângulo 1 maximizado em cm: %s %n", triangulo1.aceitaVisita((visitorMaximizar)));
        System.out.printf("Triângulo 2 maximizado em cm: %s %n", triangulo2.aceitaVisita((visitorMaximizar)));
    }
}