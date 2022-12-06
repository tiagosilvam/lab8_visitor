package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import figura.Retangulo;
import org.junit.jupiter.api.Test;
import visitor.*;

public class RetanguloTest {

    @Test
    void testRetangulo() {
        VisitorIF visitorArea = new VisitorCalcularArea();
        VisitorIF visitorPerimetro = new VisitorCalcularPerimetro();
        VisitorIF visitorDesenhar = new VisitorDesenhar();
        VisitorIF visitorMaximizar = new VisitorMaximizar();

        Retangulo retangulo1 = new Retangulo(10, 2);

        assertEquals(retangulo1.aceitaVisita(visitorArea), 20.0);
        assertEquals(retangulo1.aceitaVisita(visitorPerimetro), 24.0);
        assertEquals(retangulo1.aceitaVisita((visitorDesenhar)), "Desenhando um retângulo.");
        assertEquals(retangulo1.aceitaVisita((visitorMaximizar)).toString(), "Retângulo {base=20.0, altura=4.0}");
    }
}
