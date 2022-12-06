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

        System.out.println("Cálculo de area:");
        System.out.printf("Área círculo: %s %n", circulo1.aceitaVisita(visitorArea));
        System.out.printf("Área retângulo: %s %n", retangulo1.aceitaVisita(visitorArea));
        System.out.printf("Área trapézio: %s %n", trapezio1.aceitaVisita(visitorArea));
        System.out.printf("Área triângulo: %s %n", triangulo1.aceitaVisita(visitorArea));
        System.out.println("\nCálculo de perímetro:");
        System.out.printf("Perímetro círculo: %s %n", circulo1.aceitaVisita(visitorPerimetro));
        System.out.printf("Perímetro retângulo: %s %n", retangulo1.aceitaVisita(visitorPerimetro));
        System.out.printf("Perímetro trapézio: %s %n", trapezio2.aceitaVisita(visitorPerimetro));
        System.out.printf("Perímetro triângulo: %s %n", triangulo2.aceitaVisita(visitorPerimetro));
        System.out.println("\nDesenhado:");
        System.out.println(circulo1.aceitaVisita((visitorDesenhar)));
        System.out.println(retangulo1.aceitaVisita((visitorDesenhar)));
        System.out.println(trapezio1.aceitaVisita((visitorDesenhar)));
        System.out.println(triangulo1.aceitaVisita((visitorDesenhar)));
        System.out.println("\nMaximizado:");
        System.out.printf("Círculo maximizado: %s %n", circulo1.aceitaVisita((visitorMaximizar)));
        System.out.printf("Retângulo maximizado: %s %n", retangulo1.aceitaVisita((visitorMaximizar)));
        System.out.printf("Trapézio maximizado: %s %n", trapezio1.aceitaVisita((visitorMaximizar)));
        System.out.printf("Triângulo maximizado: %s %n", triangulo1.aceitaVisita((visitorMaximizar)));
    }
}