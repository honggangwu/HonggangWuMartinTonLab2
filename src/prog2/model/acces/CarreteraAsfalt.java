package prog2.model.acces;

import prog2.model.allotjament.LlistaAllotjaments;

public class CarreteraAsfalt extends AccesAsfalt{
    private int pes;
    public CarreteraAsfalt(String nom,boolean accessibilitat, boolean estat, LlistaAllotjaments llista,
                      int metresQuadrats, int pes) {
        super(nom, accessibilitat, estat, llista,metresQuadrats);
        this.pes=pes;
    }

    public int getPes(){return this.pes;}

    public void setPes(int pes){this.pes=pes;}

    @Override
    public boolean isAccessibilitat() {return true;}
}
