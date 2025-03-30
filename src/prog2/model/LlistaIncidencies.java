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
        // Convertir el tipus de String a TipusIncidencia
        Incidencia.TipusIncidencia tipusIncidencia;
        try {
            tipusIncidencia = Incidencia.TipusIncidencia.valueOf(tipus);
        } catch (IllegalArgumentException e) {
            throw new ExcepcioCamping("Aquesta incidència no existeix.");
        }

        // Verificar si l’allotjament ja té una incidència
        for (Incidencia incidencia : incidencies) {
            if (incidencia.getAllotjament().equals(allotjament)) {
                throw new ExcepcioCamping("Aquest allotjament ja té una incidència.");
            }
        }

        // Crear una nova incidència
        Incidencia novaIncidencia = new Incidencia(num, allotjament, data, tipusIncidencia);

        // Afegir la incidència a la llista
        incidencies.add(novaIncidencia);

        // Tancar l’allotjament
        allotjament.tancarAllotjament(novaIncidencia);
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
