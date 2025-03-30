package prog2.model;

import prog2.vista.ExcepcioCamping;
import java.util.ArrayList;

public class LlistaIncidencies implements InLlistaIncidencies {
    private ArrayList<Incidencia> incidencies;

    public LlistaIncidencies() {
        incidencies = new ArrayList<>();
    }

    @Override
    public void afegirIncidencia(int num, String tipus, Allotjament allotjament, String data) throws ExcepcioCamping {
        // Verificar si el tipo de incidencia es válido
        if (!tipus.equals("Tancament") && !tipus.equals("Reparacio") && !tipus.equals("Neteja")) {
            throw new ExcepcioCamping("Aquesta incidència no existeix.");
        }

        // Verificar si el allotjament ya tiene una incidencia
        for (Incidencia incidencia : incidencies) {
            if (incidencia.getAllotjament().equals(allotjament)) {
                throw new ExcepcioCamping("Aquest allotjament ja té una incidència.");
            }
        }

        // Crear y añadir la nueva incidencia
        Incidencia novaIncidencia = new Incidencia(num, allotjament, data, tipus);
        incidencies.add(novaIncidencia);

        // Cambiar el estado del allotjament y la iluminación
        allotjament.tancarAllotjament(novaIncidencia);

        // Aquí se deberían gestionar los accesos, sin necesidad de nuevos atributos.
        // Verificar si es necesario "tancar" o "obrir" accesos a los allotjaments relacionados.
    }

    @Override
    public void eliminarIncidencia(Incidencia in) throws ExcepcioCamping {
        boolean eliminada = incidencies.removeIf(incidencia -> incidencia.equals(in));

        if (!eliminada) {
            throw new ExcepcioCamping("No s'ha trobat la incidència a eliminar.");
        }

        // Restaurar el allotjament a operatiu
        in.getAllotjament().obrirAllotjament();

        // Aquí se podrían reactivar los accesos si es necesario.
    }

    @Override
    public String llistarIncidencies() {
        if (incidencies.isEmpty()) {
            return "No hi ha incidències registrades.";
        }
        StringBuilder info = new StringBuilder();
        for (Incidencia incidencia : incidencies) {
            info.append(incidencia.toString()).append("\n");
        }
        return info.toString();
    }

    @Override
    public Incidencia getIncidencia(int num) throws ExcepcioCamping {
        for (Incidencia incidencia : incidencies) {
            if (incidencia.getNumeroIncidencia() == num) {
                return incidencia;
            }
        }
        throw new ExcepcioCamping("La incidència amb número " + num + " no existeix.");
    }

    public ArrayList<Incidencia> getIncidencies() {
        return new ArrayList<>(incidencies);
    }

    public void setIncidencies(ArrayList<Incidencia> incidencies) {
        this.incidencies = new ArrayList<>(incidencies);
    }
}
