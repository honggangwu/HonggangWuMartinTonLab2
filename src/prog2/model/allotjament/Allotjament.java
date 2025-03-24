package prog2.model.allotjament;
import prog2.model.Incidencia;

public abstract class Allotjament implements InAllotjament{
    private String nom;
    private String idAllotjament;
    private long estadaMinAlta;
    private long estadaMinBaixa;
    private boolean estat;
    private String iluminacio;

    public Allotjament(String nom, String idAllotjament, long estadaMinAlta,
                       long estadaMinBaixa, boolean estat, String iluminacio) {
        this.nom = nom;
        this.idAllotjament = idAllotjament;
        this.estadaMinAlta = estadaMinAlta;
        this.estadaMinBaixa = estadaMinBaixa;
        this.estat = estat;
        this.iluminacio = iluminacio;
    }

    public boolean isOperatiu(){
        return true;
    }

    @Override
    public String getNom() { return nom; }

    @Override
    public void setNom(String nom) { this.nom = nom; }

    @Override
    public String getId() { return idAllotjament; }

    @Override
    public void setId(String id) { this.idAllotjament = id; }

    @Override
    public long getEstadaMinima(Temp temp) {
        switch (temp) {
            case ALTA -> {return this.estadaMinAlta;}
            case BAIXA -> {return this.estadaMinBaixa;}
        }
        return 0;
    }

    @Override
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        this.estadaMinAlta = estadaMinimaALTA_;
        this.estadaMinBaixa = estadaMinimaBAIXA_;
    }

    @Override
    public void tancarAllotjament(Incidencia in) {
        estat = false;
        if (in.equals(Reparacio)){ iluminacio = "Nose%";}
        if (in.equals(Neteja)){ iluminacio = "Nose%";}
        if (in.equals(Tancament)){ iluminacio = "Nose%";}
    }

    @Override
    public void obrirAllotjament() {
        estat = true;
        iluminacio = "100%";
    }
}