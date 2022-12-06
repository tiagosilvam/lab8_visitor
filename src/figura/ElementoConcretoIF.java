package figura;

import visitor.VisitorIF;

public interface ElementoConcretoIF {

    Object aceitaVisita(VisitorIF visitor) throws Exception;
}