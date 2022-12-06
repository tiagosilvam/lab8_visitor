package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import figura.Retangulo;
import org.junit.Before;
import org.junit.Test;
import visitor.*;

public class RetanguloTest {

    VisitorIF visitorArea, visitorPerimetro, visitorDesenhar, visitorMaximizar;
    Retangulo retangulo1;

    @Before
    public void start() {
        visitorArea = new VisitorCalcularArea();
        visitorPerimetro = new VisitorCalcularPerimetro();
        visitorDesenhar = new VisitorDesenhar();
        visitorMaximizar = new VisitorMaximizar();

        retangulo1 = new Retangulo(10, 2);
    }

    @Test
    public void testArea() {
        assertEquals(retangulo1.aceitaVisita(visitorArea), 20.0);
    }

    @Test
    public void testPerimetro() {
        assertEquals(retangulo1.aceitaVisita(visitorPerimetro), 24.0);
    }

    @Test
    public void testDesenhar() {
        assertEquals(retangulo1.aceitaVisita((visitorDesenhar)), "Desenhando um retângulo.");
    }

    @Test
    public void testMaximizar() {
        assertEquals(retangulo1.aceitaVisita((visitorMaximizar)).toString(), "Retângulo {base=20.0, altura=4.0}");
    }
}
