package figura;

import visitor.VisitorIF;

public class Retangulo implements ElementoConcretoIF {

    private double base;
    private double altura;

    public Retangulo(double base, double altura) {
        setBase(base);
        setAltura(altura);
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public Object aceitaVisita(VisitorIF visitor) {
        return visitor.visitaRetangulo(this);
    }

    @Override
    public String toString() {
        return "Retângulo {" +
                "base=" + getBase() +
                ", altura=" + getAltura() +
                '}';
    }
}
