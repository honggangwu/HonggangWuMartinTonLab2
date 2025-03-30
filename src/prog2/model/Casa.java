package prog2.model;

public abstract class Casa extends Allotjament {
    private float mida;
    private int habitacions;
    private int placesPersones;

    public Casa(String nom, String idAllotjament, long estadaMinAlta, long estadaMinBaixa,
                boolean estat, String iluminacio, float mida, int habitacions, int placesPersones) {
        super(nom, idAllotjament, estadaMinAlta, estadaMinBaixa, estat, iluminacio);
        this.mida = mida;
        this.habitacions = habitacions;
        this.placesPersones = placesPersones;
    }

    public float getMida(){ return this.mida; }

    public int getHabitacions(){ return this.habitacions; }

    public int getPlacesPersones(){ return this.placesPersones; }

    public void setMida(float mida){ this.mida = mida; }

    public void setHabitacions(int habitacions){ this.habitacions = habitacions; }

    public void setPlacesPersones(int placesPersones){ this.placesPersones = placesPersones; }

    @Override
    public boolean isOperatiu() { return super.isOperatiu(); }
}