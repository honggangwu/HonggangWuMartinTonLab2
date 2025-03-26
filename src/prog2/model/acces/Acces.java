package prog2.model.acces;

import prog2.model.allotjament.Allotjament;
import prog2.model.allotjament.LlistaAllotjaments;

public abstract class Acces implements InAcces {
    private String nom;
    private boolean accessibilitat=true;
    private boolean estat;
    private LlistaAllotjaments llista;

    public Acces(String nom, boolean accessibilitat,
                    boolean estat, LlistaAllotjaments llista) {
        this.nom = nom;
        this.accessibilitat = accessibilitat;
        this.estat = estat;
        this.llista = llista;
    }

    public String getNom(){ return this.nom;}

    public void setNom(String nom){this.nom=nom;}

    public boolean isAccessibilitat(){return false;}

    public void setAccessibilitat(boolean accessibilitat){this.accessibilitat=accessibilitat;}

    public boolean isEstat(){return this.estat;}

    public void setEstat(){this.estat=estat;}

    public LlistaAllotjaments getLlista(){return this.llista;}

    public void setLlista(LlistaAllotjaments llista){this.llista=llista;}

    @Override
    public void afegirAllotjament(Allotjament allotjament) {

    }

    @Override
    public void tancarAcces() {

    }

    @Override
    public void obrirAcces() {

    }

    @Override
    public String toString() {
        return super.toString();
    }
}