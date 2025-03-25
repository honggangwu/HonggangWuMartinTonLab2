package prog2.model.allotjament;
import prog2.model.Incidencia;

public abstract class Allotjament implements InAllotjament{
    private String nom;
    private String idAllotjament;
    private long estadaMinAlta;
    private long estadaMinBaixa;
    private boolean estat;
    private static String iluminacio;

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
        return estat;
    }

    @Override
    public String getNom() { return nom; }

    @Override
    public void setNom(String nom) { this.nom = nom; }

    @Override
    public String getId() { return idAllotjament; }

    @Override
    public void setId(String id) { this.idAllotjament = id; }

    public static String getIluminacio() { return iluminacio; }
    public void setIluminacio(String iluminacio) {this.iluminacio = iluminacio; }
    public void setEstat(boolean estat) {this.estat = estat; }


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
        if (in.equals(Reparacio)){ iluminacio = "100%";}
        if (in.equals(Neteja)){ iluminacio = "50%";}
        if (in.equals(Tancament)){ iluminacio = "0%";}
    }

    @Override
    public void obrirAllotjament() {
        estat = true;
        iluminacio = "100%";
    }
}