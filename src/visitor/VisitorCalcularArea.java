package visitor;

import figura.Circulo;
import figura.Retangulo;
import figura.Trapezio;
import figura.Triangulo;

public class VisitorCalcularArea implements VisitorIF {

    private double pi = 3.14;

    public VisitorCalcularArea() {
        setPi(3.14);
    }

    public double getPi() {
        return pi;
    }

    public void setPi(double pi) {
        this.pi = pi;
    }

    @Override
    public Double visitaCirculo(Circulo circulo) {
        return getPi() * (circulo.getRaio() * circulo.getRaio());
    }

    @Override
    public Double visitaRetangulo(Retangulo retangulo) {
        return retangulo.getBase() * retangulo.getAltura();
    }

    @Override
    public Double visitaTrapezio(Trapezio trapezio) throws Exception {
        if(trapezio.getBaseMaior() != 0 && trapezio.getBaseMenor() != 0 && trapezio.getAltura() != 0) {
            return ((trapezio.getBaseMaior() + trapezio.getBaseMenor()) * trapezio.getAltura()) / 2;
        }
        throw new Exception("O trapézio não possui altura.");
    }

    @Override
    public Double visitaTriangulo(Triangulo triangulo) throws Exception {
        if(triangulo.getBase() != 0 && triangulo.getAltura() != 0) {
            return (triangulo.getBase() * triangulo.getAltura()) / 2;
        }
        throw new Exception("O triângulo não possui altura.");
    }
}
