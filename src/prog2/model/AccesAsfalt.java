package prog2.model;

public abstract class AccesAsfalt extends Acces {
    private float asfalt;

    public AccesAsfalt(String nom, boolean accessibilitat,
                       boolean estat, LlistaAllotjaments llista, float asfalt) {
        super(nom, accessibilitat, estat, llista);
        this.asfalt = asfalt;
    }

    public float getMetresQuadrats(){ return this.asfalt;}

    public void setMetresQuadrats(float asfalt){this.asfalt=asfalt;}
}
