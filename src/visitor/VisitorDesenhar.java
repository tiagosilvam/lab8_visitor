package visitor;

import figura.Circulo;
import figura.Retangulo;
import figura.Trapezio;
import figura.Triangulo;

public class VisitorDesenhar implements VisitorIF {


    @Override
    public String visitaCirculo(Circulo circulo) {
        return String.format("%s", "Desenhando um circulo.");
    }

    @Override
    public String visitaRetangulo(Retangulo retangulo) {
        return String.format("%s", "Desenhando um retângulo.");
    }

    @Override
    public String visitaTrapezio(Trapezio trapezio) {
        return String.format("%s", "Desenhando um trapézio.");
    }

    @Override
    public String visitaTriangulo(Triangulo triangulo) {
        return String.format("%s", "Desenhando um triângulo.");
    }
}
