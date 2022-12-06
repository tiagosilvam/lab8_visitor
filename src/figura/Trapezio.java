package figura;

import visitor.VisitorIF;

public class Trapezio implements ElementoConcretoIF {

    private double baseMaior;
    private double baseMenor;
    private double altura;
    private double lado1;
    private double lado2;

    public Trapezio(double baseMaior, double baseMenor, double altura) {
        setBaseMaior(baseMaior);
        setBaseMenor(baseMenor);
        setAltura(altura);
    }

    public Trapezio(double baseMaior, double baseMenor, double lado1, double lado2) {
        setBaseMaior(baseMaior);
        setBaseMenor(baseMenor);
        setLado1(lado1);
        setLado2(lado2);
    }

    public double getBaseMaior() {
        return baseMaior;
    }

    public void setBaseMaior(double baseMaior) {
        this.baseMaior = baseMaior;
    }

    public double getBaseMenor() {
        return baseMenor;
    }

    public void setBaseMenor(double baseMenor) {
        this.baseMenor = baseMenor;
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
        return visitor.visitaTrapezio(this);
    }

    @Override
    public String toString() {
        return "Trapézio {" +
                "baseMaior=" + getBaseMaior() +
                ", baseMenor=" + getBaseMenor() +
                (getAltura() != 0 ? ", altura=" + getAltura() : "") +
                (getLado1() != 0 ? ", lado1=" + getLado1() : "") +
                (getLado2() != 0 ? ", lado2=" + getLado2() : "") +
                '}';
    }
}
