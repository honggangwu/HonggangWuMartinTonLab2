package prog2.model.allotjament;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;

public class LlistaAllotjaments implements InLlistaAllotjaments {
    private ArrayList<Allotjament> allotjaments;
    public LlistaAllotjaments() {
        allotjaments = new ArrayList<>();
    }

    @Override
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {
        if (allotjaments.contains(allotjament)) {
            throw ExcepcioCamping ("Aquest allotjament ja existeix");
        } else {
            allotjaments.add(allotjament);
        }
    }

    @Override
    public void buidar() {
        allotjaments.clear();
    }

    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        return "";
    }

    @Override
    public boolean containsAllotjamentOperatiu() {
        return false;
    }

    @Override
    public boolean contains(Allotjament allotjament) {
        return false;
    }

    @Override
    public Allotjament getAllotjament(String nom) throws ExcepcioCamping {
        return null;
    }
}
