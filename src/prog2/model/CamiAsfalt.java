package prog2.model;

public class CamiAsfalt extends AccesAsfalt {
    public CamiAsfalt(String nom, boolean  accessibilitat, boolean estat, LlistaAllotjaments llista, int metresQuadrats) {
        super(nom, accessibilitat, estat, llista,metresQuadrats);
    }

    @Override
    public boolean isAccessibilitat() {return false;}

    @Override
    public String toString() {
        return super.toString() + ", metres quadrats: "+ getMetresQuadrats();
    }
}