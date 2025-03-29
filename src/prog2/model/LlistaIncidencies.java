package prog2.model;
import prog2.vista.ExcepcioCamping;
import java.util.ArrayList;

public class LlistaIncidencies implements InLlistaIncidencies{
    private ArrayList<Incidencia> incidencies;

    public LlistaIncidencies() { incidencies = new ArrayList<>(); }

    @Override
    public void afegirIncidencia(int num, String tipus, Allotjament allotjament, String data) throws ExcepcioCamping {
        Incidencia novaIncidencia = new Incidencia(num, allotjament, data, tipus);
        if(tipus != "Tancament" || tipus != "Reparacio" || tipus != "Neteja"){
            throw new ExcepcioCamping("Aquesta incidencia no existeix");
        }

        for (Incidencia incidencia : incidencies) {
            if (incidencia.getAllotjament().equals(allotjament)) {
                throw new ExcepcioCamping("Aquest allotjament ja té una incidencia.");
            }
        }

        incidencies.add(novaIncidencia);
    }

    @Override
    public void eliminarIncidencia(Incidencia in) throws ExcepcioCamping {
        for (Incidencia incidencia : incidencies) {
            if (incidencia.equals(in)) {
                incidencies.remove(incidencia);
            }
        }
    }

    @Override
    public String llistarIncidencies() throws ExcepcioCamping {
        String info ="";
        for (Incidencia incidencia : incidencies) {
            if (incidencia == null) {
                throw new ExcepcioCamping("Incidencia no trobada");
            }
            info = info + incidencia.toString();
        }
        return info;
    }

    @Override
    public Incidencia getIncidencia(int num) throws ExcepcioCamping {
        for (Incidencia incidencia : incidencies) {
            if (incidencia.getNumeroIncidencia() == num) {
                return incidencia;
            }
        }
        throw new ExcepcioCamping("Incidencia no existeix");
    }
}