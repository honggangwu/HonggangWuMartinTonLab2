import org.junit.jupiter.api.Assertions;
import prog2.model.Allotjament;
import prog2.model.Incidencia;

class AllotjamentTest {

    private Allotjament allotjament;
    private Incidencia incidenciaProva;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        allotjament = new Allotjament("Allotjament Prova","1234",
                3,2,true,"100%");
        incidenciaProva = new Incidencia(12,allotjament,"avui", Incidencia.TipusIncidencia.Reparacio);

    }

    @org.junit.jupiter.api.Test
    void tancarAllotjamentTest() {

        allotjament.tancarAllotjament(incidenciaProva);
        Assertions.assertEquals("100%", Allotjament.getIluminacio());
        Assertions.assertFalse(allotjament.isOperatiu());

        Incidencia incidenciaProva2 = new Incidencia(12,allotjament,"avui", Incidencia.TipusIncidencia.Neteja);
        allotjament.tancarAllotjament(incidenciaProva2);
        Assertions.assertEquals("50%", Allotjament.getIluminacio());
        Assertions.assertFalse(allotjament.isOperatiu());

        Incidencia incidenciaProva3 = new Incidencia(12,allotjament,"avui", Incidencia.TipusIncidencia.Tancament);
        allotjament.tancarAllotjament(incidenciaProva3);
        Assertions.assertEquals("0%", Allotjament.getIluminacio());
        Assertions.assertFalse(allotjament.isOperatiu());
    }
    @org.junit.jupiter.api.Test
    void obrirAllotjament() {

        allotjament.obrirAllotjament();
        Assertions.assertEquals("100%", Allotjament.getIluminacio());
        Assertions.assertTrue(allotjament.isOperatiu());

    }
}