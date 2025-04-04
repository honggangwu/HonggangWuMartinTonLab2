package prog2.model;

public class Parcela extends Allotjament {
    private float mida;
    private boolean connexioElectrica;

    public Parcela(String nom, String idAllotjament, float mida,
                   boolean connexioElectrica, boolean estat, String iluminacio) {
        super(nom, idAllotjament,4,2, estat, iluminacio);
        this.mida = mida;
        this.connexioElectrica = connexioElectrica;
    }

    public float getMida(){ return this.mida; }

    public void setMida(float mida){ this.mida = mida; }

    public boolean isConnexioElectrica(){ return this.connexioElectrica; }

    public void setConnexioElectrica(boolean connexio){ this.connexioElectrica = connexio; }

    public String toString() {
        return "Nom=" + getNom() + ", Id=" + getId() +
                ", estada mínima en temp ALTA: " + getEstadaMinima(Temp.ALTA) +
                ", estada mínima en temp BAIXA: " + getEstadaMinima(Temp.BAIXA) +
                " Parcela { mida=" + getMida() +
                ", connexio electrica=" + isConnexioElectrica() + " }";
    }

}