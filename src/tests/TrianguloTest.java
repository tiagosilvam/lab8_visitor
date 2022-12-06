package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import figura.Triangulo;
import org.junit.jupiter.api.Test;
import visitor.*;

public class TrianguloTest {

    @Test
    void testTriangulo() throws Exception {
        VisitorIF visitorArea = new VisitorCalcularArea();
        VisitorIF visitorPerimetro = new VisitorCalcularPerimetro();
        VisitorIF visitorDesenhar = new VisitorDesenhar();
        VisitorIF visitorMaximizar = new VisitorMaximizar();

        Triangulo triangulo1 = new Triangulo(13, 7);
        Triangulo triangulo2 = new Triangulo(13, 7, 3);

        assertEquals(triangulo1.aceitaVisita(visitorArea), 45.5);
        assertThrowsExactly(Exception.class, () -> triangulo1.aceitaVisita((visitorPerimetro)));
        assertEquals(triangulo1.aceitaVisita((visitorDesenhar)), "Desenhando um triângulo.");
        assertEquals(triangulo1.aceitaVisita((visitorMaximizar)).toString(), "Triângulo {base=26.0, altura=14.0}");

        assertThrowsExactly(Exception.class, () -> triangulo2.aceitaVisita((visitorArea)));
        assertEquals(triangulo2.aceitaVisita(visitorPerimetro), 23.0);
        assertEquals(triangulo2.aceitaVisita((visitorDesenhar)), "Desenhando um triângulo.");
        assertEquals(triangulo2.aceitaVisita((visitorMaximizar)).toString(), "Triângulo {base=26.0, lado1=14.0, lado2=6.0}");
    }
}
