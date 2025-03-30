import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.model.Allotjament;
import prog2.model.LlistaAllotjaments;
import prog2.vista.ExcepcioCamping;
import java.util.List;

class LlistaAllotjamentsTest {

    private Allotjament allotjament;
    private LlistaAllotjaments llistaProva;

    @BeforeEach
    void setUp() {
        allotjament = new Allotjament("Allotjament Prova", "1234", 3, 2, true, "100%");
        llistaProva = new LlistaAllotjaments();
    }

    @Test
    void afegirAllotjament() throws ExcepcioCamping {
        llistaProva.afegirAllotjament(allotjament);
        List<Allotjament> allotjaments = llistaProva.getAllotjaments();

        // Comprovar que l'allotjament s'ha afegit correctament
        Assertions.assertTrue(allotjaments.contains(allotjament));
    }

    @Test
    void buidar() throws ExcepcioCamping {
        llistaProva.afegirAllotjament(allotjament);
        llistaProva.buidar();

        // Comprovar que la llista està buida després de cridar "buidar()"
        Assertions.assertTrue(llistaProva.getAllotjaments().isEmpty());
    }

    @Test
    void llistarAllotjaments() {
        try {
            llistaProva.afegirAllotjament(allotjament);
            String resultat = llistaProva.llistarAllotjaments("Operatiu");

            // Comprovem que la informació retornada conté el nom de l'allotjament
            Assertions.assertTrue(resultat.contains("Allotjament Prova"));
        } catch (ExcepcioCamping e) {
            Assertions.fail("No hauria de llançar una excepció: " + e.getMessage());
        }
    }

    @Test
    void containsAllotjamentOperatiu() throws ExcepcioCamping {
        llistaProva.afegirAllotjament(allotjament);
        Assertions.assertTrue(llistaProva.containsAllotjamentOperatiu());
    }

    @Test
    void contains() throws ExcepcioCamping {
        llistaProva.afegirAllotjament(allotjament);

        // Comprova que el llistat conté l'allotjament afegit
        Assertions.assertTrue(llistaProva.contains(allotjament));

        // Comprova que un allotjament no afegit no és trobat
        Allotjament inexistent = new Allotjament("Inexistent", "9999", 1, 1, false, "0%");
        Assertions.assertFalse(llistaProva.contains(inexistent));
    }

    @Test
    void getAllotjament() {
        try {
            llistaProva.afegirAllotjament(allotjament);
            Allotjament resultat = llistaProva.getAllotjament("Allotjament Prova");

            // Comprovar que es retorna l'allotjament correcte
            Assertions.assertEquals(allotjament, resultat);
        } catch (ExcepcioCamping e) {
            Assertions.fail("No hauria de llançar una excepció: " + e.getMessage());
        }
    }

    @Test
    void getAllotjamentInexistent() {
        ExcepcioCamping excepcio = Assertions.assertThrows(ExcepcioCamping.class, () -> {
            llistaProva.getAllotjament("No Existent");
        });

        Assertions.assertEquals("No existeix", excepcio.getMessage());
    }
}
