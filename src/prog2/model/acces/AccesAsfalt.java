package prog2.model.acces;

import prog2.model.allotjament.LlistaAllotjaments;

public abstract class AccesAsfalt extends Acces{
    private int metresQuadrats;

    public AccesAsfalt(String nom, boolean accessibilitat,
                       boolean estat, LlistaAllotjaments llista) {
        super(nom, idAllotjament, 7, 4, mida, habitacions, placesPersones);
        this.placesParquing = placesParquing;
        this.terrassa = terrassa;
        this.tv = tv;
        this.aireFred = aireFred;
    }

    public int getMetresQuadrats(){ return this.metresQuadrats;}

    public void setMetresQuadrats(int metresQuadrats){this.metresQuadrats=metresQuadrats;}
}
