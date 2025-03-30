package prog2.model;

public class CarreteraAsfalt extends AccesAsfalt {
    private float pesMaxim;
    public CarreteraAsfalt(String nom,boolean accessibilitat, boolean estat, LlistaAllotjaments llista,
                      float asfalt, float pesMaxim) {
        super(nom, accessibilitat, estat, llista,asfalt);
        this.pesMaxim=pesMaxim;
    }

    public float getPes(){return this.pesMaxim;}

    public void setPes(float pesMaxim){this.pesMaxim=pesMaxim;}

    @Override
    public boolean isAccessibilitat() {return true;}

    @Override
    public String toString() {
        return super.toString()+ ", metres quadrats: "+ getMetresQuadrats()+ ", pes:" + getPes();
    }
}
