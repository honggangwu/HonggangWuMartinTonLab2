package prog2.model.acces;

import prog2.model.allotjament.LlistaAllotjaments;

public class CamiTerra extends AccesTerra{
    public CamiTerra(String nom,boolean accessibilitat, boolean estat, LlistaAllotjaments llista, int metresQuadrats) {
        super(nom, accessibilitat, estat, llista,metresQuadrats);
    }

    @Override
    public boolean isAccessibilitat() {return false;}
}
