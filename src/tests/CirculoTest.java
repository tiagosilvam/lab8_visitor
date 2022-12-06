package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import figura.Circulo;
import org.junit.jupiter.api.Test;
import visitor.*;

public class CirculoTest {

    @Test
    void testCirculo() {
        VisitorIF visitorArea = new VisitorCalcularArea();
        VisitorIF visitorPerimetro = new VisitorCalcularPerimetro();
        VisitorIF visitorDesenhar = new VisitorDesenhar();
        VisitorIF visitorMaximizar = new VisitorMaximizar();

        Circulo circulo1 = new Circulo(4);

        assertEquals(circulo1.aceitaVisita(visitorArea), 50.24);
        assertEquals(circulo1.aceitaVisita(visitorPerimetro), 25.12);
        assertEquals(circulo1.aceitaVisita((visitorDesenhar)), "Desenhando um circulo.");
        assertEquals(circulo1.aceitaVisita((visitorMaximizar)).toString(), "Círculo {raio=8.0}");
    }
}
