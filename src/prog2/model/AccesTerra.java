package prog2.model;

public abstract class AccesTerra extends Acces {
    private float longitud;

    public AccesTerra(String nom, boolean accessibilitat,
                       boolean estat, LlistaAllotjaments llista, float longitud) {
        super(nom, accessibilitat, estat, llista);
        this.longitud = longitud;
    }

    public float getLongitud(){ return this.longitud;}

    public void setLongitud(float longitud){this.longitud=longitud;}
}