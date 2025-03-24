package prog2.model;
import prog2.model.allotjament.Allotjament;

public class Incidencia{
    public static enum TipusIncidencia {
        Reparacio,
        Neteja,
        Tancament
    };

    private int numeroIncidencia;
    private Allotjament allotjament;
    private String data;
    private TipusIncidencia tipus;

    public Incidencia() {

    }

    public String getIluminacioAllotjament(){
        return "";
    }
}
