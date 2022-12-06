package visitor;

import figura.Circulo;
import figura.Retangulo;
import figura.Trapezio;
import figura.Triangulo;

public class VisitorCalcularPerimetro implements VisitorIF {

    private double pi = 3.14;

    public VisitorCalcularPerimetro() {
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
        return 2 * getPi() * circulo.getRaio();
    }

    @Override
    public Double visitaRetangulo(Retangulo retangulo) {
        return 2 * (retangulo.getBase() + retangulo.getAltura());
    }

    @Override
    public Double visitaTrapezio(Trapezio trapezio) throws Exception {
        if(trapezio.getLado1() != 0 && trapezio. getLado2() != 0) {
            return trapezio.getBaseMaior() + trapezio.getBaseMenor() + trapezio.getLado1() + trapezio. getLado2();
        }
        throw new Exception("Os lados do trapézio não foram informados.");
    }

    @Override
    public Double visitaTriangulo(Triangulo triangulo) throws Exception {
        if(triangulo.getLado1() != 0 && triangulo.getLado2() != 0) {
            return triangulo.getBase() + triangulo.getLado1() + triangulo.getLado2();
        }
        throw new Exception("Os lados do triângulo não foram informados.");
    }
}
