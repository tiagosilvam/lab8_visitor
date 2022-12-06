package figura;

import visitor.VisitorIF;

public class Triangulo implements ElementoConcretoIF {

    private double base;
    private double altura;
    private double lado1;
    private double lado2;

    public Triangulo(double base, double altura) {
        setBase(base);
        setAltura(altura);
    }

    public Triangulo(double base, double lado1, double lado2) {
        setBase(base);
        setLado1(lado1);
        setLado2(lado2);
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

    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    @Override
    public Object aceitaVisita(VisitorIF visitor) throws Exception {
        return visitor.visitaTriangulo(this);
    }

    @Override
    public String toString() {
        return "Triângulo {" +
                "base=" + getBase() +
                (getAltura() != 0 ? ", altura=" + getAltura() : "") +
                (getLado1() != 0 ? ", lado1=" + getLado1() : "") +
                (getLado2() != 0 ? ", lado2=" + getLado2() : "") +
                '}';
    }
}
