import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.model.Allotjament;
import prog2.model.Incidencia;
import prog2.model.LlistaIncidencies;
import prog2.vista.ExcepcioCamping;

class LlistaIncidenciesTest {
    private LlistaIncidencies llistaIncidencies;
    private Incidencia incidencia;
    private Allotjament allotjament;

    @BeforeEach
    void setUp() {
        llistaIncidencies = new LlistaIncidencies();
        allotjament = new Allotjament("Allotjament Test", "A001", 3, 2, true, "100%");
        incidencia = new Incidencia(1, allotjament, "2025-03-29", Incidencia.TipusIncidencia.Reparacio);
    }

    @Test
    void afegirIncidencia() {
        try {
            llistaIncidencies.afegirIncidencia(2, "Neteja", allotjament, "2025-03-29");
            Assertions.assertFalse(llistaIncidencies.getIncidencies().isEmpty());
        } catch (ExcepcioCamping e) {
            Assertions.fail("No hauria de llançar una excepció: " + e.getMessage());
        }
    }

    @Test
    void afegirIncidenciaDuplicada() {
        try {
            llistaIncidencies.afegirIncidencia(1, "Reparacio", allotjament, "2025-03-29");
            Assertions.assertThrows(ExcepcioCamping.class, () ->
                    llistaIncidencies.afegirIncidencia(2, "Reparacio", allotjament, "2025-03-30")
            );
        } catch (ExcepcioCamping e) {
            Assertions.fail("No hauria de fallar la primera inserció.");
        }
    }

    @Test
    void eliminarIncidencia() {
        try {
            llistaIncidencies.afegirIncidencia(1, "Reparacio", allotjament, "2025-03-29");
            llistaIncidencies.eliminarIncidencia(incidencia);
            Assertions.assertTrue(llistaIncidencies.getIncidencies().isEmpty());
        } catch (ExcepcioCamping e) {
            Assertions.fail("No hauria de llançar una excepció.");
        }
    }

    @Test
    void llistarIncidencies() {
        try {
            llistaIncidencies.afegirIncidencia(1, "Neteja", allotjament, "2025-03-29");
            String llistat = llistaIncidencies.llistarIncidencies();
            Assertions.assertTrue(llistat.contains("Neteja"));
            Assertions.assertTrue(llistat.contains("Allotjament Test"));
        } catch (ExcepcioCamping e) {
            Assertions.fail("No hauria de llançar una excepció.");
        }
    }

    @Test
    void getIncidencia() {
        try {
            llistaIncidencies.afegirIncidencia(1, "Reparacio", allotjament, "2025-03-29");
            Incidencia trobada = llistaIncidencies.getIncidencia(1);
            Assertions.assertEquals(incidencia.getNumeroIncidencia(), trobada.getNumeroIncidencia());
        } catch (ExcepcioCamping e) {
            Assertions.fail("No hauria de llançar una excepció.");
        }
    }

    @Test
    void getIncidenciaInexistent() {
        Assertions.assertThrows(ExcepcioCamping.class, () -> {
            llistaIncidencies.getIncidencia(99);
        });
    }
}
