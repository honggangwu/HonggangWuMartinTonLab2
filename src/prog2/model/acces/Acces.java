package prog2.model.acces;

import prog2.model.allotjament.Allotjament;
import prog2.model.allotjament.LlistaAllotjaments;

public abstract class Acces implements InAcces {
    private String nom;
    private String accessibilitat;
    private boolean estat;
    private LlistaAllotjaments llista;

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
    public boolean isAccessibilitat() {
        return false;
    }
}