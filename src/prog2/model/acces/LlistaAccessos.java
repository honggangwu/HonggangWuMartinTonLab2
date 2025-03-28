package prog2.model.acces;

import prog2.model.allotjament.Allotjament;
import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;

public class LlistaAccessos implements InLlistaAccessos {
    private ArrayList<Acces> llistaAcces;

    public LlistaAccessos() {
        llistaAcces = new ArrayList<>();
    }
    @Override
    public void afegirAcces(Acces acc) throws ExcepcioCamping {
        if (llistaAcces.contains(acc)) {
            throw new ExcepcioCamping ("Aquest acces ja existeix");
        } else {
            llistaAcces.add(acc);
        }
    }

    @Override
    public void buidar() {
        llistaAcces.clear();
    }

    @Override
    public String llistarAccessos(boolean estat) throws ExcepcioCamping {
        boolean trobat = false;
        StringBuilder info = new StringBuilder();

        for (Acces acces : llistaAcces) {
            if (acces.isOperatiu() == estat) {
                info.append(acces.toString()).append("\n"); // Afegim un salt de línia per millorar la llegibilitat
                trobat = true;
            }
        }

        if (!trobat) { // Llança l'excepció només si cap accés compleix la condició, després de recórrer tota la llista
            throw new ExcepcioCamping("No hi ha accessos amb l'estat especificat.");
        }

        return info.toString();
    }


    @Override
    public void actualitzaEstatAccessos() throws ExcepcioCamping {

    }

    @Override
    public int calculaAccessosAccessibles() throws ExcepcioCamping {
        return 0;
    }

    @Override
    public float calculaMetresQuadratsAsfalt() throws ExcepcioCamping {
        return 0;
    }
}
