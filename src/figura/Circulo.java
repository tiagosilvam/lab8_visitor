package figura;

import visitor.VisitorIF;

public class Circulo implements ElementoConcretoIF {

    private double raio;

    public Circulo(double raio) {
        setRaio(raio);
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    @Override
    public Object aceitaVisita(VisitorIF visitor) {
        return visitor.visitaCirculo(this);
    }

    @Override
    public String toString() {
        return "Círculo {" +
                "raio=" + getRaio() +
                '}';
    }
}