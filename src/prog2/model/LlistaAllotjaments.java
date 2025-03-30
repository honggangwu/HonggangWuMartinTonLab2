package prog2.model;
import prog2.vista.ExcepcioCamping;
import java.util.ArrayList;

public class LlistaAllotjaments implements InLlistaAllotjaments {
    private ArrayList<Allotjament> allotjaments;

    public LlistaAllotjaments() { allotjaments = new ArrayList<>(); }

    @Override
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {
        if (allotjaments.contains(allotjament)) {
            throw new ExcepcioCamping ("Aquest allotjament ja existeix");
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
        boolean nouEstat = estat.equals("Operatiu");
        String info ="";
        for (Allotjament allotjament : allotjaments) {
            if (allotjament.isOperatiu() == nouEstat || estat.equals("Tots")) {
                info = info + allotjament.toString();
            }
        }
        return info;
    }

    @Override
    public boolean containsAllotjamentOperatiu() {
        for (Allotjament allotjament : allotjaments) {
            if (allotjament.isOperatiu()){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Allotjament allotjament) {
        for (Allotjament i : allotjaments) {
            if (i.getId().equals(allotjament.getId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Allotjament getAllotjament(String nom) throws ExcepcioCamping {
        for (Allotjament allotjament : allotjaments) {
            if (allotjament.getNom().equals(nom)) {
                return allotjament;
            }
        }
        throw new ExcepcioCamping("No existeix");
    }

    public ArrayList<Allotjament> getAllotjaments() {
        return allotjaments;
    }

    public void setAllotjaments(ArrayList<Allotjament> allotjaments) {
        this.allotjaments = allotjaments;
    }
}