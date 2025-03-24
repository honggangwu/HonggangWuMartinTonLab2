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

    public Incidencia(int numeroIncidencia, Allotjament allotjament, String data, TipusIncidencia tipus) {
        this.numeroIncidencia = numeroIncidencia;
        this.allotjament = allotjament;
        this.data = data;
        this.tipus = tipus;
    }

    public String getIluminacioAllotjament(){
        return "";
    }
}
