package visitor;

import figura.Circulo;
import figura.Retangulo;
import figura.Trapezio;
import figura.Triangulo;

public interface VisitorIF {

    Object visitaCirculo(Circulo circulo);

    Object visitaRetangulo(Retangulo retangulo);

    Object visitaTrapezio(Trapezio trapezio) throws Exception;

    Object visitaTriangulo(Triangulo triangulo) throws Exception;
}