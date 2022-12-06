package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import figura.Trapezio;
import org.junit.Before;
import org.junit.Test;
import visitor.*;

public class TrapezioTest {

    VisitorIF visitorArea, visitorPerimetro, visitorDesenhar, visitorMaximizar;
    Trapezio trapezio1, trapezio2;

    @Before
    public void start() {
        visitorArea = new VisitorCalcularArea();
        visitorPerimetro = new VisitorCalcularPerimetro();
        visitorDesenhar = new VisitorDesenhar();
        visitorMaximizar = new VisitorMaximizar();

        trapezio1 = new Trapezio(18, 7, 15);
        trapezio2 = new Trapezio(18, 7, 15, 17);
    }

    @Test
    public void testArea() throws Exception {
        assertEquals(trapezio1.aceitaVisita(visitorArea), 187.5);
        assertThrowsExactly(Exception.class, () -> trapezio2.aceitaVisita(visitorArea));
    }

    @Test
    public void testPerimetro() throws Exception {
        assertThrowsExactly(Exception.class, () -> trapezio1.aceitaVisita((visitorPerimetro)));
        assertEquals(trapezio2.aceitaVisita(visitorPerimetro), 57.0);
    }

    @Test
    public void testDesenhar() throws Exception {
        assertEquals(trapezio1.aceitaVisita((visitorDesenhar)), "Desenhando um trapézio.");
        assertEquals(trapezio2.aceitaVisita((visitorDesenhar)), "Desenhando um trapézio.");
    }

    @Test
    public void testMaximizar() throws Exception {
        assertEquals(trapezio1.aceitaVisita((visitorMaximizar)).toString(), "Trapézio {baseMaior=36.0, baseMenor=14.0, altura=30.0}");
        assertEquals(trapezio2.aceitaVisita((visitorMaximizar)).toString(), "Trapézio {baseMaior=36.0, baseMenor=14.0, lado1=30.0, lado2=34.0}");
    }
}
