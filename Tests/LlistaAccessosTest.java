import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.model.*;
import prog2.vista.ExcepcioCamping;

class LlistaAccessosTest {
    private LlistaAccessos llistaAccessos;
    private Acces acces;
    private LlistaAllotjaments llistaAllotjaments;
    private Allotjament allotjamentOperatiu;
    @BeforeEach
    void setUp() {
        llistaAllotjaments = new LlistaAllotjaments();
        llistaAccessos = new LlistaAccessos();
        acces = new CarreteraAsfalt("Acc6", true, true, llistaAllotjaments, 13, 200);
        allotjamentOperatiu = new Allotjament("Allotjament1", "1234", 3, 2, true, "100%");
    }


    @Test
    void afegirAcces() {
        llistaAccessos.afegirAcces(acces);
        Assertions.assertTrue(llistaAccessos.getLlistaAcces().contains(acces));
    }

    @Test
    void buidar() {
        llistaAccessos.buidar();
        Assertions.assertTrue(llistaAccessos.getLlistaAcces().isEmpty());
    }

    @Test
    void llistarAccessos() {
        llistaAccessos.afegirAcces(acces);
        String resultatEsperat = acces.toString() + "\n";

        try {
            String resultatObtingut = llistaAccessos.llistarAccessos(true);
            Assertions.assertEquals(resultatEsperat, resultatObtingut);
        } catch (ExcepcioCamping e) {
            Assertions.fail("S'ha llançat una excepció inesperada: " + e.getMessage());
        }
    }

    @Test
    void actualitzaEstatAccessos() {
        try {
            // Afegim l'allotjament operatiu a la llista
            llistaAllotjaments.afegirAllotjament(allotjamentOperatiu);

            // Afegim l'accés a la llista d'accessos
            llistaAccessos.afegirAcces(acces);

            // Actualitzem els estats dels accessos
            llistaAccessos.actualitzaEstatAccessos();

            // Comprovem que l'accés segueix obert perquè hi ha un allotjament operatiu
            Assertions.assertTrue(acces.isOperatiu());

            // Tanquem l'allotjament i tornem a actualitzar els accessos
            allotjamentOperatiu.tancarAllotjament(new Incidencia(1, allotjamentOperatiu, "Avui", Incidencia.TipusIncidencia.Reparacio));
            llistaAccessos.actualitzaEstatAccessos();

            // Ara l'accés hauria d'estar tancat
            Assertions.assertFalse(acces.isOperatiu());

        } catch (ExcepcioCamping e) {
            Assertions.fail("No hauria de llançar una excepció: " + e.getMessage());
        }
    }

    @Test
    void calculaAccessosAccessibles() {
        try {
            // Afegim diferents tipus d'accessos amb diferents valors d'accessibilitat
            Acces acces1 = new CarreteraAsfalt("A1", true, true, llistaAllotjaments, 10, 100);
            Acces acces2 = new CarreteraTerra("A2", false, true, llistaAllotjaments, 15, 50);
            Acces acces3 = new CarreteraAsfalt("A3", true, false, llistaAllotjaments, 20, 150);

            llistaAccessos.afegirAcces(acces1);
            llistaAccessos.afegirAcces(acces2);
            llistaAccessos.afegirAcces(acces3);

            // Comprovem que només els accessos accessibles es compten
            int result = llistaAccessos.calculaAccessosAccessibles();
            Assertions.assertEquals(2, result); // Només A1 i A3 són accessibles

        } catch (ExcepcioCamping e) {
            Assertions.fail("No hauria de llançar una excepció: " + e.getMessage());
        }
    }


    @Test
    void calculaMetresQuadratsAsfalt() {
        try {
            // Afegim accessos d'asfalt
            AccesAsfalt acces1 = new CarreteraAsfalt("A1", true, true, llistaAllotjaments, 10, 100);
            AccesAsfalt acces2 = new CarreteraAsfalt("A2", true, true, llistaAllotjaments, 15, 200);

            // Afegim un accés de terra que no hauria de comptar
            Acces acces3 = new CarreteraTerra("A3", true, true, llistaAllotjaments, 20, 150);

            llistaAccessos.afegirAcces(acces1);
            llistaAccessos.afegirAcces(acces2);
            llistaAccessos.afegirAcces(acces3);

            // Calcula els metres quadrats d'asfalt
            float result = llistaAccessos.calculaMetresQuadratsAsfalt();
            Assertions.assertEquals(300, result); // 100 + 200

        } catch (ExcepcioCamping e) {
            Assertions.fail("No hauria de llançar una excepció: " + e.getMessage());
        }
    }

}