package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import figura.Triangulo;
import org.junit.Before;
import org.junit.Test;
import visitor.*;

public class TrianguloTest {

    VisitorIF visitorArea, visitorPerimetro, visitorDesenhar, visitorMaximizar;
    Triangulo triangulo1, triangulo2;

    @Before
    public void start() {
        visitorArea = new VisitorCalcularArea();
        visitorPerimetro = new VisitorCalcularPerimetro();
        visitorDesenhar = new VisitorDesenhar();
        visitorMaximizar = new VisitorMaximizar();

        triangulo1 = new Triangulo(13, 7);
        triangulo2 = new Triangulo(13, 7, 3);
    }

    @Test
    public void testArea() throws Exception {
        assertEquals(triangulo1.aceitaVisita(visitorArea), 45.5);
        assertThrowsExactly(Exception.class, () -> triangulo2.aceitaVisita((visitorArea)));
    }

    @Test
    public void testPerimetro() throws Exception {
        assertThrowsExactly(Exception.class, () -> triangulo1.aceitaVisita((visitorPerimetro)));
        assertEquals(triangulo2.aceitaVisita(visitorPerimetro), 23.0);

    }

    @Test
    public void testDesenhar() throws Exception {
        assertEquals(triangulo1.aceitaVisita((visitorDesenhar)), "Desenhando um triângulo.");
        assertEquals(triangulo2.aceitaVisita((visitorDesenhar)), "Desenhando um triângulo.");
    }

    @Test
    public void testMaximizar() throws Exception {
        assertEquals(triangulo1.aceitaVisita((visitorMaximizar)).toString(), "Triângulo {base=26.0, altura=14.0}");
        assertEquals(triangulo2.aceitaVisita((visitorMaximizar)).toString(), "Triângulo {base=26.0, lado1=14.0, lado2=6.0}");
    }
}
