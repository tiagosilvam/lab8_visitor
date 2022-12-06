package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import figura.Circulo;
import org.junit.Before;
import org.junit.Test;
import visitor.*;

public class CirculoTest {

    VisitorIF visitorArea, visitorPerimetro, visitorDesenhar, visitorMaximizar;
    Circulo circulo1;

    @Before
    public void start() {
        visitorArea = new VisitorCalcularArea();
        visitorPerimetro = new VisitorCalcularPerimetro();
        visitorDesenhar = new VisitorDesenhar();
        visitorMaximizar = new VisitorMaximizar();

        circulo1 = new Circulo(4);
    }

    @Test
    public void testArea() {
        assertEquals(circulo1.aceitaVisita(visitorArea), 50.24);
    }

    @Test
    public void testPerimetro() {
        assertEquals(circulo1.aceitaVisita(visitorPerimetro), 25.12);
    }

    @Test
    public void testDesenhar() {
        assertEquals(circulo1.aceitaVisita((visitorDesenhar)), "Desenhando um circulo.");
    }

    @Test
    public void testMaximizar() {
        assertEquals(circulo1.aceitaVisita((visitorMaximizar)).toString(), "Círculo {raio=8.0}");
    }
}