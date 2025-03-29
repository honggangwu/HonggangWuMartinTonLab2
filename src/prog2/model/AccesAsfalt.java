package prog2.model;

public abstract class AccesAsfalt extends Acces {
    private int metresQuadrats;

    public AccesAsfalt(String nom, boolean accessibilitat,
                       boolean estat, LlistaAllotjaments llista, int metresQuadrats) {
        super(nom, accessibilitat, estat, llista);
        this.metresQuadrats = metresQuadrats;
    }

    public int getMetresQuadrats(){ return this.metresQuadrats;}

    public void setMetresQuadrats(int metresQuadrats){this.metresQuadrats=metresQuadrats;}
}
