package prog2.model;

public class CamiTerra extends AccesTerra {
    public CamiTerra(String nom,boolean accessibilitat, boolean estat, LlistaAllotjaments llista, float longitud) {
        super(nom, accessibilitat, estat, llista,longitud);
    }

    @Override
    public boolean isAccessibilitat() {return false;}

    @Override
    public String toString() {
        return super.toString()+ ", longitud: "+ getLongitud();
    }
}
