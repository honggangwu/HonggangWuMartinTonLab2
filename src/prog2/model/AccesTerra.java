package prog2.model;

public abstract class AccesTerra extends Acces {
    private int longitud;

    public AccesTerra(String nom, boolean accessibilitat,
                       boolean estat, LlistaAllotjaments llista, int longitud) {
        super(nom, accessibilitat, estat, llista);
        this.longitud = longitud;
    }

    public int getLongitud(){ return this.longitud;}

    public void setLongitud(int longitud){this.longitud=longitud;}
}
