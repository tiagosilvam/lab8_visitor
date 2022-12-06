package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import figura.Trapezio;
import org.junit.jupiter.api.Test;
import visitor.*;

public class TrapezioTest {

    @Test
    void testTrapezio() throws Exception {
        VisitorIF visitorArea = new VisitorCalcularArea();
        VisitorIF visitorPerimetro = new VisitorCalcularPerimetro();
        VisitorIF visitorDesenhar = new VisitorDesenhar();
        VisitorIF visitorMaximizar = new VisitorMaximizar();

        Trapezio trapezio1 = new Trapezio(18, 7, 15);
        Trapezio trapezio2 = new Trapezio(18, 7, 15, 17);

        assertEquals(trapezio1.aceitaVisita(visitorArea), 187.5);
        assertThrowsExactly(Exception.class, () -> trapezio1.aceitaVisita((visitorPerimetro)));
        assertEquals(trapezio1.aceitaVisita((visitorDesenhar)), "Desenhando um trapézio.");
        assertEquals(trapezio1.aceitaVisita((visitorMaximizar)).toString(), "Trapézio {baseMaior=36.0, baseMenor=14.0, altura=30.0}");

        assertThrowsExactly(Exception.class, () -> trapezio2.aceitaVisita(visitorArea));
        assertEquals(trapezio2.aceitaVisita(visitorPerimetro), 57.0);
        assertEquals(trapezio2.aceitaVisita((visitorDesenhar)), "Desenhando um trapézio.");
        assertEquals(trapezio2.aceitaVisita((visitorMaximizar)).toString(), "Trapézio {baseMaior=36.0, baseMenor=14.0, lado1=30.0, lado2=34.0}");
    }
}
