package visitor;

import figura.Circulo;
import figura.Retangulo;
import figura.Trapezio;
import figura.Triangulo;

public class VisitorMaximizar implements VisitorIF {

    @Override
    public Object visitaCirculo(Circulo circulo) {
        circulo.setRaio(circulo.getRaio() * 2);
        return circulo;
    }

    @Override
    public Object visitaRetangulo(Retangulo retangulo) {
        retangulo.setBase(retangulo.getBase() * 2);
        retangulo.setAltura(retangulo.getAltura() * 2);
        return retangulo;
    }

    @Override
    public Object visitaTrapezio(Trapezio trapezio) {
        trapezio.setBaseMaior(trapezio.getBaseMaior() * 2);
        trapezio.setBaseMenor(trapezio.getBaseMenor() * 2);
        if (trapezio.getAltura() != 0) {
            trapezio.setAltura(trapezio.getAltura() * 2);
        } else {
            trapezio.setLado1(trapezio.getLado1() * 2);
            trapezio.setLado2(trapezio.getLado2() * 2);
        }
        return trapezio;
    }

    @Override
    public Object visitaTriangulo(Triangulo triangulo) {
        triangulo.setBase(triangulo.getBase() * 2);
        if (triangulo.getAltura() != 0) {
            triangulo.setAltura(triangulo.getAltura() * 2);
        } else {
            triangulo.setLado1(triangulo.getLado1() * 2);
            triangulo.setLado2(triangulo.getLado2() * 2);
        }
        return triangulo;
    }
}
