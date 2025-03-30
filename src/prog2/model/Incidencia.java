package prog2.model;

public class Incidencia {
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


    // GETTERS I SETTERS
    public int getNumeroIncidencia() { return numeroIncidencia; }
    public Allotjament getAllotjament() { return allotjament; }
    public String getData() { return data; }
    public TipusIncidencia getTipus() { return tipus; }
    void setNumeroIncidencia(int numeroIncidencia) { this.numeroIncidencia = numeroIncidencia; }
    void setAllotjament(Allotjament allotjament) { this.allotjament = allotjament; }
    void setData(String data) { this.data = data; }
    void setTipus(TipusIncidencia tipus) { this.tipus = tipus; }

    public String getIluminacioAllotjament(){
        return switch (tipus){
            case Reparacio -> "100%";
            case Neteja -> "50%";
            case Tancament -> "0%";
        };
    }

    public String toString() {
        return "Numero:" + getNumeroIncidencia() + ", Allotjament:" + getAllotjament().toString() +
                " Data:" + getData() + ", Tipus:" + getTipus();
    }
}